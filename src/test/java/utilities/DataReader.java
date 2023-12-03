package utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataReader 
{

@DataProvider(name="RegistrationData")
public String[][] getData() throws IOException
{
	System.out.println("Controll has invoked getData() from DataReader Class ");
	  String path=".\\testData\\Registration_Data.xlsx";
	  UtilityClass uc= new UtilityClass(path);
	  
	int totalRows= uc.getRowCount( "Sheet1");
	System.out.println("totalRows is:"+ totalRows);
	
	int totalColms= uc.getCellCount( "Sheet1",1);
	System.out.println("totalColomns are:"+ totalColms);
	
	String regstrData[][]=new String [totalRows][totalColms];
	
	System.out.println(" Controll has created String of Double array");
	
			for(int i=1; i<=totalRows;i++)
			{
				for(int j=0; j<totalColms;j++)
				{
					regstrData[i-1][j]=uc.getCellData("Sheet1", i, j);
				}
			}
		
		System.out.println("Excel Data is:"+regstrData);
		return regstrData;
				
	
}   




@DataProvider(name="LoginData")
public String[][] readData() throws IOException
{
	System.out.println("Controll has invoked getData() from DataReader Class ");
	  String path=".\\testData\\Registration_Data.xlsx";
	  UtilityClass uc= new UtilityClass(path);
	  
	int totalRows= uc.getRowCount( "Sheet1");
	System.out.println("totalRows is:"+ totalRows);
	
	int totalColms= uc.getCellCount( "Sheet1",1);
	System.out.println("totalColomns are:"+ totalColms);
	
	String regstrData[][]=new String [totalRows][totalColms];
	
	System.out.println(" Controll has created String of Double array");
	
			for(int i=1; i<=totalRows;i++)
			{
				for(int j=6; j<totalColms;j++)
				{
					regstrData[i-1][j]=uc.getCellData("Sheet1", i, j);
				}
			}
		
		System.out.println("Excel Data is:"+regstrData);
		return regstrData;
				
	
}   

     }


