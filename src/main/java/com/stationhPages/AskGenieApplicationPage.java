package com.stationhPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resources.FunctionalLibrary;

public class AskGenieApplicationPage {
	@FindBy(xpath = "//h2[text()='Create Incident']")
	public WebElement createIncidentBTN;
	
	@FindBy(xpath = "//h2[text()='Create IT Incident']")
	public WebElement createITIncidentBTN;
	
	@FindBy(xpath = "//h2[text()='Create Non-IT Incident']")
	public WebElement createNonITIncidentBTN;
	
	@FindBy(xpath = "(//a[@class='select2-choice select2-default form-control'])[2]")
	public WebElement serviceLabel;
	
	@FindBy(xpath = "//div[text()='End user computing (Deskside) services']")
	public WebElement eucLabel;
	
	@FindBy(xpath = "//div[text()='HR']")
	public WebElement hrLabel;
	
	@FindBy(xpath = "(//a[@class='select2-choice select2-default form-control'])[2]")
	public WebElement CategoryLabel;
	
	@FindBy(xpath = "//div[text()='Software']")
	public WebElement softwareLabel;
	
	@FindBy(xpath = "//div[text()='Payroll']")
	public WebElement payrollLabel;
	
	@FindBy(xpath = "(//a[@class='select2-choice select2-default form-control'])[2]")
	public WebElement childCategoryLabel;
	
	@FindBy(xpath = "//div[text()='Microsoft Office']")
	public WebElement microsoftOfficeLabel;
	
	@FindBy(xpath = "//div[text()='Queries related to salary']")
	public WebElement queriesLabel;
	
	@FindBy(xpath = "//input[@name='short_description']")
	public WebElement shortDescription;
	
	@FindBy(xpath = "//textarea[@aria-label='Detailed Description']")
	public WebElement detailedDescription;
	
	
	
	
	
	
	
	
	
	/**
	 * Constructor to instantiate the page elements
	 */
	public AskGenieApplicationPage() {
		PageFactory.initElements(FunctionalLibrary.driver, this);
	}
	
	/**
	 * 
	*Getters
	 */
	
	public WebElement getCreateIncidentBTN() {
		return createIncidentBTN;
	}
	
	public WebElement getCreateITIncidentBTN() {
		return createITIncidentBTN;
	}
	
	public WebElement getCreateNonITIncidentBTN() {
		return createNonITIncidentBTN;
	}
	
	public WebElement getServiceLabel() {
		return serviceLabel;
	}
	
	public WebElement getEUCLabel() {
		return eucLabel;
	}
	
	public WebElement getHRLabel() {
		return hrLabel;
	}
	
	public WebElement getCategoryLabel() {
		return CategoryLabel;
	}
	
	public WebElement getsoftwareLabel() {
		return softwareLabel;
	}
	
	public WebElement getPayrollLabel() {
		return payrollLabel;
	}
	
	public WebElement getChildCategoryLabel() {
		return childCategoryLabel;
	}
	
	public WebElement getMicrosoftOfficeLabel() {
		return microsoftOfficeLabel;
	}
	

	public WebElement getQueriesLabel() {
		return queriesLabel;
	}
	
	public WebElement getShortDescription() {
		return shortDescription;
	}
	
	public WebElement getDetailedDescription() {
		return detailedDescription;
	}
	
	
	
	

	
	

	

	
	public void NavigateToITIncident() throws Exception {
		try {
			FunctionalLibrary.click(getCreateIncidentBTN(), "Create Incident");
			FunctionalLibrary.jsWaitForPageLoad();
			FunctionalLibrary.click(getCreateITIncidentBTN(), "Create IT Incident");
			FunctionalLibrary.jsWaitForPageLoad();
				
					
		} catch (Exception e) {
			//FunctionalLibrary.logStep(LogStatus.FAIL, "CPQ Login", "Login not successful", true);
			throw new Exception("Failed to navigate into Apps section");
		}
	}
	
