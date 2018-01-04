package com.suyati.frameworkengine;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.suyati.tests.Startup;

public class TestExecutor {

	/**
	 * @param args
	 * @throws Exception
	 */
	public void executeTest(String scenario) throws Exception {
		String scenarioName = scenario;
		WebElement ele = null;

		ExcelLibrary lib = new ExcelLibrary();
		ReadWER readwer = new ReadWER();
		int numOfSteps = lib.getRowCount(scenarioName);
		for (int i = 1; i <= numOfSteps; i++) {

			String elementIdMethod = lib.getExcelData(scenarioName, i, 1);
			String logicalName = lib.getExcelData(scenarioName, i, 2);
			System.out.println("*****Logical Name****" + logicalName);
			try {
				String data1 = lib.getExcelData(scenarioName, i, 4);

			} catch (Exception e) {
				System.out.println("Exception --->" + e);
			}
			String elementIdValue = readwer.getElementFromRepository(logicalName);
			String action = lib.getExcelData(scenarioName, i, 3);
			String data = lib.getExcelData(scenarioName, i, 4);
			System.out.println(elementIdMethod + "---" + elementIdValue + "---" + action + "---" + data);

			// Conditions to find the element
			if (elementIdMethod.equals("name")) {
				try {
					ele = Startup.driver.findElement(By.name(elementIdValue));
				} catch (Exception e) {
					lib.setExcelData(scenarioName, i, 5, "FAIL");
					lib.setExcelData(scenarioName, i, 6, "Element " + logicalName + " not found");
					System.out.println("Element " + logicalName + " not found");
					ele = null;
				}
			} else if (elementIdMethod.equals("id")) {
				try {
					ele = Startup.driver.findElement(By.id(elementIdValue));
				} catch (Exception e) {
					lib.setExcelData(scenarioName, i, 5, "FAIL");
					lib.setExcelData(scenarioName, i, 6, "Element " + logicalName + " not found");
					System.out.println("Element " + logicalName + " not found");
					ele = null;
				}
			} else if (elementIdMethod.equals("css")) {
				try {
					ele = Startup.driver.findElement(By.cssSelector(elementIdValue));
				} catch (Exception e) {
					System.out.println("Element " + logicalName + " not found");
					ele = null;
				}
			} else if (elementIdMethod.equals("xpath")) {
				try {
					ele = Startup.driver.findElement(By.xpath(elementIdValue));
				} catch (Exception e) {
					lib.setExcelData(scenarioName, i, 5, "FAIL");
					lib.setExcelData(scenarioName, i, 6, "Element " + logicalName + " not found");
					System.out.println("Element " + logicalName + " not found");
					ele = null;
				}
			} else if (elementIdMethod.equals("linkText")) {
				try {
					ele = Startup.driver.findElement(By.linkText(elementIdValue));
				} catch (Exception e) {
					lib.setExcelData(scenarioName, i, 5, "FAIL");
					lib.setExcelData(scenarioName, i, 6, "Element " + logicalName + " not found");
					System.out.println("Link " + logicalName + " not found");
					ele = null;
				}
			}

			else if (elementIdMethod.equals("partialLinkText")) {
				try {
					ele = Startup.driver.findElement(By.partialLinkText(elementIdValue));
				} catch (Exception e) {
					lib.setExcelData(scenarioName, i, 5, "FAIL");
					lib.setExcelData(scenarioName, i, 6, "Element " + logicalName + " not found");
					System.out.println("Link " + logicalName + " not found");
					ele = null;
				}
			}

			else if (elementIdMethod.equals("linkTextdynamic")) {
				try {
					ele = Startup.driver.findElement(By.linkText(data));
				} catch (Exception e) {
					System.out.println("Link " + logicalName + " not found");
					ele = null;
				}
			}

			else if (elementIdMethod.equals("tagname")) {
				System.out.println("Tag name session");
				try {
					ele = Startup.driver.findElement(By.tagName(elementIdValue));
					System.out.println("Value of element is " + elementIdValue);
					List<WebElement> elelist;

				} catch (Exception e) {
					System.out.println("tagname " + logicalName + " not found");
					ele = null;
				}
			}

			else if (elementIdMethod.equals("class")) {
				try {
					ele = Startup.driver.findElement(By.className(elementIdValue));
				} catch (Exception e) {
					System.out.println("Element " + logicalName + " not found");
					ele = null;
				}
			}

			// Perform action
			if (action.equals("sendKeys")) {
				System.out.println("inside the sendkeys");
				if (ele != null) {
					ele.sendKeys(data);
					lib.setExcelData(scenarioName, i, 5, "PASS");
					lib.setExcelData(scenarioName, i, 6, "Typed " + data + " into " + logicalName + " text box");
				} else {
					System.out.println("ele is null");
				}
			}

			else if (action.equals("click")) {
				if (ele != null) {
					ele.click();
					lib.setExcelData(scenarioName, i, 5, "PASS");
					lib.setExcelData(scenarioName, i, 6, "clicked on " + logicalName);
					System.out.println("clicked on " + logicalName);
				}
			} else if (action.equals("accept alert")) {
				try {

					Alert simpleAlert = Startup.driver.switchTo().alert();
					System.out.println(simpleAlert.getText());
					simpleAlert.accept();

					lib.setExcelData(scenarioName, i, 5, "PASS");
					lib.setExcelData(scenarioName, i, 6, "Accepted  " + logicalName);
					System.out.println(" Accepted" + logicalName);

				} catch (WebDriverException e) {
					System.out.println(e);
					lib.setExcelData(scenarioName, i, 5, "FAIL");
					lib.setExcelData(scenarioName, i, 6, "Not Accepted " + logicalName);
					System.out.println("Not Accepted  " + logicalName + " alert");
				}

			}

			else if (action.equals("clear")) {
				if (ele != null) {
					ele.clear();
					lib.setExcelData(scenarioName, i, 5, "PASS");
					lib.setExcelData(scenarioName, i, 6, "clear the field  " + logicalName);
					System.out.println("clear the data on " + logicalName);
				}
			}

			else if (action.equals("wait")) {

				long data1 = Integer.parseInt(data);
				Thread.sleep(data1);
				lib.setExcelData(scenarioName, i, 5, "PASS");
				lib.setExcelData(scenarioName, i, 6,
						"Waiting for " + data + " millisecond " + logicalName + " text box to be present");
				System.out.println("Typed " + data + " into " + logicalName + " text box");

			}

			else if (action.equals("searchElement")) {
				try {
					Boolean foundit = null;
					ele = Startup.driver.findElement(By.xpath(elementIdValue));
					List<WebElement> cells = ele.findElements(By.tagName("td"));
					for (WebElement cell : cells) {
						if (cell.getText().contains(data)) {
							foundit = true;
							System.out.println("***Found It ***" + foundit);
							lib.setExcelData(scenarioName, i, 5, "PASS");
							lib.setExcelData(scenarioName, i, 6, "Found " + logicalName);
							System.out.println("found it  on " + logicalName);
						} else {
							foundit = false;
						}
					}
				} catch (Exception e) {
					lib.setExcelData(scenarioName, i, 5, "FAIL");
					lib.setExcelData(scenarioName, i, 6, "Element " + logicalName + " not found");
					System.out.println("Link " + logicalName + " not found");
					ele = null;
				}
			}

			else if (action.equals("select")) {
				if (ele != null) {
					Select dd = new Select(ele);
					dd.selectByVisibleText(data);
					lib.setExcelData(scenarioName, i, 5, "PASS");
					lib.setExcelData(scenarioName, i, 6, "Selected the field  " + logicalName);
				}
			} else if (action.equals("switchWindow")) {
				boolean flag = false;
				Set<String> allWindowHandles = Startup.driver.getWindowHandles();
				Iterator<String> it = allWindowHandles.iterator();
				while (it.hasNext()) {
					Startup.driver.switchTo().window(it.next());
					String actual = Startup.driver.getTitle();
					if (actual.equals(data)) {
						System.out.println("Switched to window");
						flag = true;
						break;
					}

				}
				if (!flag) {
					System.out.println("No window with the title");
				}
			} else if (action.equals("switchToFrame")) {
				Startup.driver.switchTo().frame(ele);
				System.out.println("Switched to frame");
			}

			else if (action.equals("switchToFramedata")) {
				Startup.driver.switchTo().frame(data);
				System.out.println("Switched to framedata");
			} else if (action.equals("switchBackFromFrame")) {
				Startup.driver.switchTo().defaultContent();
			} else if (action.equals("verifyTitle")) {
				String actualTitle = Startup.driver.getTitle();

				if (data.equals(actualTitle)) {
					System.out.println("Title matches");
					lib.setExcelData(scenarioName, i, 5, "PASS");
					lib.setExcelData(scenarioName, i, 6, "TITLE matches : " + actualTitle);
				} else {
					System.out.println("Title fails to match");
				}
			} else if (action.equals("verifyText")) {
				if (ele != null) {
					String actualText = ele.getText();
					if (actualText.equals(data)) {
						System.out.println("Text matches");
						lib.setExcelData(scenarioName, i, 5, "PASS");
						lib.setExcelData(scenarioName, i, 6, "Text matches : " + actualText);
					} else {
						System.out.println("Actual value " + actualText + " does not match " + data);
						lib.setExcelData(scenarioName, i, 5, "FAIL");
						lib.setExcelData(scenarioName, i, 6, "Text doesnot matches : " + actualText);
					}
				}
			} else if (action.equals("getText")) {
				if (ele != null) {
					String Text = ele.getText();
					lib.setExcelData(scenarioName, i, 5, "PASS");
					lib.setExcelData(scenarioName, i, 6, "Element present : " + Text);

				}

				else {
					System.out.println("Value doesnot match ");
				}

			}
			// Modified by Nandini

			else if (action.equals("getTextContent")) {
				if (ele != null) {
					String Text = ele.getAttribute("textContent");
					lib.setExcelData(scenarioName, i, 5, "PASS");
					lib.setExcelData(scenarioName, i, 6, "Element present : " + Text);
					System.out.println("****Text*****" + Text);

				}

				else {
					System.out.println("Value doesnot match ");
				}

			}

			else if (action.equals("verifyElement")) {
				if (ele != null) {
					System.out.println("Element found");
					lib.setExcelData(scenarioName, i, 5, "PASS");
					lib.setExcelData(scenarioName, i, 6, "Element present : " + logicalName);
				} else {
					System.out.println("Element not found");
				}

			}

			else if (action.equals("mouseover")) {
				if (ele != null) {

					Actions act = new Actions(Startup.driver);
					act.moveToElement(ele).build().perform();
					System.out.println("Mouseover");
					lib.setExcelData(scenarioName, i, 5, "PASS");
					lib.setExcelData(scenarioName, i, 6, "Element present : " + logicalName);
				} else {
					System.out.println("Element not found");
				}

			} else if (action.equals("Enablebutton")) {

				System.out.println("Inside Enablebutton");
				JavascriptExecutor jse = (JavascriptExecutor) Startup.driver;
				jse.executeScript(
						"document.getElementsByClassName('btn btn-uppercase pull-right btn-register')[0].removeAttribute('disabled');");

				lib.setExcelData(scenarioName, i, 5, "PASS");
				lib.setExcelData(scenarioName, i, 6, "Element enabled : " + logicalName);

			}
		}
	}
}
