package com.SynergyConnect.pageobject.AppSetup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SynergyConnect.utilities.AlertUtils;
import com.SynergyConnect.utilities.ElementInteractionUtils;

public class OfacConfigurationPage {
	WebDriver driver;
	ElementInteractionUtils EI;
	AlertUtils AU;
	private static final Logger logger = LogManager.getLogger(OfacConfigurationPage.class);

	public OfacConfigurationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		EI = new ElementInteractionUtils(driver);
		AU = new AlertUtils(driver);
	}

	// identify WebElements
	@FindBy(xpath = "//span[contains(text(),'App Setup')]")
	private WebElement ddlAppSetup;

	@FindBy(xpath = "//span[contains(text(),'OFAC Configuration')]")
	private WebElement ddlOfacConfiguration;

	@FindBy(xpath = "//*[@id=\"collapseBtn\"]")
	private WebElement btnOfacConfigurationAdd;

	@FindBy(xpath = "//*[@id=\"purpose\"]")
	private WebElement ddlOfacPurpose;

	@FindBy(xpath = "//*[@id=\"ofacamount\"]")
	private WebElement txtOfacAmountLimit;

	@FindBy(xpath = "//*[@id=\"addNewRow03\"]")
	private WebElement btnAddOfacConfiguration;

	@FindBy(xpath = "//*[@id=\"addOFACMasterForm\"]/div/div/div[3]/button[2]")
	private WebElement btnCancel;

	@FindBy(xpath = "//*[@id=\"activeBtn\"]")
	private WebElement btnActiveTab;

	@FindBy(xpath = "//*[@id=\"activeOFACMasterData_wrapper\"]")
	private WebElement tblBankNameActive;

	@FindBy(xpath = "//*[@id=\"bEdit\"]")
	private WebElement btnEdit;

	@FindBy(xpath = "//*[@id=\"bElim\"]")
	private WebElement btnDelete;

	@FindBy(xpath = "//*[@id=\"activeOFACMasterData_next\"]")
	private WebElement btnOfacCOnfigurationActiveNext;

	@FindBy(xpath = "//*[@id=\"nonActiveBtn\"]")
	private WebElement btnInactiveTab;

	@FindBy(xpath = "//*[@id=\"inactiveOFACMasterData_wrapper\"]")
	private WebElement tblOfacConfigurationInactive;

	@FindBy(xpath = "//*[@id=\"activate\"]")
	private WebElement btnActive;

	@FindBy(xpath = "//*[@id=\"inactiveOFACMasterData_next\"]")
	private WebElement btnOfacConfigurationNext;

}
