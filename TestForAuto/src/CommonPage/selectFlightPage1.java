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

public class selectFlightPage1 {
	  private WebDriver driver;
	  
	  @FindBy(xpath="(//input[@name='outFlight'])[1]")
	  WebElement departFlight1;
	  @FindBy(xpath="(//input[@name='outFlight'])[2]")
	  WebElement departFlight2;
	  @FindBy(xpath="(//input[@name='outFlight'])[3]")
	  WebElement departFlight3;
	  @FindBy(xpath="(//input[@name='outFlight'])[4]")
	  WebElement departFlight4;
	  
	  @FindBy(xpath="(//input[@name='inFlight'])[1]")
	  WebElement returnFlight1;
	  @FindBy(xpath="(//input[@name='inFlight'])[2]")
	  WebElement returnFlight2;
	  @FindBy(xpath="(//input[@name='inFlight'])[3]")
	  WebElement returnFlight3;
	  @FindBy(xpath="(//input[@name='inFlight'])[4]")
	  WebElement returnFlight4;
	  
	 
	  @FindBy(xpath="//table[1]/tbody/tr/td/table/tbody/tr[2]/td/b/font")
	static
	 WebElement departLocation;
	  @FindBy(xpath="//table[2]/tbody/tr/td/table/tbody/tr[2]/td/b/font")
	static
	  WebElement returnLocation;
	 
	  @FindBy(name="reserveFlights")
	  WebElement continueBtn;

	  
	
 public  selectFlightPage1(WebDriver driver) {
	 this.driver=driver;
 }
 public String[][]  selectFlightInput(String dataFilePath,int sheetNum) throws Exception {

		    //String dataFilePath = Driver.dataPath+"/" + "Register.xls";
		    String[][] InputData=new String[0][0];
		    InputData=new Driver().readExcel(dataFilePath,sheetNum);
		    switch (InputData[1][1]) {
		    case "1":
		    	departFlight1.click();
		        break;
		    case "2":
		    	departFlight2.click();
		        break;
		    case "3":
		    	departFlight3.click();
		        break;
		    case "4":
		    	departFlight3.click();
		        break;
		    }
		    switch (InputData[1][2]) {
		    case "1":
		    	returnFlight1.click();
		        break;
		    case "2":
		    	returnFlight2.click();
		        break;
		    case "3":
		    	returnFlight3.click();
		        break;
		    case "4":
		    	returnFlight3.click();
		        break;
		    }
		     Report.takeScreenShot("Flight1", "Input",driver);
		     continueBtn.click(); 
		     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// Thread.sleep(3000);	
				 return InputData;   
		    	    }
 public void selectflight1() throws Exception {
	 Report.takeScreenShot("Flight1", "Input",driver);
	 continueBtn.click();
}
 public static String getDepartLocation() {   
     return departLocation.getText();   
 } 
 public static String getReturnLocation() {   
     return returnLocation.getText();   
 } 
 
}
