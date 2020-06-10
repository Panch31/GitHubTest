package util;

import io.qameta.allure.Attachment;
import managers.AppManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;

public class TestListener implements ITestListener {

        @Override
        public void onTestStart(ITestResult result) {
// TODO Auto-generated method stub
        }

        @Override
        public void onTestSuccess(ITestResult result) {
// TODO Auto-generated method stub
            System.out.println("Success of test cases and its details are : "+result.getName());
        }

        @Override
        public void onTestFailure(ITestResult result) {
        makeScreenshot();
        System.out.println("Started");
        if (result.getThrowable()!=null) {
            result.getThrowable().printStackTrace();
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] makeScreenshot() {
        return ((TakesScreenshot) AppManager.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

        @Override
        public void onTestSkipped(ITestResult result) {
            System.out.println("Skip of test cases and its details are : "+result.getName());
        }

        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
// TODO Auto-generated method stub
            System.out.println("Failure of test cases and its details are : "+result.getName());
        }

        @Override
        public void onStart(ITestContext context) {
// TODO Auto-generated method stub
        }

        @Override
        public void onFinish(ITestContext context) {
// TODO Auto-generated method stub
        }
    }
//    @Override
//    public void onTestFailure(ITestResult result) {
//        makeScreenshot();
//        System.out.println("Started");
//        if (result.getThrowable()!=null) {
//            result.getThrowable().printStackTrace();
//        }
//    }
//
//    @Attachment(value = "Page screenshot", type = "image/png")
//    private byte[] makeScreenshot() {
//        return ((TakesScreenshot) AppManager.getWebDriver()).getScreenshotAs(OutputType.BYTES);
//    }