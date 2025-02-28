package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class testlistener extends common_actions implements ITestListener{

    public static ExtentReports extent = new ExtentReports();
    private static ExtentSparkReporter reporter = new ExtentSparkReporter("./reports/SecuritEase_Execution_Report_"+generateDateTimeString()+".html");


    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        ITestListener.super.onTestSuccess(iTestResult);
        String passedTest = iTestResult.getMethod().getDescription();
        reporter.config().setDocumentTitle("SecuritEase Execution Results");
        reporter.config().setReportName("SecuritEase Execution Results");
        reporter.config().setTheme(Theme.DARK);
        takeScreenshot(passedTest);
        extent.attachReporter(reporter);
        extent.createTest(passedTest).assignAuthor("Mlungisi_Mbele").assignCategory("Health_Check").log(Status.PASS,passedTest+" executed successfully")
                .info(MediaEntityBuilder.createScreenCaptureFromPath(passedTest+".png").build());
        extent.flush();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        ITestListener.super.onTestFailure(iTestResult);
        String failedTest = iTestResult.getMethod().getDescription();
        reporter.config().setDocumentTitle("SecuritEase Execution Results");
        reporter.config().setReportName("SecuritEase Execution Results");
        reporter.config().setTheme(Theme.DARK);
        takeScreenshot(failedTest);
        extent.attachReporter(reporter);
        extent.createTest(failedTest).assignAuthor("Mlungisi_Mbele").assignCategory("Health_Check").log(Status.FAIL,failedTest+" was unsuccessful. see logs/stacktrace for errors")
                .info(MediaEntityBuilder.createScreenCaptureFromPath(failedTest+".png").build());
        extent.flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onStart(ITestContext iTestResult) {
        ITestListener.super.onStart(iTestResult);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }

}