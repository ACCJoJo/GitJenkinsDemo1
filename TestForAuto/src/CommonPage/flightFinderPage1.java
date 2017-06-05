package CommonPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import commonFuntion.Driver;
import commonFuntion.Report;

public class flightFinderPage1 {
	  private WebDriver driver;
	  
	  @FindBy(xpath="(//input[@name='tripType'])[1]")
	  WebElement tripType1;
	  @FindBy(xpath="(//input[@name='tripType'])[2]")
	  
	  WebElement tripType2;
	  @FindBy(name="passCount")
	  WebElement passCount;
	  @FindBy(name="fromPort")
	  WebElement fromPort;
	  @FindBy(name="toPort")
	  WebElement toPort;
	  @FindBy(name="fromMonth")
	  WebElement fromMonth;
	  @FindBy(name="toMonth")
	  WebElement toMonth;	 
	  @FindBy(name="fromDay")
	  WebElement fromDay;
	  @FindBy(name="toDay")
	  WebElement toDay;
	  
	  @FindBy(xpath="(//input[@name='servClass'])[1]")
	  WebElement servClass1;
	  @FindBy(xpath="(//input[@name='servClass'])[2]")
	  WebElement servClass2;
	  @FindBy(xpath="(//input[@name='servClass'])[3]")
	  WebElement servClass3;
	  
	  @FindBy(name="airline")
	  WebElement airline;
	  @FindBy(name="findFlights")
	  WebElement findFlightsBtn;

	  
	
 public  flightFinderPage1(WebDriver driver) {
	 this.driver=driver;
 }
 public String[][]  flightDetailInput(String dataFilePath,int sheetNum) throws Exception {

		    //String dataFilePath = Driver.dataPath+"/" + "Register.xls";
		    String[][] InputData=new String[0][0];
		    InputData=new Driver().readExcel(dataFilePath,sheetNum);
		    switch (InputData[1][1]) {
		    case "1":
		    	tripType1.click();
		        break;
		    case "2":
		    	tripType2.click();
		        break;
		    }
		    new Select(passCount).selectByVisibleText(InputData[1][2]);
		    new Select(fromPort).selectByVisibleText(InputData[1][3]);
		    new Select(fromMonth).selectByVisibleText(InputData[1][4]);
		    new Select(fromDay).selectByVisibleText(InputData[1][5]);
		    new Select(toPort).selectByVisibleText(InputData[1][6]);
		    new Select(toMonth).selectByVisibleText(InputData[1][7]);
		    new Select(toDay).selectByVisibleText(InputData[1][8]);
		    switch (InputData[1][9]) {
		    case "1":
		    	servClass1.click();
		        break;
		    case "2":
		    	servClass2.click();
		        break;
		    case "3":
		    	servClass3.click();
		        break;
		    }
		    new Select(airline).selectByVisibleText(InputData[1][10]);
		     Report.takeScreenShot("Flight1", "Input",driver);
				 findFlightsBtn.click();    
				 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
				 return InputData;   
		    	    }
 public void flight1() throws Exception {
	 Report.takeScreenShot("Flight1", "Input",driver);
	 findFlightsBtn.click();
}
 
 public static String getservClass(String dataFilePath,int sheetNum) {   
	 String[][] InputData=new String[0][0];
	 String serviceClass = null;
	 InputData=new Driver().readExcel(dataFilePath,sheetNum);
	 
	 switch (InputData[1][1]) {
	    case "1":
	    	serviceClass="Economy class";
	    	break;
	    case "2":
	    	serviceClass= "Business class ";
	    	break;
	    case "3":
	    	serviceClass="First class";
	    	break;
	    }
	return serviceClass;  
 } 

}
