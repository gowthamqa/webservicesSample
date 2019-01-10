package com.qa.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.qa.common.utils.ApplicationProperties;

public class ApplicationProperties {
	
	private static ApplicationProperties s_uniqueInstance;
	
	Properties properties = new Properties();
	
	String host;
	
	public ApplicationProperties() {
		
		try {
			properties.load(getPropertiesFile());
			host = getSetting("HOST", "http://ergast.com");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	InputStream getPropertiesFile() {
        File file = new File("./src/test/java/com/qa/config/application.properties");
        FileInputStream propFile = null;
		try {
			propFile = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return propFile;
    }
	
	/**
     * First attempt to read the setting from system property. if not found, read from properties file, and both attempts fail, use default
     *
     * @param settingName
     * @param defaultValue
     *
     */
    public String getSetting(String settingName, String defaultValue) {
        String value = System.getProperty(settingName);
        if (value == null) {
            value = properties.getProperty(settingName, defaultValue);
        }

        return value;
    }

	public static ApplicationProperties getInstance() {
		
		s_uniqueInstance = new ApplicationProperties();
		// TODO Auto-generated method stub
		return s_uniqueInstance;
	}
	
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}


}
