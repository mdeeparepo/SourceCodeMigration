package com.scenarios;

import java.util.HashMap;

import java.util.List;

import com.resources.FunctionalLibrary;
import com.resources.ReadDatafromExcel;
import com.stationhPages.ConcurApplicationPage;
import com.stationhPages.LoginPage;
import com.stationhPages.MainDashBoardPage;


public class TC006_LoginAndLogout {

    static String DT_RMCS_ENVIRONMENT;
    static String DT_BROWSER;
    static String DT_URL;
    static String DT_USERNAME;
    static String DT_PASSWORD;
    static String DT_APPNAME;
    static String DT_TITLE;
    static int testRow = 1;

    public void setupTestData() throws Exception {
        List<HashMap<String, String>> testData1 = ReadDatafromExcel
                .data("src/test/resources/TestData/StationH.xlsx", "LoginCreds");

        DT_BROWSER = testData1.get(testRow).get("DT_BROWSER");
        DT_URL = testData1.get(testRow).get("DT_URL");
        DT_USERNAME = testData1.get(testRow).get("DT_USERNAME");
        DT_PASSWORD = testData1.get(testRow).get("DT_PASSWORD");   
    }

    public void executeTest() throws Exception {
        try {
            FunctionalLibrary.driverInit(DT_BROWSER);
            LoginPage loginpage = new LoginPage();
            loginpage.LoginMethod(DT_URL,DT_USERNAME,DT_PASSWORD);
            loginpage.LogOutMethod();
            System.out.println("Test executed successfully.");

        } catch (Exception e) {
            System.out.println("Test execution failed: " + e.getMessage());
            throw e;
        } finally {
            FunctionalLibrary.closeBrowser();
        }
    }

    public static void main(String[] args) {
        TC006_LoginAndLogout test = new TC006_LoginAndLogout();
        try {
            test.setupTestData();
            test.executeTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
