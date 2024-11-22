package com.genericmethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;



import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
	public Properties prop;
	public Properties dataProp;

	public String path = "C:\\Users\\TECQNIO\\eclipse-workspace\\com.APTN_Automation\\com.properties";

	public void loadPropertiesFile() {
		
		prop = new Properties();
		File propFile = new File(path);

		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
			System.out.println("Properties loaded successfully.");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Failed to load properties file.");
		}

	}

	public WebDriver initializeAndOpenBrowser(String browserName) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		FirefoxOptions options1 = new FirefoxOptions();
		InternetExplorerOptions options2 = new InternetExplorerOptions();
		SafariOptions options3 = new SafariOptions();

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver(options1);
		} else if (browserName.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver(options2);
		} else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver(options3);
		}

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		if (prop != null && prop.getProperty("url") != null) {
			driver.get(prop.getProperty("url"));
		} else {
			System.out.println("URL property not found.");
		}

		// driver.get(prop.getProperty("url"));
//		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
//		HotelManagmentPage hotel = PageFactory.initElements(driver, HotelManagmentPage.class);
//        ThirdPartyServicesPage thirdparty = PageFactory.initElements(driver, ThirdPartyServicesPage.class);
		
        return driver;

	}

}
