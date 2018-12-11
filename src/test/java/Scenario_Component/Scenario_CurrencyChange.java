package Scenario_Component;

import java.io.IOException;

import org.testng.annotations.Test;

import Generic_Component.Base_Class;
import PageObject_Component.PageObject_CurrencyChange;

public class Scenario_CurrencyChange extends Base_Class{
	
	@Test
	public void testCurrencychange() throws IOException, InterruptedException
	{
		Start_Server();
		
		Initialize_app();
		
		
		PageObject_CurrencyChange PF_cc = new PageObject_CurrencyChange(driver);
		
		Explicitwait(PF_cc.myAccount_btn, 25);
		PF_cc.Click_MyAccount();
		
		PF_cc.swipePage();
		
		PF_cc.Click_Currency();
		
		PF_cc.Click_EUR();
		
		Stop_Server();
		
	}

	
	
}
