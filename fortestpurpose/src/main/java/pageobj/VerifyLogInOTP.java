package pageobj;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import action.Actions_Class;
import baseclass.BaseClass;

public class VerifyLogInOTP extends BaseClass {
	Actions_Class act = new Actions_Class();
	@FindBy(className = "VerifyLogInOTP")
	List <WebElement> otp;
	
	@FindBy(className = "llMuju")
	WebElement button;
	
	@FindBy(className = "eIDgeN")
	WebElement errormsg;
	
	public VerifyLogInOTP() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyTitle(String expectedTitle) {
		boolean title = act.verifyTitle(expectedTitle);
		return title;
	}
	
	public boolean verifyUrl(String expectedUrl) {
		boolean url = act.verifyUrl(expectedUrl);
		return url;
	}
	
	public void enterOtp(String num ) {
		List <WebElement> otptextBoxes = otp;
		WebElement firstBox = otptextBoxes.get(0);
		WebElement secondBox = otptextBoxes.get(1);
		WebElement thirdBox = otptextBoxes.get(2);
		WebElement fourthBox = otptextBoxes.get(3);
		WebElement fifthBox = otptextBoxes.get(4);
		WebElement sixthBox = otptextBoxes.get(5);
		
		String first = String.valueOf(num.charAt(0));
		act.sendKeys(firstBox, first);
		String second = String.valueOf(num.charAt(1));
		act.sendKeys(secondBox, second);
		String third = String.valueOf(num.charAt(2));
		act.sendKeys(thirdBox, third);
		String fourth = String.valueOf(num.charAt(3));
		act.sendKeys(fourthBox, fourth);
		String fifth = String.valueOf(num.charAt(4));
		act.sendKeys(fifthBox, fifth);
		String sixth = String.valueOf(num.charAt(5));
		act.sendKeys(sixthBox, sixth);
		
	}
	
	public void enterCorrectOtpForLogin() throws InterruptedException {
		Thread.sleep(30000);;
	}
	
	public boolean verifyInvalidOtpError(String expectedMsg) {
		boolean error = act.verifyText(errormsg, expectedMsg);
		return error;
	}
}
