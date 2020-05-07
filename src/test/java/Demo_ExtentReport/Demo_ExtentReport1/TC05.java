package Demo_ExtentReport.Demo_ExtentReport1;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

public class TC05 extends BrowserUtility1{

	public static report_util re = new report_util();
	public static void main(String[] args) throws Exception {
		
		BrowserUtility1.launchBrowser("ch");
		BrowserUtility1.loginToBrowser();
		report_util.createReport();
		re.createTestCase("TC05 TestCases_1");
		waitForPageElementToVisible(driver.findElement(By.xpath("//span[@id='userNavLabel']")));
		driver.findElement(By.xpath("//span[@id='userNavLabel']")).click();
		String values= driver.findElement(By.xpath("//div[@id='userNav-menuItems']")).getText();
		System.out.println(values);
		Thread.sleep(3000);
		BrowserUtility1.quitBrowser();
		re.endTestCase();
		re.EndReport();

		
	}

}
