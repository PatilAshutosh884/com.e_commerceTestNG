package test_Base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters; 

public class BaseClass
{
public static WebDriver driver =null;
public Logger logger;

@BeforeClass
@Parameters("Browser")
public void setup(String br) throws InterruptedException 
{
	logger= LogManager.getLogger(this.getClass());
	logger.info("==========================setup() invoked============================");
	
	
	
	if(br.equals("chrome"))
	{
	
		 driver=new ChromeDriver();
		
		
	}
	else if(br.equals("edge"))
	{
		
	   driver=new EdgeDriver();
	
	}
	else
	{
		System.out.println("Provide proper browser name");
	}

	
	
	driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
	
	logger.info("link opened");
	//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	driver.manage().window().maximize();

} 


@AfterClass
public void teardown()
{
	logger.info("************************driver teared down*********************************");
	driver.quit();
}

}

