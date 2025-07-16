package com.resources;
import java.text.*;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.StaleElementReferenceException;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.jasypt.util.text.BasicTextEncryptor;
import org.joda.time.LocalDateTime;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.FluentWait; 



public class FunctionalLibrary {

	public static WebDriver driver = null;
	private static String homeWindow = null;
	public static WebDriverWait wd;
	public static Properties prop;
	public static FileReader reader;

	/***
	 * To Launch the browser
	 * @param browser
	 * @return
	 */
	public static WebDriver driverInit(String browser) {
		switch(browser){
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("disable-infobars");
			//chromeOptions.addArguments("--incognito");
			chromeOptions.addArguments("--disable-web-security");
			chromeOptions.addArguments("--allow-running-insecure-content");				
			//chromeOptions.addArguments("window-size=2280,2024");
			//1280,1024
			
			chromeOptions.addArguments("--no-sandbox");
			chromeOptions.addArguments("--disable-gpu");			
			//chromeOptions.addArguments("--disable-extensions");
			chromeOptions.addArguments("--dns-prefetch-disable");
			chromeOptions.addArguments("--disable-browser-side-navigation");
			chromeOptions.addArguments("enable-automation");

			driver = new ChromeDriver(chromeOptions);
			//logStep(LogStatus.PASS, "Launch Chrome Browser", "Chrome browser launch successfully", false);
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", "src/main/resources/lib/IEDriverServer_32.exe");
			DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
			capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capability.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			//driver = new InternetExplorerDriver(capability);
			//logStep(LogStatus.PASS,"Launch IE Browser","IE browser launch successfully",false);
			break;
		case "ff":
			//driver = new FirefoxDriver();
			//logStep(LogStatus.PASS,"Launch FireFox Browser","Firefox browser launch successfully",false);
			System.setProperty("webdriver.gecko.driver", "src/main/resources/lib/geckodriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette",true);
			//driver= new FirefoxDriver(capabilities);
			break;
		default:
			break;
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}


public static void setText(WebElement element,String ElementReadableName, String value) throws Exception {
	try {		
		//element.clear();
		Thread.sleep(1000);
		element.sendKeys(value);
		//logStep(LogStatus.PASS, "Enter value as "+value+ " in "+ElementReadableName+" Textbox", "Value entered into "+ElementReadableName+" textbox successfully",false);
		//logPassedStep(LogStatus.PASS, "Enter value as "+value+ " in "+ElementReadableName+" Textbox", "Value entered into "+ElementReadableName+" textbox successfully");
	}
	catch (Exception e) {
		//logStep(LogStatus.FAIL, "Enter value as "+value+ " in "+ElementReadableName+" Textbox", "Value not entered into "+ElementReadableName+" textbox ",true);		
		e.printStackTrace();
		throw new Exception("Value not entered into "+ElementReadableName+" textbox ");
	}
}




public static void jsWaitForPageLoad() {
	String pageReadyState = (String) ((JavascriptExecutor)driver).executeScript("return document.readyState");
	while(!pageReadyState.equals("complete"))
	{
		pageReadyState = (String) ((JavascriptExecutor)driver).executeScript("return document.readyState");

	}
}

public static void closeBrowser() {
	try {
		//driver.quit();
		//logStep(LogStatus.PASS, "Close browser", "Browser closed successfully",false);
	}
	catch (Exception e) {
		//logStep(LogStatus.FAIL, "Close browser", "Browser is not closed",true);
	}
}

public static void click(WebElement element,String ElementReadableName) throws Exception {
	try{
		element.click();			
		//logPassedStep(LogStatus.PASS, "Click on "+ElementReadableName,ElementReadableName+ " Element is clicked successfully");
	} catch (Exception e) {
		//logStep(LogStatus.FAIL, "Click on "+ElementReadableName, ElementReadableName+" Element is not clicked",true);
		throw new Exception("Element is not clicked");
	}
}

public static void waitFor(long wait) throws Exception {
	Thread.sleep(wait);
}

public static void doubleClick(WebElement element,String ElementReadableName) throws Exception {
	 
	try{		
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();		
		//logPassedStep(LogStatus.PASS, "Mouseover to the "+ElementReadableName +" element and click" , "Mouseover to the "+ElementReadableName +" element and clicked");
				
	}
	catch(Exception e){
		//logStep(LogStatus.FAIL, "Mouseover to the "+ElementReadableName +" element and click" , "No action perfromed to the "+ElementReadableName +" element",true);					 
		throw new Exception("No such Element present");
	}
}

public static void enterByROBOT() throws Exception {
	try {
		
		FunctionalLibrary.waitFor(2000);
		Robot robot=new Robot();
		robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		robot.delay(4000);
		robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
		FunctionalLibrary.waitFor(3000);
		//FunctionalLibrary.logPassedStep(LogStatus.PASS, "PDF file", "PDF file is downloaded successfully",true);
		
	} 
	catch (Exception e) {
		//logStep(LogStatus.FAIL,"Download File","Unable to Download file",true);
		throw new Exception("Unable to Download file");
	}
	
		}


public static void implicitWait(long time) {
	driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
}


public static void switchToWindow() {
	homeWindow = driver.getWindowHandle();
	for (String window : driver.getWindowHandles()) {
		if(!window.equals(homeWindow)) // added line to make sure window is switched to new window
		driver.switchTo().window(window);
	}
}

public static boolean verifyPageTitle(String expectedTitle) {
    String actualTitle = driver.getTitle();
    System.out.println(actualTitle);
    return actualTitle.equals(expectedTitle);
}

public static void waitForElementVisibility(WebElement element) {

	try{
        //implicitWait(10);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
        //logStep(LogStatus.PASS, "Element Visibility", "The Webelement is visible",false);
    }
    catch(Exception e){
        //logStep(LogStatus.FAIL, "Element Visibility", "The WebElement was not visible after a wait of 30 seconds",true);
    }
}

public static boolean isElementPresent(WebElement element) {
	boolean elementPresent = false;
	try {
		waitForElementVisibility(element);
		if (element.isDisplayed()) {
			elementPresent = true;
		}
		//logStep(LogStatus.PASS, "Verify Element Present", "Element is Displayed successfully",false);
	}
	catch (Exception e) {
		//logStep(LogStatus.FAIL, "Verify Element Present", "Element is not Displayed",true);
	}
	return elementPresent;
}

public static void scrolDown() throws Exception {
	try{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1000)", "");
		//System.out.println("scroll_1_inside");
	}catch(Exception e){
		throw new Exception("Unable to scroll down");
	}
}

public static void moveToElement(WebElement element) throws Exception {
    try {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform(); // Removed click()s
    } catch (Exception e) {
        throw new Exception("No action performed" );
    }
}

public static void moveToElementAndClick(WebElement element, String elementReadableName) throws Exception {
    try {
        Actions action = new Actions(driver);
        action.moveToElement(element).click().build().perform(); // Hover and click

    } catch (Exception e) {
        throw new Exception("Mouseover and click failed on " + elementReadableName);
    }
}

public static String getTextFromElement(WebElement element) throws Exception {
    try {
        String text = element.getText().trim();
        System.out.println( " Extracted Text"+ ": " + text);
        return text;
    } catch (Exception e) {
        throw new Exception("Failed to retrieve text from ");
    }
}



public static String getTextJS(WebElement element) throws Exception{

	try {JavascriptExecutor jse = (JavascriptExecutor)driver;
	Object obj = jse.executeScript( "return arguments[0].textContent;", element);
	return obj.toString();
	}
	
	catch(Exception e)
	{
		//logStep(LogStatus.FAIL, "Get Text" , "Unable to obtain the Text",true);					 
		throw new Exception("Unable to obtain the Text");
	}
	
}

public static void jsMouseOver(WebElement element,String readableelementname) throws Exception{
	try{
		String code = "var fireOnThis = arguments[0];" + "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initEvent( 'mouseover', true, true );" + "fireOnThis.dispatchEvent(evObj);";
		((JavascriptExecutor) driver).executeScript(code, element);
		//logStep(LogStatus.PASS, "Mouseover to the element", "Mouseover action is performed successfully",false);
	}
	catch(Exception e){
		//logStep(LogStatus.FAIL, "Mouseover to the element", "Mouseover action is not perforemed",true);
		throw new Exception("Mouseover is not performed on the elemnet "+readableelementname+"");
	}
}

public void loadProperties() throws Exception{
	
	try {
		prop = new Properties();
		reader=new FileReader(new File(new File(".")+"\\src\\main\\java\\com\\resources\\config.properties"));
		prop.load(reader);
	} 
	catch (Exception e) {
		//logStep(LogStatus.FAIL, "Load properties file", "Unable to load properties file",true);
		throw new Exception("Unable to load properties file");
	}
	
}
public String getProperties(String key) throws Exception{
	
	try {
		return prop.getProperty(key);
	} 
	catch (Exception e) {
		//logStep(LogStatus.FAIL, "Read properties file", "Unable to read properties file",true);
		throw new Exception("Unable to read properties file");
	}
	
}
public String screenCapture(String imgLocation){
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(scrFile, new File(imgLocation));
		//logStep(LogStatus.PASS, "Screen capture", "Captured screen successfully",false);
	} 
	catch (IOException e) {
		//logStep(LogStatus.FAIL, "Screen capture", "Screen is not captured",true);
	}
	return imgLocation;
}

