package thinkBridge.baseTestPackage;

import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

//import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.mongodb.MongoClient;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import thinkBridge.TestDataExternalization.*;


public class BaseTest_TestNG extends TestDataManagement {
	public static ExtentReports report;
	public static ExtentTest test;
	public static Properties globalProp;
	
	 		

	@BeforeClass
	public void startTest() throws Exception {
		File f = new File(".");
		
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_hh_mm_ss");
		String strDate = dateFormat.format(date);
		System.out.println("path"+f.getCanonicalPath());
		File reportFile = new File(f.getCanonicalPath() + "\\ExtentReport\\ExtentReportResults1_" + strDate + ".html");
		if (!reportFile.exists()) {
			reportFile.createNewFile();
		}
		report = new ExtentReports(f.getCanonicalPath() + "\\ExtentReport\\ExtentReportResults1_" + strDate + ".html",
				true);

	}

	@AfterClass
	public static void endTest() throws Exception {
		report.endTest(test);
		
		report.flush();
	}

	
}