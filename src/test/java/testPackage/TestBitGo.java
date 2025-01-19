package testPackage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.io.*;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.junit.BeforeClass;
import org.junit.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBitGo {
	Playwright playwright = Playwright.create();
	 Browser browser =null;
	 Page page = null;
	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			System.out.println("start");
		     
	
		
		  // 
		  
		     
		    }
		  
	catch(Exception e)
		{
		e.printStackTrace();
		}
}
	@BeforeClass()
	public void startTest()
	{
		 BrowserType chromium = playwright.chromium();
	      browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("msedge"));
	       page = browser.newPage();
//	      page.navigate("https://vedabase.io/en/library/bg/2/7");
	      
	 
	}
	
	@Test()
	public void verifyText()
	{
		page.navigate("https://blockstream.info/block/000000000000000000076c036ff5119e5a5a74df77abf64203473364509f7732");
		 String transaction_list =   page.locator("div.transactions>h3").textContent();
		
		  assertTrue(transaction_list.contains("25 of 2875 Transactions"));
	}
	

	@Test()
	public void printTransactions()
	{
		  for(int i=1;i<=25;i++) {
				List<Locator> locatorListIn =  page.locator("div#transaction-box:nth-of-type("+i+") div.vin:nth-of-type(1)").all();
				List<Locator> locatorListOut =  page.locator("div#transaction-box:nth-of-type("+i+") div.vout:nth-of-type(1)").all();
				if(locatorListIn.size()==1 && locatorListOut.size()==2)
					System.out.println(page.locator("div#transaction-box:nth-of-type("+i+") div.header > div > a").textContent());
				
				  }
	}
	
	@AfterClass()
	public void afterClass()
	{
		browser.close();
	}
}
