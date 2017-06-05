package SeleniumTestDemo;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFuntion.Driver;
import commonFuntion.Report;


public class AdvanceReporting {

protected ExtentReports extent;
protected ExtentTest test;
WebDriver driver;


@BeforeSuite
public void beforeSuite() throws IOException {
	extent = new ExtentReports(Report.generateReport("AdvanceReporting"), true);
	extent.addSystemInfo("Host Name", "Anshoo").addSystemInfo("Environment", "QA");
}
	    
@Test
public void verifySeleniumBlog() throws IOException{
// Start Test

test=extent.startTest("Verify Page Title");

// Start browser
driver=Driver.startDriver("chrome");
driver.manage().window().maximize();
test.log(LogStatus.INFO, "Browser started");
// Open application
driver.get("http://newtours.demoaut.com/");
test.log(LogStatus.INFO, "Navigated to www.learn-automation.com");
// get title
String title=driver.getTitle();
test.log(LogStatus.INFO, "Get the current title");
// Verify title
Assert.assertTrue(title.contains("Welcome"));


//I am taking random image but you have to take screenshot at run time and specify the path


// Close application



// close report
}
 
 @AfterMethod
 protected void afterEachTest(ITestResult result) throws IOException {
 if (!result.isSuccess()) {
test.log(LogStatus.FAIL,result.getThrowable());
}
 else 
	 {test.log(LogStatus.PASS, "Title verified");}
 
String img=test.addScreenCapture(Report.takeScreenShot1(result,driver));
test.log(LogStatus.INFO, "Image", "Image example: " + img);
driver.quit();
test.log(LogStatus.INFO, "Browser closed");
extent.endTest(test);
extent.flush();
 }

@AfterSuite
protected void afterSuite() {
    extent.close();

}

}
