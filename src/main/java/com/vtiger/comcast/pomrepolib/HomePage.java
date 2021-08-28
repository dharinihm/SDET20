package com.vtiger.comcast.pomrepolib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "Organizations")
	private WebElement OrganisationLink;

	@FindBy(xpath = "//img[@src ='themes/softed/images/user.PNG' ]")
	private WebElement adminstratorImg;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;

	public WebElement getOrganisationLink() {
		return OrganisationLink;
	}

	public WebElement getAdminstratorImg() {
		return adminstratorImg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public void logOut() {
		WebDriverUtility wdUtil = new WebDriverUtility();
		wdUtil.mouseOver(driver, adminstratorImg);
//		Actions action= new Actions(driver);
//		action.moveToElement(adminstratorImg).perform();
		signOutLink.click();
		driver.quit();

	}
}
