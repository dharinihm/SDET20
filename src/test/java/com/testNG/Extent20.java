package com.testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Extent20 {

	public WebDriver driver;

	ExtentHtmlReporter reporter;
	ExtentReports reports;
	ExtentTest test;

	@BeforeMethod
	@BeforeSuite
	public void setUp() {
		reporter = new ExtentHtmlReporter("./ExtentReports20/vtiger.html");
		System.out.println("Before suite executed");

		reports = new ExtentReports();
		reports.attachReporter(reporter);
	}

	@BeforeClass
	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");

	}

	@BeforeMethod
	public void login() {
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("12345");
		driver.findElement(By.id("submitButton")).click();
	}

	@AfterMethod
	public void logOut() {
		WebElement adminstratorImg = driver.findElement(By.xpath("//img[@src ='themes/softed/images/user.PNG' ]"));

		Actions action = new Actions(driver);
		action.moveToElement(adminstratorImg).perform();
		WebElement signOutLink = driver.findElement(By.linkText("Sign Out"));
		signOutLink.click();
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

	@AfterSuite
	public void afterSuite() {
		reports.flush();
		
		System.out.println("After suite is executed");
	}

}
