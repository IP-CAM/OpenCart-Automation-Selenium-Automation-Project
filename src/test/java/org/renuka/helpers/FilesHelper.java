package org.renuka.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FilesHelper {

	private final static String repositoryPath = "src/test/resources/Locators/Repository.properties";

	public static String getLocatorValueUsingKey(String key) {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream(repositoryPath);
			// load a properties file from class path, inside static method
			prop.load(input);

			// get the property value and print it out
			return prop.getProperty(key);

		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
