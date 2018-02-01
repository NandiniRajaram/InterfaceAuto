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
		
			String client="Family Dollar";
			/* String Query ="Select count(distinct s.CompanyNumber)  from oneviewV2.dbo.Site s Inner Join oneviewV2.dbo.System sy on s.Id=sy.SiteId " +
        	 		 "where sy.code in ('IPNETW','BURG','VOIP','CCTV','INTVIDEO')  And (sy.Status = 'Active' Or sy.Status = 'Service Only')  and  s.tempclosed <> '1' and s.PermClosed  <> '1' "+
        	 		 "and s.mastercompany ='Family Dollar'"; */
			
			String wer="ddd "+client;
        	 System.out.println(wer );			
		}
}



