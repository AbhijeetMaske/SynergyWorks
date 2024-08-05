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

public class ItemCategoryPage {
	WebDriver driver;
	ElementInteractionUtils EI;
	AlertUtils AU;
	private static final Logger logger = LogManager.getLogger(ItemCategoryPage.class);
	ReadConfig config = new ReadConfig();

	public ItemCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		EI = new ElementInteractionUtils(driver);
		AU = new AlertUtils(driver);
	}

	// identify WebElements

	@FindBy(xpath = "//span[contains(text(),'App Setup')]")
	private WebElement ddlAppSetup;

	@FindBy(xpath = "//span[contains(text(),'Item Category')]")
	private WebElement ddlItemCategory;

	@FindBy(xpath = "//*[@id=\"collapseBtn\"]")
	private WebElement btnItemCategoryAdd;

	@FindBy(xpath = "//*[@id=\"itemType\"]")
	private WebElement ddlItemType;

	@FindBy(xpath = "//*[@id=\"itemCategory\"]")
	private WebElement txtItemCategory;

	@FindBy(xpath = "//*[@id=\"abbreviation\"]")
	private WebElement txtAbbreviation;

	@FindBy(xpath = "//*[@id=\"software\"]")
	private WebElement ddlIsThisASoftware;

	@FindBy(xpath = "//*[@id=\"assetMapping\"]")
	private WebElement ddlAssetMapping;

	@FindBy(xpath = "//*[@id=\"farApplicableYes\"]")
	private WebElement rdoFarAppliableYes;

	@FindBy(xpath = "//*[@id=\"farApplicableNo\"]")
	private WebElement rdoFarAppliableNo;

	@FindBy(xpath = "//*[@id=\"addNewRow03\"]")
	private WebElement btnAdd;

	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	private WebElement btnCancel;

	@FindBy(xpath = "//*[@id=\"activeBtn\"]")
	private WebElement btnActiveTab;

	@FindBy(xpath = "//*[@id=\"DyanmicTable03_wrapper\"]")
	private WebElement tblItemCategoryActive;

	@FindBy(xpath = "//*[@id=\"updateItemCategory\"]")
	private WebElement btnEdit;

	@FindBy(xpath = "//*[@id=\"deleteItemCategory\"]")
	private WebElement btnDelete;

	@FindBy(xpath = "//*[@id=\"DyanmicTable03_next\"]/a")
	private WebElement btnItemCategoryActiveNext;

	@FindBy(xpath = "//*[@id=\"nonActiveBtn\"]")
	private WebElement btnInactiveTab;

	@FindBy(xpath = "//*[@id=\"DyanmicTable03_wrapper\"]")
	private WebElement tblItemCategoryInactive;

	@FindBy(xpath = "//*[@id=\"bActive\"]")
	private WebElement btnActive;

	@FindBy(xpath = "//*[@id=\"DyanmicTable03_next\"]")
	private WebElement btnItemCategoryInactiveNext;
}
