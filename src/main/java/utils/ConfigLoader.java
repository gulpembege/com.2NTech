package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

	private Properties properties;

	public ConfigLoader() {
		try {
			FileInputStream fis = new FileInputStream("src/test/resources/config/config.yaml");
			properties = new Properties();
			properties.load(fis);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}


	public String getConfigValue(String key) {
		return properties.getProperty(key);
	}


	public boolean getBooleanConfigValue(String key) {
		return Boolean.parseBoolean(properties.getProperty(key));
	}

}
