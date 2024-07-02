package com.SynergyConnect.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.github.dockerjava.api.model.Driver;

import groovyjarjarantlr4.v4.parse.ANTLRParser.element_return;

import com.SynergyConnect.common.BaseClass;
import com.SynergyConnect.utilities.ElementInteractionUtils;
import com.SynergyConnect.utilities.ExtentReportListener;
import com.SynergyConnect.utilities.ReadConfig;

public class LoginPage {
	ElementInteractionUtils EI;
	
	//constructor
	public LoginPage(WebDriver driver) {	
		PageFactory.initElements(driver, this);
		EI = new ElementInteractionUtils(driver);
	}	
	ReadConfig config = new ReadConfig();
	String UserName = config.getUserId();
	String UserPassword = config.getPassword();
	
	//identify WebElements
	@FindBy(id="username")
	WebElement Userid;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(xpath="//button[text()='Login']")
	WebElement Login;
	
	@FindBy(xpath="//*[@id=\"app\"]/div/div[1]/nav[1]/div[1]/div[1]/a/em")
	WebElement NavBar;
	
	@FindBy(xpath="//*[@id=\"productworks\"]")
	WebElement synergyWorks;
	
	
	//identify Action on WebElement
	public void enterUserid() {
		ElementInteractionUtils.sendKeys(Userid, UserName);
		ExtentReportListener.getExtent().log(Status.PASS, "User ID successfully entered: " +config.getUserId());
	}
	
	public void enterPassword() {
		ElementInteractionUtils.sendKeys(Password, UserPassword );
		ExtentReportListener.getExtent().log(Status.PASS, "Pasword successfully entered: "+config.getPassword());
	}
	
	public void clickOnLogin() {
		ElementInteractionUtils.click(Login);
		ExtentReportListener.getExtent().log(Status.PASS, "Login button clicked successfully.");
	}
	
	public String getHompageUrl() {
		String currentURL =BaseClass.getDriver().getCurrentUrl();
		boolean loginStatus = currentURL.contains("https://test30.synergyapps.in/");
		if (loginStatus) {
		    ExtentReportListener.getExtent().log(Status.PASS, "Successfully fetched URL: " + currentURL);
		} else {
		    ExtentReportListener.getExtent().log(Status.FAIL, "Failed to fetch URL: " + currentURL);
		}
		return currentURL;
	}
	
	public void synergyWorks() {
		ElementInteractionUtils.click(NavBar);
		ElementInteractionUtils.click(synergyWorks);
		ExtentReportListener.getExtent().log(Status.PASS, "Successfully redirected to Product: SynergyWorks");
	}
}
