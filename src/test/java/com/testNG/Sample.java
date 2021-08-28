package com.testNG;

import org.testng.annotations.Test;

public class Sample {

	
	public static void main(String[] args) {
		System.out.println("Good evening");
		print();
	}

	@Test
	public static void print() {
		System.out.println("Good Evening");
	}

}
