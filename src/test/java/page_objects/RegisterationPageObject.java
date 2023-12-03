package page_objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegisterationPageObject extends BasePage
{

	public RegisterationPageObject(WebDriver driver)
	{
		
		super(driver);
		
	}
	
	@FindBy(xpath="//h1[normalize-space()='Register']")
	WebElement register_logo;
	
	@FindBy(xpath="//input[@id='gender-male']")
	WebElement r_Male;
	
	@FindBy(xpath="//*[@id=\"gender-female\"]")
	WebElement r_Female;
	
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement first_Name;
	
	@FindBy(xpath="//input[@id='LastName']")
	WebElement last_Name;
	
	
	@FindBy(xpath="//select[@name='DateOfBirthDay']") 
	WebElement day_E;
	
	@FindBy(xpath="//select[@name='DateOfBirthDay']/option")
	List<WebElement> day_options;
	
	
	@FindBy(xpath="//select[@name='DateOfBirthMonth']")
	WebElement month_E;
	
	@FindBy(xpath="//select[@name='DateOfBirthMonth']//option")
	List<WebElement> month_options;
	
	
	
	@FindBy(xpath="//select[@name='DateOfBirthYear']")
	WebElement year_E;
	
	@FindBy(xpath="//select[@name='DateOfBirthYear']//option")
	List<WebElement> year_options;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement e_mail;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement pass_word;
	
	@FindBy(xpath="//input[@id='ConfirmPassword']")
	WebElement confirm_Pass;
	
	@FindBy(xpath="//button[@id='register-button']")
	WebElement register_Button;
	
	@FindBy(xpath="//div[@class='result']")
	WebElement register_Result;
	
	@FindBy(xpath="//a[@class='ico-register']")
	WebElement register_link;
	
	
	
	
	public boolean checkLogoPresence()
	{
		boolean status= register_logo.isDisplayed();
		String text=register_logo.getText();
		return status;
		
	}
	
	public void select_Gender(String gender)
	{
		String Male = null;
		
	
		if(gender==Male)
		{
			r_Male.click();
		} 
		else 
		{
			r_Female.click();
		}
			
			
	}
	
	
	
	
	public void set_FirstName(String fName) 
	{
		first_Name.clear();
		first_Name.sendKeys(fName);
	}
	
	public void set_LastName(String lName) 
	{
		last_Name.clear();
		last_Name.sendKeys(lName);
	}
	
	public void clickOn_Day(String day) 
	{
		System.out.println(day);
		day_E.click();
		
	
		
		for(WebElement day_option:day_options)
		{
			
			String text=day_option.getText();
			
			if(text==day)
			{
				day_option.click();
			}
		
		}
	
	
		
		
	 }
	
	public void clickOn_Month(String month) 
	{
		month_E.click();
	
	
		for(WebElement month_option:month_options)
		{
			String text= month_option.getText();
			if(text.equals(month))
			{
				month_option.click();
			}
				
		}
		
	}
	
	
	
	public void clickOn_Year(String year) 
	{
		year_E.click();
		
		for(WebElement year_option:year_options)
		{
			String text= year_option.getText();

	
			if(text==year)
			{
				year_option.click();
			}
				
		}
	}
	
	
	public void set_Email(String email) 
	{
		e_mail.clear();
		e_mail.sendKeys(email);
		
	}
	
	public void set_Password(String password) 
	{
		pass_word.clear();
		pass_word.sendKeys(password);
	}
	
	public void set_ConfirmPassword(String password) 
	{
		confirm_Pass.clear();
		confirm_Pass.sendKeys(password);
	}
	
	public void clickOn_RegisterButton() 
	{
		register_Button.click();
	}

	public String register_result()
	{  
		try {
		String act_text=register_Result.getText();
		
		return act_text;
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
	public void clickon_registerLink() throws InterruptedException
	{
		register_link.click();
		Thread.sleep(5000);
	}
}
