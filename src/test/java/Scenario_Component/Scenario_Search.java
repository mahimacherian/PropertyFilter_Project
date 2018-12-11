package Scenario_Component;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Component.Base_Class;
import PageObject_Component.PageObject_Search;

public class Scenario_Search extends Base_Class {
	
	public static Logger log= Logger.getLogger(Scenario_Search.class);
	SoftAssert sAssert= new SoftAssert();
	
	@Test(dataProvider = "dp_ValidSearch", dataProviderClass=DataProvider_Component.DataProvider_Search.class)
	public void testValidSearch(Map Search) throws IOException, InterruptedException
	{
		String TC_ID = Search.get("TC_ID").toString();
		String Order = Search.get("Order").toString();
		String Search_item = Search.get("Search_item").toString();
		String Exp_Result = Search.get("Exp_Result").toString();
		
		Start_Server();
		log.info("Executing the Testcase " +TC_ID +" Order is  "+Order);
		
		Initialize_app();
		
		PageObject_Search PF_pob = new PageObject_Search(driver);
		
		Explicitwait(PF_pob.Search_btn, 25);
		PF_pob.Click_Search();
		
		Explicitwait(PF_pob.Search_txtbox, 25);
		PF_pob.Enter_Searchtxt(Search_item);
		
		Explicitwait(PF_pob.valid_text, 25);
		String Actual_Result = PF_pob.getValidmsg();
		
		
		if(Actual_Result.equals(Exp_Result))
		{
			
			PF_pob.Click_Valid();
			PF_pob.Click_Property();
			log.info("Passed as Actual Result is " +Actual_Result+ "  Expected Result is "+Exp_Result);
			
			
		}
		
		else
		{
			log.info("Failed as Actual Result is " +Actual_Result+ "  Expected Result is "+Exp_Result);
			sAssert.fail("Failed as Actual Result is " +Actual_Result+ "  Expected Result is "+Exp_Result);
		}
		
		
		
		
		Stop_Server();
		sAssert.assertAll();
	}
	
	
	@Test(dataProvider = "dp_InvalidSearch", dataProviderClass=DataProvider_Component.DataProvider_Search.class)
	public void testInvalidSearch(Map Search)
	{
		
		
		//Code for Invalid Search
		
	}
	
}
	
