package CommonPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import commonFuntion.Driver;
import commonFuntion.Report;

public class bookFlightPage1 {
	  private WebDriver driver;
	  //Passengers
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
	  
	  //Billing Address
	  @FindBy(name="billAddress1")
	  WebElement billAddress1;
	  @FindBy(name="billAddress2")
	  WebElement billAddress2;
	  @FindBy(name="billCity")
	  WebElement billCity;
	  @FindBy(name="billState")
	  WebElement billState;
	  @FindBy(name="billZip")
	  WebElement billZip;
	  @FindBy(name="billCountry")
	  WebElement billCountry;
	  
	//Delivery Address
	  @FindBy(xpath="(//input[@name='ticketLess'])[2]")
	  WebElement sameAsBill;
	  @FindBy(name="delAddress1")
	  WebElement delAddress1;
	  @FindBy(name="delAddress2")
	  WebElement delAddress2;
	  @FindBy(name="delCity")
	  WebElement delCity;
	  @FindBy(name="delState")
	  WebElement delState;
	  @FindBy(name="delZip")
	  WebElement delZip;
	  @FindBy(name="delCountry")
	  WebElement delCountry;
	 
	 
	  @FindBy(name="buyFlights")
	  WebElement buyFlightsBtn;

	  
	
 public  bookFlightPage1(WebDriver driver) {
	 this.driver=driver;
 }
 public String[][]  bookFlightInput(String dataFilePath,int sheetNum,String passNum) throws Exception {

		    //String dataFilePath = Driver.dataPath+"/" + "Register.xls";
		    String[][] InputData=new String[0][0];
		    InputData=new Driver().readExcel(dataFilePath,sheetNum);
		    firstName0.clear();
		    firstName0.sendKeys(InputData[1][1]);
		    lastName0.clear();
		    lastName0.sendKeys(InputData[1][2]);
		    new Select(passMeal0).selectByVisibleText(InputData[1][3]);
		    switch (passNum) {
		    case "4":
		    	firstName3.clear();
			    firstName3.sendKeys(InputData[1][10]);
			    lastName3.clear();
			    lastName3.sendKeys(InputData[1][11]);
			    new Select(passMeal3).selectByVisibleText(InputData[1][12]);
		    case "3":
		    	firstName2.clear();
		    	firstName2.sendKeys(InputData[1][7]);
		    	lastName2.clear();
				lastName2.sendKeys(InputData[1][8]);
				new Select(passMeal2).selectByVisibleText(InputData[1][9]);
		    case "2":
		    	firstName1.clear();
			    firstName1.sendKeys(InputData[1][4]);
			    lastName1.clear();
			    lastName1.sendKeys(InputData[1][5]);
			    new Select(passMeal1).selectByVisibleText(InputData[1][6]);
		    case "1":
		    	break;
		    }
		    
		    new Select(creditCard).selectByVisibleText(InputData[1][13]);
		    creditNumber.clear();
		    creditNumber.sendKeys(InputData[1][14]);
		    new Select(creditDtMM).selectByVisibleText(InputData[1][15]);
		    new Select(creditDtYY).selectByVisibleText(InputData[1][16]);
		    ccFirstName.clear();
		    ccFirstName.sendKeys(InputData[1][17]);
		    ccMiddleName.clear();
		    ccMiddleName.sendKeys(InputData[1][18]);		    
		    ccLastName.clear();
		    ccLastName.sendKeys(InputData[1][19]);	
		    
		  //Billing Address
		    billAddress1.clear();
		    billAddress1.sendKeys(InputData[1][20]);
		    billAddress2.clear();
		    billAddress2.sendKeys(InputData[1][21]);
		    billCity.clear();
		    billCity.sendKeys(InputData[1][22]);
		    billState.clear();
		    billState.sendKeys(InputData[1][23]);
		    billZip.clear();
		    billZip.sendKeys(InputData[1][24]);
		    new Select(billCountry).selectByVisibleText(InputData[1][25]);

		//Delivery Address
		    sameAsBill.click();
		    delAddress1.clear();
		    delAddress1.sendKeys(InputData[1][26]);
		    delAddress2.clear();
		    delAddress2.sendKeys(InputData[1][27]);
		    delCity.clear();
		    delCity.sendKeys(InputData[1][28]);
		    delState.clear();
		    delState.sendKeys(InputData[1][29]);
		    delZip.clear();
		    delZip.sendKeys(InputData[1][30]);
		    new Select(delCountry).selectByVisibleText(InputData[1][31]);
		   
		     Report.takeScreenShot("Order", "Input",driver);
			 buyFlightsBtn.click();    
			 
		     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// Thread.sleep(3000);	
				 return InputData;   
		    	    }
 public void bookflight1() throws Exception {
	 Report.takeScreenShot("Flight1", "Input",driver);
	 buyFlightsBtn.click();
}

 
}
