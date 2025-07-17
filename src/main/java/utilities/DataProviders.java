package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData1")
	public String [][] getData() throws IOException
	{
		String path=".\\TestData\\EmailData2.xlsx"; // taking xl file from testdata
		
		ExcelUtility xlutil=new ExcelUtility(path); // creating object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);
		 
		String logindata[][] = new String[totalrows][totalcols];//created for two dimension array which store array		
		for(int i=1;i<=totalrows;i++)  // read the data from xl storing in two dimensional array
		{
			for(int j=0;j<totalcols;j++) //i is row j is col
			{
				logindata[i-1][j] = xlutil.getCellData("Sheet1", i, j); //1,0
			}
		}
		return logindata;
		
	}

}
