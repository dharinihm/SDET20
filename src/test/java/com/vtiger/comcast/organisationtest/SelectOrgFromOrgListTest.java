package com.vtiger.comcast.organisationtest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericUtility.BaseClass;
import com.vtiger.comcast.pomrepolib.HomePage;
import com.vtiger.comcast.pomrepolib.OrganizationInfoPage;
import com.vtiger.comcast.pomrepolib.OrganizationsPage;


@Listeners(com.vtiger.comcast.genericUtility.ListenerImpCls.class)
public class SelectOrgFromOrgListTest extends BaseClass {

	@Test(groups = { "smokeTest", "regressionTest" })
	public void selectOrgFromOrgListTest() {

		HomePage homePage = new HomePage(driver);
		homePage.getOrganisationLink().click();

		/* Step-1: click on the organization name */
		OrganizationsPage org = new OrganizationsPage(driver);
		org.getSriRamLaptops().click();

		/* Step-2: Verifying organization information page with the below msg */
		String expTxt = "[ ACC7 ] SriRamLaptops - Organization Information Updated";
		OrganizationInfoPage orginfo = new OrganizationInfoPage(driver);
		String divDivHead = orginfo.getDivHeaderText().getText();
		String smalldivHead = orginfo.getSmallHeaderText().getText();
		String actualTxt = divDivHead + " " + smalldivHead;
		boolean res = actualTxt.contains(expTxt);
		Assert.assertTrue(res);
		}

}
