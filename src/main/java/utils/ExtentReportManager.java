package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance();
        }
        return extent;
    }

    private static void createInstance() {
        String reportDir = "reports/";
        new File(reportDir).mkdirs();
        String reportName = "ExtentReport_" +
                new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".html";

        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportDir + reportName);
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("UI Test Execution");
        htmlReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }
}
