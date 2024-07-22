package com.SynergyConnect.testcases.AppSetup;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.SynergyConnect.common.BaseClass;
import com.SynergyConnect.pageobject.AppSetup.EmailConfigurationPage;
import com.SynergyConnect.utilities.ExtentReportListener;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class EmailConfiguration extends BaseClass {
    
    private EmailConfigurationPage emailConfigurationPage;
    private ExtentTest parentTest;

    public EmailConfiguration() {
        PageFactory.initElements(driver, this);
    }

    @BeforeClass
    public void setUp() {
        parentTest = ExtentReportListener.createParentTest("Email Configuration", "Tests related to email configuration");
        ExtentReportListener.tags("Regression", "Smoke");
        emailConfigurationPage = new EmailConfigurationPage(getDriver());
    }

    @Test(priority = 1, alwaysRun = true)
    public void pageRedirection() {
        ExtentTest childTest = parentTest.createNode("Page Redirection & validating URL");
        ExtentReportListener.author("Abhijeet Maske");
        try {
            emailConfigurationPage.redirectToEmailConfigAndValidateUrl();
            childTest.log(Status.PASS, "Page redirection and URL validation successful");
        } catch (Exception e) {
            childTest.log(Status.FAIL, "Page redirection and URL validation failed: " + e.getMessage());
        }
    }

    @Test(priority = 2, alwaysRun = true, dependsOnMethods = "pageRedirection")
    public void validateEmailConfigurationForm() {
        ExtentTest childTest = parentTest.createNode("Validating Email Configuration Form");
        ExtentReportListener.author("Abhijeet Maske");
        try {
            emailConfigurationPage.emailConfigurtionFormvalidation();
            childTest.log(Status.PASS, "Email configuration form validation successful");
        } catch (Exception e) {
            childTest.log(Status.FAIL, "Email configuration form validation failed: " + e.getMessage());
        }
    }

    @Test(priority = 3, alwaysRun = true, dependsOnMethods = "pageRedirection")
    public void addEmailConfiguration() {
        ExtentTest childTest = parentTest.createNode("Adding Email Configuration");
        ExtentReportListener.author("Abhijeet Maske");
        try {
            emailConfigurationPage.addEmailConfigurtion();
            childTest.log(Status.PASS, "Email configuration added successfully");
        } catch (Exception e) {
            childTest.log(Status.FAIL, "Failed to add email configuration: " + e.getMessage());
        }
    }

    @Test(priority = 4, alwaysRun = true, dependsOnMethods = "pageRedirection")
    public void verifyEmailConfigurationAdd() {
        ExtentTest childTest = parentTest.createNode("Verifying Added Email Configuration Data in Table");
        ExtentReportListener.author("Abhijeet Maske");
        try {
            emailConfigurationPage.verifyAddedEmailConfigurtion();
            childTest.log(Status.PASS, "Email configuration data verified successfully in table");
        } catch (Exception e) {
            childTest.log(Status.FAIL, "Failed to verify email configuration data in table: " + e.getMessage());
        }
    }

    @Test(priority = 5, alwaysRun = true, dependsOnMethods = "pageRedirection")
    public void updateEmailConfigurationAdd() throws InterruptedException {
        ExtentTest childTest = parentTest.createNode("Updating the Added Email Configuration Data from the Table");
        ExtentReportListener.author("Abhijeet Maske");
        try {
            emailConfigurationPage.updateAddedEmailConfiguration();
            childTest.log(Status.PASS, "Email configuration data updated successfully");
        } catch (Exception e) {
            childTest.log(Status.FAIL, "Failed to update email configuration data: " + e.getMessage());
        }
    }
}
