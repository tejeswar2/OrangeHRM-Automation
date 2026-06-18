package listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.LaunchBase;

public class ExtentTestNGListener implements ITestListener {

	ExtentReports extent;
	ExtentTest test;

	@Override
	public void onStart(ITestContext context) {
		if (extent == null) {
			ExtentSparkReporter spark = new ExtentSparkReporter(
					System.getProperty("user.dir") + "/test-output/ExtentReports/Report.html");

			spark.config().setDocumentTitle("OrangeHRM Web Automation");
			spark.config().setReportName("OrangeHRM Test Report");
			spark.config().setTheme(Theme.DARK);

			extent = new ExtentReports();
			extent.attachReporter(spark);

			extent.setSystemInfo("Application", "OrangeHRM Demo");
			extent.setSystemInfo("Env", "QA");
			extent.setSystemInfo("Browser", "Chrome");
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass("Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail("Test failed");
		test.fail(result.getThrowable());

		WebDriver d = ((LaunchBase) result.getInstance()).d;
		if (d != null) {
			 try {

		            String screenshot =
		                    ((TakesScreenshot) d).getScreenshotAs(OutputType.BASE64);

		            System.out.println("screenshot captured");
		            System.out.println("SS length: " + screenshot.length());

		            test.addScreenCaptureFromBase64String(
		                    screenshot,
		                    "Failure screenshot");

		        } catch (Exception e) {

		            e.printStackTrace();

		            test.warning("Couldn't capture screenshot: "
		                    + e.getMessage());
		        }
			 }
     }

	@Override
	public void onTestSkipped(ITestResult result) {

		test.skip("Test skipped");

		if (result.getThrowable() != null) {
			test.skip(result.getThrowable());
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}