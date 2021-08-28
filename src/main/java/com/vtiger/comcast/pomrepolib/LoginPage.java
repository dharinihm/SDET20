package com.vtiger.comcast.pomrepolib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindAll ({@FindBy(id="submitButton") , @FindBy(xpath = "//input[@id='submitButton']")})
	private WebElement loginBtn;
	
	@FindBy(name = "user_name")
	private WebElement userNameEdt;
	       
	@FindBy(name = "user_password")
	private WebElement userPasswordEdt;

	
	public WebElement getLoginBtn() {
		return loginBtn;
	}


	public WebElement getUserNameEdt() {
		return userNameEdt;
	}


	public WebElement getUserPasswordEdt() {
		return userPasswordEdt;
	}


	public void loginToApp(String username , String password) {
		userNameEdt.sendKeys(username);
		userPasswordEdt.sendKeys(password);
		loginBtn.click();
	}
	
	
	
}
