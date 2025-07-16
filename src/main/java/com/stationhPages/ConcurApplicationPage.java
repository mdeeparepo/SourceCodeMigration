package com.stationhPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resources.FunctionalLibrary;

public class ConcurApplicationPage {
	@FindBy(xpath = "//span[text()='Resources']")
	public WebElement resourcesLabel;
	
	@FindBy(xpath="(//button[@aria-label='Home'])[2]")
	public WebElement HomeBTN;
	
	@FindBy(xpath="//a[@aria-label='App Center']")
	public WebElement appCenterBTN;
	
	@FindBy(xpath="//input[@type='text']")
	public WebElement enterPriseAppName;
	
	@FindBy(xpath="//span[@data-trans-id='Search']")
	public WebElement searchBTN;
	
	@FindBy(xpath="//img[@alt='Topia icon']")
	public WebElement appNameDisplayed;
	
	
	
	
	/**
	 * Constructor to instantiate the page elements
	 */
	public ConcurApplicationPage() {
		PageFactory.initElements(FunctionalLibrary.driver, this);
	}
	
	/**
	 * 
	*Getters
	 */
	
	public WebElement getResources() {
		return resourcesLabel;
	}
	
	public WebElement getHomeBTN() {
		return HomeBTN;
	}
	
	public WebElement getAppCenterBTN() {
		return appCenterBTN;
	}
	
	public WebElement getEnterpriseAppName() {
		return enterPriseAppName;
	}
	
	public WebElement getSearchBTN() {
		return searchBTN;
	}
	
	public WebElement getAppNameDisplayed() {
		return appNameDisplayed;
	}
	
	
	

	

	
	public void VerifyTitleofConcur(String TitleName) throws Exception {
		try {
				FunctionalLibrary.waitFor(9000);
				FunctionalLibrary.verifyPageTitle(TitleName);
				System.out.println("Successfully navigated into Apps section");
				
					
		} catch (Exception e) {
			//FunctionalLibrary.logStep(LogStatus.FAIL, "CPQ Login", "Login not successful", true);
			throw new Exception("Failed to navigate into Apps section");
		}
	}
	
	public void NavigateToAppCenter()throws Exception{
		try {
		FunctionalLibrary.click(getHomeBTN(), "Home");
		FunctionalLibrary.jsWaitForPageLoad();
		FunctionalLibrary.click(getAppCenterBTN(), "App Center");
		FunctionalLibrary.jsWaitForPageLoad();
		System.out.println("Successfully navigated into App center section");
	} catch (Exception e) {
		//FunctionalLibrary.logStep(LogStatus.FAIL, "CPQ Login", "Login not successful", true);
		throw new Exception("failed to navigate into App center section");
	}
	}
	
	public void VerifyTopiaApp(String EnterpriseAppName) throws Exception {
		try {
			FunctionalLibrary.setText(getEnterpriseAppName(), " user name", EnterpriseAppName);
			FunctionalLibrary.jsWaitForPageLoad();
			FunctionalLibrary.click(getSearchBTN(), "search button");
			FunctionalLibrary.jsWaitForPageLoad();
			FunctionalLibrary.isElementPresent(getAppNameDisplayed());
			System.out.println("Successfully verified the app name displayed in the page");
				
					
		} catch (Exception e) {
			//FunctionalLibrary.logStep(LogStatus.FAIL, "CPQ Login", "Login not successful", true);
			throw new Exception("Failed to verify into app");
		}
	}

}
