package DataProvider_Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

import Generic_Component.Excel_ReadWrite;

public class DataProvider_Search {
	
	@DataProvider(name="dp_ValidSearch")
	public static Iterator<Object[]> getValidSearchdata() throws IOException
	{
		List<Object[]> Obj = flagRowCount("ValidSearch");
		return Obj.iterator();
	}
	
	@DataProvider(name="dp_InvalidSearch")
	public static Iterator<Object[]> getInvalidSearchdata() throws IOException
	{
		List<Object[]> obj = flagRowCount("InvalidSearch");
		return obj.iterator();
	}
	
	public static List<Object[]> flagRowCount(String Scriptname) throws IOException
	{
		Excel_ReadWrite xl = new Excel_ReadWrite("F:\\Appium\\PropertySearch\\Project\\TestData\\TestData.xls");
		HSSFSheet Scenario_Search = xl.Setsheet("Scenario_PropertySearch");
		
		int RowCount = xl.getrowcount(Scenario_Search);
		int ColCount = xl.getcolcount(Scenario_Search, 0);
		
		//Create the list of Object array
		List<Object[]> list_Search = new ArrayList<Object[]>();
		
		
		for(int irow=1;irow<=RowCount; irow++)
		{
			String Execute_Flag = xl.Readvalue(Scenario_Search, irow, "Execute_Flag");
			String Script_Name = xl.Readvalue(Scenario_Search, irow, "Script_name");
			
			if((Execute_Flag.equals("Y")) && (Script_Name.equals(Scriptname)))
			{
				
				//Create the Map
				Map<String,String> dsMap = new HashMap<String,String>();
				
				for(int jcol=0;jcol<=ColCount;jcol++)
				{
					String Key = xl.Readvalue(Scenario_Search, 0, jcol);
					String Value = xl.Readvalue(Scenario_Search, irow, jcol);
					
					dsMap.put(Key,Value);
					
				}
				
				Object[] x = new Object[1];
				x[0] = dsMap;
				
				list_Search.add(x);
				
			}
			
			
		}
		return list_Search;
		
	}
	
	

}
