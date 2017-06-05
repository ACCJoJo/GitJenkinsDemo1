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

public class flightConfirmationPage1 {
	  private WebDriver driver;
	  //Flight Confirmation
	  @FindBy(name="passFirst0")
	  WebElement firstName0;
	  @FindBy(name="passFirst1")
	  WebElement firstName1;
	  @FindBy(name="passFirst2")
	  WebElement firstName2;
	  @FindBy(name="passFirst3")
	  WebElement firstName3;

	  @FindBy(name="passLast0")
	  WebElement lastName0;
	  @FindBy(name="passLast1")
	  WebElement lastName1;
	  @FindBy(name="passLast2")
	  WebElement lastName2;
	  @FindBy(name="passLast3")
	  WebElement lastName3;
	  
	  @FindBy(name="pass.0.meal")
	  WebElement passMeal0;
	  @FindBy(name="pass.1.meal")
	  WebElement passMeal1;
	  @FindBy(name="pass.2.meal")
	  WebElement passMeal2;
	  @FindBy(name="pass.3.meal")
	  WebElement passMeal3;
	  
	  //Credit Card
	  @FindBy(name="creditCard")
	  WebElement creditCard;
	  @FindBy(name="creditnumber")
	  WebElement creditNumber;
	  @FindBy(name="cc_exp_dt_mn")
	  WebElement creditDtMM;
	  @FindBy(name="cc_exp_dt_yr")
	  WebElement creditDtYY;
	  @FindBy(name="cc_frst_name")
	  WebElement ccFirstName;
	  @FindBy(name="cc_mid_name")
	  WebElement ccMiddleName;
	  @FindBy(name="cc_last_name")
	  WebElement ccLastName;
	  
	  //Button
	  @FindBy(xpath="//td[2]/a/img")
	  //(xpath="//a[contains(@href, ‘reservation’)]")
	  WebElement backToFlightBtn;
	  @FindBy(xpath="//td[2]/a/img")
	  WebElement backToHomeBtn;
	  @FindBy(xpath="//td[3]/a/img")
	  WebElement backToLogoutBtn;

	  
	
 public  flightConfirmationPage1(WebDriver driver) {
	 this.driver=driver;
 }
 public void backToFlight() throws Exception {

	        Report.takeScreenShot("backToFlight", "Click",driver);
	         backToFlightBtn.click();    
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 }
 public void backToHome() throws Exception {

     Report.takeScreenShot("backToHome", "Click",driver);
      backToHomeBtn.click();    
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
 public void backToLogout() throws Exception {

     Report.takeScreenShot("backToLogout", "Click",driver);
      backToLogoutBtn.click();    
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
 
}
