package com.vtiger.comcast.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.comcast.pomrepolib.HomePage;
import com.vtiger.comcast.pomrepolib.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sDriver;
	
	/*Object Creation for Lib*/
	public WebDriverUtility wdutil = new WebDriverUtility();
	public JavaUtility javaUtil = new JavaUtility();
	public FileUtility flUtil = new FileUtility();

	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void configBS() {
		System.out.println("Connect to DB");

	}

	@Parameters("BROWSER")
	@BeforeClass
	public void configBC(String browser) {
		System.out.println("=======Browser Launching========");

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else
			driver = new ChromeDriver();
		sDriver = driver;
		wdutil.waitUntilPageLoad(driver);
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void configBM() throws Throwable {
		/* common Data */
		String USERNAME = flUtil.getPropertyKeyValue("username");
		String PASSWORD = flUtil.getPropertyKeyValue("password");
		String URL = flUtil.getPropertyKeyValue("url");
		String BROWSER = flUtil.getPropertyKeyValue("browser");
		/* Navigate to app */
		driver.get(URL);
		/* step 1 : login */
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(USERNAME, PASSWORD);
	}

	@AfterMethod
	public void configAM() {
		/* step 6 : logout */
		HomePage homePage = new HomePage(driver);
		homePage.logOut();
	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void configAC() {
		System.out.println("=============Close the Browser==========");
		driver.quit();
	}

	@AfterSuite
	public void configAS() {
		System.out.println("========================close DB========================");
	}

}
