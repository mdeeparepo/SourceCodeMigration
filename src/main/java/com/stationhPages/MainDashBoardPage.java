package com.stationhPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resources.FunctionalLibrary;

public class MainDashBoardPage {
	
	@FindBy(xpath = "//span[text()='Resources']")
	public WebElement resourcesLabel;
	
	@FindBy(xpath="//button[text()='Apps']")
	public WebElement appsBTN;
	
	@FindBy(xpath="//input[@name='searchText']")
	public WebElement appSearchBox;

	/**
	 * Constructor to instantiate the page elements
	 */
	public MainDashBoardPage() {
		PageFactory.initElements(FunctionalLibrary.driver, this);
	}
	
	/**
	 * 
	*Getters
	 */
	
	public WebElement getResources() {
		return resourcesLabel;
	}
	
	public WebElement getAppsBTN() {
		return appsBTN;
	}
	
	public WebElement getAppSearchBox(){
		return appSearchBox;
	}
	
	public WebElement getClickAppName(String applink) {
		return FunctionalLibrary.driver.findElement(By.xpath("//h3[text()='" + applink + "']"));
	}

	

	
	public void NavigateToAppsSection() throws Exception {
		try {
				FunctionalLibrary.click(getResources(), "Resources");
				FunctionalLibrary.waitFor(3000);
				FunctionalLibrary.click(getAppsBTN(), "Apps");
					
		} catch (Exception e) {
			//FunctionalLibrary.logStep(LogStatus.FAIL, "CPQ Login", "Login not successful", true);
			throw new Exception("Successfully navigated into Apps section");
		}
	}
	
	public void searchAppNameAndNavigate(String AppName) throws Exception{
		try {
			FunctionalLibrary.setText(getAppSearchBox(), "Searchbox", AppName);
			FunctionalLibrary.jsWaitForPageLoad();
			FunctionalLibrary.enterByROBOT();
			FunctionalLibrary.jsWaitForPageLoad();
			FunctionalLibrary.click(getClickAppName(AppName), AppName);
			FunctionalLibrary.implicitWait(10);
			FunctionalLibrary.switchToWindow();
			
			
	} catch (Exception e) {
		//FunctionalLibrary.logStep(LogStatus.FAIL, "CPQ Login", "Login not successful", true);
		throw new Exception("Successfully navigated into selected app");
	}
}
		

}
