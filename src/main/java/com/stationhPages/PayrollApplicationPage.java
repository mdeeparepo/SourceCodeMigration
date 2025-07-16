package com.stationhPages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.resources.FunctionalLibrary;


public class PayrollApplicationPage {	
	
	@FindBy(xpath = "//h3[@class='profile_completion']")
	private WebElement percentageElement;
	
	@FindBy(xpath = "(//span[text()='Payroll'])[2]")
	private WebElement payroll;
	
	@FindBy(xpath = "(//a[text()='My Slips'])[2]")
	private WebElement mySlips;
	
	@FindBy(xpath = "(//span[text()='Select Year'])[1]")
	private WebElement selectYear;
	
	@FindBy(xpath = "//span[text()='2025']")
	private WebElement year;
	
	@FindBy(xpath = "(//span[text()='Select Month'])[1]")
	private WebElement selectMonth;
	
	@FindBy(xpath = "//span[text()='June']")
	private WebElement month;
	
	@FindBy(xpath = "(//a[text()=' View '])[1]")
	private WebElement viewLink;
	
	
	
	
	/**
	 * Constructor to instantiate the page elements
	 */
	public PayrollApplicationPage() {
		PageFactory.initElements(FunctionalLibrary.driver, this);
	}
	
	/**
	 * 
	*Getters
	 */
	

	public WebElement getPercentageElement() {
	    return percentageElement;
	}
	public WebElement getPayroll() {
	    return payroll;
	}
	public WebElement getPaySlips() {
	    return mySlips;
	}
	public WebElement getSelectYear() {
	    return selectYear;
	}
	public WebElement getYear() {
	    return year;
	}
	public WebElement getSelectMonth() {
	    return selectMonth;
	}
	public WebElement getMonth() {
	    return month;
	}
	public WebElement getViewBTN() {
	    return viewLink;
	}



	

	public String EmployeeProfilePercentage() throws Exception {
		
		try {
			FunctionalLibrary.jsWaitForPageLoad();
			return getPercentageElement().getText().trim();
				
				
				
		} catch (Exception e) {
			//FunctionalLibrary.logStep(LogStatus.FAIL, "CPQ Login", "Login not successful", true);
			throw new Exception("Error while log out StationH");
		}
	}
	
	public void navigateToPayslipPage() throws Exception {
		try {   
			    FunctionalLibrary.jsWaitForPageLoad();
				FunctionalLibrary.click(getPayroll(), "Payroll");
				FunctionalLibrary.jsWaitForPageLoad();
				FunctionalLibrary.click(getPaySlips(), "Pay slips");
				FunctionalLibrary.jsWaitForPageLoad();
				FunctionalLibrary.click(getSelectYear(), "Select Year");
				FunctionalLibrary.jsWaitForPageLoad();
				FunctionalLibrary.click(getYear(), "2025");
				FunctionalLibrary.jsWaitForPageLoad();
				FunctionalLibrary.click(getSelectMonth(), "Select Month");
				FunctionalLibrary.jsWaitForPageLoad();
				FunctionalLibrary.click(getMonth(), "June");
				FunctionalLibrary.jsWaitForPageLoad();
				FunctionalLibrary.click(getViewBTN(), "View Link");
				
		} catch (Exception e) {
			//FunctionalLibrary.logStep(LogStatus.FAIL, "CPQ Login", "Login not successful", true);
			throw new Exception("Error while log out StationH");
		}
	}
}
