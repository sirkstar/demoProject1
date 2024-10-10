package com.assaaboly.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ConfigDataProvider {

	Properties prop;
	
	public ConfigDataProvider() throws IOException {
		File src = new File("./Config/config.properties");
		try {
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		}catch(Exception e) {
			System.out.println("Exception :"+e);
		}
	}
	
	public String getPropertyData(String keyToSearch){
		return prop.getProperty(keyToSearch);
	}
	
	public String getBaseURL() {
		return prop.getProperty("baseURL");
	}
	
	
}
