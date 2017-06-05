package SeleniumTestDemo;

import static org.testng.Assert.fail;

import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTestDemo {
	  private WebDriver driver;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	
	@BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
		 System.setProperty("webdriver.chrome.driver", "C:/Automation/WebDriver/chromedriver.exe");    
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();

	  }
	
  @Test
 public void testDemo() throws Exception {
		  driver.get("http://newtours.demoaut.com/");
		    driver.findElement(By.linkText("REGISTER")).click();
		    driver.findElement(By.name("firstName")).clear();
		    driver.findElement(By.name("firstName")).sendKeys("Test");
		    driver.findElement(By.name("lastName")).clear();
		    driver.findElement(By.name("lastName")).sendKeys("Fordemo");
		    driver.findElement(By.name("phone")).clear();
		    driver.findElement(By.name("phone")).sendKeys("1372069");
		    driver.findElement(By.id("userName")).clear();
		    driver.findElement(By.id("userName")).sendKeys("new@qq.com");
		    driver.findElement(By.id("email")).clear();
		    driver.findElement(By.id("email")).sendKeys("user1");
		    driver.findElement(By.name("password")).clear();
		    driver.findElement(By.name("password")).sendKeys("123456");
		    driver.findElement(By.name("confirmPassword")).clear();
		    driver.findElement(By.name("confirmPassword")).sendKeys("123456");
		    driver.findElement(By.name("register")).click();
    }
  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
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
