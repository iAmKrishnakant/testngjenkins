package pageobj;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import action.Actions_Class;
import baseclass.BaseClass;

public class Signup extends BaseClass{
Actions_Class act = new Actions_Class();
	
	@FindBy(className = "r4vIwl")  
	WebElement mobileNumTxtbox;
	
	@FindBy(className = "_7Pd1Fp")  
	WebElement continueButton;
	
	WebElement signupButton;
	WebElement otpBox;
	WebElement otpError;
	
	
	
	public Signup() {
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
	
	public boolean mobileNumberTxtboxVisible() {
		if(mobileNumTxtbox.isDisplayed() && mobileNumTxtbox.isEnabled()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean continuButtonVisible() {
		if(continueButton.isDisplayed() && continueButton.isEnabled()) {
			return true;
		}else {
			return false;
		}
	}
	
	public void enterMobilenumber(long mobileNumber) {
		act.sendkeysNumneric(mobileNumTxtbox, mobileNumber);
		
	}
	
	public void clickOnContinue() {
		continueButton.click();
	}
	
	public void enterOtp(int otp) {
		otpBox = driver.findElement(By.xpath("//input[@maxlength='6' and @type='text']"));
		String setOtp = String.valueOf(otp);
		act.sendKeys(otpBox, setOtp);
	}
	
	public void enterCorrectOtpForSignUP() {
		new Scanner(System.in).nextLine();
	}
	
	public Home_Logged_in clickOnSignupButton() {
		signupButton = driver.findElement(By.className("_7Pd1Fp"));
		signupButton.click();
		return new Home_Logged_in();
	}
	
	public boolean verifyOtpError(String expectedError) {
		otpError = driver.findElement(By.className("llBOFA"));
		boolean error = act.verifyText(otpError, expectedError);
		//Please enter valid OTP
		return error;
	}
}
