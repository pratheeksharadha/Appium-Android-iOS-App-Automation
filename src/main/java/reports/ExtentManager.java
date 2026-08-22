package reports;

import com.aventstack.extentreports.ExtentReports;

public final class ExtentManager {

    private static final ExtentReports EXTENT_REPORTS =
            new ExtentReports();

    private ExtentManager() {
    }

    public static ExtentReports getExtentReports() {
        return EXTENT_REPORTS;
    }

}
