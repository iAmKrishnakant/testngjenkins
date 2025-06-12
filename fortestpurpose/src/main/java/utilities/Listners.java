package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import baseclass.BaseClass;

public class Listners implements ITestListener {
	private static int count = 1 ;
	BaseClass bs = new BaseClass();
	@Override
	public void onTestFailure(ITestResult result) {

		String tc = result.getName();
		System.out.println("screen shot method");
		File f = ((TakesScreenshot)bs.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(f,new File ("C:\\New folder\\"+tc+count+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("failed to take screenshot");
		}	
		count++;
		System.out.println("updated cont " + count);
	}
	
	public static void takeScreenshot(String tc) {
		
		System.out.println("screen shot method");
		File f = ((TakesScreenshot)BaseClass.driver).getScreenshotAs(OutputType.FILE);
		try {    //C:\Users\kaila\eclipse-workspace\flipkartProject\screenshot
			FileUtils.copyFile(f,new File ("C:\\Users\\kaila\\eclipse-workspace\\flipkartProject\\screenshot\\"+tc+count+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("failed to take screenshot");
		}	
		count++;
		System.out.println("updated cont " + count);
	}
	
	
}
