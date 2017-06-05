package commonFuntion;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

public class Report {
	
	static long currentTime=System.currentTimeMillis(); //get the current time of system. 
	public static void takeScreenShot(String folder,String fileName, WebDriver driver) throws IOException {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		  
		String screenshotFilePath=Driver.screenshotPath + folder + "/" + Driver.browser+ "/" + fileName +"_"+ currentTime  + ".jpg";
		//String screenshotFilePath=Driver.screenshotPath + folder + "/"  + fileName +"_"+ "01"  + ".jpg";
		FileUtils.copyFile(srcFile, new File(screenshotFilePath));
	}
	
	public static String takeScreenShot1(ITestResult tr,WebDriver driver) throws IOException {
		String fileName = tr.getName() +"_"+ currentTime + ".jpg";
	    File dir = new File("target/Snapshot");
	    if (!dir.exists()) {
	        dir.mkdirs();
	    }
	    String filePath = dir.getAbsolutePath() + "/" + fileName;
	    if (driver != null) {
	        try {
	        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(scrFile, new File(filePath));
	        } catch (IOException e) {
	        e.printStackTrace();
	        }
	    }
	    return filePath;
	    }
	
	public static String generateReport(String report) throws IOException {
		String reportName=report +"_"+ currentTime +".html";
		 File dir = new File("target/Report");
		    if (!dir.exists()) {
		        dir.mkdirs();
		    }
		    String reportPath = dir.getAbsolutePath() +"\\" + reportName;
		    new File(reportPath).createNewFile();
		    //FileHandler.createDir(new File(reportPath));
		return reportPath;
	}
	
}
