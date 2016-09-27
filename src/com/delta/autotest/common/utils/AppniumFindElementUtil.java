package com.delta.autotest.common.utils;


import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AppniumFindElementUtil {
	private static WebElement webElement;
	public static WebElement findElement(AndroidDriver<WebElement> driver,
			String tag, String value) {
		switch (tag) {
		case "ByText":
			webElement = driver.findElementByAndroidUIAutomator(value);
			break;

		case "ById":
			webElement = driver.findElement(By.id(value));
			break;
		case "ByElementsByXPath":
			driver.findElementsByXPath(value);
			break;
		case "ByElementByXPath":
			webElement = driver.findElementByXPath(value);
			break;
		case "ByClassName":
			webElement = driver.findElementByClassName(value);
			break;
		case "ByName":
			webElement = driver.findElementByName(value);
			break;
		case "ByLinkText":
			webElement = driver.findElementByLinkText(value);
			break;
		}
		return webElement;

	}

}