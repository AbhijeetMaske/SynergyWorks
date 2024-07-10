package com.SynergyConnect.pageobject.AppSetup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SynergyConnect.utilities.AlertUtils;
import com.SynergyConnect.utilities.ElementInteractionUtils;
import com.SynergyConnect.utilities.ExtentReportListener;
import com.SynergyConnect.utilities.ReadConfig;
import com.aventstack.extentreports.Status;

public class EmailConfigurationPage {
	WebDriver driver;
	ElementInteractionUtils EI;
	AlertUtils AU;
	private static final Logger logger = LogManager.getLogger(EmailConfigurationPage.class);
	ReadConfig config = new ReadConfig();

	public EmailConfigurationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		EI = new ElementInteractionUtils(driver);
		AU = new AlertUtils(driver);

	}

	// identify WebElements

	@FindBy(xpath = "//span[contains(text(),'App Setup')]")
	private WebElement ddlAppSetup;

	@FindBy(xpath = "//span[contains(text(),'Email Configuration')]")
	private WebElement ddlEmailConfiguration;

	@FindBy(xpath = "//*[@id=\"collapseBtn\"]")
	private WebElement btnEmailConfigAdd;

	@FindBy(xpath = "//input[@id='username']")
	private WebElement txtPersonName;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement txtEmail;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement txtPassword;

	@FindBy(xpath = "//select[@id='tls']")
	private WebElement ddlTls;

	@FindBy(xpath = "//input[@id='port']")
	private WebElement txtPort;

	@FindBy(xpath = "//input[@id='host']")
	private WebElement txtHost;

	@FindBy(xpath = "//button[@id='addEmailConfigButton']")
	private WebElement btnAdd;

	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	private WebElement btnCancel;

	@FindBy(id = "emailConfigTable")
	private WebElement emailConfigurationTable;

	@FindBy(id = "")
	private WebElement emailConfigurationTableNext;

	@FindBy(xpath = "//*[@id=\"bEdit\"]/span")
	private WebElement btnEdit;

	@FindBy(xpath = "//*[@id=\"username-error\"]")
	private WebElement PersonNameError;

	@FindBy(xpath = "//*[@id=\"email-error\"]")
	private WebElement emailError;

	@FindBy(xpath = "//*[@id=\"password-error\"]")
	private WebElement passwordError;

	@FindBy(xpath = "//*[@id=\"tls-error\"]")
	private WebElement tlsError;

	@FindBy(xpath = "//*[@id=\"port-error\"]")
	private WebElement portError;

	@FindBy(xpath = "//*[@id=\"host-error\"]")
	private WebElement hostError;

	//
	@Test
	public void redirectToEmailConfigAndValidateUrl() throws InterruptedException {
		ElementInteractionUtils.click(ddlAppSetup);
		ElementInteractionUtils.click(ddlEmailConfiguration);
	}

	@Test
	public void emailConfigurtionFormvalidation() {
		try {
			ElementInteractionUtils.click(btnEmailConfigAdd);
			ElementInteractionUtils.clear(txtPersonName);
			ElementInteractionUtils.clear(txtEmail);
			ElementInteractionUtils.clear(txtPassword);
			//ElementInteractionUtils.clear(ddlTls);
			ElementInteractionUtils.clear(txtPort);
			ElementInteractionUtils.clear(txtHost);
			ElementInteractionUtils.click(btnAdd);
			Thread.sleep(3000);
			
			String personNameErrorText = ElementInteractionUtils.getElementVisibleText(PersonNameError);
			Assert.assertEquals(personNameErrorText, "This field is required.");

			String emailErrorText = ElementInteractionUtils.getElementVisibleText(emailError);
			Assert.assertEquals(emailErrorText, "This field is required.");

			String passwordErrorText = ElementInteractionUtils.getElementVisibleText(passwordError);
			Assert.assertEquals(passwordErrorText, "This field is required.");

			String tlsErrorText = ElementInteractionUtils.getElementVisibleText(tlsError);
			Assert.assertEquals(tlsErrorText, "This field is required.");

			String portErrorText = ElementInteractionUtils.getElementVisibleText(portError);
			Assert.assertEquals(portErrorText, "Port");

			String hostErrorText = ElementInteractionUtils.getElementVisibleText(hostError);
			Assert.assertEquals(hostErrorText, "This field is required.");
			
			ElementInteractionUtils.click(btnCancel);
			
			ExtentReportListener.getExtent().log(Status.PASS, "Email configuration form validation successful");
			
		} catch (Exception e) {
			logger.error("Exception occurred during email configuration form validation: ", e);
	        ExtentReportListener.getExtent().log(Status.FAIL, "Failed to validate email configuration: " + e.getMessage());
		}
	}

	@Test
	public void addEmailConfigurtion() {
		try {
			ElementInteractionUtils.click(btnEmailConfigAdd);
			ElementInteractionUtils.sendKeys(txtPersonName, "Work");
			ElementInteractionUtils.sendKeys(txtEmail, config.getEmailConfiguration_Email());
			ElementInteractionUtils.sendKeys(txtPassword, config.getEmailConfiguration_Password());
			ElementInteractionUtils.selectByVisibleText(ddlTls, "Yes");
			ElementInteractionUtils.sendKeys(txtPort, "587");
			ElementInteractionUtils.sendKeys(txtHost, "smtp.office365.com");
			ElementInteractionUtils.click(btnAdd);
			AU.getToasterText();
			ExtentReportListener.getExtent().log(Status.PASS, "Email configuration added successfully.");
		} catch (Exception e) {
			ExtentReportListener.getExtent().log(Status.FAIL, "Failed to add email configuration: " + e.getMessage());
		}
	}

	@Test
	public void verifyAddedEmailConfigurtion() {
		try {
			boolean isPersonNamePresent = ElementInteractionUtils.verifyTextInTable("emailConfigTable", 2, "Work",
					emailConfigurationTableNext);
			Assert.assertTrue(isPersonNamePresent, "Added email configuration - Person Name not found in the table.");
			boolean isEmailPresent = ElementInteractionUtils.verifyTextInTable("emailConfigTable", 3,
					config.getEmailConfiguration_Email(), emailConfigurationTableNext);
			Assert.assertTrue(isEmailPresent, "Added email configuration - Email not found in the table.");
			boolean isHostPresent = ElementInteractionUtils.verifyTextInTable("emailConfigTable", 4,
					"smtp.office365.com", emailConfigurationTableNext);
			Assert.assertTrue(isHostPresent, "Added email configuration - Host not found in the table.");
			boolean isPortPresent = ElementInteractionUtils.verifyTextInTable("emailConfigTable", 5, "587",
					emailConfigurationTableNext);
			Assert.assertTrue(isPortPresent, "Added email configuration - Port not found in the table.");
			boolean isTlsPresent = ElementInteractionUtils.verifyTextInTable("emailConfigTable", 6, "Yes",
					emailConfigurationTableNext);
			Assert.assertTrue(isTlsPresent, "Added email configuration - TLS not found in the table.");
			ExtentReportListener.getExtent().log(Status.PASS, "Added Email configuration found in table");
		} catch (AssertionError ae) {
			ExtentReportListener.getExtent().log(Status.FAIL,
					"Assertion failed while verifying added email configuration: " + ae.getMessage());
			logger.error("Assertion failed while verifying added email configuration: ", ae);
			throw ae;
		} catch (Exception e) {
			ExtentReportListener.getExtent().log(Status.FAIL,
					"Error verifying added email configuration: " + e.getMessage());
			logger.error("Error verifying added email configuration: ", e);
			Assert.fail("Error verifying added email configuration: " + e.getMessage());
		}

	}

	@Test
	public void updateAddedEmailConfiguration() throws InterruptedException {
		Thread.sleep(10000);
		boolean isClickedOnEdit = ElementInteractionUtils.verifyTextInTableAndPerformAction("emailConfigTable", 2,
				"Work", emailConfigurationTableNext, btnEdit);
		Assert.assertTrue(isClickedOnEdit, "Unable to click on edit button");
		ElementInteractionUtils.sendKeys(txtPersonName, "Work");
		ElementInteractionUtils.click(btnAdd);
		AU.dismissAlertIfPresent();
		String updateToaster = AU.getToasterText();
		Assert.assertEquals(updateToaster, "Email Details updated..!");
	}
}
