package com.delta.autotest.common.utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;

public class Action {
	private static AndroidDriver driver;

	public static void longPress(WebElement el,int duration){
		TouchAction action=new TouchAction(driver);
		action.longPress(el,duration);
	}

}
