package com.practice;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.vtiger.comcast.pomrepolib.HomePage;
import com.vtiger.comcast.pomrepolib.LoginPage;
import com.vtiger.comcast.pomrepolib.OrganizationsPage;

public class SearchOrgByRatingTest {

	
		@Test
		public void test() {
//			System.out.println("reading system props");
//			System.out.println(System.getProperty("url"));
//			System.exit(0);
			
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

		/* Step-3: Navigate to the Advanced Search panel */
		OrganizationsPage org = new OrganizationsPage(driver);
		org.getGotoAdvancedSearchLink().click();

		/* Step-4: Select Rating from dropdown1 */
		Select select = new Select(org.getAdvSearchDropDown1());
		select.selectByVisibleText("Rating");

		/* Step-5: Select function from dropdown2 */
		Select select1 = new Select(org.getAdvSearchDropDown2());
		select.selectByVisibleText("equals");

		/* Step-6: Type Active for Search keyword textField */
		org.getAdvSearchtxtFld().sendKeys("active");

		/* Step-7: Click on advance search button */
		org.getBasicSearchBtn().click();

		/* Step-8: LogOut from the application */

		homePage.logOut();

	}

}
