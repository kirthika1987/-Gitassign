package thinkBridge.baseTestPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import com.relevantcodes.extentreports.ExtentReports;

import thinkBridge.com.UITesting.utilities.*;

public class BaseTestUI extends BaseTest_TestNG {

	protected static WebDriver driver;
	protected static Properties properties;
	protected static SeleniumActions sele_Actions;
	protected static WebDriverListener eventListener;
	protected static EventFiringWebDriver e_driver;
	protected static ChromeOptions chromeOptions;
	protected static WebDriverWait wait;
	//protected static Logger log;

	/*
	 * protected ITestResult result; protected ExtentReports extent; protected
	 * ExtentTest extentTest;
	 */
	public BaseTestUI() {

		try {
			File f = new File(".");
			properties = new Properties();
			FileInputStream ip = new FileInputStream(
					f.getCanonicalPath() +"\\config.properties");
			properties.load(ip);
			
		} catch (IOException e) {
			System.out.println("io exception");

		}

	}

	protected static void initializaton(String url) throws Exception {
		String browserName = properties.getProperty("browser");
		driver = getDriver("chrome");
	//	log.info(browserName + " is configured");

		
			wait= new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

		driver.get(url);
			Thread.sleep(5000);
		sele_Actions = new SeleniumActions();

	}

	public static WebDriver getDriver(String browserName) throws Exception {
		File f = new File(".");
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",  f.getCanonicalPath() + "\\src\\drivers\\chromedriver.exe");
			chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--start-maximized");
			return new ChromeDriver(chromeOptions);
		} else if (browserName.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver", f.getCanonicalPath() + "\\src\\drivers\\geckodriver.exe");
			return new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", TestUtils.WORKSAPCE_PATH + "//drivers//IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
		return null;
	}

	private static void startLogger() {
	//	log = Logger.getLogger(LoggerClass.class);
		//PropertyConfigurator.configure("C:\\Users\\508231\\Downloads\\Selenium-POM-TestNG-Maven-master\\Selenium-POM-TestNG-Maven-master\\src\\main\\resources\\log4j.properties");

	}

	public void tearDownMain() {
			//report.endTest(test);
		
		//report.flush();
		driver.manage().deleteAllCookies();
		driver.close();
	}

	}