	public void NavigateToNonITIncident() throws Exception {
		try {
			FunctionalLibrary.click(getCreateIncidentBTN(), "Create Incident");
			FunctionalLibrary.jsWaitForPageLoad();
			FunctionalLibrary.click(getCreateNonITIncidentBTN(), "Create Non IT Incident");
			FunctionalLibrary.jsWaitForPageLoad();
				
					
		} catch (Exception e) {
			//FunctionalLibrary.logStep(LogStatus.FAIL, "CPQ Login", "Login not successful", true);
			throw new Exception("Failed to navigate into Apps section");
		}
	}
	
	
	public void createEndUserServiceTicket(String shortdescription, String detaileddescription) throws Exception {
		try {
			
			FunctionalLibrary.scrolDown();
			FunctionalLibrary.jsWaitForPageLoad();
			FunctionalLibrary.waitFor(4000);
			FunctionalLibrary.click(getServiceLabel(), "Service");
			FunctionalLibrary.jsWaitForPageLoad();
			FunctionalLibrary.click(getEUCLabel(), "End user computing (Deskside) services");
			FunctionalLibrary.jsWaitForPageLoad();
			FunctionalLibrary.click(getCategoryLabel(), "child");
			FunctionalLibrary.jsWaitForPageLoad();
			FunctionalLibrary.scrolDown();
			FunctionalLibrary.click(getsoftwareLabel(), "Software");
			FunctionalLibrary.jsWaitForPageLoad();
			FunctionalLibrary.click(getChildCategoryLabel(), "Child Category");
			FunctionalLibrary.jsWaitForPageLoad();
			FunctionalLibrary.click(getMicrosoftOfficeLabel(), "Microsoft Office");
			FunctionalLibrary.jsWaitForPageLoad();
			FunctionalLibrary.setText(getShortDescription(), "Short Description", shortdescription);
			FunctionalLibrary.jsWaitForPageLoad();
			FunctionalLibrary.setText(getDetailedDescription(), "Detailed Description", detaileddescription);
			FunctionalLibrary.jsWaitForPageLoad();
				
					
		} catch (Exception e) {
			//FunctionalLibrary.logStep(LogStatus.FAIL, "CPQ Login", "Login not successful", true);
			throw new Exception("Failed to navigate into Apps section");
		}
	}
	
	public void createNonITHrServiceTicket(String shortdescription, String detaileddescription) throws Exception {
		try {
			
			FunctionalLibrary.scrolDown();
			FunctionalLibrary.jsWaitForPageLoad();
			FunctionalLibrary.waitFor(4000);
			FunctionalLibrary.click(getServiceLabel(), "Service");
			FunctionalLibrary.jsWaitForPageLoad();
			FunctionalLibrary.click(getHRLabel(), "HR");
			FunctionalLibrary.jsWaitForPageLoad();
			FunctionalLibrary.click(getCategoryLabel(), "child");
			FunctionalLibrary.jsWaitForPageLoad();
			FunctionalLibrary.scrolDown();
			FunctionalLibrary.click(getPayrollLabel(), "Payroll");
			FunctionalLibrary.jsWaitForPageLoad();
			FunctionalLibrary.click(getChildCategoryLabel(), "Child Category");
			FunctionalLibrary.jsWaitForPageLoad();
			FunctionalLibrary.click(getQueriesLabel(), "Queries related to salary");
			FunctionalLibrary.jsWaitForPageLoad();
			FunctionalLibrary.setText(getShortDescription(), "Short Description", shortdescription);
			FunctionalLibrary.jsWaitForPageLoad();
			FunctionalLibrary.setText(getDetailedDescription(), "Detailed Description", detaileddescription);
			FunctionalLibrary.jsWaitForPageLoad();
				
					
		} catch (Exception e) {
			//FunctionalLibrary.logStep(LogStatus.FAIL, "CPQ Login", "Login not successful", true);
			throw new Exception("Failed to navigate into Apps section");
		}
	}
	
	
}
