package com.SynergyConnect.pageobject.AppSetup;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.seleniumFramework.common.BaseClass;

public class BrandPage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	// constructor
	public BrandPage(WebDriver webDriver) {
		this.driver = BaseClass.getDriver();
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	// identify WebElements 
			@FindBy(xpath="//*[@id=\"collapseBtn\"]")
			WebElement btnAddBrand;
			
			@FindBy(xpath="//input[@id='brandName']")
			WebElement textBrandName;
			
			@FindBy(xpath="//select[@id='brandItemType']")
			WebElement selectItemName;
			
			@FindBy(xpath="//select[@id='brandItemCategory']")
			WebElement selectItemCategory;
			
			@FindBy(xpath="//*[@id=\"addBrandForm\"]/div[1]/div[4]/div")
			WebElement selectItem;
			
			@FindBy(xpath="//*[@id=\"addNewRow04\"]")
			WebElement submitAddBrand;
			
			@FindBy(xpath="//*[@id=\"addBrandForm\"]/div[2]/button[2]")
			WebElement btnCancelBrand;
			
			

}
