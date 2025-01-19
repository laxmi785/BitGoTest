import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class TDT_Test {

	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			System.out.println("start");
		      BrowserType chromium = playwright.chromium();
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("msedge"));
		      Page page = browser.newPage();
//		      page.navigate("https://vedabase.io/en/library/bg/2/7");
		      page.navigate("https://blockstream.info/block/000000000000000000076c036ff5119e5a5a74df77abf64203473364509f7732");
		  String transaction_list =   page.locator("div.transactions>h3").textContent();
		  System.out.println("transaction_list "+transaction_list);
		  
		      
		      Thread.sleep(5000);
	//25 of 2875 Transactions
		      
		      String filePath ="C:\\Users\\laxmi\\Downloads\\Contacts_latest1.xlsx"; // Replace with your file path
			     FileInputStream fileinputStream = new FileInputStream(filePath);
			     XSSFWorkbook xssfworkbook = new XSSFWorkbook(fileinputStream);
			     XSSFSheet xssfsheet = xssfworkbook.getSheetAt(0);
			     DataFormatter formatter = new DataFormatter();
			     for(int i=1;i<19;i++) {
			    String mobileno= formatter.formatCellValue(xssfsheet.getRow(i).getCell(1));
			    		 String name= formatter.formatCellValue(xssfsheet.getRow(i).getCell(0));  
			    		 String MarStatus= formatter.formatCellValue(xssfsheet.getRow(i).getCell(2));  
			    		 String Profession= formatter.formatCellValue(xssfsheet.getRow(i).getCell(3));  
			    		 page.locator("input[name='name']").fill(name);
			    		 Thread.sleep(500);
			    				 page.locator("input[name='phone']").fill(mobileno);
			    				 Thread.sleep(500);
			    				 page.locator("//label[contains(text(),'Select Profession')]/parent::div").click();
			    				 Thread.sleep(500);
			     page.locator("//li[contains(text(),'"+Profession+"')]").click();
			    
			     
			     Thread.sleep(500);
			     page.locator("input[name='registered_by']").fill("DEEP PRABHUJI");
			     Thread.sleep(1000);
			     page.locator("//label[contains(text(),'Branch')]/parent::div/div");
			     Thread.sleep(1000);
			     page.locator("//li[contains(text(),'AECS')]").click();
			     Thread.sleep(500);
			     page.locator("button[type='submit']").click();
			     Thread.sleep(5000);
//			     page.locator("//button[text()='OK']").click();
			     System.out.println("\nSuccessfully added: "+mobileno);
			     }
		      System.out.println("\ndone ");
		      Thread.sleep(2000);
		      // other actions...
		      browser.close();
		    }
		  
	catch(Exception e)
		{
		e.printStackTrace();
		}

}
}
