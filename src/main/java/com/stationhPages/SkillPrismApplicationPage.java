package com.stationhPages;

import java.util.NoSuchElementException;


import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import com.resources.FunctionalLibrary;

public class SkillPrismApplicationPage {
	@FindBy(xpath = "//span[text()=' My Projects ']")
	public WebElement myProjectsLabel;
	
	@FindBy(xpath = "//mat-icon[text()='keyboard_arrow_down']")
	public WebElement filterDropDown;
	
	@FindBy(xpath = "//span[text()=' Completed ']")
	public WebElement completedCheckbox;
	
	@FindBy(xpath = "//div[text()='Projects']")
	public WebElement projects;
	
	@FindBy(xpath = "//div[@mattooltip='Project name']")
	public WebElement projectNames;
	
	@FindBy(xpath = "//div[@mattooltip='Project name']")
	private List<WebElement> projectNameElements;

	
	
	
	
	
	
	
	/**
	 * Constructor to instantiate the page elements
	 */
	public SkillPrismApplicationPage() {
		PageFactory.initElements(FunctionalLibrary.driver, this);
	}
	
	/**
	 * 
	*Getters
	 */
	
	public WebElement getMyProjects() {
		return myProjectsLabel;
	}
	
	public WebElement getFilterDropDown() {
		return filterDropDown;
	}
	
	public WebElement getCompletedCheckBox() {
		return completedCheckbox;
	}
	
	public WebElement getProjects() {
		return projects;
	}
	
	public List<WebElement> getProjectNameElements() {
	    return projectNameElements;
	}

	
	
	
	
	

	

	
	public void RetreiveProjectNames() throws Exception {
		try {
				FunctionalLibrary.click(getMyProjects(), "My Projects");
				FunctionalLibrary.jsWaitForPageLoad();
				FunctionalLibrary.click(getFilterDropDown(), "Filter by status");
				FunctionalLibrary.jsWaitForPageLoad();
				FunctionalLibrary.click(getCompletedCheckBox(), "Completed");
				FunctionalLibrary.jsWaitForPageLoad();
				FunctionalLibrary.waitFor(3000);
				List<WebElement> names = getProjectNameElements();

		        if (names.isEmpty()) {
		            System.out.println(" No project name elements found.");
		            return;
		        }

		        System.out.println(" Project Names:");
		        for (int i = 0; i < names.size(); i++) {
		            String name = names.get(i).getText().trim();
		            System.out.println("• " + name);
		        }
				FunctionalLibrary.waitFor(4000);
				

				
					
		} catch (Exception e) {
			//FunctionalLibrary.logStep(LogStatus.FAIL, "CPQ Login", "Login not successful", true);
			throw new Exception("Failed to navigate into Apps section");
		}
	}
	
	

}
