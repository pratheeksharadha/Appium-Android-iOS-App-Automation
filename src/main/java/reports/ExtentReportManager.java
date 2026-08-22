package reports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import config.ConfigManager;

public class ExtentReportManager {

    private ExtentReportManager() {
    }

    public static void initializeReport() {

        ExtentSparkReporter sparkReporter =
                new ExtentSparkReporter("${sys:user.dir}/reports/framework-${date:yyyy-MM-dd}.html");

        ExtentManager.getExtentReports()
                .attachReporter(sparkReporter);
        ExtentManager.getExtentReports()
                .setSystemInfo("Platform", ConfigManager.getPlatform());

        ExtentManager.getExtentReports()
                .setSystemInfo("Automation", ConfigManager.getAutomationName());
        ExtentManager.getExtentReports()
                .setSystemInfo("Environment", ConfigManager.getEnvironment());

        ExtentManager.getExtentReports()
                .setSystemInfo("Execution", ConfigManager.getExecution());

    }

    public static void flushReport() {
        ExtentManager.getExtentReports().flush();
    }
}
