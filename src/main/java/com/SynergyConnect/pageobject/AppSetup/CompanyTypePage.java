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

public class CompanyTypePage {
	WebDriver driver;
	ElementInteractionUtils EI;
	AlertUtils AU;
	private static final Logger logger = LogManager.getLogger(CompanyTypePage.class);
	ReadConfig config = new ReadConfig();

	public CompanyTypePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		EI = new ElementInteractionUtils(driver);
		AU = new AlertUtils(driver);

	}
	
	// identify WebElements
			@FindBy(xpath="//span[contains(text(),'App Setup')]")
			private WebElement ddlAppSetup;

			@FindBy(xpath="//span[contains(text(),'Company Type')]")
			private WebElement ddlCompanyType;
			
			@FindBy(xpath="//*[@id=\"collapseBtn\"]")
			private WebElement btnCompanyTypeAdd;
			
			@FindBy(xpath="//*[@id=\"companyType\"]")
			private WebElement txtCompanyType;
			
			@FindBy(xpath="//*[@id=\"addNewRow03\"]")
			private WebElement btnAddCompanyType;
			
			@FindBy (xpath="//*[@id=\"addCompanyTypeForm\"]/div/div/div[2]/button[2]")
			private WebElement btnCancel;			
			
			@FindBy (xpath="//*[@id=\"activeBtn\"]")
			private WebElement btnActiveTab;
			
			@FindBy (xpath="//*[@id=\"activeCompanyData\"]")
			private WebElement tblCompanyTypeActive;
			
			@FindBy (xpath="//*[@id=\"bEdit\"]")
			private WebElement btnEdit;
			
			@FindBy (xpath="//*[@id=\"bElim\"]")
			private WebElement btnDelete;
			
			@FindBy (xpath="//*[@id=\"activeCompanyData_next\"]")
			private WebElement btnCompanyTypeActiveNext;
			
			@FindBy (xpath="//*[@id=\"nonActiveBtn\"]")
			private WebElement btnInactiveTab;
			
			@FindBy (xpath="//*[@id=\"companyDataNotactive\"]")
			private WebElement tblCompanyTypeInactive;
			
			@FindBy (xpath="//*[@id=\"bElim\"]")
			private WebElement btnActive;
			
			@FindBy (xpath="//*[@id=\"companyDataNotactive_next\"]")
			private WebElement btnCompanyTypeInactiveNext;
	
}
