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
public class SMS_Services_Event {

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
	public void testServices_Event() {
		BaseUtils.login_Remember(driver, bt_login);

		//  进入Services
        BaseUtils.chooseLocationChargerEVSE(driver, dropList, listItem);

		AppniumFindElementUtil.findElement(driver, "ById",
				SMS_Constants.service_event_ID).click();// 進入Event
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.swipe(250, 1400, 250, 300, 3); // 下滑
		Snapshot.snapshot(driver, "Show Event.png");// 截图 出现event界面
		for (int i = 0; i <= 3; i++) {
			AppniumFindElementUtil.findElement(driver, "ById",
					SMS_Constants.Event_orderIcon_ID).click();// 点击排序按钮
			AppniumFindElementUtil.findElement(driver, "ById",
					SMS_Constants.Event_orderNumber_ID+i).click();// 点击第i个排序
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			Snapshot.snapshot(driver, "Event_order_level.png");// 截图
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			driver.swipe(250, 1400, 250, 300, 3); // 下滑
		}

		driver.pressKeyCode(AndroidKeyCode.BACK);// Exit Event
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		
		// Assert.assertEquals(driver.currentActivity(),
		// ".ContactsListActivity");

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
