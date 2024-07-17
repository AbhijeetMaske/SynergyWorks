package com.SynergyConnect.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SynergyConnect.common.BaseClass;
import com.SynergyConnect.utilities.ElementInteractionUtils;
import com.SynergyConnect.utilities.ExtentReportListener;
import com.SynergyConnect.utilities.ReadConfig;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LoginPage {
	ElementInteractionUtils EI;

	// constructor
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		EI = new ElementInteractionUtils(driver);
	}

	ReadConfig config = new ReadConfig();
	String UserName = config.getUserId();
	String UserPassword = config.getPassword();
	public static ExtentTest test;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;

	// identify WebElements
	@FindBy(id = "username")
	WebElement Userid;

	@FindBy(id = "password")
	WebElement Password;

	@FindBy(xpath = "//button[text()='Login']")
	WebElement Login;

	@FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/nav[1]/div[1]/div[1]/a/em")
	WebElement NavBar;

	@FindBy(xpath = "//*[@id=\"productworks\"]")
	WebElement synergyWorks;

	// identify Action on WebElement
	public void enterUserid() {
		ElementInteractionUtils.sendKeys(Userid, UserName);
		// ExtentReportListener.getExtent().log(Status.PASS, "User ID successfully
		// entered: " +config.getUserId());
	}

	public void enterPassword() {
		ElementInteractionUtils.sendKeys(Password, UserPassword);
	}

	public void clickOnLogin() {
		ElementInteractionUtils.click(Login);
		// ExtentReportListener.getExtent().log(Status.PASS, "Login button clicked
		// successfully.");
	}

	public String getHompageUrl() {
		String currentURL = BaseClass.getDriver().getCurrentUrl();
		boolean loginStatus = currentURL.contains("https://test30.synergyapps.in/");
		return currentURL;
	}

	public void synergyWorks() {
		ElementInteractionUtils.click(NavBar);
		ElementInteractionUtils.click(synergyWorks);
	}
}
