package lt.vcs.pom.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenShot(result.getName());
    }

    private void takeScreenShot(String testName) {

        if (Driver.getDriver() == null) return;

        TakesScreenshot screenshot = (TakesScreenshot) Driver.getDriver();
        File fileSrc = screenshot.getScreenshotAs(OutputType.FILE);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HH_mm_ss_SSS");

        String date = LocalDateTime.now().format(formatter);

        File fileDest = new File("screenshot/%s_screenshot_%s.png".formatted(date, testName));

        try {
            FileUtils.copyFile(fileSrc, fileDest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
