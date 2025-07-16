package com.stationhPages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.resources.FunctionalLibrary;


public class LoginPage {	
	
	@FindBy(xpath = "//input[@type='email']")
	public WebElement userNameTxt;

	@FindBy(xpath="//input[@type='submit']")
	public WebElement nextBTN;	
	
	@FindBy(xpath="//input[@name='passwd']")
	public WebElement passwordTXT;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement signInBTN;
	
	@FindBy(id="KmsiCheckboxField")
	public WebElement checkBox;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement yesBTN;
	
	@FindBy(xpath="(//img[contains(@alt,'Profile')])[1]")
	public WebElement profileIcon;
	
	@FindBy(xpath="//button[text()='Sign out']")
	public WebElement signOutBTN;
	
	
	/**
	 * Constructor to instantiate the page elements
	 */
	public LoginPage() {
		PageFactory.initElements(FunctionalLibrary.driver, this);
	}
	
	/**
	 * 
	*Getters
	 */
	
	public WebElement getUserNameTxt() {
		return userNameTxt;
	}

	public WebElement getNextBTN() {
		return nextBTN;
	}

	public WebElement getPasswordTXT() {
		return passwordTXT;
	}
	public WebElement getSignBTN() {
		return signInBTN;
	}
	
	public WebElement getCheckBox() {
		return checkBox;
	}
	public WebElement getYesBTN() {
		return yesBTN;
	}
	public WebElement getProfileIcon() {
		return profileIcon;
	}
	public WebElement getsignOutBTN() {
		return signOutBTN;
	}


	
	public void LoginMethod(String url, String userName, String password) throws Exception {
		try {
				FunctionalLibrary.driver.get(url);
				FunctionalLibrary.jsWaitForPageLoad();
				FunctionalLibrary.setText(getUserNameTxt(), " user name", userName);
				FunctionalLibrary.jsWaitForPageLoad();
				FunctionalLibrary.click(getNextBTN(), "Next Button");
				FunctionalLibrary.waitFor(3000);
				FunctionalLibrary.setText(getPasswordTXT(), " Password", password);
				FunctionalLibrary.jsWaitForPageLoad();
				FunctionalLibrary.click(getSignBTN(), "Sign In button");
				FunctionalLibrary.waitFor(5000);
				FunctionalLibrary.click(getCheckBox(), "Click check box ");
				FunctionalLibrary.click(getYesBTN(), "Yes Button");
				FunctionalLibrary.jsWaitForPageLoad();
		} catch (Exception e) {
			//FunctionalLibrary.logStep(LogStatus.FAIL, "CPQ Login", "Login not successful", true);
			throw new Exception("Error while logging into StationH");
		}
	}
	
	public void LogOutMethod() throws Exception {
		try {
				FunctionalLibrary.click(getProfileIcon(), "Profile Icon");
				FunctionalLibrary.jsWaitForPageLoad();
				FunctionalLibrary.click(getsignOutBTN(), "Sign Out");
				
		} catch (Exception e) {
			//FunctionalLibrary.logStep(LogStatus.FAIL, "CPQ Login", "Login not successful", true);
			throw new Exception("Error while log out StationH");
		}
	}
}
