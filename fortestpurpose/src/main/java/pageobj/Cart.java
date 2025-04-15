package pageobj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import action.Actions_Class;
import baseclass.BaseClass;

public class Cart extends BaseClass {
	Actions_Class act = new Actions_Class();
	
	@FindBy(className = "p6sArZ")
	WebElement qtyBox;
	
	@FindBy(className = "_1Y9Lgu")
	WebElement cartTotal;
	
	@FindBy(className = "_3ZeUN+")
	WebElement settingsDropDown;
	
	@FindBy(xpath = "//div[@class='qstlfy' and text()='Logout']")
	WebElement logout;
	
	@FindBy(className="zA2EfJ")
	WebElement placeOrder;
	
	//div[@class='qstlfy' and text()='Logout']
	public Cart() {
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
	
	public boolean proQtyInCart(String ExpectedQty) {
		String qty = qtyBox.getAttribute("value");
		System.out.println(qty + "this is qty");
		if(qty.equals(ExpectedQty)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean verifyCartTotal(String total) {
		String ttl = cartTotal.getText();
		if(ttl.equals(total)) {
			return true;
		}else {
			return false;
		}
	}
	
	public void clickOnSettingDropDown() {
		act.hoverAnElement(settingsDropDown);
	}
	
	public void clickOnLogOut() {
		act.hoverAnElement(settingsDropDown);
		logout.click();
	}
	
	public CheckOut clickOnPlaceOrder() {
		placeOrder.click();
		return new CheckOut();
	}
	
	
	
	//
	//Flipkart.com: Secure Payment: Login > Select Shipping Address > Review Order > Place Order
	
	
	
	
}
