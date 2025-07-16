package com.stationhPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resources.FunctionalLibrary;

public class TMGApplicationPage {
	
	@FindBy(xpath = "//input[@name='txtUserId']")
	public WebElement username;
	
	@FindBy(xpath = "//input[@name='txtPassword']")
	public WebElement password;
	
	@FindBy(xpath = "//input[@name='btnLogin']")
	public WebElement loginBTN;
	
	@FindBy(xpath = "//a[@id='aLinkAlloc']")
	public WebElement allocBTN;
	
	 @FindBy(xpath = "//th[text()='Project ID']")
	 public WebElement projectIdHeader;
	 
	 @FindBy(xpath = "//th[text()='Project Name']")
	 public WebElement projectNameHeader;
	 
	 @FindBy(xpath = "//th[text()='Supervisor']")
	 public WebElement supervisorNameHeader;
	 
	 @FindBy(xpath = "//th[text()='Start Date']")
	 public WebElement startDateHeader;

	 @FindBy(xpath = "//th[text()='End Date']")
	 public WebElement endDateHeader;
	
	

	
	
	
	
	/**
	 * Constructor to instantiate the page elements
	 */
	public TMGApplicationPage() {
		PageFactory.initElements(FunctionalLibrary.driver, this);
	}
	
	/**
	 * 
	*Getters
	 */
	
	public WebElement getUsername() {
		return username;
	}
	
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLoginBTN() {
		return loginBTN;
	}
	public WebElement getAllocBTN() {
		return loginBTN;
	}
	public WebElement getProjectIdHeader() {
        return projectIdHeader;
    }
	public WebElement getProjectNameHeader() {
	    return projectNameHeader;
	}
	public WebElement getSupervisorNameHeader() {
        return supervisorNameHeader;
    }
	public WebElement getStartDateHeader() {
        return startDateHeader;
    }

    public WebElement getEndDateHeader() {
        return endDateHeader;
    }
	
	
	
	

	
	
	


	
	public void LoginToTMGPortal(String Username,String Password,String title) throws Exception {
		try {
				FunctionalLibrary.waitFor(4000);
				FunctionalLibrary.setText(getUsername(), "Username Textbox", Username);
				FunctionalLibrary.jsWaitForPageLoad();
				FunctionalLibrary.setText(getPassword(), "Password Textbox", Password);
				FunctionalLibrary.jsWaitForPageLoad();
				FunctionalLibrary.click(getLoginBTN(), "Login");
				FunctionalLibrary.verifyPageTitle(title);
				
					
		} catch (Exception e) {
			//FunctionalLibrary.logStep(LogStatus.FAIL, "CPQ Login", "Login not successful", true);
			throw new Exception("Failed to navigate into Apps section");
		}
	}
	
	
	public void verifyProjectAllocationDetails() throws Exception {
		try {
				FunctionalLibrary.waitFor(4000);
				FunctionalLibrary.jsWaitForPageLoad();
				FunctionalLibrary.switchToWindowByIndex(1);
				FunctionalLibrary.click(getAllocBTN(), "Allocations");
				FunctionalLibrary.implicitWait(10);
				FunctionalLibrary.switchToWindowByIndex(2);
				FunctionalLibrary.isElementPresent(getProjectIdHeader());
				FunctionalLibrary.isElementPresent(getProjectNameHeader());
				FunctionalLibrary.isElementPresent(getSupervisorNameHeader());
				FunctionalLibrary.isElementPresent(getStartDateHeader());
				FunctionalLibrary.isElementPresent(getEndDateHeader());
				
					
		} catch (Exception e) {
			//FunctionalLibrary.logStep(LogStatus.FAIL, "CPQ Login", "Login not successful", true);
			throw new Exception("Failed to navigate into Apps section");
		}
	}
	
	

}
