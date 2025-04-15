package pageobj;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import action.Actions_Class;
import baseclass.BaseClass;

public class Home_Page extends BaseClass{
	Actions_Class act = new Actions_Class() ;
	
	@FindBy(className = "_1Mikcj")
	WebElement signupButton;
	
	@FindBy(xpath = "//img[@alt='Login' and @width = '24']")
	WebElement loginButton;
	
	public Home_Page() {
		PageFactory.initElements(driver, this);
		System.out.println("home page elements found");
	}
	
	public boolean verifyTitle(String expectedTitle) {
		boolean title = act.verifyTitle(expectedTitle);
		return title;
	}
	
	public boolean verifyUrl(String expectedUrl) {
		boolean url = act.verifyUrl(expectedUrl);
		return url;
	}
	
	public Login clickOnLogin() {
		loginButton.click();
		return new Login();
	}
	
	public Signup clickOnSignup() {
		if (loginButton.isDisplayed() && loginButton.isEnabled()) {
			System.out.println("login button shows");
		}
		WebDriverWait setWait = new WebDriverWait(driver , Duration.ofSeconds(15));
		setWait.until(ExpectedConditions.visibilityOf(loginButton));
		act.hoverAnElement(loginButton);
		signupButton.click();
		return new Signup();
	}
	
	

}
