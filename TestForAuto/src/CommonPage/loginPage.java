package CommonPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import commonFuntion.Driver;
import commonFuntion.Report;

public class loginPage {
	  private WebDriver driver;

	  @FindBy(name="userName")
	  WebElement userName;
	  @FindBy(name="password")
	  WebElement passWord;
	  @FindBy(name="login")
	  WebElement loginBtn;
	  
	
 public loginPage(WebDriver driver) {
	 this.driver=driver;
 }
 public void Login(String username,String password) throws Exception {

				 userName.clear();
				 userName.sendKeys(username);
                 passWord.clear();
				 passWord.sendKeys(password);
				 Report.takeScreenShot("Login", "Input",driver);
				 loginBtn.click();    
				 Thread.sleep(3000);	
			
		    	    }
		   
}
