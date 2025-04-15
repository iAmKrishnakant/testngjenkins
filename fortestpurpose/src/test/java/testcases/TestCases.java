package testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import baseclass.BaseClass;
import dataproviders.DataProviderClass;
import pageobj.Cart;
import pageobj.CheckOut;
import pageobj.Home_Logged_in;
import pageobj.Home_Page;
import pageobj.Login;
import pageobj.ProductDetails;
import pageobj.ProductSearchedPage;
import pageobj.Signup;
import pageobj.VerifyLogInOTP;
import utilities.Listners;

public class TestCases extends BaseClass {
	
	
	Home_Page hp ;
	Login lg;
	Signup sg;
	Home_Logged_in homeli;
	VerifyLogInOTP lgOtp;
	ProductSearchedPage proSearchpage;
	ProductDetails prodtls;
	Cart cart ;
	CheckOut cout;
//	@Test(priority = 1 , dataProvider = "OTPS for signup" , dataProviderClass = DataProviderClass.class)
	public void Register(int otp ,String scenario ) {
		
		// before signup or login update mobile numer
		
		long mobileno = 9856320541L;
		log = report.createTest("register " +scenario );
		hp = new Home_Page();
		boolean titlehome = hp.verifyTitle("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		try {
		Assert.assertTrue(titlehome);
		log.log(Status.PASS,"Verify that home page is visible successfully");
		}catch(AssertionError ae){
			Listners.takeScreenshot("Register"); 
		log.log(Status.FAIL,"Verify that home page is visible successfully");
		}
		sg = hp.clickOnSignup();
		sg.enterMobilenumber(mobileno);
		sg.clickOnContinue();
		
		switch(scenario){
		case "invalid otp" :
			sg.enterOtp(otp);
			homeli = sg.clickOnSignupButton();
			boolean error= sg.verifyOtpError("Please enter valid OTP");
			try {
			Assert.assertTrue(error);
			log.log(Status.PASS,"must show error for valid otp");
			}catch(AssertionError ae){
				Listners.takeScreenshot("Register"); 
				log.log(Status.FAIL,"must show error for valid otp");
			}
			System.out.println("without otp done");
			break;
		case "correct otp" :
			sg.enterCorrectOtpForSignUP();
			homeli = sg.clickOnSignupButton();
			boolean title = homeli.verifyTitle("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
			try {
				Assert.assertTrue(title);
				log.log(Status.PASS,"successfully signup and user nevigate to home page");
				}catch(AssertionError ae){
					Listners.takeScreenshot("Register"); 
					log.log(Status.FAIL,"successfully signup and user nevigate to home page");
				}
			break;
		default :
			System.out.println("add valid scenario");
		
		}
		
		
	}
	
	@Test (priority = 2 ,dataProvider = "phonenumber for login" , dataProviderClass = DataProviderClass.class)
	public void login(long mobileNumber , String scenario) {
		
		// before signup or login update mobile numer in data provider
		
		log = report.createTest("login " + scenario );
		String invalidMobileNumberError = "Please enter valid Email ID/Mobile number";
		String homePageTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		hp = new Home_Page();
		boolean titlehome = hp.verifyTitle("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		try {
			Assert.assertTrue(titlehome);
			log.log(Status.PASS,"Verify that home page is visible successfully");
			}catch(AssertionError ae){
			Listners.takeScreenshot("login");
			log.log(Status.FAIL,"Verify that home page is visible successfully");
			}
		lg = hp.clickOnLogin();
		
		
		switch(scenario){
		case "invalid number" :
			lg.enterMobilenumber(mobileNumber);
			lgOtp = lg.clickOnReqOTP();
			boolean error= lg.verifyMobileNumberError(invalidMobileNumberError);
			try {
				Assert.assertTrue(error);
				log.log(Status.PASS,"Showing error for enter mobile number");
				}catch(AssertionError ae){
					Listners.takeScreenshot("login");
				log.log(Status.FAIL,"Showing error for enter mobile number");
				}
			
			System.out.println("with invalid done");
			break;
		case "correct number" :
			lg.enterMobilenumber(mobileNumber);
			lgOtp = lg.clickOnReqOTP();
			try {
				lgOtp.enterCorrectOtpForLogin();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			homeli = new Home_Logged_in();
			boolean title = homeli.verifyTitle(homePageTitle);

			try {
				Assert.assertTrue(title);
				log.log(Status.PASS,"successfully logedin and user nevigate to home page");
				}catch(AssertionError ae){
				Listners.takeScreenshot("login"); 
				log.log(Status.FAIL,"successfully logedin and user nevigate to home page");
				}
			
			break;
		default :
			System.out.println("add valid scenario");
		
		}
		

	}
	
	//@Test(priority = 3)
	public void addProductInCart() {
		// before signup or login update mobile number
		String homePageTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		long mobileNumber = 6354635550L;
		String Searchdata = "iphone 16";
		String productName = "Apple iPhone 16 (Black, 256 GB)";
		String proDetailsPageTitle = "Apple iPhone 16 ( 256 GB Storage, 0 GB RAM ) Online at Best Price On Flipkart.com";
		String modelName = "iPhone 16";
		String color = "Black";
		String internalStorage = "256 GB";
		String qty = "1";
		String checkOutPageTitle = "Flipkart.com: Secure Payment: Login > Select Shipping Address > Review Order > Place Order";
		hp = new Home_Page();
		boolean titlehome = hp.verifyTitle("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		Assert.assertTrue(titlehome);
		lg = hp.clickOnLogin();
		lg.enterMobilenumber(mobileNumber);
		lgOtp = lg.clickOnReqOTP();
		try {
			lgOtp.enterCorrectOtpForLogin();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homeli = new Home_Logged_in();
		boolean title = homeli.verifyTitle(homePageTitle);
		Assert.assertTrue(title);
		homeli = new Home_Logged_in();
		System.out.println("ocject init");
		homeli.enterSearchData(Searchdata);
		System.out.println("searched");
		proSearchpage = homeli.clickOnSearch();
		boolean searchedCorrect = proSearchpage.verifySearchResults(Searchdata);
		Assert.assertTrue(searchedCorrect);
		proSearchpage.clickOnProduct(Searchdata);
		prodtls = proSearchpage.clickOnProduct(productName);
		System.out.println("product clickied");
		prodtls.switchTOProdetails();
		boolean proDetailPageTitle = prodtls.verifyTitle(proDetailsPageTitle);
		Assert.assertTrue(proDetailPageTitle);
		boolean productTitles  = prodtls.verifyProductTitle(productName);
		Assert.assertTrue(productTitles);
		boolean productsSpecs =prodtls.verifyProductSpecs(modelName, color, internalStorage);
		Assert.assertTrue(productsSpecs);
		cart = prodtls.addToCart();	
		boolean qtys = cart.proQtyInCart(qty);
		Assert.assertTrue(qtys);
		cout = cart.clickOnPlaceOrder();
		boolean checkOutTitle = cout.verifyTitle(checkOutPageTitle);
		Assert.assertTrue(checkOutTitle);
	}
	
	


	
}
