package com.vtiger.comcast.genericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImpCls implements ITestListener {
	JavaUtility jUtil = new JavaUtility();

	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		System.out.println("================Listener is executing============");
		EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sDriver);
		File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
		String date = jUtil.getSystemDate();
		try {
			FileUtils.copyFile(srcFile, new File("./screenshot/" + testName + date + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
