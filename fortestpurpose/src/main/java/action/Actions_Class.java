package action;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import baseclass.BaseClass;

public class Actions_Class extends BaseClass{
	public void sendKeys (WebElement ele , String data) {
		if(ele.isEnabled() && ele.isDisplayed()) {
			ele.sendKeys(data);
		}else {
			System.out.println("This element is not present - " + "cant enter data " + data);
		}
		
	}
	
	public void sendkeysNumneric (WebElement ele , long data) {
		if(ele.isEnabled() && ele.isDisplayed()) {
			String number = String.valueOf(data);
			ele.sendKeys(number);
		}else {
			System.out.println("This element is not present - " + "cant enter data " + data);
		}
		
	}
	
	public boolean verifyTitle(String expectedTitle) {
		System.out.println("verifying title " + driver.getTitle());
		boolean title = driver.getTitle().equals(expectedTitle);
		return title;
	}
	
	public boolean verifyUrl(String expectedUrl) {
		boolean url = driver.getCurrentUrl().equals(expectedUrl);
		return url;
	}
	
	public boolean verifyText(WebElement ele , String expectedText) {
		boolean txt = ele.getText().equals(expectedText);
		System.out.println(ele.getText() + "got text");
		return txt;
	}
	
	public void scroll(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",ele);
	}
	
	public void hoverAnElement(WebElement ele) {
		System.out.println("Hovering");
		Actions actn = new Actions(driver);
		actn.moveToElement(ele).perform();;
		System.out.println("hovered");
	}

}
