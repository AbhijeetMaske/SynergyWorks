package com.SynergyConnect.testcases;

import org.testng.annotations.Test;
import com.SynergyConnect.common.BaseClass;

public class Login extends BaseClass{
	@Test
	//@Test(retryAnalyzer = com.synergyconnect.utilities.RetryAnalyzer.class)
	public void verifyLoginisworking() throws InterruptedException {
		
		getDriver().get(url);
		logger.info("url opeed");
		Thread.sleep(500);
		getDriver().manage().window().maximize();
		Thread.sleep(500);
		
		System.out.println("gmail Home page");
		
	}
}