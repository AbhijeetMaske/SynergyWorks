package com.SynergyConnect.pageobject.AppSetup;

public class ApprovalConfigurationPage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	// constructor
	public BrandPage(WebDriver webDriver) {
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
