package datadriverntesting.readData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class ReadDataFromPropertiesFile {

	protected static String username;
	protected static String browser;
	protected static String url;
	protected static String password;
	protected static String email;
	protected static String role;
	
	@BeforeSuite
	public void fetchData() throws IOException {
		
		FileInputStream fis = new FileInputStream("D:\\training\\Capgemini\\Pojo\\src\\test\\resources\\configData\\ConfigData.properties");
			
		Properties p = new Properties();
		p.load(fis);
		

		username = p.getProperty("username");
		browser = p.getProperty("browser");
		url = p.getProperty("url");
		password = p.getProperty("password");
		
		email = p.getProperty("email");
		role = p.getProperty("role");
		
		RestAssured.baseURI=url;
	}

}
