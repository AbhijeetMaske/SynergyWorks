package com.SynergyConnect.pageobject.AppSetup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SynergyConnect.utilities.AlertUtils;
import com.SynergyConnect.utilities.ElementInteractionUtils;

public class UnitOfMeasurePage {
	WebDriver driver;
	ElementInteractionUtils EI;
	AlertUtils AU;
	private static final Logger logger = LogManager.getLogger(UnitOfMeasurePage.class);

	public UnitOfMeasurePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		EI = new ElementInteractionUtils(driver);
		AU = new AlertUtils(driver);
	}

	// identify WebElements
	@FindBy(xpath="//span[contains(text(),'App Setup')]")
	private WebElement ddlAppSetup;

	@FindBy(xpath="//span[contains(text(),'Unit of Measure'')]")
	private WebElement ddlUnitOfMeasure;

	@FindBy(xpath="//*[@id=\"collapseBtn\"]")
	private WebElement btnUnitOfMeasureAdd;
	
	@FindBy (xpath="//*[@id=\"unitMeasure\"]")
	private WebElement txtUnit;
	
	@FindBy (xpath="//*[@id=\"addNewRow02\"]")
	private WebElement btnAddUnitOfMeasure;
	
	@FindBy (xpath="//*[@id=\"addUnitForm\"]/div/div[2]/button[2]")
	private WebElement btnCancel;
	
	@FindBy (xpath="//*[@id=\"unitActiveTab\"]")
	private WebElement btnActiveTab;
	
	@FindBy (xpath="//*[@id=\"DyanmicTable03\"]")
	private WebElement tblUnitActive;
	
	@FindBy (xpath="//*[@id=\"bEdit\"]")
	private WebElement btnEdit;
	
	@FindBy (xpath="//*[@id=\"bElim\"]")
	private WebElement btnDelete;
	
	@FindBy (xpath="//*[@id=\"DyanmicTable03_next\"]")
	private WebElement btnUnitActiveNext;
	
	@FindBy (xpath="//*[@id=\"unitDeactiveTab\"]")
	private WebElement btnInactiveTab;
	
	@FindBy (xpath="//*[@id=\"unitMeasurementTableDeactive\"]")
	private WebElement tblUnitInactive;
	
	@FindBy (xpath="//*[@id=\"bView\"]")
	private WebElement btnActive;
	
	@FindBy (xpath="//*[@id=\"unitMeasurementTableDeactive_next\"]")
	private WebElement btnUnitInactiveNext;
		
}
