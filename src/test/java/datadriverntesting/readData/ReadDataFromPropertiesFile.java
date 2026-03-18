package datadriverntesting.readData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertiesFile {

	protected static String username;
	protected static String browser;
	protected static String url;
	protected static String password;
	protected static String email;
	protected static String role;

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("D:\\training\\Capgemini\\Pojo\\src\\test\\resources\\configData\\ConfigData.properties");
			
		Properties p = new Properties();
		p.load(fis);
		

		username = p.getProperty("username");
		browser = p.getProperty("browser");
		url = p.getProperty("url");
		password = p.getProperty("password");
		
		email = p.getProperty("email");
		role = p.getProperty("role");
	}

}
