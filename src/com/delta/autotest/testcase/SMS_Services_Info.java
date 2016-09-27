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
public class SMS_Services_Info {

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
		//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.wait(1);

	}

	@Test
	public void testServices_Info() {
		BaseUtils.login_Remember(driver, bt_login);
		  Assert.assertTrue(driver.findElementByAndroidUIAutomator("Dashboard").isDisplayed());
	//  进入Services
        BaseUtils.chooseLocationChargerEVSE(driver, dropList, listItem);
        
		AppniumFindElementUtil.findElement(driver, "ById",
				SMS_Constants.info_ID).click();// 進入Info
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.scrollTo("Phone numbers").click();// 点击Phone numbers
		SwipeUtil.swipeToUp(driver, 10);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//SwipeUtil.swipeToDown(driver, 10);

	//	SwipeUtil.swipeAll(driver, 10,"left");
		/* int width = driver.manage().window().getSize().width;
	        int height = driver.manage().window().getSize().height;
	        driver.swipe(width / 2, height / 4, width / 2, height * 3 / 4, 500);
		*/
		
		//拍照使用照片
		takePicture();
		AppniumFindElementUtil.findElement(driver, "ById", "android:id/button1").click();//点击SURE
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Snapshot.snapshot(driver, "service_userPicture.png");// Service_address
		//拍照不使用照片
		takePicture();
		AppniumFindElementUtil.findElement(driver, "ById", "android:id/button2").click();//点击Cancel
		//driver.pressKeyCode(AndroidKeyCode.BACK);// Exit Take a picture
		
		AppniumFindElementUtil.findElement(driver, "ById",
				SMS_Constants.service_cameraIcon_ID).click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		AppniumFindElementUtil.findElement(driver, "ById",
				SMS_Constants.service_choosePicture_ID).click();// 点击Choose a
																// picture
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		AppniumFindElementUtil.findElement(driver, "ById",
				SMS_Constants.service_cancelCamera_ID).click();// 点击取消退出
		SwipeUtil.swipeToDown(driver, 10);
		// APP内上滑：driver.swipe(250, 300, 250, 1400, 0);
		// APP内下滑： driver.swipe(250,1400, 250,300 , 0);
		driver.swipe(250, 1400, 250, 300, 0); // 下滑
		driver.scrollTo("Address").click();// 点击Address
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.pressKeyCode(AndroidKeyCode.BACK);// Exit address
		Snapshot.snapshot(driver, "Services_address.png");// Service_address
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Assert.assertEquals(driver.currentActivity(),
		// ".ContactsListActivity");

	}

	private void takePicture() {
		AppniumFindElementUtil.findElement(driver, "ById",
				SMS_Constants.service_cameraIcon_ID).click();//进入拍照
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		AppniumFindElementUtil.findElement(driver, "ById",
				SMS_Constants.service_takePicture_ID).click();// 点击Take a
																// picture
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_CAMERA);//拍照成功
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		AppniumFindElementUtil.findElement(driver, "ById", "com.sec.android.app.camera:id/save").click();//点击存储
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
