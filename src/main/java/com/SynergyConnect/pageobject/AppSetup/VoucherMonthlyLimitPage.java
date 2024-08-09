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

public class VoucherMonthlyLimitPage {
	WebDriver driver;
	ElementInteractionUtils EI;
	AlertUtils AU;
	private static final Logger logger = LogManager.getLogger(VoucherMonthlyLimitPage.class);
	ReadConfig config = new ReadConfig();

	public VoucherMonthlyLimitPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		EI = new ElementInteractionUtils(driver);
		AU = new AlertUtils(driver);
	}

	// identify WebElements
	@FindBy(xpath = "//span[contains(text(),'App Setup')]")
	private WebElement ddlAppSetup;

	@FindBy(xpath = "//span[contains(text(),'Voucher Monthly Limit')]")
	private WebElement ddlCompanyType;

	@FindBy(xpath = "//*[@id=\"collapseBtn\"]")
	private WebElement btnVoucherMonthlyLimitAdd;
	
	@FindBy(xpath = "//*[@id=\"selectRoll\"]")
	private WebElement ddlRole;

	@FindBy(xpath = "//*[@id=\"selectUser\"]")
	private WebElement ddlUser;
	
	@FindBy(xpath = "//*[@id=\"voucherType\"]")
	private WebElement ddlVoucherType;
	
	@FindBy(xpath = "//*[@id=\"monthlyAmount\"]")
	private WebElement txtAmountLimit;
	
	@FindBy(xpath = "//*[@id=\"addNewRow\"]")
	private WebElement btnAddVoucherMonthlyLimit;

	@FindBy(xpath = "//*[@id=\"voucherMonthlyLimitForm\"]/div/div[5]/button[1]")
	private WebElement btnCancel;
	
	@FindBy(xpath = "//*[@id=\"activeBtn\"]")
	private WebElement btnActiveTab;

	@FindBy(xpath = "//*[@id=\"activeDataTable\"]")
	private WebElement tblVoucherMonthlyLimitActive;

	@FindBy(xpath = "//*[@id=\"bEdit\"]")
	private WebElement btnEdit;

	@FindBy(xpath = "//*[@id=\"bElim\"]")
	private WebElement btnDelete;

	@FindBy(xpath = "//*[@id=\"activeDataTable_next\"]/a")
	private WebElement btnVoucherMonthlyLimitActiveNext;

	@FindBy(xpath = "//*[@id=\"nonActiveBtn\"]")
	private WebElement btnInactiveTab;

	@FindBy(xpath = "//*[@id=\"DyanmicTable01_wrapper\"]")
	private WebElement tblVoucherMonthlyLimitInactive;

	@FindBy(xpath = "//*[@id=\"bElim\"]")
	private WebElement btnActive;

	@FindBy(xpath = "//*[@id=\"DyanmicTable01_next\"]")
	private WebElement btnVoucherMonthlyLimitInactiveNext;
}
