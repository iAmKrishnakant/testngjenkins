package pageobj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import action.Actions_Class;
import baseclass.BaseClass;

public class Home_Logged_in extends BaseClass {
  // otp - class name IX3CMV
	Actions_Class act = new Actions_Class();
	
	@FindBy(className = "Pke_EE")
	WebElement searchBox;
	
	@FindBy(className = "_2iLD__")
	WebElement searchButton;
	
	
	public Home_Logged_in() {
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
	
	public void enterSearchData(String data) {
		act.sendKeys(searchBox, data);
	}
	
	public ProductSearchedPage clickOnSearch() {
		searchButton.click();
		return new ProductSearchedPage();
	}
}
