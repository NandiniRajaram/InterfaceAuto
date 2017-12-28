package com.suyati.tests;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SwitchToWindow;
import org.openqa.selenium.support.ui.Select;




import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class Testmain {


	
		/**
		 * @param args
		 * @throws InterruptedException 
		 * @throws IOException 
		 */
		public static void main(String[] args) throws InterruptedException, IOException {
		
			/*System.setProperty("webdriver.chrome.driver","E:\\Framework\\hybridframework\\lib\\chromedriver.exe");
			= new ChromeDriver();
					driver.get("http://toolsqa.com/automation-practice-switch-windows/");
				
			System.setProperty("webdriver.gecko.driver", "E:\\Project\\Framework_SAIG\\hybridframework\\lib\\geckodriver.exe");
			WebDriver driver =new FirefoxDriver();	 	 
			System.setProperty("webdriver.chrome.driver","E:\\Framework\\hybridframework\\lib\\chromedriver.exe");
			//System.setProperty("webdriver.gecko.driver", "E:\\Project\\Framework_SAIG\\hybridframework\\lib\\geckodriver.exe");
			WebDriver driver = new ChromeDriver();	
		
				
			
			driver.get("https://oneview.interfacesys.com");
		WebElement ele;
			
            String str=driver.getTitle();
			System.out.println(str);
			ele=driver.findElement(By.id("txt_username"));
			ele.sendKeys("faiz.dani");
			ele=driver.findElement(By.id("txt_password"));
			ele.sendKeys("Interface1");
			ele=driver.findElement(By.id("btn_submit"));
			ele.click();
			/*System.out.println("before click");
			ele=driver.findElement(By.partialLinkText("Cookie"));
			ele.click();
			List <WebElement> alllist =new ArrayList<WebElement>();
			alllist =driver.findElements(By.tagName("a"));
			
			for(int i=0; i<alllist.size();i++)
			{
				ele=alllist.get(i);
				System.out.println(ele.getAttribute("href") + " : " +ele.getText());
			}
			ele=driver.findElement(By.id("day"));
			Select se=new Select(ele);
			se.selectByIndex(2); 
			
		
			
			ele=driver.findElement(By.id("month"));
			 se=new Select(ele);
			se.selectByVisibleText("Aug");
			ele=driver.findElement(By.id("u_0_6"));
			ele.click();
			
			
			ele=driver.findElement(By.id("u_0_4"));
			ele.click(); 
				
			Thread.sleep(5000);
			ele=driver.findElement(By.xpath("//button[contains(text(),'Simple Alert')]"));
			ele.click(); 
			Alert alt=driver.switchTo().alert();
			Thread.sleep(5000);
			System.out.println(alt.getText());
			alt.accept();
			*/
	
			
		
			ReadConfig config=new ReadConfig();
			
			ReadConfig rc = new ReadConfig();
			
			String browser = rc.getConfiguration("BROWSER");
System.out.println(browser);
		
		
		
		}
	}




 class ReadConfig {
	 
	public String getConfiguration(String logicalName) throws IOException {
		String retVal=null;
		 String current = new java.io.File( "." ).getCanonicalPath();
	        System.out.println("Current dir:"+current);
		try {
			FileInputStream fis = new FileInputStream("./config/config.properties");
			//E:\Workspace\InterfaceAutomation\config\config.properties
		
			Properties properties = new Properties();
			properties.load(fis);
			retVal = properties.getProperty(logicalName);			
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retVal;
	}
}




