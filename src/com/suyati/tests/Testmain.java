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
import org.openqa.selenium.chrome.ChromeOptions;
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
			WebDriver driver;
			System.setProperty("webdriver.chrome.driver",".//chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			/*options.addArguments("test-type");
			options.addArguments("start-maximized");
			options.addArguments("disable-infobars");
			options.addArguments("--disable-extensions");  */
			driver = new ChromeDriver();
			WebElement ele;
			
			driver.get("https://www.google.com/");
			ele=driver.findElement(By.id("lst-ib"));
			ele.sendKeys("Selenium");
			Thread.sleep(4000);
			//ffgg
			ele=driver.findElement(By.xpath("//div[@class='sbsb_a']/ul/li[6]/div/div[2]/b"));
			                         
		
			//ele=driver.findElement(By.xpath("//div[@class='sbsb_a']/ul/li/div/div[2]/b[contains(text(),'guru99')]"));
            
			System.out.println(ele.getText());
			ele.click();

		
			
				
		}
}



