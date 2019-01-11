package com.javademo.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry  implements IRetryAnalyzer {
    private int retryCount         = 0;
    private int maxRetryCount     = 2;   // retry a failed test 2 additional times

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount <maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}
