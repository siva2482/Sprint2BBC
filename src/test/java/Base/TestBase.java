package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import TestUtils.ReadOR;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static FileInputStream fis;
	public static Properties pro;
	ExtentReports reports;
	ExtentTest test;
	public Date d;
	String sdate;
	@BeforeSuite
	public void Beforesuite()
	{
		d = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHHmmssZ");
	sdate = formatter.format(d);
		
		String s=ReadOR.getLocator("browser");
		reports=new ExtentReports(System.getProperty("user.dir")+"\\src\\test\\resources\\reports\\AutomationReport"+sdate+".html");
		test=reports.startTest("Demo Register Report");
		
		if(s.equalsIgnoreCase("chrome"))
		{
			//ChromeOptions options = new ChromeOptions();
			//options. addArguments("headless");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			test.log(LogStatus.INFO,"chrome browser started");
			driver.get(ReadOR.getLocator("testingurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			test.log(LogStatus.INFO,"Url launched");
		}
	}
	@BeforeTest
	public void beforetest()
	{
		System.out.println("Test Started");
		test.log(LogStatus.INFO,"test started");
	}
	@AfterMethod
	   public void getScreenshot(ITestResult r) throws IOException
	   {
			
			
			if(r.isSuccess())
			{
				test.log(LogStatus.PASS,"test case"+r.getName()+"passed");
		File sc=   ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dst=new File("C:\\Sprint2BBC\\src\\test\\resources\\screenshot_" +r.getName()+sdate+".png");
		FileUtils.copyFile(sc, dst);
	   }
			else
			{
				test.log(LogStatus.FAIL,"test case"+r.getName()+"failed");
			}
	}
	@AfterClass
 public void generateReport()
 {
				reports.endTest(test);
				reports.flush();
 }

}
