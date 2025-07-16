package com.scenarios;

import java.util.HashMap;

import java.util.List;

import com.resources.FunctionalLibrary;
import com.resources.ReadDatafromExcel;
import com.stationhPages.ConcurApplicationPage;
import com.stationhPages.LoginPage;
import com.stationhPages.MainDashBoardPage;
import com.stationhPages.PayrollApplicationPage;


public class TC007_VerifyTheEmployeeProfileCompletionStatus {

    static String DT_RMCS_ENVIRONMENT;
    static String DT_BROWSER;
    static String DT_URL;
    static String DT_USERNAME;
    static String DT_PASSWORD;
    static String DT_APPNAME;
    static int testRow = 1;

    public void setupTestData() throws Exception {
        List<HashMap<String, String>> testData1 = ReadDatafromExcel
                .data("src/test/resources/TestData/StationH.xlsx", "LoginCreds");
        List<HashMap<String, String>> testData2 = ReadDatafromExcel
                .data("src/test/resources/TestData/StationH.xlsx", "TestData_Payroll");

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
            loginpage.LoginMethod(DT_URL, DT_USERNAME, DT_PASSWORD);
            maindashboardpage.NavigateToAppsSection();
            maindashboardpage.searchAppNameAndNavigate(DT_APPNAME);
            PayrollApplicationPage payrollapplicationpage=new PayrollApplicationPage();
            String percentageValue = payrollapplicationpage.EmployeeProfilePercentage();
            System.out.println(percentageValue);


        } catch (Exception e) {
            System.out.println("Test execution failed: " + e.getMessage());
            throw e;
        } finally {
            FunctionalLibrary.closeBrowser();
        }
    }

    public static void main(String[] args) {
        TC007_VerifyTheEmployeeProfileCompletionStatus test = new TC007_VerifyTheEmployeeProfileCompletionStatus();
        try {
            test.setupTestData();
            test.executeTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
