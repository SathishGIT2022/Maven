package org.fish;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Actions act;
	public static Alert a;
	public static JavascriptExecutor js;
	
	//browser launch
	public static void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	//window max
	public static void windowMax() {
       driver.manage().window().maximize();
		
	}
	
	// 1.WEBDRIVER METHODS
	//get()
	public static void launchUrl(String url) {
      driver.get(url);
	}
	
	//getTitle()
	public static void pageTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	//getCurrenturl()
	public static void pageUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}
	
	//close()
	public static void pageClose() {
		driver.close();
	}
	
	//quit()
	public static void pageQuit() {
		driver.quit();
	}
	
	//getWindowHandle() 
	public static void windowHandle() {
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
	}

	//getWindowHandles() 
	public static void windowHandles() {
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
	}
	
	
	
	// 2.WEBELEMENT METHODS
	//sendKeys()
	public static void sendText(String txt, WebElement sendtxt) {
		sendtxt.sendKeys(txt);
	}
	
	//click()
	public static void clickBox(WebElement txtclick) {
		txtclick.click();
		}
	
	//getText()
		public static void pageText(WebElement text) {
			String text2 = text.getText();
			System.out.println(text2);
		}
	
	//getAttribute()
		public static void pageAttribute(String txt, WebElement atti) {
			String attribute = atti.getAttribute(txt);
			System.out.println(attribute);
		}
		
		
		//ACTIONS
		//moveToElement()
		public static void pageMove(WebElement target) {
			act = new Actions(driver);
			act.moveToElement(target).perform();
		}
		
		//dragAndDrop()
		public static void pageDrag(WebElement source, WebElement target) {
			act = new Actions(driver);
			act.dragAndDrop(source, target).perform();
		}
		
		//doubleClick() 
		public static void pageDouble(WebElement dd) {
			act = new Actions(driver);
			act.doubleClick(dd).perform();
		}
		
		//contextClick() 
		public static void pageContext(WebElement ff) {
			act = new Actions(driver);
			act.contextClick(ff).perform();
		}
		
		
		// 3.ALERT
		//simple alert using accept()
		public static void pageAccept() {
			a = driver.switchTo().alert();
			a.accept();
		}
		
		//confirm alert using accept() & dismiss()
		public static void pageDismiss() {
			a = driver.switchTo().alert();
			a.dismiss();

		}
		
		//prompt alert sendKey(), accept() & dismiss()
		public static void pageAlert(String txt) {
			a = driver.switchTo().alert();
			a.sendKeys(txt);
		}
		
		// alert getText()
		public static void alertGetText() {
			a=driver.switchTo().alert();
			String text = a.getText();
			System.out.println(text);
		}
		
		
		
		// 4.TAKE SCREENSHOT
		public static void screenshot(String desPath) throws IOException {
		    TakesScreenshot ts =(TakesScreenshot)driver;
		    File src = ts.getScreenshotAs(OutputType.FILE); 
		    File des=new File(desPath); 
		    FileUtils.copyFile(src, des); 
		}
		
		
		// 5.JAVA SCRIPT EXECUTION 
		//scrollUp
		public static void scroolUp(WebElement webEle) {
		    js=(JavascriptExecutor)driver;
		    js.executeScript("arguments[0].scrollIntoView(false)", webEle);
		}
		
		//scrollDown
		public static void scrollDown(WebElement webEle) { 
		    js=(JavascriptExecutor)driver; 
		    js.executeScript("arguments[0].scrollIntoView(true)", webEle);  
		} 
		
		//sendKeys()-js 
		public static void jsSendkey(String txt,WebElement webEle) { 
		    js=(JavascriptExecutor)driver; 
		    js.executeScript("arguments[0].setAttribute('value','txt')", webEle); 
		} 
	
		//click()-js 
		public static void jsClick(WebElement webEle) { 
		    js=(JavascriptExecutor)driver; 
		    js.executeScript("arguments[0].click()", webEle); 	 
		} 
		
		
		// 6.Waits
		//ImplicitWait 
		public static void implicitWait(long sec) {
			driver.manage().timeouts().implicitlyWait(sec,TimeUnit.SECONDS);
		}
		
		//ExplicitWait 
		//alertIsPresent wait 
		public static void alertPresentWait(long sec) { 
		    WebDriverWait w=new WebDriverWait(driver, sec); 
		    w.until(ExpectedConditions.alertIsPresent()); 
		} 
	
	
		//fluentWait 
		//invisibilityOf() 
		public static void fluentMilliSec(long milliSec,long pollingSec,WebElement webEle) { 
		     FluentWait<WebDriver> f=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMillis(milliSec)).pollingEvery(Duration.ofMillis(pollingSec)).ignoring(Throwable.class); 
		     f.until(ExpectedConditions.invisibilityOf(webEle)); 
		} 
		
		//alertIsPresent() 
		public static void fluentSec(long sec,long pollingSec) { 
		FluentWait<WebDriver> f=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(sec)).pollingEvery(Duration.ofSeconds(pollingSec)).ignoring(Throwable.class); 
		f.until(ExpectedConditions.alertIsPresent()); 
		} 

		
		// 7.DataDriven
		//createExcel
		public static void createExcel(int rowNum, int cellNum, String setData) throws IOException {
			File f = new File("C:\\Users\\Koli\\eclipse-workspace\\Maven\\Excel Files\\files.xlsx");
			Workbook w = new XSSFWorkbook();
			Sheet newSheet = w.createSheet("sample sheet");
			Row newRow = newSheet.createRow(rowNum);
			Cell newCell = newRow.createCell(cellNum);
			newCell.setCellValue(setData);
			FileOutputStream fos = new FileOutputStream(f);
			w.write(fos);
			System.out.println("writed");
            }
		
		//createCell
		public static void createCell(int getTheRow, int crtCell, String setData) throws IOException {
			File f = new File("C:\\Users\\Koli\\eclipse-workspace\\Maven\\Excel Files\\files.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook w = new XSSFWorkbook(fis);
			Sheet newSheet = w.getSheet("sample sheet");
			Row newRow = newSheet.getRow(getTheRow);
			Cell newCell = newRow.createCell(crtCell);
			newCell.setCellValue(setData);
			FileOutputStream fos = new FileOutputStream(f);
			w.write(fos);
			System.out.println("writed");
		}
		
		
		//createRow
		public static void createRow(int creRow, int crtCell, String setData) throws IOException {
			File f = new File("C:\\Users\\Koli\\eclipse-workspace\\Maven\\Excel Files\\files.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook w = new XSSFWorkbook(fis);
			Sheet newSheet = w.getSheet("sample sheet");
			Row newRow = newSheet.createRow(creRow);
			Cell newCell = newRow.createCell(crtCell);
			newCell.setCellValue(setData);
			FileOutputStream fos = new FileOutputStream(f);
			w.write(fos);
			System.out.println("writed");
		}
		
		
		
		
		
		
		
		
		
		
		
		
}


