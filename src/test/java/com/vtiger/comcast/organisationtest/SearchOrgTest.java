package com.vtiger.comcast.organisationtest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericUtility.BaseClass;
import com.vtiger.comcast.genericUtility.WebDriverUtility;
import com.vtiger.comcast.pomrepolib.HomePage;
import com.vtiger.comcast.pomrepolib.OrganizationsPage;

@Listeners(com.vtiger.comcast.genericUtility.ListenerImpCls.class)
public class SearchOrgTest extends BaseClass {

	@Test(groups = { "smokeTest" })
	public void SearchOrgByAssignToTest() {

		/* Step-1: Navigate to the Organization */
		HomePage homePage = new HomePage(driver);
		homePage.getOrganisationLink().click();

		/* Step-2: Type the required assignee name in search text field */
		String searchText = "Administrator";
		OrganizationsPage org = new OrganizationsPage(driver);
		org.getBasicsearchForTxtFld().sendKeys(searchText);

		/* Step-3: Select "AssignTo" from IN dropdown list */
		wdutil.select(org.getBasicsearchInDropDown(), "Assigned To");

		/* Step-4: Click on basic search button */
		org.getBasicSearchBtn().click();

		/* Step-5: Validating Assign To column Text */
		List<WebElement> assignToText = org.getAssignToColumnText();

		for (WebElement ele : assignToText) {
			boolean assertRes = ele.getText().contains(searchText);
			AssertJUnit.assertTrue(assertRes);

		}

	}

	@Test(groups = { "regressionTest" })
	public void SearchOrgByRatingTest() {

		/* Step-1: Navigate to the Organization */
		HomePage homePage = new HomePage(driver);
		homePage.getOrganisationLink().click();

		/* Step-2: Navigate to the Advanced Search panel */
		OrganizationsPage org = new OrganizationsPage(driver);
		org.getGotoAdvancedSearchLink().click();

		/* Step-3: Select Rating from dropdown1 */
		wdutil.select(org.getAdvSearchDropDown1(), "Rating");

		/* Step-4: Select function from dropdown2 */
		wdutil.select(org.getAdvSearchDropDown2(), "equals");

		/* Step-5: Type Active for Search keyword textField */
		org.getAdvSearchtxtFld().sendKeys("active");

		/* Step-6: Click on advance search button */
		org.getBasicSearchBtn().click();

	}

}
