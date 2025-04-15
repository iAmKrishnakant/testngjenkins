package baseclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public ExtentReports report;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest log;
	public static WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		report = new ExtentReports();
		htmlReporter = new ExtentSparkReporter("C:\\Users\\kaila\\eclipse-workspace\\flipkartProject\\reports\\reportflipkart.html");
		htmlReporter.config().setDocumentTitle("Flipkart Report");
		htmlReporter.config().setReportName("Flipkart Testcases Reports");
		htmlReporter.config().setTheme(Theme.STANDARD);
		report.attachReporter(htmlReporter);
	}
	
	@BeforeMethod
	public void launch() {
		String browser = "chrome";
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("selected chrome");
		}else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else {
			System.out.println("select valid browser");
		}
		
		System.out.println("browser selected");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.navigate().to("https://www.flipkart.com");;
	}
	
	
	
	@AfterSuite
	public void closing() {
		driver.quit();
		if(report != null) {
			System.out.println("report done");
			report.flush();
		}
	}
	
	
}
