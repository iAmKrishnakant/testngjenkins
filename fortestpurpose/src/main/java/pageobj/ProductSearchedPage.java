package pageobj;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import action.Actions_Class;
import baseclass.BaseClass;

public class ProductSearchedPage extends BaseClass{
	
	Actions_Class act = new Actions_Class();
	
	@FindBy(xpath = "//span[text() = 'iphone 16']")
	WebElement searchResult;
	@FindBy(className = "KzDlHZ")
	List<WebElement> productNames;
	
	public ProductSearchedPage() {
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
	
	public boolean verifySearchResults(String searchedData) {
		boolean searchedResults = act.verifyText(searchResult, searchedData);
		return searchedResults;
	}
	
	public ProductDetails clickOnProduct(String productName) {
		List <WebElement> allProductNames= productNames;
		for(WebElement products : allProductNames ) {
			
			boolean proname =products.getText().equalsIgnoreCase(productName);
			
			if(proname) {
				products.click();
				return new ProductDetails();
			}
			
		
		}
		return null;
	}
	

	
}
