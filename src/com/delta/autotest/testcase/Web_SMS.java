package com.delta.autotest.testcase;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.internal.WrapsDriver;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;


@SuppressWarnings("deprecation")
public  class Web_SMS {

	static WebDriver driver;
	WebElement et_pwd, et_user, bt_login, et_main;
	TouchAction action_item;
	@SuppressWarnings("rawtypes")
	List dropList = null;
	MobileElement listItem = null;
	String network = "RETRY";
	private static Selenium selenium;

	FirefoxDriver wd;
	@Before
	public void setup() throws Exception {
		//selenium=new WebDriverBackedSelenium(new ChromeDriver(), "");
	    //selenium=new WebDriverBackedSelenium(new FirefoxDriver(), "");
       // driver= ((WrapsDriver) selenium).getWrappedDriver();
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\dandan.cao\\Desktop\\geckodriver-v0.9.0-win64\\geckodriver.exe");
      //  WebDriver driver = new FirefoxDriver();
		wd= new FirefoxDriver();
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
 
	}

	 @Test
	public void testLogin() throws Exception {
		 
		wd.get("www.baidu.com");
		wait(5000);
	/*	
		WebElement username=driver.findElement(By.xpath("//input[@name='uName']"));
		username.sendKeys("dandan");*/
	}
	
	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		
		}
	}

}
