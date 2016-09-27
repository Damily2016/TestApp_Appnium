/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.delta.autotest.testcase;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.delta.autotest.common.utils.URLlist;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SMSBaseAndroidTest {
    private static AppiumDriverLocalService service;
    protected static AndroidDriver<WebElement> driver;

    /**
     * initialization.
     */
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

    /**
     * finishing.
     */
   
	@After
	public void tearDown() {
		 if (driver != null) {
	            driver.quit();
	        }
	}
}
