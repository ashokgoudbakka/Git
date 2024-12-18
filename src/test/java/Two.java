import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.languagetool.JLanguageTool;
import org.languagetool.Language;
import org.languagetool.rules.RuleMatch;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;

import basic.New;

public class Two extends New {
	
	public WebDriver driver;
	
@Test
	public void add() throws IOException  {
	driver= initializeDriver();
	


	 //  String file =System.getProperty("user.dir")+"\\src\main\\java\\basic\\ashok.xlsx";
	   
	 String f=  System.getProperty("user.dir")+"\\src\\main\\java\\basic\\ashok.xlsx";

       // Read the Excel file
       try (FileInputStream fis = new FileInputStream(new String(f))) {

           // Create a workbook instance for .xlsx file
          XSSFWorkbook workbook = new XSSFWorkbook(fis);
           
           // Get the first sheet
           XSSFSheet sheet = workbook.getSheetAt(0);
           XSSFRow r= sheet.getRow(3);
           int rcount = sheet.getLastRowNum();
           System.out.println(rcount);
           int ccount = r.getLastCellNum();
           System.out.println(ccount);
           XSSFCell c= r.getCell(1);
           
           if (c != null && c.getCellType() == CellType.STRING) {
            String url = c.getStringCellValue();
        	
        	driver.get(url);
            System.out.println("No URL found in this cell.");
           }
          
           else {
             // Handle case where the cell is null or not a string
            System.out.println("No URL found in this cell.");
        }
           workbook.close();
           
          
       }
    

 catch (IOException e) {
  e.printStackTrace();
  
  } 
     
//	}


      


// Fetch page source
String pageSource = driver.getPageSource();
 // Close the browser

// Parse text from the page using JSoup
Document doc = Jsoup.parse(pageSource);
String visibleText = doc.text(); // Extract visible text


    //      Language lan = new BritishLanguage();
		
// Initialize LanguageTool for spell-checking
JLanguageTool langTool = new JLanguageTool( new English());


System.out.println("ccount");
try {
    List<RuleMatch> matches = langTool.check(visibleText);
    System.out.println("ccount");
    if (matches.isEmpty()) {
        System.out.println("No spelling errors found!");
    } else {
        System.out.println("Spelling errors detected:");
        for (RuleMatch match : matches) {
            System.out.println("Potential Error: " + match.getMessage());
            System.out.println("Suggestions: " + match.getSuggestedReplacements());
            System.out.println("At position: " + match.getFromPos() + " - " + match.getToPos());
        }
    }
} catch (Exception e) {
    e.printStackTrace();
}


}



    
	
}


      






