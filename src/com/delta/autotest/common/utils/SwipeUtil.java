package com.delta.autotest.common.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.android.AndroidDriver;

public class SwipeUtil {
	static AndroidDriver driver;
	public static int[] appScreen() {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        int[] appSize = { width, height };
        return appSize;
    }
/*    public static void swipeToUdp(int duration) {
        int starty = ClassName.appScreen()[1] * 4 / 5;
        int endy = ClassName.appScreen()[1] * 1 / 5;
        int x = ClassName.appScreen()[0] * 1 / 2;
        try {
            driver.swipe(x, starty, x, endy, duration);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

	public static void swipeToUp(AndroidDriver driver, int time) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        try {
        	  driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, time);
		} catch (Exception e) {
			e.printStackTrace();
		}
      
    }

    /**
     *  Swipe to right on the screen
     */
    public static void swipeToRight(AndroidDriver driver, int time) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        try {
        	   driver.swipe(width / 4, height / 2, width * 3 / 4, height / 2, time);
		} catch (Exception e) {
			e.printStackTrace();
		}
     
    }
   
    public static void swipeToDown(AndroidDriver driver, int during) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width / 2, height / 4, width / 2, height * 3 / 4, during);
        // wait for page loading
    }
    public static void swipeAll(AndroidDriver driver, int during,String direction) {
    	Dimension dimension = driver.manage().window().getSize();
    	int width = dimension.getWidth();
    	int height = dimension.getHeight();
    	switch(direction)
    	{
    	case "right" : driver.swipe((int) (width*(0.20)), (int) (height*(0.50)), (int)(width*(0.80)), (int) (height*(0.50)), 6000);
    	break;
    	case "left" : driver.swipe((int) (width*(0.80)), (int) (height*(0.50)), (int) (width*(0.20)), (int) (height*(0.50)), 6000);
    	break;
    	case "up" : driver.swipe((int) (width*(0.50)), (int) (height*(0.70)), (int) (width*(0.50)), (int) (height*(0.30)), 6000);
    	break;
    	default : driver.swipe((int) (width*(0.50)), (int) (height*(0.30)), (int) (width*(0.50)), (int) (height*(0.70)), 6000);
    	break;
    	}

    }
    


}
