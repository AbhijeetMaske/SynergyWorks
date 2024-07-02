package com.SynergyConnect.pageobject.AppSetup;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SynergyConnect.common.BaseClass;

public class ApprovalConfigurationPage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	// constructor
	public void BrandPage(WebDriver webDriver) {
		this.driver = BaseClass.getDriver();
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	// identify WebElements
				@FindBy(xpath="//a[@id='collapseBtn']")
				WebElement btnAddApprovalConfig;
				
				@FindBy(xpath="//*[@id=\"type\"]")
				WebElement selectItem;
				
				@FindBy(xpath="//*[@id=\"apprApplicableYes\"]")
				WebElement radioYesApprovalApp;
				
				@FindBy(xpath="//*[@id=\"apprApplicableNo\"]")
				WebElement radioNoApprovalApp;
				
				@FindBy(xpath="//*[@id=\"addNewRow03\"]")
				WebElement submitAddApprovalConfig;

}
