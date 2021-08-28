package com.vtiger.comcast.organisationtest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.vtiger.comcast.pomrepolib.HomePage;
import com.vtiger.comcast.pomrepolib.LoginPage;
import com.vtiger.comcast.pomrepolib.OrganizationsPage;

public class SearchOrgByAssignTo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");

		/* Step-1: Login */
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp("admin", "12345");

		/* Step-2: Navigate to the Organization */
		HomePage homePage = new HomePage(driver);
		homePage.getOrganisationLink().click();

		/* Step-3: Type the required assignee name in search text field */
		String searchText = "Administrator";
		OrganizationsPage org = new OrganizationsPage(driver);
		org.getBasicsearchForTxtFld().sendKeys(searchText);

		/* Step-4: Select "AssignTo" from IN dropdown list */
		Select select = new Select(org.getBasicsearchInDropDown());
		select.selectByVisibleText("Assigned To");

		/* Step-5: Click on basic search button */
		org.getBasicSearchBtn().click();

		/* Step-5: Validating Assign To column Text */
		List<WebElement> assignToText = org.getAssignToColumnText();

		for (WebElement ele : assignToText) {

			if (ele.getText().contains(searchText)) {
				System.out.println("PASS:: Organization has been searched successfully using AssignedTo parameter");
			} else
				System.out.println("FAIL:: Organization has not searched successfully using AssignedTo parameter");

		}

		/* Step-6: LogOut from the application */
		homePage.logOut();

	}

}
