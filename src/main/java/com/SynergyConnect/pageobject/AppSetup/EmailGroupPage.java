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

public class EmailGroupPage {
	WebDriver driver;
	ElementInteractionUtils EI;
	AlertUtils AU;
	private static final Logger logger = LogManager.getLogger(EmailConfigurationPage.class);
	ReadConfig config = new ReadConfig();

	public EmailGroupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		EI = new ElementInteractionUtils(driver);
		AU = new AlertUtils(driver);

	}

	// identify WebElements	
	@FindBy(xpath = "//span[contains(text(),'App Setup')]")
	private WebElement ddlAppSetup;

	@FindBy(xpath = "//span[contains(text(),'Email Group')]")
	private WebElement ddlEmailGroup;
	
	@FindBy(xpath = "//a[@id='collapseBtn']")
	private WebElement btnEmailGroupAdd;
	
	@FindBy (xpath = "//*[@id=\"teamName\"]")
	private WebElement txtTeam;
	
	@FindBy (xpath = "//*[@id=\"multipleEmail\"]")
	private WebElement txtEmailId;
	
	@FindBy(className = "input-group-text btn-cyan text-white no-left-radius")
	private WebElement btnAddAnotherEmail;
	
	@FindBy (xpath = "//*[@id=\"accEmails\"]/div[1]/div/input")
	private WebElement textAnotherEmailId;
	
	@FindBy (xpath = "//*[@id=\"submitEmailGroupBtn\"]")
	private WebElement btnAddEmailGroup;
	
	@FindBy (xpath = "//*[@id=\"emailGroupForm\"]/div[3]/div/button[1]")
	private WebElement btnCancelEmailGroup;
	
	@FindBy (xpath = "//*[@id=\"activeBtn\"]")
	private WebElement tabActive;
	
	@FindBy (xpath = "//*[@id=\"editBtn\"]")
	private WebElement btnEdit;
	
	@FindBy (xpath = "//*[@id=\"deleteBtn\"]")
	private WebElement btnDelete;
	
	@FindBy (xpath = "//*[@id=\"emailDetailActiveTable\"]")
	private WebElement tblEmailGroupActive;
	
	@FindBy (xpath = "//*[@id=\"nonActiveBtn\"]")
	private WebElement tabInactive;
	
	@FindBy (xpath = "//*[@id=\"emailDetailInActiveTable\"]")
	private WebElement tblEmailGroupInactive;
	
	@FindBy (xpath = "//*[@id=\"activeBtn\"]")
	private WebElement btnActive;
	
}
