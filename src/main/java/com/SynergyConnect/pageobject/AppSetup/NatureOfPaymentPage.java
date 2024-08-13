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

public class NatureOfPaymentPage {
	WebDriver driver;
	ElementInteractionUtils EI;
	AlertUtils AU;
	private static final Logger logger = LogManager.getLogger(NatureOfPaymentPage.class);
	ReadConfig config = new ReadConfig();

	public NatureOfPaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		EI = new ElementInteractionUtils(driver);
		AU = new AlertUtils(driver);
	}

	// identify WebElements
	@FindBy(xpath = "//span[contains(text(),'App Setup')]")
	private WebElement ddlAppSetup;

	@FindBy(xpath = "//span[contains(text(),'Nature of Payment')]")
	private WebElement ddlCompanyType;

	@FindBy(xpath = "//*[@id=\"collapseBtn\"]")
	private WebElement btnNatureOfPaymentAdd;
	
	@FindBy(xpath = "//*[@id=\"reason\"]")
	private WebElement txtNatureOfPayment;
	
	@FindBy(xpath = "//*[@id=\"addNewRow\"]")
	private WebElement btnAddNatureOfPayment;

	@FindBy(xpath = "//*[@id=\"reasonForm\"]/div/div[2]/div/button[2]")
	private WebElement btnCancel;
	
	@FindBy(xpath = "//*[@id=\"activeBtn\"]")
	private WebElement btnActiveTab;

	@FindBy(xpath = "//*[@id=\"activeDataTable\"]")
	private WebElement tblNatureOfPaymentActive;

	@FindBy(xpath = "//*[@id=\"bEdit\"]")
	private WebElement btnEdit;

	@FindBy(xpath = "//*[@id=\"bElim\"]")
	private WebElement btnDelete;

	@FindBy(xpath = "//*[@id=\"activeDataTable_next\"]")
	private WebElement btnNatureOfPaymentActiveNext;

	@FindBy(xpath = "//*[@id=\"nonActiveBtn\"]")
	private WebElement btnInactiveTab;

	@FindBy(xpath = "//*[@id=\"DyanmicTable01_wrapper\"]")
	private WebElement tblNatureOfPaymentInactive;

	@FindBy(xpath = "//*[@id=\"bElim\"]")
	private WebElement btnActive;

	@FindBy(xpath = "//*[@id=\"DyanmicTable01_next\"]")
	private WebElement btnNatureOfPaymentInactiveNext;
}
