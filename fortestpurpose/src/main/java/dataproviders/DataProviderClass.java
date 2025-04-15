package dataproviders;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	  
    @DataProvider(name = "OTPS for signup")
    public Object[][] dataProviderForotp() {
        Object[][] testData = {
                {12, "invalid otp"},
                {456321, "correct otp"}
        };
        return testData;
    }
    
    @DataProvider(name = "phonenumber for login")
    public Object[][] dataProviderForPhoneNUmber() {
        Object[][] testData = {
                {1L, "invalid number"},
                {875487210L, "correct number"}
        };
        return testData;
    }
    
    
}
