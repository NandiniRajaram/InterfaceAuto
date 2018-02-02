package com.suyati.frameworkengine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchObject {
	WebDriver driver;

	public SearchObject(WebDriver driver) {
		this.driver=driver;
		
		// TODO Auto-generated constructor stub
	}
	 String SiteName()
	 {
	String siteName= 	 driver.findElement(By.xpath("//h3[text()='Site Info']/parent::div/table//tr[1]/td")).getText();
		 System.out.println("I have entered some" );
		return siteName;
	 }
	 
	 String siteAddress()
	 {
		 String siteAddress =  driver.findElement(By.xpath("(//h3[text()='Site Info']/parent::div/table//tr[3]/td)[1]")).getText();
		 return siteAddress;
	 }
	 
	 String cityStateCode()
	 {
		 String cityStateCode=  driver.findElement(By.xpath("(//h3[text()='Site Info']/parent::div/table//tr[4]/td)[1]")).getText();
		 return cityStateCode;
	 }
	 

}
