package test_cases;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import page_objects.LoginPageObject;
import page_objects.RegisterationPageObject;
import test_Base.BaseClass;
import utilities.DataReader;

class TC_002_LoginTest extends BaseClass
{

	
	public Logger logger;
	
	
	@Test( dataProvider="LoginData", dataProviderClass=DataReader.class)
	void testLogin(String gender, String fname, String lname, String day, String month, String year, String email, String password) throws InterruptedException
	{
		
		
		
		logger.info("Testing testLogo");
		 LoginPageObject lpo = new LoginPageObject(driver);
		 lpo.clickOn_loginLink();
	 System.out.println(lpo.checkloginPage());
		
	 	logger.info("Opened Login Page");
		
	
	try 
	{
	
	lpo.clickOn_emailinput(email);
	lpo.clickOn_passwordinput(password);
	lpo.clickOn_loginButton();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Implicit wait Command

	String act_Msg=lpo.check_welcomeMsg();
	String exp_Msg="Welcome to our store";
	
	
	if(act_Msg.equals(exp_Msg))
	{
		Assert.assertTrue(true);
		
		lpo.clickOn_logout();
	}
	else
	{
		Assert.assertTrue(false);
	}
	}
	catch(Exception e)
	{
		Assert.fail();
	}
	
	lpo.clickOn_loginLink();
	
	
}
	

	
	
	
	
	

	
	
	
	
}
	