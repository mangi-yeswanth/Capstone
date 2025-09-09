package testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import utils.DriverManager;
import utils.ExtentReportManager;
import utils.ScreenshotUtil;

import java.io.IOException;
import java.lang.reflect.Method;

public class BaseTest {
    protected WebDriver driver;
    protected static ExtentReports extent;
    protected static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @BeforeSuite
    public void setupExtent() {
        extent = ExtentReportManager.getInstance();
    }

    @BeforeMethod
    public void setUp(Method method) {
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();

        ExtentTest extentTest = extent.createTest(method.getName());
        test.set(extentTest);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            String path = ScreenshotUtil.takeScreenshot(driver, result.getName());
            test.get().fail(result.getThrowable(),
                    MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            String path = ScreenshotUtil.takeScreenshot(driver, result.getName());
            test.get().pass("Test Passed",
                    MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        } else if (result.getStatus() == ITestResult.SKIP) {
            String path = ScreenshotUtil.takeScreenshot(driver, result.getName());
            test.get().skip("Test Skipped",
                    MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        }

        DriverManager.quitDriver();
    }

    @AfterSuite
    public void tearDownExtent() {
        if (extent != null) {
            extent.flush();
        }
    }

    // Getter for ExtentTest (optional)
    protected ExtentTest getTest() {
        return test.get();
    }
}
