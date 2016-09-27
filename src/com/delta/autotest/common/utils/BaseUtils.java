package com.delta.autotest.common.utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.delta.autotest.common.SMS_Constants;

public class BaseUtils {
	public static void selectDropItem(AndroidDriver<WebElement> driver,List dropList, MobileElement listItem, int i) {
		dropList = driver.findElements(By.id(SMS_Constants.location_ID));
		listItem = (MobileElement) dropList.get(i);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		listItem.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}
	public static void login_Remember(AndroidDriver<WebElement> driver,WebElement bt_login){
		
		bt_login = AppniumFindElementUtil.findElement(driver, "ByText",
				SMS_Constants.login_txt);
		bt_login.click();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

		AppniumFindElementUtil.findElement(driver, "ById",
				SMS_Constants.login_ID).click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public static void logout(AndroidDriver<WebElement> driver){
		AppniumFindElementUtil.findElement(driver, "ById", SMS_Constants.logout_ID).click();
	}
	
	public static void chooseLocationChargerEVSE(AndroidDriver<WebElement> driver,List dropList, MobileElement listItem){
		// 3 进入Services
				AppniumFindElementUtil.findElement(driver, "ById",
						SMS_Constants.service_ID).click();
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

				AppniumFindElementUtil.findElement(driver, "ByText",
						SMS_Constants.location_txt).click();
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

				BaseUtils.selectDropItem(driver, dropList, listItem, 1);// Location的item

				AppniumFindElementUtil.findElement(driver, "ByText",
						SMS_Constants.charger_txt).click();
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				BaseUtils.selectDropItem(driver, dropList, listItem, 1);// Charger的item

				AppniumFindElementUtil.findElement(driver, "ByText",
						SMS_Constants.evse_txt).click();
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
				BaseUtils.selectDropItem(driver, dropList, listItem, 1);// EVSE的item
				Snapshot.snapshot(driver, "Services.png");
	}
}
