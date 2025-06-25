package automation.ultis.listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import automation.common.CommonBase;
import automation.ultis.extentreports.ExtentTestManager;
import automation.ultis.logs.Log;
import io.qameta.allure.Attachment;

public class ReportListener implements ITestListener{
	  WebDriver driver;

	    public String getTestName(ITestResult result) {
	        return result.getTestName() != null ? result.getTestName()
	                : result.getMethod().getConstructorOrMethod().getName();
	    }

	    public String getTestDescription(ITestResult result) {
	        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
	    }

	    //Text attachments for Allure
	    @Attachment(value = "{0}", type = "text/plain")
	    public static String saveTextLog(String message) {
	        return message;
	    }

	    //HTML attachments for Allure
	    @Attachment(value = "{0}", type = "text/html")
	    public static String attachHtml(String html) {
	        return html;
	    }

	    //Text attachments for Allure
	    @Attachment(value = "Page screenshot", type = "image/png")
	    public byte[] saveScreenshotPNG(WebDriver driver) {
	        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	    }

	    @Override
	    public void onStart(ITestContext iTestContext) {
	        driver = CommonBase.getDriver();
	        Log.info("Start testing " + iTestContext.getName());
	     
	    }

	    @Override
	    public void onFinish(ITestContext iTestContext) {
	        Log.info("End testing " + iTestContext.getName());
	
	    }

	    @Override
	    public void onTestStart(ITestResult iTestResult) {
	        Log.info(getTestName(iTestResult) + " test is starting...");
	        ExtentTestManager.saveToReport(iTestResult.getName(), iTestResult.getTestName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult iTestResult) {
	        Log.info(getTestName(iTestResult) + " test is passed.");
	        //ExtentReports log operation for passed tests.
	        ExtentTestManager.logMessage(Status.PASS, getTestDescription(iTestResult));
	    }

	    @Override
	    public void onTestFailure(ITestResult iTestResult) {
	        driver = CommonBase.getDriver();

	        Log.error(getTestName(iTestResult) + " test is failed.");

	        ExtentTestManager.addScreenshot(Status.FAIL, getTestName(iTestResult));

	        ExtentTestManager.logMessage(Status.FAIL, iTestResult.getThrowable().toString());
	        ExtentTestManager.logMessage(Status.FAIL, iTestResult.getName() + " is failed.");

	        //Allure Screenshot custom
	        Log.error("Screenshot captured for test case: " + getTestName(iTestResult));
	        saveScreenshotPNG(driver);
	        //Save a log on Allure report.
	        saveTextLog(getTestName(iTestResult) + " failed and screenshot taken!");
	    }

	    @Override
	    public void onTestSkipped(ITestResult iTestResult) {
	        Log.warn(getTestName(iTestResult) + " test is skipped.");
	        ExtentTestManager.logMessage(Status.SKIP, getTestName(iTestResult) + " test is skipped.");
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
	        Log.error("Test failed but it is in defined success ratio " + getTestName(iTestResult));
	        ExtentTestManager.logMessage("Test failed but it is in defined success ratio " + getTestName(iTestResult));
	    }
}