public String fullScreenCapture(String imgLocation) throws HeadlessException, AWTException{

	try {
		
		BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(image, "png", new File(imgLocation)); 
		//logStep(LogStatus.PASS, "Full windows screen capture", "Captured screen successfully",false);
	} 
	catch (IOException e) {
		//logStep(LogStatus.FAIL, "Full windows screen capture", "Screen is not captured",true);
	}
	return imgLocation;
}

public static void switchToWindowUsingContainsTitle(String partialTitle, String readableName) throws Exception {
    try {
        String homeWindow = driver.getWindowHandle();
        boolean found = false;

        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
            String currentTitle = driver.getTitle();

            if (currentTitle.contains(partialTitle)) {
                System.out.println("✅ Switched to tab: " + readableName + " with title: " + currentTitle);
                found = true;
                break;
            }
        }

        if (!found) {
            driver.switchTo().window(homeWindow);
            throw new Exception("❌ Could not find window containing title: " + partialTitle);
        }

    } catch (Exception e) {
        throw new Exception("💥 Error while switching to window: " + readableName + "\n" + e.getMessage());
    }
}

public static void switchToWindowByIndex(int tabIndex) throws Exception {
    try {
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());

        if (tabIndex >= windowHandles.size()) {
            throw new Exception("❌ Tab index " + tabIndex + " exceeds available tab count.");
        }

        driver.switchTo().window(windowHandles.get(tabIndex));
        System.out.println("✅ Switched to tab: " +   " (Index: " + tabIndex + ")");
    } catch (Exception e) {
        throw new Exception("💥 Error while switching to tab: " +  "\n" + e.getMessage());
    }
}



