package com.SynergyConnect.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Utility class to read configurations from a properties file.
 */

public class ReadConfig {
	
	private static final Logger logger = LogManager.getLogger(ReadConfig.class);
    Properties properties;
    
    /********************************************************************************************
     * Constructor to load properties from the config file.
     *
     * @author Abhijeet Maske Created June 27,2023
     * @version 1.0 June 27,2023
     ********************************************************************************************/
    public ReadConfig() {
    	// Get the current working directory
        String userDir = System.getProperty("user.dir");
        // Construct the path to the config.properties file
        String path = userDir + "\\Configuration\\application.properties";
        logger.info("Loading configuration from: {}", path);
        try {
            FileInputStream fis = new FileInputStream(path);
            properties = new Properties();
            properties.load(fis);
            logger.info("Configuration loaded successfully from: {}", path);
        } catch (IOException e) {
        	logger.error("Error loading config properties from {}: {}", path, e.getMessage(), e);
        }
    }

    /********************************************************************************************
     * Gets the base URL from the properties file.
     *
     * @return The base URL.
     *
     * @author Abhijeet Maske Created June 27,2023
     * @version 1.0 June 27,2023
     ********************************************************************************************/
    public String getBaseUrl() {
    	String baseUrl = properties.getProperty("baseUrl");
        logger.info("Base URL retrieved: {}", baseUrl);
        return baseUrl;
    }

    /********************************************************************************************
     * Gets the browser type from the properties file.
     *
     * @return The browser type.
     *
     * @author Abhijeet Maske Created June 27,2023
     * @version 1.0 June 27,2023
     ********************************************************************************************/
    public String getBrowser() {
    	String browser = properties.getProperty("browser");
        logger.info("Browser type retrieved: {}", browser);
        return browser;
    }
    
    public String getUserId() {
    	String userId = properties.getProperty("Test_userid");
    	logger.info("User ID retrieved: {}", userId);
        return userId;
    }
    
	public String getPassword() {
		String password = properties.getProperty("Test_password");
		logger.info("password retrieved: {}", password);
		return password;
	}
	public String getEmailConfiguration_Email() {
		String gmail_Email = properties.getProperty("EmailConfiguration_Email");
		logger.info("gmail address retrieved: {}", gmail_Email);
		return gmail_Email;
	}
	public String getEmailConfiguration_Password() {
		String gmail_password = properties.getProperty("EmailConfiguration_Password");
		logger.info("gmail password retrieved: {}", gmail_password);
		return gmail_password;
	}
}
