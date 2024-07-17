package com.SynergyConnect.testcases;

import org.testng.annotations.Test;

import com.SynergyConnect.common.BaseClass;
import com.SynergyConnect.pageobject.LoginPage;
import com.SynergyConnect.utilities.ExtentReportListener;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Login extends BaseClass {

    @Test(priority = 1, testName = "Login Test", alwaysRun = true)
    public void verifyLoginIsWorking() throws InterruptedException {
        // Create parent test node
        ExtentTest parentTest = ExtentReportListener.createParentTest("Login Test","Verify that login functionality works").assignAuthor("Abhijeet Maske");

        // Assign tags
        ExtentReportListener.tags("Regression", "Smoke");

        // Create a child node for the actual test steps
        ExtentTest test = parentTest.createNode("Login Functionality Test");

        LoginPage loginPage = new LoginPage(getDriver());

        try {
            getDriver().get(url);
            logger.info("Navigated to URL: " + url);
            test.log(Status.INFO, "Navigated to URL: " + url);

            Thread.sleep(500);

            getDriver().manage().window().maximize();
            logger.info("Browser window maximized");
            test.log(Status.INFO, "Browser window maximized");

            Thread.sleep(500);

            loginPage.enterUserid();
            logger.info("Entered User ID");
            test.log(Status.INFO, "Entered User ID");

            loginPage.enterPassword();
            logger.info("Entered Password");
            test.log(Status.INFO, "Entered Password");

            loginPage.clickOnLogin();
            logger.info("Clicked on Login button");
            test.log(Status.INFO, "Clicked on Login button");

            loginPage.getHompageUrl();
            logger.info("Validated homepage URL");
            test.log(Status.INFO, "Validated homepage URL");

            loginPage.synergyWorks();
            logger.info("Synergy Works validated");
            test.log(Status.PASS, "Login functionality works as expected");

        } catch (Exception e) {
            logger.error("Test case verifyLoginIsWorking failed: " + e.getMessage());
            test.log(Status.FAIL, "Test case verifyLoginIsWorking failed: " + e.getMessage());
        }
    }
}
