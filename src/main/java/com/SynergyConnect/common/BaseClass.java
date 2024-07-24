package com.SynergyConnect.common;

import java.lang.reflect.Method;
import java.time.Duration;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;

import com.SynergyConnect.utilities.BrowserUtils;
import com.SynergyConnect.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();
	
	protected String url;
    protected String browser;
    protected String browserVersion;

    public static WebDriver driver;
    public static Logger logger;
    public static ThreadLocal<WebDriver> driverObject = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver() {
        return driverObject.get();
    }
    //From XML file
    @Parameters({"baseUrl", "browser"})
    @BeforeSuite
    public void setupSuite(String baseUrl, String browser) {
    	logger = LogManager.getLogger(BaseClass.class);
		this.url = baseUrl != null ? baseUrl : readConfig.getBaseUrl();
		this.browser = browser != null ? browser : readConfig.getBrowser();
        
		if (this.url == null || this.browser == null) {
			String errorMessage = "Base URL or browser not provided in XML or config file.";
			logger.error(errorMessage);
			throw new IllegalArgumentException(errorMessage);
		}

        // Get the browser version
        switch (browser.toLowerCase()) {
            case "chrome":
               // browserVersion = BrowserUtils.getChromeBrowserVersion();
                break;
            case "firefox":
                browserVersion = BrowserUtils.getFirefoxBrowserVersion();
                break;
            case "edge":
                browserVersion = BrowserUtils.getEdgeBrowserVersion();
                break;
//            case "opera":
//                browserVersion = BrowserUtils.getOperaBrowserVersion();
//                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        try {
            setupDriver(this.browser);
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            logger.info("WebDriver initialized before suite with browser: {}", this.browser);
        } catch (Exception e) {
            logger.error("Error during WebDriver initialization before suite: {}", e.getMessage(), e);
            throw e;
        }
    }
	

    public void setupDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                //WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setBrowserVersion("126");
               driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                driver = new EdgeDriver(edgeOptions);
                break;
//            case "opera":
//                WebDriverManager.operadriver().setup();
//                OperaOptions operaOptions = new OperaOptions();
//                driver = new OperaDriver(operaOptions);
//                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        driverObject.set(driver);
        // Implicit wait of 10 seconds
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Page load timeout
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

        // For logging
        logger = LogManager.getLogger("<== SynergyWorks ==>");
        logger.info("WebDriver initialized successfully for {}", browser);
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
    	logger.info("Executing test method: {}", method.getName());
    	if (getDriver() == null) {
			setupSuite(url, browser);
		}
		try {
			logger.info("WebDriver initialized for method: {} with browser: {}", method.getName(), this.browser);
		} catch (Exception e) {
			logger.error("Error during WebDriver setup: {}", e.getMessage(), e);
			throw e;
		}
    }
    
    @AfterMethod
    public void afterMethod(Method method) {
    	logger.info("Completed test method: {}", method.getName());
    }
    
    @AfterSuite
    public void tearDown() {
        if (getDriver() != null) {
            try {
                getDriver().close();
                getDriver().quit();
                driverObject.remove();
                logger.info("WebDriver closed and session ended successfully.");
            } catch (Exception e) {
                logger.error("Error while closing WebDriver: " + e.getMessage(), e);
            }
        }
    }
}