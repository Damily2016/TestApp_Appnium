package com.delta.autotest.testcase;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.delta.autotest.common.SMS_Constants;
import com.delta.autotest.common.utils.AppniumFindElementUtil;
import com.delta.autotest.common.utils.BaseUtils;
import com.delta.autotest.common.utils.Snapshot;
import com.delta.autotest.common.utils.URLlist;

//sanxing & Nexus run ok
public  class SMS_Settings {

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
	public void testSettings() {
		BaseUtils.login_Remember(driver, bt_login);
		//进入Settings分支
		AppniumFindElementUtil.findElement(driver, "ById", "com.delta.smsandroidproject:id/tv_dashboard_settings");
	//com.delta.smsandroidproject:id/location
		
		//class android.widget.RelativeLayout
		driver.pressKeyCode(AndroidKeyCode.BACK);
	}


	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			flag = false;
		}
	}

}
