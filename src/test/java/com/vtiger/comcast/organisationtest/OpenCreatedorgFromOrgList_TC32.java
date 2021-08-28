package com.vtiger.comcast.organisationtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.comcast.pomrepolib.HomePage;
import com.vtiger.comcast.pomrepolib.LoginPage;
import com.vtiger.comcast.pomrepolib.OrganizationInfoPage;
import com.vtiger.comcast.pomrepolib.OrganizationsPage;

public class OpenCreatedorgFromOrgList_TC32 {

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

		/* Step-3: click on the organization name */
		OrganizationsPage org = new OrganizationsPage(driver);
		org.getSriRamLaptops().click();

		/* Step-4: Verifying organization information page with the below msg */
		String actualTxt = "[ ACC7 ] SriRamLaptops - Organization Information Updated today (19 Aug 2021) By Administrator";
		OrganizationInfoPage orginfo = new OrganizationInfoPage(driver);
		String divDivHead = orginfo.getDivHeaderText().getText();
		String smalldivHead = orginfo.getSmallHeaderText().getText();
		String expTxt = divDivHead + " " + smalldivHead;

		System.out.println("actualTxt " + actualTxt);
		System.out.println("expTxt " + expTxt);

		if (expTxt.equalsIgnoreCase(actualTxt)) {
			System.out.println(
					"PASS:: The Created Organization from \"Organization List\" is displayed with proper message");
		} else
			System.out.println(
					"FAIL:: The Created Organization from \"Organization List\" is  NOT displayed with proper message");

		homePage.logOut();

	}

}
