package Demo_ExtentReport.Demo_ExtentReport1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BrowserUtility1 {
	public static WebDriver driver = null;
	static ExtentTest logger;
	
//	public static report_util re = new report_util();
	public static void launchBrowser(String sBrowser)
		{
			if(sBrowser.startsWith("ch")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			}
			else
			{
				System.out.println("You have not given browser type correctly");
			}
			
//			logger.log(LogStatus.INFO, "Browser Launched");

			
			driver.manage().window().maximize();
			driver.get("https://login.salesforce.com/");
		}
		
		 static void quitBrowser()
		 {
			 driver.quit();
		 }
		 static void loginToBrowser()
		 {

			  File file = new File("C:\\Users\\chapa004\\Documents\\Indu\\Workspaces\\Eclipse\\JavaTraining\\SFDC_37/test1.properties");
			 FileInputStream fileInput = null;
			  try
			  {
				   fileInput = new FileInputStream(file);
				  
			  }
			  catch(FileNotFoundException e)
			  {
				  System.out.println(e);
			  }
			  
			  Properties prop = new Properties();
			  try
			  {
				  prop.load(fileInput);
			  }
			  catch(Exception a)
			  {
				  System.out.println(a);
			  }
				
			  waitForPageElementToVisible(driver.findElement(By.xpath("//input[@id='username']")));
			 driver.findElement(By.xpath("//input[@id='username']")).sendKeys(prop.getProperty("username"));
			 logger.log(LogStatus.INFO, "Entered Username successfully");
			logger.log(LogStatus.INFO, "Submit button clicked  successfully");
			 driver.findElement(By.xpath("//input[@id='password']")).sendKeys(prop.getProperty("password"));
			 logger.log(LogStatus.INFO, "Entered Password successfully");
			 driver.findElement(By.xpath("//input[@id='Login']")).click();
			 logger.log(LogStatus.PASS, "Login success");
		 }
		 static void  waitForPageElementToVisible(WebElement eleToWait)
		 {
			 WebDriverWait wait = new WebDriverWait(BrowserUtility1.driver,30);
			 wait.until(ExpectedConditions.visibilityOf(eleToWait));
		 }
	}


