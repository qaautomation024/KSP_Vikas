package com.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;
	
	@FindBy(xpath = "//p[contains(text(),'SIGN IN')]")
	private WebElement signincta;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement validEmail;

	@FindBy(xpath = "//input[@id='pass']")
	private WebElement validPassword;

	@FindBy(xpath = "//span[contains(text(),'SIGN IN')]")
	private WebElement Login;
	
	@FindBy(xpath = "//h3[contains(text(),'LP')]")
	private WebElement loginProfile;
	
	@FindBy(xpath = "//button[contains(text(),'SKIP')]")
	private WebElement vivreSkip;
	
	
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
}

	
	public WebElement getVivreSkip() {
		return vivreSkip;
	}


	public void setVivreSkip(WebElement vivreSkip) {
		this.vivreSkip = vivreSkip;
	}


	public WebElement getLoginProfile() {
		return loginProfile;
	}


	public void setLoginProfile(WebElement loginProfile) {
		this.loginProfile = loginProfile;
	}


	public WebElement getSignincta() {
		return signincta;
	}


	public void setSignincta(WebElement signincta) {
		this.signincta = signincta;
	}


	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getValidEmail() {
		return validEmail;
	}

	public void setValidEmail(WebElement validEmail) {
		this.validEmail = validEmail;
	}

	public WebElement getValidPassword() {
		return validPassword;
	}

	public void setValidPassword(WebElement validPassword) {
		this.validPassword = validPassword;
	}

	public WebElement getLogin() {
		return Login;
	}

	public void setLogin(WebElement login) {
		Login = login;
	}
}