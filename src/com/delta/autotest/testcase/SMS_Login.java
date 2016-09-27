package com.delta.autotest.testcase;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.jsp.tagext.Tag;

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
public  class SMS_Login {

	static AndroidDriver<WebElement> driver;
	WebElement et_pwd, et_user, bt_login, et_main;
	TouchAction action_item;
	private WebElement network_ID, remember_ID, no_network;
	private boolean flag = true;
	@SuppressWarnings("rawtypes")
	List dropList = null;
	MobileElement listItem = null;
	String network = "RETRY";
	private String tag="SMS_Login";
	private boolean isInstall=false;

	@Before
	public void setup() throws Exception {
		// Runtime rt = Runtime.getRuntime();
	        // this code for record the screen of your device
	     //   rt.exec("cmd.exe /C adb shell monkey -p com.delta.smsandroidproject -v --throttle 300 --pct -touch 30 --pct -motion 20 --pct -nav 20 --pct -majornav 15 --pct-appswitch 5 -- pct -anyevent 5 -- pct -tracball 0 -- pct -syskeys 0 -p '&s' 1000");
	  // final File apkRoot = new File("C:/Users/dandan.cao/Desktop/SmsAndroidProject-release-20160825103720.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android Device");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4.2");
		capabilities.setCapability("--no-reset", "True");
		//if(isInstall){
			//final File apkRoot = new File(System.getProperty("user.dir"));
			// File appDir = new File(apkRoot, "apps");
	        //    File app = new File(appDir, "SmsAndroidProject-release-20160825103720.apk");
	           capabilities.setCapability("app","C:/Users/dandan.cao/Desktop/SmsAndroidProject-release-20160825103720.apk");
	//	}
		capabilities.setCapability("appPackage", "com.delta.smsandroidproject");
		capabilities.setCapability("appActivity",
				"com.delta.smsandroidproject.view.activity.LoginActivity");
		URL url = new URL(URLlist.SERVER_URL);
		driver = new AndroidDriver<WebElement>(url, capabilities);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}

	 @Test
	public void testLogin() throws Exception {
		// Login
		et_user = AppniumFindElementUtil.findElement(driver, "ById",
				SMS_Constants.user_ID);
		et_user.clear();
		et_user.sendKeys(SMS_Constants.userText);
		driver.hideKeyboard();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		et_pwd = AppniumFindElementUtil.findElement(driver, "ById",
				SMS_Constants.pwd_ID);
		et_pwd.sendKeys(SMS_Constants.pwdText);
		driver.hideKeyboard();
		network_ID = AppniumFindElementUtil.findElement(driver, "ById",
				SMS_Constants.network_ID);
		network_ID.click();
//ӛס�ܴa
		remember_ID= AppniumFindElementUtil.findElement(driver, "ById", SMS_Constants.remember_ID); 
	  if (!remember_ID.isSelected()) {
		  remember_ID.click();
      }
		bt_login = AppniumFindElementUtil.findElement(driver, "ByText",
				SMS_Constants.login_txt);
		bt_login.click();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

		// Login choose network
		AppniumFindElementUtil.findElement(driver, "ById",
				SMS_Constants.spinner_id).click();
		System.out.println("Login successfully:" + SMS_Constants.userText
				+ "\n");
		AppniumFindElementUtil.findElement(driver, "ByElementByXPath",
				SMS_Constants.net_xpath).click();
		AppniumFindElementUtil.findElement(driver, "ById",
				SMS_Constants.login_ID).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Snapshot.snapshot(driver, tag+"--mainInterface.png");
		BaseUtils.logout(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Snapshot.snapshot(driver, tag+"--logout.png");
		
	}
	
	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			flag = false;
		
		}
	}

}
