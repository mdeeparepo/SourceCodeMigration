package com.stationhPages;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resources.FunctionalLibrary;

public class QualityApplicationPage {
	
	@FindBy(xpath = "//span[text()='PRIME HIGHLIGHTS​']")
	public WebElement primeHighLightDisplayed;
	
	@FindBy(xpath = "//div[@id='versionid']")
	public WebElement versionID;
	
	@FindBy(xpath="//h4[text()='INFOSEC AWARENESS']")
	public WebElement InfosecEle;
	
	@FindBy(xpath="//a[text()='InfoSec Awareness Videos']")
	public WebElement infosecAwarenessVideoslink;
	
	@FindBy(xpath="//a[text()='Disclaimer']")
	public WebElement DisclaimerLink;
	
	@FindBy(xpath="(//tr//td//a)[7]")
	public WebElement DisclaimerText;
	
	@FindBy(xpath="(//tr//td)[4]")
	public WebElement textText;
	
	@FindBy(xpath="(//*[contains(text(),'Infosec DO')])[1]")
	public WebElement infosecDos;
	
	@FindBy(xpath="//*[contains(text(),'Infosec DONT')]")
	public WebElement infosecDont;
	
	@FindBy(xpath = "//div[@id='dvdonts']//h5")
	public List<WebElement> dontsHeadings;
	
	@FindBy(xpath = "//div[@id='dvdonts']//span")
	private List<WebElement> dontsDescriptions;
	
	@FindBy(xpath = "//div[@id='contentmarquee']")
	public WebElement endPage;
	
	@FindBy(xpath = "//div[@id='dvdos']//h5")
	public List<WebElement> dosHeadings;
	
	@FindBy(xpath = "//div[@id='dvdos']//span")
	private List<WebElement> dosDescriptions;

	

	

	
	
	
	
	/**
	 * Constructor to instantiate the page elements
	 */
	public QualityApplicationPage() {
		PageFactory.initElements(FunctionalLibrary.driver, this);
	}
	
	/**
	 * 
	*Getters
	 */
	
	public WebElement getPrimeHighLight() {
		return primeHighLightDisplayed;
	}
	public WebElement getVersionID() {
		return versionID;
	}
	
	public WebElement getInfoSecBTN() {
		return InfosecEle;
	}
	public WebElement getInfosecAwarenessVideoslink(){
		return infosecAwarenessVideoslink;
	}
	public WebElement getDisclaimerLink(){
		return DisclaimerLink;
	}
	public WebElement getDisclaimerText(){
		return DisclaimerLink;
	}
	public WebElement getTextText(){
		return textText;
	}
	public WebElement getInfoSecDos(){
		return infosecDos;
	}
	public WebElement getInfoSecDonts(){
		return infosecDont;
	}
	public List<WebElement> getdontsHeadings() {
	    return dontsHeadings;
	}
	public List<WebElement> getdontsDescriptions() {
	    return dontsDescriptions;
	}
	public List<WebElement> getdosHeadings() {
	    return dosHeadings;
	}
	public List<WebElement> getdosDescriptions() {
	    return dosDescriptions;
	}
	public WebElement getendPage(){
		return endPage;
	}
	
	
	
	
	
	

	
	
	


	
	public void VerifyPrimeHighLightsAndVersion() throws Exception {
		try {
				FunctionalLibrary.jsWaitForPageLoad();
				FunctionalLibrary.isElementPresent(getPrimeHighLight());
				FunctionalLibrary.jsWaitForPageLoad();
				FunctionalLibrary.isElementPresent(getVersionID());
				System.out.println("Prime HighLights And Version verified successfully");
				
					
		} catch (Exception e) {
			//FunctionalLibrary.logStep(LogStatus.FAIL, "CPQ Login", "Login not successful", true);
			throw new Exception("Failed to navigate into Apps section");
		}
	}
	
	public void VerifyInfoSecAwarness() throws Exception {
		try {
				FunctionalLibrary.jsWaitForPageLoad();
				FunctionalLibrary.isElementPresent(getInfoSecBTN());
				System.out.println("Infosec awarness element verified successfully");
				
					
		} catch (Exception e) {
			//FunctionalLibrary.logStep(LogStatus.FAIL, "CPQ Login", "Login not successful", true);
			throw new Exception("Failed to navigate into Apps section");
		}
	}
	
