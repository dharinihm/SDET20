package com.vtiger.comcast.pomrepolib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	WebElement divHeaderText;

	@FindBy(xpath = "//span[@class='small']")
	WebElement smallHeaderText;

	public WebElement getDivHeaderText() {
		return divHeaderText;
	}

	public WebElement getSmallHeaderText() {
		return smallHeaderText;
	}
	
	
}
