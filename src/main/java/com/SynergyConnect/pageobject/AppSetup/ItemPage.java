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

public class ItemPage {
	WebDriver driver;
	ElementInteractionUtils EI;
	AlertUtils AU;
	private static final Logger logger = LogManager.getLogger(ItemPage.class);
	ReadConfig config = new ReadConfig();

	public ItemPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		EI = new ElementInteractionUtils(driver);
		AU = new AlertUtils(driver);
	}

	// identify WebElements

	@FindBy(xpath = "//span[contains(text(),'App Setup')]")
	private WebElement ddlAppSetup;

	@FindBy(xpath = "//span[contains(text(),'Item')]")
	private WebElement ddlItem;

	@FindBy(xpath = "//*[@id=\"collapseBtn\"]")
	private WebElement btnItemAdd;

	@FindBy(xpath = "//*[@id=\"item\"]")
	private WebElement ddlItemType;

	@FindBy(xpath = "//*[@id=\"item\"]")
	private WebElement ddlItemCategory;

	@FindBy(xpath = "//*[@id=\"itemName\"]")
	private WebElement txtItem;

	@FindBy(xpath = "//*[@id=\"itemabbreviation\"]")
	private WebElement txtItemAbbreviation;

	@FindBy(xpath = "//*[@id=\"itemshelfLife\"]")
	private WebElement txtAssetLife;

	@FindBy(xpath = "//*[@id=\"itempurchaseLimitMin\"]")
	private WebElement txtPurchaseAmountLimit_Min;

	@FindBy(xpath = "//*[@id=\"itempurchaseLimitMax\"]")
	private WebElement txtPurchaseAmountLimit_Max;

	@FindBy(xpath = "//*[@id=\"addNewRow031\"]")
	private WebElement btnAdd;

	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	private WebElement btnCancel;

	@FindBy(xpath = "//*[@id=\"activeBtn\"]")
	private WebElement btnActiveTab;

	@FindBy(xpath = "//*[@id=\"DyanmicTable04_wrapper\"]")
	private WebElement tblItemActive;

	@FindBy(xpath = "//*[@id=\"updateItemCategory\"]")
	private WebElement btnEdit;

	@FindBy(xpath = "//*[@id=\"deleteItemCategory\"]")
	private WebElement btnDelete;

	@FindBy(xpath = "//*[@id=\"DyanmicTable04_next\"]/a")
	private WebElement btnItemActiveNext;

	@FindBy(xpath = "//*[@id=\"nonActiveBtn\"]")
	private WebElement btnInactiveTab;

	@FindBy(xpath = "//*[@id=\"assetMasterItemDataInactive_wrapper\"]")
	private WebElement tblItemInactive;

	@FindBy(xpath = "//*[@id=\"bActive\"]")
	private WebElement btnActive;

	@FindBy(xpath = "//*[@id=\"assetMasterItemDataInactive_next\"]")
	private WebElement btnItemInactiveNext;
}