public static void switchToWindow(String windowtitle) {
	homeWindow = driver.getWindowHandle();
	for (String window : driver.getWindowHandles()) {
		if(window.contains(windowtitle)) {
			driver.switchTo().window(window);
			break;
		}
	}
}

public static boolean VerifyTheText(WebElement element,String TextToVerify,String elementReadableName) throws Exception {
	boolean textValue = false;
	String text = "";
	try {				
		text = element.getText();
		if(text.contains(TextToVerify)){
			//logPassedStep(LogStatus.PASS, "Verify text of "+elementReadableName+"", "Text is displayed as "+text+" ,which is as expected",true);
			textValue  = true;
		}
		else
		{
			//logStep(LogStatus.FAIL, "Verify text of "+elementReadableName+"", "Text is displayed as "+text+" but it should be "+TextToVerify+"",true);
			
		}


	}
	catch (Exception e) {
		//logStep(LogStatus.FAIL, "Verify value of "+elementReadableName+"", "Unable to verify the value",true);
		throw new Exception("Unable to verify value of "+elementReadableName+"");
	}
	return textValue;

}

public static void switchToFrame(String frameName) throws Exception {
    try {
        driver.switchTo().frame(frameName);
    } catch (Exception e) {
        throw new Exception("No such frame present: " + frameName);
    }
}





}
	