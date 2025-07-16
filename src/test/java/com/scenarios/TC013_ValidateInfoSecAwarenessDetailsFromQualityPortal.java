package com.scenarios;

import java.util.HashMap;

import java.util.List;

import com.resources.FunctionalLibrary;
import com.resources.ReadDatafromExcel;
import com.stationhPages.ConcurApplicationPage;
import com.stationhPages.LoginPage;
import com.stationhPages.MainDashBoardPage;
import com.stationhPages.QualityApplicationPage;
import com.stationhPages.TMGApplicationPage;


public class TC013_ValidateInfoSecAwarenessDetailsFromQualityPortal {

    static String DT_RMCS_ENVIRONMENT;
    static String DT_BROWSER;
    static String DT_URL;
    static String DT_USERNAME;
    static String DT_PASSWORD;
    static String DT_APPNAME;
    static String DT_TITLE;
    static int testRow = 1;
    static int DT_Index=2;
    static String DisclaimerText="Disclaimer";
    static String Text="Text";

    public void setupTestData() throws Exception {
        List<HashMap<String, String>> testData1 = ReadDatafromExcel
                .data("src/test/resources/TestData/StationH.xlsx", "LoginCreds");
        List<HashMap<String, String>> testData2 = ReadDatafromExcel
                .data("src/test/resources/TestData/StationH.xlsx", "TestData_Quality");

        DT_BROWSER = testData1.get(testRow).get("DT_BROWSER");
        DT_URL = testData1.get(testRow).get("DT_URL");
        DT_USERNAME = testData1.get(testRow).get("DT_USERNAME");
        DT_PASSWORD = testData1.get(testRow).get("DT_PASSWORD");
        DT_APPNAME = testData2.get(testRow).get("DT_APPNAME");
        
        
       
       
        
    }

    public void executeTest() throws Exception {
        try {
            FunctionalLibrary.driverInit(DT_BROWSER);
            LoginPage loginpage = new LoginPage();
            MainDashBoardPage maindashboardpage=new MainDashBoardPage();
            QualityApplicationPage qualityapplicationpage=new QualityApplicationPage();
            loginpage.LoginMethod(DT_URL, DT_USERNAME, DT_PASSWORD);
            maindashboardpage.NavigateToAppsSection();
            maindashboardpage.searchAppNameAndNavigate(DT_APPNAME);
            qualityapplicationpage.VerifyInfoSecAwarness();
            qualityapplicationpage.NavigateToInfoSecAwarnessVideosSection(DT_Index,DisclaimerText,Text);

            System.out.println("Test executed successfully.");

        } catch (Exception e) {
            System.out.println("Test execution failed: " + e.getMessage());
            throw e;
        } finally {
            FunctionalLibrary.closeBrowser();
        }
    }

    public static void main(String[] args) {
        TC013_ValidateInfoSecAwarenessDetailsFromQualityPortal test = new TC013_ValidateInfoSecAwarenessDetailsFromQualityPortal();
        try {
            test.setupTestData();
            test.executeTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
