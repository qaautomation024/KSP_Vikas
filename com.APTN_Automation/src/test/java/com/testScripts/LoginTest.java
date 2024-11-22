package com.testScripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.genericmethods.Base;
import com.objectRepo.LoginPage;


public class LoginTest extends Base {
	private WebDriver driver;

	@BeforeMethod
	public void browsersetup() throws InterruptedException {
		loadPropertiesFile();
		driver = initializeAndOpenBrowser(prop.getProperty("browser"));
	}

	@AfterMethod
	public void quitt() throws InterruptedException {
		Thread.sleep(3000);
		// driver.quit();

	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	@Test(priority = 1)
	public void validPasswordloginpage() throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		Thread.sleep(4000);

	
		login.getValidEmail().sendKeys(prop.getProperty("validemail"));
		Thread.sleep(2000);
		login.getValidPassword().sendKeys(prop.getProperty("validpassword"));
		Thread.sleep(4000);
		login.getLogin().click();
		Thread.sleep(3000);

		// to capture total time from the login to home page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Long loadTime = (Long) js.executeScript("return performance.timing.loadEventEnd - performance.timing.navigationStart;");
		System.out.println("Page load time from login to home: " + loadTime + " milliseconds");

		login.getLoginProfile().click();
		System.out.println("User looged in successfully");
		Thread.sleep(2000);

	}
}
