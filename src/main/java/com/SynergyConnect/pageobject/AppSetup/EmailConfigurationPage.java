package com.SynergyConnect.pageobject.AppSetup;

import java.sql.Array;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.SynergyConnect.utilities.AlertUtils;
import com.SynergyConnect.utilities.ElementInteractionUtils;

public class EmailConfigurationPage {
	WebDriver driver;
	ElementInteractionUtils EI;
	AlertUtils AU;
	private static final Logger logger = LogManager.getLogger(EmailConfigurationPage.class);
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
	
	@FindBy (id ="")
	private WebElement emailConfigurationTableNext;

	//
	@Test
	public void redirectToEmailConfigAndValidateUrl() throws InterruptedException {
		ElementInteractionUtils.click(ddlAppSetup);
		ElementInteractionUtils.click(ddlEmailConfiguration);
	}

	@Test
	public void emailConfigurtionFormvalidation() {
		//ElementInteractionUtils.click(btnEmailConfigAdd);

	}

	@Test
	public void addEmailConfigurtion() {
		ElementInteractionUtils.click(btnEmailConfigAdd);
		ElementInteractionUtils.sendKeys(txtPersonName, "Works");
		ElementInteractionUtils.sendKeys(txtEmail, "info@synergyconnect.in");
		ElementInteractionUtils.sendKeys(txtPassword, "Leadership@2016");// ddlTls
		ElementInteractionUtils.sendKeys(ddlTls, "Leadership@2016");
		ElementInteractionUtils.selectByVisibleText(ddlTls, "Yes");
		ElementInteractionUtils.sendKeys(txtPort, "587");
		ElementInteractionUtils.sendKeys(txtHost, "smtp.office365.com");
		ElementInteractionUtils.click(btnAdd);
		AU.getToasterText();

	}

	@Test
	public void verifyAddedEmailConfigurtion() {
		ElementInteractionUtils.verifyTextInTable("emailConfigTable", 3, "info@synergyconnect.in", emailConfigurationTableNext);
	}
		

}
