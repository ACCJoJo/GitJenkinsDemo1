package SeleniumTestDemo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import CommonPage.bookFlightPage1;
import CommonPage.flightConfirmationPage1;
import CommonPage.flightFinderPage1;
import CommonPage.loginPage;
import CommonPage.registerPage;
import CommonPage.selectFlightPage1;
import commonFuntion.Driver;
import commonFuntion.RealTimeReport;
import commonFuntion.Report;
import commonFuntion.Reporter;


public class MainFunction {
	  private WebDriver driver;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  protected ExtentReports extent;
      protected ExtentTest test;

	  
	 @BeforeSuite
     public void beforeSuite() throws IOException {
	 extent = new ExtentReports(Report.generateReport("MainFunction"), true);
	 extent.addSystemInfo("Host Name", "Anshoo").addSystemInfo("Environment", "QA");
     } 
	 @AfterSuite
     protected void afterSuite() {
     extent.close();
     }
	 
	@BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
	 this.driver=Driver.startDriver(Driver.browser);
    }
	    
    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
   }
   
	@AfterMethod
    protected void afterEachTest(ITestResult result) throws IOException {
     if (!result.isSuccess()) {
       test.log(LogStatus.FAIL,result.getThrowable());
     }
	 else 
	 { test.log(LogStatus.PASS, "Execute Succesfully");
	 test.log(LogStatus.INFO, "Image", "Image example: "+test.addScreenCapture(Report.takeScreenShot1(result,driver)));
	 }
     extent.endTest(test);
     extent.flush();
	 }
	 
	 
  /*@Test
 public  String[][]  testRegister() throws Exception {
		  driver.get("http://newtours.demoaut.com/");
		    driver.findElement(By.linkText("REGISTER")).click();
		    registerPage registerPage=PageFactory.initElements( driver,registerPage.class);
		    String dataFilePath = Driver.dataPath+"/" + "Register.xls";
		    return registerPage.Register(dataFilePath,0);
		   
		   }
  
  @Test
  public void login() throws Exception {
	     String userName = null;
	     String passWord = null;
	     String[][] userData= testRegister();
	     for(int j=1;j<userData[0].length;j++){
	    	if("email".equals(userData[0][j]))
	    		userName=userData[1][j];
	       else if ("password".equals(userData[0][j]))
	    			   passWord=userData[1][j];
	     }
	     driver.findElement(By.linkText("sign-in")).click();
	     loginPage loginPage=PageFactory.initElements( driver,loginPage.class);
	     loginPage.Login(userName, passWord);
	   	 System.out.println("Login Succesfully!");	    
} */
  @Test(description="Login the Newtour Page")
  public void login2() throws Exception {
	  test=extent.startTest("Login the Newtour Page");
     //driver.findElement(By.linkText("sign-in")).click();
	   driver.get("http://newtours.demoaut.com/");
	   loginPage loginPage=PageFactory.initElements( driver,loginPage.class);
	   loginPage.Login("UserNameW190G","123456");
	   test.log(LogStatus.INFO, "Login Succesfully!");
	    //System.out.println("Login Succesfully!");	    
}
  @Test(description="Complete the book flight")
  public void orderFlight() throws Exception {
     //driver.findElement(By.linkText("sign-in")).click();
	   test=extent.startTest("Complete the book flight");
	   String[][] flightData;
	  //Search for flight info
	   flightFinderPage1 flightFinderPage1=PageFactory.initElements( driver,flightFinderPage1.class);
	   String dataFilePath = Driver.dataPath+"/" + "FlightInfo1.xls";
	   flightData=flightFinderPage1.flightDetailInput(dataFilePath,0);
	   test.log(LogStatus.INFO, "Select the flight Info");
	     
	  //Select flight info
	   //Verify the flight info if the info match the search critical
	      selectFlightPage1 selectFlightPage1=PageFactory.initElements( driver,selectFlightPage1.class);  
		   String departLocation=flightData[1][3] + " to "+ flightData[1][6]; //store the search critical
		   String returnLocation=flightData[1][6] + " to "+ flightData[1][3];//store the search critical
	       String  checkDepartLocation=selectFlightPage1.getDepartLocation();
	       String  checkReturnLocation=selectFlightPage1.getReturnLocation();
	       System.out.println(" The Depart Location is " + checkDepartLocation+" The Return Location is " + checkReturnLocation);    
		 try{
			 assertEquals(checkDepartLocation,departLocation) ;
		  }catch(Exception e){
			  fail("The flight Info is not correct"); 
		  }
		 try{
			 assertEquals(checkReturnLocation,returnLocation);
		  }catch(Exception e){
			  fail("The flight Info is not correct"); 
		  }
		 test.log(LogStatus.INFO, "Verify the flight Info");
		 
		 //Select flight info
		 selectFlightPage1.selectFlightInput(dataFilePath,1);
		 test.log(LogStatus.INFO, "Select the flight");
		 //Book flight info
		 bookFlightPage1 bookFlightPage1=PageFactory.initElements( driver,bookFlightPage1.class); 
		 bookFlightPage1.bookFlightInput(dataFilePath, 2,flightData[1][2]);
		 test.log(LogStatus.INFO, "Book the flight ");
		 flightConfirmationPage1 flightConfirmationPage1=PageFactory.initElements( driver,flightConfirmationPage1.class); 
		 flightConfirmationPage1.backToLogout();
		 test.log(LogStatus.INFO, "Log Out");
}
  

  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }

}
