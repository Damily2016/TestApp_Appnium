package com.delta.autotest.testcase;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.delta.autotest.common.SMS_Constants;
import com.delta.autotest.common.utils.AppniumFindElementUtil;
import com.delta.autotest.common.utils.URLlist;

public abstract  class BaseLogindan {
static AndroidDriver<WebElement> driver;
WebElement et_pwd, et_user, bt_login, et_main;
TouchAction action_item;

public BaseLogindan() {
	
	
}

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
public void testBase(){
	test();
}

    abstract  void test() ;


	

}
