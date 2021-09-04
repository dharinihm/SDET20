package com.testNG;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class SampleExtent extends Extent20 {

	@Test
	public void getTitleForHome() {
		test = reports.createTest("getTitleForHome");

		String expTitle = "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";

		String actualTitle = driver.getTitle();
		AssertJUnit.assertEquals(expTitle, actualTitle);
	}
}