	public void VerifyInfoSecDos() throws Exception {
		try {
				FunctionalLibrary.jsWaitForPageLoad();
				FunctionalLibrary.moveToElement(getInfoSecDos());
				FunctionalLibrary.jsWaitForPageLoad();
				FunctionalLibrary.isElementPresent(getInfoSecDos());
				System.out.println("Infosec Do's element verified successfully");
				
					
		} catch (Exception e) {
			//FunctionalLibrary.logStep(LogStatus.FAIL, "CPQ Login", "Login not successful", true);
			throw new Exception("Failed to navigate into Apps section");
		}
	}
	
	public void VerifyInfoSecDonts() throws Exception {
		try {
				FunctionalLibrary.jsWaitForPageLoad();
				FunctionalLibrary.moveToElement(getInfoSecDonts());
				FunctionalLibrary.jsWaitForPageLoad();
				FunctionalLibrary.isElementPresent(getInfoSecDonts());
				System.out.println("Infosec Dont's element verified successfully");
				
					
		} catch (Exception e) {
			//FunctionalLibrary.logStep(LogStatus.FAIL, "CPQ Login", "Login not successful", true);
			throw new Exception("Failed to navigate into Apps section");
		}
	}
	
	public void NavigateToInfoSecAwarnessVideosSection(int Index, String DisclaimerText, String Text) throws Exception {
		try {
				FunctionalLibrary.jsWaitForPageLoad();
				FunctionalLibrary.click(getInfosecAwarenessVideoslink(), "Info Sec Awarness Videos");
				FunctionalLibrary.jsWaitForPageLoad();
				FunctionalLibrary.waitFor(5000);
				FunctionalLibrary.switchToWindowByIndex(Index);
				FunctionalLibrary.jsWaitForPageLoad();
				FunctionalLibrary.VerifyTheText(getDisclaimerText(), DisclaimerText, "Disclaimer");
				FunctionalLibrary.VerifyTheText(getTextText(), Text, "Text");
				
				System.out.println("Infosec Awarness video section values verified successfully");
				
					
		} catch (Exception e) {
			//FunctionalLibrary.logStep(LogStatus.FAIL, "CPQ Login", "Login not successful", true);
			throw new Exception("Failed to navigate into Apps section");
		}
	}
	public void RetriveDontsDescrption() throws Exception {
		try {
				FunctionalLibrary.jsWaitForPageLoad();
				FunctionalLibrary.waitFor(3000);
				FunctionalLibrary.moveToElement(getendPage());
				FunctionalLibrary.waitFor(3000);
		        List<WebElement> headings = getdontsHeadings();
		        List<WebElement> descriptions = getdontsDescriptions();

		        if (headings.isEmpty() || descriptions.isEmpty()) {
		            System.out.println(" Either headings or descriptions are missing under <div id='dvdonts'>.");
		            return;
		        }

		        int count = Math.min(headings.size(), descriptions.size());
		        System.out.println("Found " + count + " heading-description pairs:\n");

		        for (int i = 0; i < count; i++) {
		            String headingText = headings.get(i).getText().trim();
		            String descriptionText = descriptions.get(i).getText().trim();
		            System.out.println("🔸 " + headingText + ": " + descriptionText);
		        }
				
					
		} catch (Exception e) {
			//FunctionalLibrary.logStep(LogStatus.FAIL, "CPQ Login", "Login not successful", true);
			throw new Exception("Failed to navigate into Apps section");
		}
	}
	
	public void RetriveDosDescrption() throws Exception {
		try {
				FunctionalLibrary.jsWaitForPageLoad();
				FunctionalLibrary.waitFor(3000);
				FunctionalLibrary.moveToElement(getendPage());
				FunctionalLibrary.waitFor(3000);
		        List<WebElement> headings = getdosHeadings();
		        List<WebElement> descriptions = getdosDescriptions();

		        if (headings.isEmpty() || descriptions.isEmpty()) {
		            System.out.println(" Either headings or descriptions are missing under <div id='dvdonts'>.");
		            return;
		        }

		        int count = Math.min(headings.size(), descriptions.size());
		        System.out.println("Found " + count + " heading-description pairs:\n");

		        for (int i = 0; i < count; i++) {
		            String headingText = headings.get(i).getText().trim();
		            String descriptionText = descriptions.get(i).getText().trim();
		            System.out.println("🔸 " + headingText + ": " + descriptionText);
		        }
				
					
		} catch (Exception e) {
			//FunctionalLibrary.logStep(LogStatus.FAIL, "CPQ Login", "Login not successful", true);
			throw new Exception("Failed to navigate into Apps section");
		}
	}
	
	
	

}
