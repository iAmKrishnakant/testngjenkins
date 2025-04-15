package pageobj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import action.Actions_Class;
import baseclass.BaseClass;

public class Login extends BaseClass {
	Actions_Class act = new Actions_Class();
	
	@FindBy(className = "r4vIwl")  
	WebElement mobileNumTxtbox;
	
	@FindBy(className = "_7Pd1Fp")  
	WebElement reqOtpButton;
	
	@FindBy(className = "llBOFA")
	WebElement mobileNumberError;
	
	
	public Login() {
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
		if(reqOtpButton.isDisplayed() && reqOtpButton.isEnabled()) {
			return true;
		}else {
			return false;
		}
	}
	
	public void enterMobilenumber(long mobileNumber) {
		act.sendkeysNumneric(mobileNumTxtbox, mobileNumber);
		
	}
	
	public VerifyLogInOTP clickOnReqOTP() {
		reqOtpButton.click();
		return new VerifyLogInOTP();
	}
	
	public boolean verifyMobileNumberError(String expectedError) {
		boolean error = act.verifyText(mobileNumberError, expectedError);
		return error;
		//Please enter a valid Mobile number
	}
	
}
