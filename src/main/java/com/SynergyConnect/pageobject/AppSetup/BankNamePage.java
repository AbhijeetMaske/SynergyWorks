package com.SynergyConnect.pageobject.AppSetup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SynergyConnect.utilities.AlertUtils;
import com.SynergyConnect.utilities.ElementInteractionUtils;

public class BankNamePage {
	WebDriver driver;
	ElementInteractionUtils EI;
	AlertUtils AU;
	private static final Logger logger = LogManager.getLogger(UnitOfMeasurePage.class);

	public BankNamePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		EI = new ElementInteractionUtils(driver);
		AU = new AlertUtils(driver);
	}
	
	// identify WebElements
	@FindBy(xpath="//span[contains(text(),'App Setup')]")
	private WebElement ddlAppSetup;

	@FindBy(xpath="//span[contains(text(),'Bank Name')]")
	private WebElement ddlBankName;
	
	@FindBy(xpath="//*[@id=\"collapseBtn\"]")
	private WebElement btnBankNameAdd;
	
	@FindBy (xpath="//*[@id=\"bankName\"]")
	private WebElement txtBankName;
	
	@FindBy (xpath="//*[@id=\"bankSubmitBtn\"]")
	private WebElement btnAddBankName;
	
	@FindBy (xpath="//*[@id=\"addBankForm\"]/div/div[2]/button[2]")
	private WebElement btnCancel;
	
	@FindBy (xpath="//*[@id=\"bankActiveTab\"]")
	private WebElement btnActiveTab;
	
	@FindBy (xpath="//*[@id=\"bankTableActive_wrapper\"]")
	private WebElement tblBankNameActive;
	
	@FindBy (xpath="//*[@id=\"bEdit\"]")
	private WebElement btnEdit;
	
	@FindBy (xpath="//*[@id=\"bElim\"]")
	private WebElement btnDelete;
	
	@FindBy (xpath="//*[@id=\"bankTableActive_next\"]")
	private WebElement btnBankNameActiveNext;
	
	@FindBy (xpath="//*[@id=\"bankDeactiveTab\"]")
	private WebElement btnInactiveTab;
	
	@FindBy (xpath="//*[@id=\"bankTableDeactive\"]")
	private WebElement tblBankNameInactive;
	
	@FindBy (xpath="//*[@id=\"bView\"]")
	private WebElement btnActive;
	
	@FindBy (xpath="//*[@id=\"bankTableDeactive_next\"]")
	private WebElement btnBankNameNext;
	
}
