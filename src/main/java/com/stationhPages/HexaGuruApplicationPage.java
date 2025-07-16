package com.stationhPages;

import java.util.List;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.resources.FunctionalLibrary;


public class HexaGuruApplicationPage {	
	
	@FindBy(xpath = "//button[@aria-label='Overall training progress']")
	public WebElement overalltraningprogressicon;
	
	@FindBy(xpath = "//button[@aria-label='My Trainings']")
	public WebElement mytrainings;
	
	
	@FindBy(xpath = "//ul[@id='maincontainer']//li")
    private List<WebElement> TraningNames;

    

	
	
	
	/**
	 * Constructor to instantiate the page elements
	 */
	public HexaGuruApplicationPage() {
		PageFactory.initElements(FunctionalLibrary.driver, this);
	}
	
	/**
	 * 
	*Getters
	 */
	
	public WebElement getOverallTraningProgressIcon() {
		return overalltraningprogressicon;
	}
	
	public List<WebElement> getTraningNames() {
        return TraningNames;
    }
	public WebElement getMyTrainings() {
		return mytrainings;
	}

	
	


	
	public void RetrieveTrainingNames() throws Exception {
		try {
				FunctionalLibrary.jsWaitForPageLoad();
				FunctionalLibrary.waitFor(5000);
				FunctionalLibrary.click(getMyTrainings(), "Overall Traning Progress icon");
				FunctionalLibrary.waitFor(5000);
				System.out.println("Successfully navigated into my trainings section");
				
				
		} catch (Exception e) {
			//FunctionalLibrary.logStep(LogStatus.FAIL, "CPQ Login", "Login not successful", true);
			throw new Exception("Error while logging into StationH");
		}
	}
	
	
	
	
}
