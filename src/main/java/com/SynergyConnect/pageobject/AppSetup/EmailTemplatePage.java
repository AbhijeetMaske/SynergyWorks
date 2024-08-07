package com.SynergyConnect.pageobject.AppSetup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SynergyConnect.utilities.AlertUtils;
import com.SynergyConnect.utilities.ElementInteractionUtils;
import com.SynergyConnect.utilities.ReadConfig;

public class EmailTemplatePage {

	WebDriver driver;
	ElementInteractionUtils EI;
	AlertUtils AU;
	private static final Logger logger = LogManager.getLogger(EmailTemplatePage.class);
	ReadConfig config = new ReadConfig();

	public EmailTemplatePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		EI = new ElementInteractionUtils(driver);
		AU = new AlertUtils(driver);
	}

	// identify WebElements
	@FindBy(xpath = "//span[contains(text(),'App Setup')]")
	private WebElement ddlAppSetup;

	@FindBy(xpath = "//span[contains(text(),'Email Template')]")
	private WebElement ddlEmailGroup;

	@FindBy(xpath = "//*[@id=\"collapseBtn\"]")
	private WebElement btnEmailTemplateAdd;

	@FindBy(xpath = "//*[@id=\"type\"]")
	private WebElement ddlTemplateType;

	@FindBy(xpath = "//*[@id=\"subject\"]")
	private WebElement txtSubject;

	@FindBy(xpath = "//*[@id=\"emailConfig\"]")
	private WebElement ddlEmailSenderAddress;

	@FindBy(xpath = "//*[@id=\"signature\"]")
	private WebElement updSignature;

	@FindBy(xpath = "//*[@id=\"multipleCC\"]")
	private WebElement txtCCEmailRecipient;

	@FindBy(xpath = "//*[@id=\"multipleBCC\"]")
	private WebElement txtBCCEmailRecipient;

	@FindBy(xpath = "//*[@id=\"body\"]")
	private WebElement txaEmailHtmlTemplate;

	@FindBy(xpath = "//*[@id=\"addEmailTemplateButton\"]")
	private WebElement btnEmailTemplateFormAdd;

	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	private WebElement btnEmailTemplateFormCancel;

	@FindBy(xpath = "//*[@id=\"emailTemplateTable\"]")
	private WebElement tblEmailTemplate;

	@FindBy(xpath = "//*[@id=\"btnView\"]")
	private WebElement btnEmailTemplateView;

	@FindBy(xpath = "//*[@id=\"btnEdit\"]")
	private WebElement btnEdit;

	@FindBy(xpath = "//*[@id=\"emailTemplateTable_next\"]")
	private WebElement btnEmailTemplateTableNext;

}
