package com.testNG;

import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Sample {

	
	public static void main(String[] args) {
		System.out.println("Good evening");
		print();
		new ChromeDriver();
	
	}

	@Test
	public static void print() {
		System.out.println("Good Evening");
	}

}
