package thinkBridge.com.UITesting.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import thinkBridge.baseTestPackage.*;
import thinkBridge.com.UITesting.pages.*;

public class SignUpPageTestcases extends BaseTestUI {


	SignUpPage homePage;


	public SignUpPageTestcases() {
		super();
	}

	
	@BeforeSuite(alwaysRun = true)
	public void setUp() throws Exception {
		initializaton("http://jt-dev.azurewebsites.net/#/SignUp");
	
		
	}
	@AfterSuite(alwaysRun = true)
	public void tearDown() throws Exception {
	tearDownMain();
	
		
	}

	@Test
	public void TC001_VerifyUITextboxes() throws InterruptedException {
		test = report.startTest("UI Elements validation ");
		
		SignUpPage sign= new SignUpPage(driver);
		sign.verifyElementPresent(sign.fullName,"Full Name textbox");
		sign.verifyElementPresent(sign.organizationName,"Organizanization Name textbox");
		sign.verifyElementPresent(sign.email,"Email textbox");
	}
	
	
	@Test
	public void TC002_VerifyDropdownItems() throws InterruptedException {
		test = report.startTest("Dropdown Items validation(English,Dutch)");
		
		SignUpPage sign= new SignUpPage(driver);
		sign.clickEnglishOption();
		sign.explicitWait(sign.DutchOption);
		sign.verifyElementPresent(sign.DutchOption, "Dutch Option");
		
	}
	
	@Test
	public void TC003_VerifyfullName() throws InterruptedException {
		test = report.startTest("Negative validation without full name");
		
		SignUpPage sign= new SignUpPage(driver);
		sign.enterFullName("", test);
		sign.enterOrganizationName("kirthi", test);
		sign.enterEmail("kirthi.gayu@gmail.com", test);
		sign.checkSignOn();
		sign.getStartedButtonAttribute();
	}
	
	
	@Test
	public void TC003_VerifyEmail() throws InterruptedException {
		test = report.startTest("Negative validation without full name");
		
		SignUpPage sign= new SignUpPage(driver);
		sign.enterFullName("kirthi", test);
		sign.enterOrganizationName("kirthi", test);
		sign.enterEmail("", test);
		sign.checkSignOn();
		sign.getStartedButtonAttribute();
	}
	
	@Test
	public void TC003_VerifyOrganization() throws InterruptedException {
		test = report.startTest("Negative validation without email");
		
		SignUpPage sign= new SignUpPage(driver);
		sign.enterFullName("kirthi", test);
		sign.enterOrganizationName("", test);
		sign.enterEmail("kirthi.gayu@gmail.com", test);
		sign.checkSignOn();
		sign.getStartedButtonAttribute();
	}
	@Test
	public void TC004_VerifyOrganization() throws InterruptedException {
		test = report.startTest("Negative validation without Organization");
		
		SignUpPage sign= new SignUpPage(driver);
		sign.enterFullName("kirthi", test);
		sign.enterOrganizationName("", test);
		sign.enterEmail("kirthi.gayu@gmail.com", test);
		sign.checkSignOn();
		sign.getStartedButtonAttribute();
	}
	
	@Test
	public void TC005_VerifyOrganization() throws InterruptedException {
		test = report.startTest("welcome");
		
		SignUpPage sign= new SignUpPage(driver);
		sign.enterFullName("kirthi", test);
		sign.enterOrganizationName("kirthi", test);
		sign.enterEmail("kirthi.gayu@gmail.com", test);
		sign.checkSignOn();
		sign.getStartedButtonAttributeNotPresent();
		sign.clickStarted();
		sign.verifyElementPresent(sign.welcomeMessage, "Welcome Message is present");
	}
	}
