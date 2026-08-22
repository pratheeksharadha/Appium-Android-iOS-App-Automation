package utils;

import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private static final Logger logger =
            LoggerUtils.getLogger(RetryAnalyzer.class);

    private int retryCount = 0;

    private static final int MAX_RETRY_COUNT = 2;

    @Override
    public boolean retry(ITestResult result) {

        if (retryCount < MAX_RETRY_COUNT) {

            retryCount++;

            logger.info(
                    "Retrying Test : {} | Attempt : {}",
                    result.getName(),
                    retryCount);

            return true;

        }

        logger.info(
                "Maximum retry attempts reached for : {}",
                result.getName());

        return false;

    }
}