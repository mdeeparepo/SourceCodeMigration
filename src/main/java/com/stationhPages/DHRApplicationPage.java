package com.stationhPages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.resources.FunctionalLibrary;


public class DHRApplicationPage {	
	
	@FindBy(xpath = "//button[@class='ssoBtnActive']")
	public WebElement ssoLogin;
	
	@FindBy(xpath = "//div[@target='me_contact_information']")
	public WebElement contactInfoBTN;
	
	@FindBy(xpath = "(//a[contains(@id,'phone')])[2]")
	public WebElement mobileno;
	
	@FindBy(xpath = "(//a[contains(@id,'email')])[2]")
	public WebElement email;
	
	@FindBy(xpath = "//a[text()='Time and Absences']")
	public WebElement timeandabsenceBTN;
	
	@FindBy(xpath = "//span[text()='Absence Balance']")
	public WebElement addabsencebalanceBTN;
	
	@FindBy(xpath = "(//span[@class='xng'])[1]")
	public WebElement earnedLeave;
	
	@FindBy(xpath = "(//span[@class='xng'])[3]")
	public WebElement optionalLeave;

	
	
	
	/**
	 * Constructor to instantiate the page elements
	 */
	public DHRApplicationPage() {
		PageFactory.initElements(FunctionalLibrary.driver, this);
	}
	
	/**
	 * 
	*Getters
	 */
	
	public WebElement getSSOloginBTN() {
		return ssoLogin;
	}
	public WebElement getcontaceInfoBTN() {
		return contactInfoBTN;
	}
	public WebElement getMobileNo() {
		return mobileno;
	}
	public WebElement getEmailAddress() {
		return email;
	}
	public WebElement getTimeAndAbsence() {
		return timeandabsenceBTN;
	}
	public WebElement getaddabsencebalanceBTN() {
		return addabsencebalanceBTN;
	}
	public WebElement getearnedLeave() {
		return earnedLeave;
	}
	public WebElement getoptionalLeave() {
		return optionalLeave;
	}


	


	
	public void LoginIntoDHR() throws Exception {
		try {
				FunctionalLibrary.jsWaitForPageLoad();
				FunctionalLibrary.click(getSSOloginBTN(), "Company Single SignOn");
				FunctionalLibrary.waitFor(5000);
				
		} catch (Exception e) {
			//FunctionalLibrary.logStep(LogStatus.FAIL, "CPQ Login", "Login not successful", true);
			throw new Exception("Error while logging into StationH");
		}
	}
	
	public void RetreiveContactInfo() throws Exception {
		try {
				FunctionalLibrary.waitFor(3000);
				FunctionalLibrary.moveToElementAndClick(getcontaceInfoBTN(), "Contact Info");
				FunctionalLibrary.waitFor(2000);
				FunctionalLibrary.getTextFromElement(getMobileNo());
				FunctionalLibrary.getTextFromElement(getEmailAddress());
				
		} catch (Exception e) {
			//FunctionalLibrary.logStep(LogStatus.FAIL, "CPQ Login", "Login not successful", true);
			throw new Exception("Error while logging into StationH");
		}
	}
	
	public void RetreiveLeaveBalances() throws Exception {
		try {
				FunctionalLibrary.waitFor(3000);
				FunctionalLibrary.moveToElementAndClick(getTimeAndAbsence(), "Time and absences");
				FunctionalLibrary.waitFor(2000);
				FunctionalLibrary.moveToElementAndClick(getaddabsencebalanceBTN(), "Time and absences");
				FunctionalLibrary.waitFor(2000);
				String EarnedLeave = FunctionalLibrary.getTextFromElement(getearnedLeave());
				System.out.println("Earned leave balance \"" + EarnedLeave + "\" days");
				FunctionalLibrary.waitFor(2000);
				String optionalLeave = FunctionalLibrary.getTextFromElement(getoptionalLeave());
				System.out.println("Optional leave balance \"" + optionalLeave + "\" days");
				
				
		} catch (Exception e) {
			//FunctionalLibrary.logStep(LogStatus.FAIL, "CPQ Login", "Login not successful", true);
			throw new Exception("Error while logging into StationH");
		}
	}
}
