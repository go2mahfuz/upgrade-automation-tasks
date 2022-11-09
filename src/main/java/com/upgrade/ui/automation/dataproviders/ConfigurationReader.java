package com.upgrade.ui.automation.dataproviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
	public Properties properties;
	public final static String PROPERTY_FILE_PATH = "src//test//resources//configs//Configuration.properties";
	public final static String DRIVER_PATH = "driverPath";
	public final static String IMPLICITLY_WAIT = "implicitlyWait";
	public final static String URL = "url";
	public final static String LOGIN ="loginURL";

	public ConfigurationReader() {
		properties = new Properties();
		try (BufferedReader reader = new BufferedReader(new FileReader(PROPERTY_FILE_PATH))) {
			properties.load(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + PROPERTY_FILE_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getDriverPath() {
		if (properties.getProperty(DRIVER_PATH) != null) {
			return properties.getProperty(DRIVER_PATH);
		} else {
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
		}
	}

	public String getImplicitlyWait() {
		if (properties.getProperty(IMPLICITLY_WAIT) != null) {
			return properties.getProperty(IMPLICITLY_WAIT);
		} else {
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
		}
	}

	public String getApplicationUrl() {
		if (properties.getProperty(URL) != null) {
			return properties.getProperty(URL);
		} else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public String getLoginUrl() {
		if (properties.getProperty(LOGIN) != null) {
			return properties.getProperty(LOGIN);
		} else
			throw new RuntimeException("login not specified in the Configuration.properties file.");
	}
	
}