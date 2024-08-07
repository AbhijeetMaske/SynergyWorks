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

public class TeamConfigurationPage {
	WebDriver driver;
	ElementInteractionUtils EI;
	AlertUtils AU;
	private static final Logger logger = LogManager.getLogger(TeamConfigurationPage.class);
	ReadConfig config = new ReadConfig();

	public TeamConfigurationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		EI = new ElementInteractionUtils(driver);
		AU = new AlertUtils(driver);
	}

	// identify WebElements
	@FindBy(xpath = "//span[contains(text(),'App Setup')]")
	private WebElement ddlAppSetup;

	@FindBy(xpath = "//span[contains(text(),'Team Configuration')]")
	private WebElement ddlCompanyType;

	@FindBy(xpath = "//*[@id=\"collapseBtn\"]")
	private WebElement btnTatConfigurationAdd;
	
	@FindBy(xpath = "//*[@id=\"selectTeam\"]")
	private WebElement ddlTeam;
	
	@FindBy(xpath = "//*[@id=\"selectRole\"]")
	private WebElement ddlRole;
	
	@FindBy(xpath = "//*[@id=\"selectMember\"]")
	private WebElement ddlMember;
	
	@FindBy(xpath = "//*[@id=\"addNewRow\"]")
	private WebElement btnAddTeamConfiguration;

	@FindBy(xpath = "//*[@id=\"addPurchaseTeamMembersForm\"]/div/div[4]/div/button[2]")
	private WebElement btnCancel;
	
	@FindBy(xpath = "//*[@id=\"activeBtn\"]")
	private WebElement btnActiveTab;

	@FindBy(xpath = "//*[@id=\"DyanmicTable01_wrapper\"]")
	private WebElement tblTeamConfigurationActive;

	@FindBy(xpath = "//*[@id=\"bEdit\"]")
	private WebElement btnEdit;

	@FindBy(xpath = "//*[@id=\"bDelete\"]")
	private WebElement btnDelete;

	@FindBy(xpath = "//*[@id=\"DyanmicTable01_next\"]")
	private WebElement btnTeamConfigurationActiveNext;

	@FindBy(xpath = "//*[@id=\"nonActiveBtn\"]")
	private WebElement btnInactiveTab;

	@FindBy(xpath = "//*[@id=\"DyanmicTable02_wrapper\"]")
	private WebElement tblTeamConfigurationInactive;

	@FindBy(xpath = "//*[@id=\"bActive\"]")
	private WebElement btnActive;

	@FindBy(xpath = "//*[@id=\"DyanmicTable02_next\"]")
	private WebElement btnTeamConfigurationInactiveNext;
}
