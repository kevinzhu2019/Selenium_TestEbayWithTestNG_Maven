package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import testCases.TestEbay;

public class PropertiesFile {

	static Properties prop = new Properties();
	static String path = System.getProperty("user.dir");
	
	public static void getProperties() {
		
		try {
			InputStream input = new FileInputStream(path + "/src/test/java/config/config.properties");
			prop.load(input);
			String browser = prop.getProperty("browser");
			System.out.println("The current set of browser is: " + browser);
			TestEbay.browserName = browser;
		}
		catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}
	
	public static void setProperties() {
		
		try {
			OutputStream output = new FileOutputStream(path + "/src/test/java/config/config.properties");
			prop.setProperty("browser", "chrome");
			prop.store(output, null);
		}
		catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}
}
