package PageObject_Component;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

public class PageObject_CurrencyChange {
	
	public AppiumDriver driver;
	
	public PageObject_CurrencyChange(AppiumDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="ae.propertyfinder.propertyfinder:id/settings")
	public WebElement myAccount_btn;
	
	@FindBy(id="android:id/title")
	public WebElement ele_swipe;

	
	@FindBy(xpath = "//[@index='0'][@class ='android.widget.TextView'][@text='Currency']")
	public WebElement currency_txt;
	
	@FindBy(xpath = "//[@id='android:id/text1'][@class ='android.widget.CheckedTextView'][@text='EUR']")
	public WebElement currency;
	
	
	
	
	
	public void Click_MyAccount()
	{
		myAccount_btn.click();
	}
	
	public void swipePage()
	{
		Dimension size = driver.manage().window().getSize();
		int Starty =(int)(size.height*0.90);
		int Endy = (int)(size.height*0.10);
		
		int Startx =(int)(size.width*0.50);
		
		//driver.swipe(Startx,Starty,Startx,Endy,1000);
		
		TouchAction action1 = new TouchAction(driver);
		action1.press(Startx,Starty).moveTo(Startx,Endy).release();
	}

	public void Click_Currency()
	{
		currency_txt.click();
	}
	
	public void Click_EUR()
	{
		currency.click();
	}
	
}
