package thinkBridge.ResuableLibrary;


import static org.awaitility.Awaitility.await;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;

/*import org.apache.metamodel.DataContext;
import org.apache.metamodel.DataContextFactory;
import org.apache.metamodel.data.DataSet;
import org.apache.metamodel.data.Row;
import org.apache.metamodel.query.Query;
import org.apache.metamodel.query.builder.SatisfiedWhereBuilder;
import org.apache.metamodel.schema.Schema;
import org.apache.metamodel.schema.Table;*/
import org.bson.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//import com.ContractTesting.ConversionService.CurrencyConversionBean;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




public class ResuableComponents {
	//static List<Row> resultSetRows;

	public void Enter(WebElement we, String text,ExtentTest test)
	{
	
		we.click();
		we.clear();
		we.sendKeys(text);
		test.log(LogStatus.INFO, "The Value "+text  +" is entered ");
	}
	public void Click(WebElement we,ExtentTest test)
	{
		we.click();
		test.log(LogStatus.INFO, "The click action is performed entered ");
	}
	
	
}