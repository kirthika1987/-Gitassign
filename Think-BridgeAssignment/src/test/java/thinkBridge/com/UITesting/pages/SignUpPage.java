package thinkBridge.com.UITesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import thinkBridge.ResuableLibrary.*;
import thinkBridge.baseTestPackage.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BaseTestUI {
	
	WebDriver driver;
	public  SignUpPage(WebDriver driver)
	{
		
		this.driver=driver;
	}

	ResuableComponents objreuse= new ResuableComponents();
	
		public By fullName= By.name("name");
		public By organizationName=By.name("orgName");
		public By email= By.name("email");
		public By englishClickElement= By.xpath("//span[text()='English']");
		public By DutchOption= By.xpath("//div[text()='Dutch']");
		public By termsCheckbox=By.xpath("//span[contains(text(),'I agree')]");
		public By startedButton=By.xpath("//button[@type='submit']");
		public By welcomeMessage= By.xpath("//span[contains(text(),'welcome email has been sent')]");
		
		
	
		public void verifyElementPresent(By by,String elementName)
		{
			
			if(driver.findElement(by) != null)
				test.log(LogStatus.PASS, "The element "+elementName  +" is Present");
			
			
			else
				test.log(LogStatus.FAIL, "The element "+elementName  +" is not Present");
			
			
			
		}
		
		public boolean isAttribtuePresent(WebElement element, String attribute) {
		    Boolean result = false;
		    try {
		        String value = element.getAttribute(attribute);
		        if (value != null){
		            result = true;
		        }
		    } catch (Exception e) {}

		    return result;
		}
	public void enterFullName(String value, ExtentTest test) {
				objreuse.Enter(driver.findElement(fullName),value,test );
		
	}
	public void enterOrganizationName(String value,ExtentTest test) {
		objreuse.Enter(driver.findElement(organizationName),value,test );
		
	}
	
	public void enterEmail(String value,ExtentTest test) {
		objreuse.Enter(driver.findElement(email),value,test );
		
	}
	
	
	public void clickEnglishOption1()
	{
		objreuse.Click(driver.findElement(englishClickElement), test);
		
	}
	
	public void explicitWait(By by)
	{
		
		WebDriverWait wait= new WebDriverWait(driver,300);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public void clickEnglishOption()
	{
		objreuse.Click(driver.findElement(englishClickElement), test);
		
	}
	
	public void checkSignOn()
	{
		objreuse.Click(driver.findElement(termsCheckbox), test);	
	}
	
	public void getStartedButtonAttribute()
	{
		if(isAttribtuePresent(driver.findElement(startedButton),"disabled"))
		{
			
			test.log(LogStatus.PASS, "The element attribute  is Present");
		}
		else
		{
			test.log(LogStatus.FAIL, "The element attribute  is not  Present");
		}
	}
	
	
	public void getStartedButtonAttributeNotPresent()
	{
		if(isAttribtuePresent(driver.findElement(startedButton),"disabled"))
		{
			
			test.log(LogStatus.FAIL, "The element attribute  is Present");
		}
		else
		{
			test.log(LogStatus.PASS, "The element attribute  is not  Present");
		}
	}
	
	public void clickStarted()
	{
		objreuse.Click(driver.findElement(startedButton), test);
		
	}
	
	
}
