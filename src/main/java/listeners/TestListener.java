package listeners;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import base.Base;
public class TestListener implements ITestListener {
	ExtentSparkReporter sparkReporter;
	ExtentReports extent;
	ExtentTest test;
	@Override
	public void onStart(ITestContext context) {
		String reportPath = "C:\\Users\\HP\\eclipse-workspace\\SeleniumClass04Batch37\\Reports\\ExtentReport.html";
		sparkReporter = new ExtentSparkReporter(reportPath);
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Project", "Selenium Class");
		extent.setSystemInfo("Tester", "Class batch 37");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Environment", "QA");
	}
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass("Test Passed");
		test.info("Test Name: " + result.getMethod().getMethodName());
	}
	@Override
	public void onTestFailure(ITestResult result) {
		test.fail("Test Failed");
		test.fail(result.getThrowable());
		// Get Base class object
		Base base = (Base) result.getInstance();
		// Capture screenshot
		String screenshotPath = base.captureScreenshot(result.getMethod().getMethodName());
		// Add screenshot to Extent Report
		test.addScreenCaptureFromPath(screenshotPath);
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip("Test Skipped");
		test.info("Test Name: " + result.getMethod().getMethodName());
	}
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
