package Scenario_Component;

import java.io.IOException;
import java.io.ObjectOutputStream.PutField;

import org.testng.annotations.Test;

import Generic_Component.Base_Class;
import PageObject_Component.PageObject_Search;
import PageObject_Component.PageObject_SendMail;
import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.Explicit;

public class Scenario_SendMail extends Base_Class{
	
	
	@Test
	public void testSendMail() throws IOException, InterruptedException
	{
		String TC_ID = "PF_06";
		
		Start_Server();
		
		Initialize_app();
		
		PageObject_Search PF_pob = new PageObject_Search(driver);
		
		PageObject_SendMail PF_sm = new PageObject_SendMail(driver);
		
		
		Explicitwait(PF_pob.Search_btn, 25);
		PF_pob.Click_Search();
		
		Explicitwait(PF_pob.Search_txtbox, 25);
		PF_pob.Search_txtbox.sendKeys("jlt");
		
		PF_pob.Click_Valid();
	
		Thread.sleep(4000);
		
		PF_pob.Click_Property();
		
		Explicitwait(PF_sm.email_btn,25);
		PF_sm.Click_Email();
		
		Explicitwait(PF_sm.name,25);
		PF_sm.enterName();
		
		PF_sm.enterMailId();
		
		PF_sm.enterPhNumber();
		
		PF_sm.clickSend();
		
		
		Stop_Server();
		
		
		
	}
	
	

}
