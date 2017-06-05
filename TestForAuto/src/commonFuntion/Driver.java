package commonFuntion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;




public class Driver {
	    //Webdiver
		public static String browser;        
		public  static String ieDriverPath;
		public  static String fireFoxDriverPath;
		public  static String chromeDriverPath;
		public static WebDriver driver;
		
		//est data path
		public  static String dataPath; 
		
		//Set the path of screenshots for cases running steps.
		public  static String screenshotPath;
		
		private static Boolean isMax=false;
		 

	static {   
        Properties prop = new Properties();   
        InputStream is =null;
        try {
			is = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\settings.properties"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        		//Object.class.getResourceAsStream("/settings.properties");  
        try {   
            prop.load(is);  
            browser = prop.getProperty("Browser").trim();  //Browser Name 
            ieDriverPath = prop.getProperty("IEDriverPath").trim();
            fireFoxDriverPath = prop.getProperty("FireFoxDriverPath").trim();
            chromeDriverPath = prop.getProperty("ChromeDriverPath").trim();   
            dataPath = prop.getProperty("DataPath").trim(); //Test Data
            screenshotPath = prop.getProperty("ScreenshotPath").trim();
           // GlobalVariables.driver=startDriver(GlobalVariables.browser);
            
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
        	
    }
	//Start Drive based on different browsers
	public static WebDriver startDriver(String browser) {
		
		switch (browser) {
	    case "ie":
	        System.setProperty("webdriver.ie.driver", ieDriverPath);    
	        driver = new InternetExplorerDriver();
	        if(isMax==false){
	        	driver.manage().window().maximize();
	        	isMax=true;
	        }
	        break;
	    case "firefox":
	    	System.setProperty("webdriver.firefox.bin",  fireFoxDriverPath); 
			FirefoxProfile fp=new FirefoxProfile();
			//FirefoxBinary firefoxBinary=new FirefoxBinary(new File("C:/Program Files (x86)/Mozilla Firefox/firefox"));
			driver = new FirefoxDriver(fp);
			driver.manage().window().maximize();
	        break;
	    case "chrome":
	    	System.setProperty("webdriver.chrome.driver", chromeDriverPath);   
	    	ChromeOptions options=new ChromeOptions();
	    	//options.setBinary("C:/Program Files (x86)/Google/Chrome/Application");
	        driver = new ChromeDriver(options);
	        driver.manage().window().maximize();
	        break;  
	    }
		return driver; 
	} 
	
	//Read excel
	
	public String[][] readExcel(String filePath, int sheetNum) {
		//List<String> keywords = new ArrayList<String>();
		Workbook rwk = null;
		String[][] arr=new String[0][0];
		try{
		File f = new File(filePath);
	    rwk = Workbook.getWorkbook(f);
		
		//There are two methods to get sheet: sheet name & index(from 0)		  
        //Sheet st = rwk.getSheet("original");   
        Sheet st = rwk.getSheet(sheetNum);
        int stCols = st.getColumns(); //get the number of columns of the sheet
        int stRows = st.getRows();   //get the number of rows of the sheet
         arr=new String[stCols][stRows];
        for(int i=0; i < stCols;i++){
        	for (int j = 0; j < stRows; j++){
        		Cell cell = st.getCell(i, j);
        		arr[i][j]= cell.getContents();
        		}
         }
		}catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
        	rwk.close();  
        }
		return arr;  
    
	}
	  
}
