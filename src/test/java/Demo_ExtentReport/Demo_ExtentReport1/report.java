package Demo_ExtentReport.Demo_ExtentReport1;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class report extends report_util{

//		static ExtentReports reports;
//		static ExtentTest logger;
		public static void main(String[] args) throws Exception {
			//we dont have any inbuil function in java'to create report. Extent Report --> Customizable report, Flexibality more
			//it will create in .html format
			//We have to tell them where this rports file needs to be generated
			BrowserUtility1.launchBrowser("ch");
           //String sPath = System.getProperty("user.dir")+"//ExtentReport//sampleReport.html";
           //reports = new ExtentReports(sPath); // It will start creating html file.
			report_util.createReport();
			//INFO, ERROR, DEBUG(when run on debugger mode), 
			//System.out.println("message");	//messages/Information wants to hold it in some file. 
			//inbuilt method to create a logging or recoridng your message for your future info
			logger=reports.startTest("DEMO REPORT STARTED");//Execution of the report started and assigned to logger object
			//Think about previous testc cases whihc we have autoamted. There we have given only syso. 
			//loginToBrowser();
			logger.log(LogStatus.INFO, "Entered Username successfully");
			logger.log(LogStatus.INFO, "Entered Password successfully");
			logger.log(LogStatus.INFO, "Submit button clicked  successfully");
			logger.log(LogStatus.PASS, "Login success");

			//logger.log(LogStatus.PASS, logger.addScreenCapture(ufTakeScreenShot()));//Attach screenshot to Extent Report
			reports.endTest(logger);
			logger=reports.startTest("DEMO REPORT STARTED 2");//Execution of the report started and assigned to logger object
			//Think about previous testc cases whihc we have autoamted. There we have given only syso. 
			logger.log(LogStatus.INFO, "Entered Username successfully");
			logger.log(LogStatus.INFO, "Entered Password successfully");
			logger.log(LogStatus.FAIL, "Login Failure");
			reports.endTest(logger);
			
			reports.flush();//Closes all the extent report object with proper shutdown. 
			System.out.println("REPORT DONE SUCCESSFULLY");
		
			//How to take screenshot? --> To Acknowledge whether it is passed or failure --> This creates more memory
			//1000 testcases --> 500kb p/s --> 500MB --> you need a track of last 7 days of run.
			//Failure test cases --> Where you really required to analyse the result. --> File upload, Alerts
			
			//Every day new concepts.. learn the concepts + Then try to incorporate to your older concepts
		}

		public static String ufTakeScreenShot() throws Exception{
			TakesScreenshot ts = (TakesScreenshot)BrowserUtility1.driver; //Screenshot setup is done
			File Source = ts.getScreenshotAs(OutputType.FILE);//Taken the screenshot and saving it to source
		    //TakeScreenshot object it is saved. not saved physically.
			String sPathOfDestinationImage = System.getProperty("user.dir")+"//screenshot//Screenshot_<timeStamp>.png";
			File dest = new File(sPathOfDestinationImage);
			FileUtils.copyFile(Source, dest);
			return sPathOfDestinationImage;
		}
		
		//WebServices  --> Sushma --> 2 Phases
		//TestNg --> Videos not recomended
	

	}


