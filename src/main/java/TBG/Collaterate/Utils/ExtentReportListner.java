package TBG.Collaterate.Utils;

import com.qa.tbg.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.io.IOException;

public class ExtentReportListner extends BasePage implements ITestListener{
	ExtentTest test;
	ExtentReports reports=ExtentReport.ExtentreportGenerator();
	private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, result.getMethod().getMethodName());
		extentTest.set(test);

	}

	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, result.getMethod().getMethodName()+"Test is pass");

	}

	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;
		extentTest.get().fail(result.getThrowable());
		Object testObject=result.getInstance();
		Class getdriver=result.getTestClass().getRealClass();
		try{
		driver=(WebDriver)getdriver.getDeclaredField("driver").get(testObject);
		}
		catch(Exception e){

		}

		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(result.getMethod().getMethodName(),driver),result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getMethod().getMethodName()+"Test is fail");
	}

	public void onTestSkipped(ITestResult result) {
		extentTest.get().skip(result.getThrowable());
		test.log(Status.SKIP, result.getMethod().getMethodName()+"Test is skipped");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		reports.flush();

	}
	

}