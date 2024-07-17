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

        try {
            FileInputStream fis = new FileInputStream(path);
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
        	logger.error("Error loading config properties: " + e.getMessage());
            e.printStackTrace();
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
        return properties.getProperty("baseUrl");
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
        return properties.getProperty("browser");
    }
    
    public String getUserId() {
        return properties.getProperty("Test_userid");
    }
    
	public String getPassword() {
		return properties.getProperty("Test_password");
	}
	public String getEmailConfiguration_Email() {
		return properties.getProperty("EmailConfiguration_Email");
	}
	public String getEmailConfiguration_Password() {
		return properties.getProperty("EmailConfiguration_Password");
	}
}
