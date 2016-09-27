package com.delta.autotest.common.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Snapshot {
	 public static void snapshot(TakesScreenshot driver, String filename) {
	        String currentpath = System.getProperty("user.dir");             // get current work folder
	        File scrFile = driver.getScreenshotAs(OutputType.FILE); 
	        try {
	            System.out.println("save snapshot path is:" + currentpath + "\\" + filename + "\n");
	            FileUtils.copyFile(scrFile, new File(currentpath + "\\" + filename));                // save screenshot
	        } catch (IOException e) {
	            System.out.println("Cannot take screenshot");
	            e.printStackTrace();
	        } finally{
	            System.out.println("already saved screenshot in:" + currentpath+ "\n"); 
	       }
	    }
}
