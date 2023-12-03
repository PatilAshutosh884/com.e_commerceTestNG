package test_cases;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;



import page_objects.RegisterationPageObject;
import test_Base.BaseClass;
import utilities.DataReader;

class TC_001_RegistrationTest extends BaseClass 
{

	RegisterationPageObject rpo;

	
	
	@Test(priority=2, dataProvider="RegistrationData", dataProviderClass=DataReader.class)
	void testRegisterForm(String gender, String fname, String lname, String day, String month, String year, String email, String password) throws InterruptedException
	{
	logger.info("Running testRegistrationForm");
	
	
	logger.info("Testing testLogo");
		 rpo = new RegisterationPageObject(BaseClass.driver);
		 System.out.println("Controll created Registration PageObject");
		 Assert.assertEquals(rpo.checkLogoPresence(),true);
		
		
	
	try 
	{
	rpo.select_Gender(gender);
	rpo.set_FirstName(fname);
	rpo.set_LastName(lname);
	rpo.clickOn_Day(day);
	rpo.clickOn_Month(month);
	rpo.clickOn_Year(year);
	rpo.set_Email(email);
	rpo.set_Password(password);
	rpo.set_ConfirmPassword(password);
		rpo.clickOn_RegisterButton();
		String act_rslt=rpo.register_result();
		String exp_rslt="Your registration completed";
	
	
	if(act_rslt.equals(exp_rslt))
	{
		Assert.assertTrue(true);
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
	
	
	
	rpo.clickon_registerLink();
	
}
	}
	