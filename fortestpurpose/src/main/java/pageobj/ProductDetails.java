package pageobj;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import action.Actions_Class;
import baseclass.BaseClass;

public class ProductDetails extends BaseClass{
	Actions_Class act = new Actions_Class();
	
	@FindBy(className = "VU-ZEz")
	WebElement productTitle;
	
	@FindBy(xpath = "//li[@class='HPETK2' and text() = 'iPhone 16']")
	WebElement productModelName;
	
	@FindBy(xpath = "//li[@class='HPETK2' and text() = 'Black']")
	WebElement productColor;
	
	@FindBy(xpath = "//button[text() = 'Read More']")
	WebElement readmoreButton;
	
	@FindBy(className = "WJdYP6") 
	List <WebElement> specsTitles;
	
	@FindBy(className = "_8tSq3v")
	WebElement specsTitle;
	
	@FindBy(className = "In9uk2")
	WebElement addToCart;
	
	public ProductDetails() {
		PageFactory.initElements(driver, this);
		System.out.println("products details init");
	}
	
	
	public boolean verifyTitle(String expectedTitle) {
		boolean title = act.verifyTitle(expectedTitle);
		return title;
	}
	
	public boolean verifyUrl(String expectedUrl) {
		boolean url = act.verifyUrl(expectedUrl);
		return url;
	}
	
	public boolean verifyProductTitle(String expectedTitle) {
		boolean proTitle = act.verifyText(productTitle, expectedTitle);
		return proTitle;
	}
	
	public void switchTOProdetails() {
		String window = driver.getWindowHandle();
		Set<String> ss = driver.getWindowHandles();
		for (String windowHandle : ss) {
		    if (!windowHandle.equals(window)) {
		        driver.switchTo().window(windowHandle);
		        System.out.println(windowHandle + "   window sitched");
		        break;
		    }
		   
		}
	}
	public boolean verifyProductSpecs(String modelNameOfPro , String colorOfPro , String internalStorageOfPro ) {
		
		System.out.println(driver.getWindowHandle()  + " for verifypro");
		String modelName = "";
		String color = "";
		String internalStorage = "";
		act.scroll(specsTitle);
		readmoreButton.click();
		List <WebElement> allSpecs = specsTitles;
		System.out.println("list is "+ allSpecs.size());
		for(WebElement specs : allSpecs ) {
			WebElement tile =specs.findElement(By.className("+fFi1w"));
			String txt = tile.getText();
			if(txt.equalsIgnoreCase("Model Name") || txt.equalsIgnoreCase("color") || txt.equalsIgnoreCase("Internal Storage")) {
				System.out.println("got one == " + txt );
				WebElement titleSpecs = specs.findElement(By.className("HPETK2"));
				if(txt.equalsIgnoreCase("Model Name")) {
					modelName = titleSpecs.getText();
				}else if(txt.equalsIgnoreCase("color")) {
					color = titleSpecs.getText();
				}else if(txt.equalsIgnoreCase("Internal Storage")) {
					internalStorage = titleSpecs.getText();
				}
			}
		}
		
		if(modelName.equalsIgnoreCase(modelNameOfPro) && color.equalsIgnoreCase(colorOfPro) && internalStorage.equalsIgnoreCase(internalStorageOfPro) ) {
			return true;
		}else {
			return false;
		}
	}
	
	public Cart addToCart() {
		addToCart.click();
		return new Cart();
	}
	
	
	
}
