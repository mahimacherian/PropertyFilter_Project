package PageObject_Component;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class PageObject_Search {
	
	public AppiumDriver driver;
	
	
	public PageObject_Search(AppiumDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="ae.propertyfinder.propertyfinder:id/action_search")
	public WebElement Search_btn;
	
	@FindBy(id= "ae.propertyfinder.propertyfinder:id/location")
	public WebElement Search_txtbox;
	
	@FindBy(id= "ae.propertyfinder.propertyfinder:id/label")
	public WebElement valid_text;
	
	@FindBy(id = "ae.propertyfinder.propertyfinder:id/filter_button")
	public WebElement invalid_search;
	
	@FindBy(id = "ae.propertyfinder.propertyfinder:id/thumbnail")
	public List<WebElement> item_count;
	
	
	public void Click_Search()
	{
		Search_btn.click();
	}
	
	public void Enter_Searchtxt(String Value)
	{
		Search_txtbox.sendKeys(Value + "\n");
	}

	public String getValidmsg()
	{
		return valid_text.getText();
	}
	
	public String getInvalidmsg()
	{
		return invalid_search.getText();
	}
	
	public void Click_Valid()
	{
		valid_text.click();
	}
	
	public void Click_Property()
	{
		item_count.get(0).click();
	}
	
}