package com.SynergyConnect.testcases;

import org.testng.annotations.Test;

import com.SynergyConnect.common.BaseClass;
import com.SynergyConnect.pageobject.LoginPage;
import com.SynergyConnect.utilities.ExtentReportListener;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;

public class Login extends BaseClass{
	
	public static ExtentTest test;
	
	
	@Test(priority = 1, testName = "Login Test", alwaysRun = true)
	//@Test(retryAnalyzer = com.synergyconnect.utilities.RetryAnalyzer.class)
	public void verifyLoginisworking() throws InterruptedException {
		
		LoginPage loginPage=new LoginPage(getDriver());		
		getDriver().get(url);
		logger.info("URL:"+url);
		Thread.sleep(500);
		getDriver().manage().window().maximize();
		Thread.sleep(500);
		loginPage.enterUserid();
		loginPage.enterPassword();
		loginPage.clickOnLogin();
		loginPage.getHompageUrl();
		loginPage.synergyWorks();
	}
}