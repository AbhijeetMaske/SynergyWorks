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

public class TatConfigurationPage {
	WebDriver driver;
	ElementInteractionUtils EI;
	AlertUtils AU;
	private static final Logger logger = LogManager.getLogger(TatConfigurationPage.class);
	ReadConfig config = new ReadConfig();

	public TatConfigurationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		EI = new ElementInteractionUtils(driver);
		AU = new AlertUtils(driver);
	}

	// identify WebElements
	@FindBy(xpath = "//span[contains(text(),'App Setup')]")
	private WebElement ddlAppSetup;

	@FindBy(xpath = "//span[contains(text(),'TAT Configuration')]")
	private WebElement ddlCompanyType;

	@FindBy(xpath = "//*[@id=\"collapseBtn\"]")
	private WebElement btnTatConfigurationAdd;

	@FindBy(xpath = "//*[@id=\"selectPurpose\"]")
	private WebElement ddlPurpose;

	@FindBy(xpath = "//*[@id=\"overdueDayOver\"]")
	private WebElement txtOverdueAfterDay;

	@FindBy(xpath = "//*[@id=\"addNewRow\"]")
	private WebElement btnAddTatConfiguration;

	@FindBy(xpath = "//*[@id=\"addTATMasterForm\"]/div/div[3]/div/button[2]")
	private WebElement btnCancel;

	@FindBy(xpath = "//*[@id=\"activeBtn\"]")
	private WebElement btnActiveTab;

	@FindBy(xpath = "//*[@id=\"activeTableTATMaster_wrapper\"]")
	private WebElement tblTatConfigurationActive;

	@FindBy(xpath = "//*[@id=\"bEdit\"]")
	private WebElement btnEdit;

	@FindBy(xpath = "//*[@id=\"bDelete\"]")
	private WebElement btnDelete;

	@FindBy(xpath = "//*[@id=\"activeTableTATMaster_next\"]")
	private WebElement btnTatConfigurationActiveNext;

	@FindBy(xpath = "//*[@id=\"nonActiveBtn\"]")
	private WebElement btnInactiveTab;

	@FindBy(xpath = "//*[@id=\"inActiveTableTATMaster_wrapper\"]")
	private WebElement tblTatConfigurationInactive;

	@FindBy(xpath = "//*[@id=\"bActive\"]")
	private WebElement btnActive;

	@FindBy(xpath = "//*[@id=\"inActiveTableTATMaster_next\"]")
	private WebElement btnTatConfigurationInactiveNext;
}
