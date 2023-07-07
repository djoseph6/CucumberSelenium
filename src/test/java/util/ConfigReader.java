package util;

import java.util.Properties;
import java.io.*;

public class ConfigReader {
	
	static Properties prop;
	
	public static Properties readProperties(String filePath) {
		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(fis);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public static String getPropertyValue(String key) {
		return prop.getProperty(key);
	}
}
