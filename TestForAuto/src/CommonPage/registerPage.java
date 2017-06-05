package CommonPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commonFuntion.Driver;
import commonFuntion.Report;

public class registerPage {
	  private WebDriver driver;
	  @FindBy(name="firstName")
	  WebElement firstName;
	  @FindBy(name="lastName")
	  WebElement lastName;
	  @FindBy(name="phone")
	  WebElement phone;
	  @FindBy(name="userName")
	  WebElement userName;
	  @FindBy(name="email")
	  WebElement email;
	  @FindBy(name="password")
	  WebElement password;
	  @FindBy(name="confirmPassword")
	  WebElement confirmPassword;
	  @FindBy(name="register")
	  WebElement registerBtn;
	  
	
 public  registerPage(WebDriver driver) {
	 this.driver=driver;
 }
 public String[][]  Register(String dataFilePath, int sheetNum) throws Exception {

		    //String dataFilePath = Driver.dataPath+"/" + "Register.xls";
		    String[][] InputData=new String[0][0];
		    InputData=new Driver().readExcel(dataFilePath,sheetNum);
		         firstName.clear();
		         firstName.sendKeys(InputData[1][1]);
		         lastName.clear();
				 lastName.sendKeys(InputData[1][2]);
				 phone.clear();
				 phone.sendKeys(InputData[1][3]);
				 userName.clear();
				 userName.sendKeys(InputData[1][4]);
				 email.clear();
				 email.sendKeys(InputData[1][5]);
				 password.clear();
				 password.sendKeys(InputData[1][6]);
				 confirmPassword.clear();
				 confirmPassword.sendKeys(InputData[1][7]);
				 Report.takeScreenShot("Register", "Input",driver);
				 registerBtn.click();    
				 Thread.sleep(3000);	
				 return InputData;   
		    	    }
		   
}
