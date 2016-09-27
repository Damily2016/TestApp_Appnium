package com.delta.autotest.testcase;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.seleniumhq.jetty9.io.Connection;

import com.delta.autotest.common.SMS_Constants;
import com.delta.autotest.common.utils.AppniumFindElementUtil;
import com.delta.autotest.common.utils.BaseUtils;
import com.delta.autotest.common.utils.Snapshot;
import com.delta.autotest.common.utils.SwipeUtil;
import com.delta.autotest.common.utils.URLlist;

//sanxing & Nexus run ok
public  class SMS_SwitchNetwork {

	static AndroidDriver<WebElement> driver;
	WebElement et_pwd, et_user, bt_login, et_main;
	TouchAction action_item;
	private WebElement network_ID, remember_ID, no_network;
	private boolean flag = true;
	@SuppressWarnings("rawtypes")
	List dropList = null;
	MobileElement listItem = null;
	String network = "RETRY";

	@Before
	public void setup() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android Device");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4.2");
		capabilities.setCapability("appPackage", "com.delta.smsandroidproject");
		capabilities.setCapability("appActivity",
				"com.delta.smsandroidproject.view.activity.LoginActivity");
		URL url = new URL(URLlist.SERVER_URL);
		driver = new AndroidDriver<WebElement>(url, capabilities);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}


	 @Test
	public void testSwitch_network() throws Exception {
		
		BaseUtils.login_Remember(driver, bt_login);

		// 2 Switch network
		AppniumFindElementUtil.findElement(driver, "ById",
				SMS_Constants.switch_network_ID).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		AppniumFindElementUtil.findElement(driver, "ById",
				SMS_Constants.spinnerNetWork_ID).click();

		BaseUtils.selectDropItem(driver, dropList, listItem, 0);
		// choose the first_network
		Snapshot.snapshot(driver, "switch_network0.png");
		AppniumFindElementUtil.findElement(driver, "ById",
				SMS_Constants.spinnerNetWork_ID).click();
		BaseUtils.selectDropItem(driver, dropList, listItem,1);
		// choose the second_network
		Snapshot.snapshot(driver, "switch_network1.png");

		driver.pressKeyCode(AndroidKeyCode.BACK);// Exit switch_network

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}

	

	/*
	 * @Test public void setWiFi() { driver.setConnection(Connection.);
	 * assertEquals(Connection.WIFI, driver.getConnection()); }
	 */


	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			flag = false;
		}
	}

}
