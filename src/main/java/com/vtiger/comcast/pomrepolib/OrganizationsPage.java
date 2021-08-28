package com.vtiger.comcast.pomrepolib;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "search_text")
	WebElement BasicsearchForTxtFld;

	@FindBy(id = "bas_searchfield")
	WebElement BasicsearchInDropDown;

	@FindBy(name = "submit")
	WebElement BasicSearchBtn;

	@FindBy(linkText = "Go to Advanced Search")
	WebElement GotoAdvancedSearchLink;

	@FindBy(className = "detailedViewTextBox")
	WebElement advSearchDropDown1;

	@FindBy(className = "fop0")
	WebElement advSearchDropDown2;

	@FindBy(id = "repBox")
	WebElement advSearchtxtFld;

	@FindBy(xpath = "//input[@class='repBox']/following::input[@value =' Search Now ']")
	WebElement advSearchBtn;

	@FindBy(css = "a[title='Organizations']")
	WebElement OrganisationList;

	@FindBy(xpath = "//a[@title='Organizations' and text()='SriRamLaptops']")
	WebElement SriRamLaptops;
	//// table[@class='lvt small']//td/span[@vtfieldname='assigned_user_id']
	//// table[@class='lvt small']//td/span[@vtfieldname='assigned_user_id']
	@FindBy(xpath = "//td[text()=' Administrator ']")
	List<WebElement> assignToColumnText;

	public WebElement getBasicsearchForTxtFld() {
		return BasicsearchForTxtFld;
	}

	public WebElement getBasicsearchInDropDown() {
		return BasicsearchInDropDown;
	}

	public WebElement getBasicSearchBtn() {
		return BasicSearchBtn;
	}

	public WebElement getGotoAdvancedSearchLink() {
		return GotoAdvancedSearchLink;
	}

	public WebElement getAdvSearchDropDown1() {
		return advSearchDropDown1;
	}

	public WebElement getAdvSearchDropDown2() {
		return advSearchDropDown2;
	}

	public WebElement getAdvSearchtxtFld() {
		return advSearchtxtFld;
	}

	public WebElement getAdvSearchBtn() {
		return advSearchBtn;
	}

	public WebElement getOrganisationList() {
		return OrganisationList;
	}

	public WebElement getSriRamLaptops() {
		return SriRamLaptops;
	}

	public List<WebElement> getAssignToColumnText() {
		return assignToColumnText;
	}

}
