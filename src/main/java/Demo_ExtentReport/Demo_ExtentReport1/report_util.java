package Demo_ExtentReport.Demo_ExtentReport1;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class report_util {

	static ExtentReports reports;
	static ExtentTest logger;
    
	public static void createReport() {
		String unicDateTime = new SimpleDateFormat("'SampleDemo_'yyyyMMddHHmm''").format(new Date());
		String sPath = System.getProperty("user.dir")+"//ExtentReport//sampleReport_"+unicDateTime+".html";
		reports = new ExtentReports(sPath); 
     }
		
		void createTestCase(String sTestCaseName) {
			
			logger=reports.startTest(sTestCaseName);
		}
		
		void endTestCase() {
			
			reports.endTest(logger);
		}
		void EndReport() {
			
		reports.flush(); 
		System.out.println("REPORT DONE SUCCESSFULLY");
	  }
}
