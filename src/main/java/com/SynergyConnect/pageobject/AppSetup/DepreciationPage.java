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

public class DepreciationPage {
	WebDriver driver;
	ElementInteractionUtils EI;
	AlertUtils AU;
	private static final Logger logger = LogManager.getLogger(DepreciationPage.class);
	ReadConfig config = new ReadConfig();

	public DepreciationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		EI = new ElementInteractionUtils(driver);
		AU = new AlertUtils(driver);
	}

	// identify WebElements
	@FindBy(xpath = "//span[contains(text(),'App Setup')]")
	private WebElement ddlAppSetup;

	@FindBy(xpath = "//span[contains(text(),'Depreciation')]")
	private WebElement ddlCompanyType;

	@FindBy(xpath = "//*[@id=\"collapseBtn\"]")
	private WebElement btnDepreciationAdd;
	
	@FindBy(xpath = "//*[@id=\"itemTypes\"]")
	private WebElement ddlItemType;

	@FindBy(xpath = "//*[@id=\"itemCategory\"]")
	private WebElement ddlItemCategory;
	
	@FindBy(xpath = "//*[@id=\"financialYear\"]")
	private WebElement ddlFinancialYear;
	
	@FindBy(xpath = "//*[@id=\"financialYear\"]")
	private WebElement txtDepreciationPercentage;
	
	@FindBy(xpath = "//*[@id=\"addNewRow\"]")
	private WebElement btnAddDepreciation;

	@FindBy(xpath = "//*[@id=\"addDepreciationForm\"]/div/div[5]/div/button[1]")
	private WebElement btnCancel;
	
	@FindBy(xpath = "//*[@id=\"activeBtn\"]")
	private WebElement btnActiveTab;

	@FindBy(xpath = "//*[@id=\"activeTableMasterDepreciation_wrapper\"]")
	private WebElement tblTeamConfigurationActive;

	@FindBy(xpath = "//*[@id=\"bEdit\"]")
	private WebElement btnEdit;

	@FindBy(xpath = "//*[@id=\"bDelete\"]")
	private WebElement btnDelete;

	@FindBy(xpath = "//*[@id=\"activeTableMasterDepreciation_next\"]")
	private WebElement btnTeamConfigurationActiveNext;

	@FindBy(xpath = "//*[@id=\"nonActiveBtn\"]")
	private WebElement btnInactiveTab;

	@FindBy(xpath = "//*[@id=\"inActiveTableMasterDepreciation_wrapper\"]")
	private WebElement tblTeamConfigurationInactive;

	@FindBy(xpath = "//*[@id=\"bActive\"]")
	private WebElement btnActive;

	@FindBy(xpath = "//*[@id=\"inActiveTableMasterDepreciation_next\"]")
	private WebElement btnTeamConfigurationInactiveNext;
}
