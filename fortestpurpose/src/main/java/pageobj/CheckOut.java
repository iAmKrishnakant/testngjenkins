package pageobj;

import org.openqa.selenium.support.PageFactory;

import action.Actions_Class;
import baseclass.BaseClass;

public class CheckOut extends BaseClass {
	
	Actions_Class act = new Actions_Class();
	
	public CheckOut() {
		PageFactory.initElements(driver, this);
		System.out.println("home page elements found");
	}
	
	public boolean verifyTitle(String expectedTitle) {
		boolean title = act.verifyTitle(expectedTitle);
		return title;
	}
}
