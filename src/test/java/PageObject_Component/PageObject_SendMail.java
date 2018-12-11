package PageObject_Component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class PageObject_SendMail {
	public AppiumDriver driver;
	
	
	public PageObject_SendMail(AppiumDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id= "ae.propertyfinder.propertyfinder:id/email")
	public WebElement email_btn;
	
	@FindBy(id = "ae.propertyfinder.propertyfinder:id/name")
	public WebElement name;
	
	@FindBy(id ="ae.propertyfinder.propertyfinder:id/email")
	public WebElement email;
	
	@FindBy(id = "ae.propertyfinder.propertyfinder:id/phone")
	public WebElement phnumber;
	
	@FindBy(id ="ae.propertyfinder.propertyfinder:id/button_send")
	public WebElement send_btn;
	
	
	
	public void Click_Email()
	{
		email_btn.click();
	}
	
	public void enterName()
	{
		name.sendKeys("Mahima");
	}

	
	public void enterMailId()
	{
		email.sendKeys("mahimacherian@gmail.com");
	}
	
	public void enterPhNumber()
	{
		phnumber.sendKeys("55152000");
	}
	
	public void clickSend()
	{
		send_btn.clear();
	}
	

	
}
