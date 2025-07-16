package com.scenarios;

import java.util.HashMap;

import java.util.List;

import com.resources.FunctionalLibrary;
import com.resources.ReadDatafromExcel;
import com.stationhPages.AskGenieApplicationPage;
import com.stationhPages.ConcurApplicationPage;
import com.stationhPages.LoginPage;
import com.stationhPages.MainDashBoardPage;


public class TC004_CreateNonITIncident {

    static String DT_RMCS_ENVIRONMENT;
    static String DT_BROWSER;
    static String DT_URL;
    static String DT_USERNAME;
    static String DT_PASSWORD;
    static String DT_APPNAME;
    static String DT_NONITSHORTDESCRIPTION;
    static String DT_NONITDETAILEDDESCRIPTION;
    static int testRow = 1;

    public void setupTestData() throws Exception {
        List<HashMap<String, String>> testData1 = ReadDatafromExcel
                .data("src/test/resources/TestData/StationH.xlsx", "LoginCreds");
        List<HashMap<String, String>> testData2 = ReadDatafromExcel
                .data("src/test/resources/TestData/StationH.xlsx", "TestData_AskGenie");

        DT_BROWSER = testData1.get(testRow).get("DT_BROWSER");
        DT_URL = testData1.get(testRow).get("DT_URL");
        DT_USERNAME = testData1.get(testRow).get("DT_USERNAME");
        DT_PASSWORD = testData1.get(testRow).get("DT_PASSWORD");
        DT_APPNAME=testData2.get(testRow).get("DT_APPNAME");
        DT_NONITSHORTDESCRIPTION="Hi";
        DT_NONITDETAILEDDESCRIPTION="Hello";
        DT_NONITSHORTDESCRIPTION = testData2.get(testRow).get("DT_NONITSHORTDESCRIPTION");
        DT_NONITDETAILEDDESCRIPTION=testData2.get(testRow).get("DT_NONITDETAILEDDESCRIPTION");
       
        
    }

    public void executeTest() throws Exception {
        try {
            FunctionalLibrary.driverInit(DT_BROWSER);
            LoginPage loginpage = new LoginPage();
            MainDashBoardPage maindashboardpage=new MainDashBoardPage();
            AskGenieApplicationPage askgenieapplicationpage=new AskGenieApplicationPage(); 
            loginpage.LoginMethod(DT_URL, DT_USERNAME, DT_PASSWORD);
            maindashboardpage.NavigateToAppsSection();
            maindashboardpage.searchAppNameAndNavigate(DT_APPNAME);
            askgenieapplicationpage.NavigateToNonITIncident();
            askgenieapplicationpage.createNonITHrServiceTicket(DT_NONITSHORTDESCRIPTION,DT_NONITDETAILEDDESCRIPTION );
            System.out.println("Test executed successfully.");

        } catch (Exception e) {
            System.out.println("Test execution failed: " + e.getMessage());
            throw e;
        } finally {
            FunctionalLibrary.closeBrowser();
        }
    }

    public static void main(String[] args) {
        TC004_CreateNonITIncident test = new TC004_CreateNonITIncident();
        try {
            test.setupTestData();
            test.executeTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
