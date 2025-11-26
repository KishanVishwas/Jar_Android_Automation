package basePackage;

import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static basePackage.driverFactory.driver;

@Slf4j
public class actions {
    public static void takeScreenShot(AppiumDriver driver, String fileName) {
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String path = System.getProperty("user.home") + "/Desktop/Screenshot_" + fileName + "_" + timeStamp + ".png";

        try {
            FileHandler.copy(screenShot, new File(path));
            log.info("new file saved at {}", path);
        } catch (IOException e) {
            log.info("Failed to save screenshot: {}", e.getMessage());
        }

    }

    public static void closeKeyboard() {
        driver.executeScript("mobile: performEditorAction", Map.of("action", "done"));
    }
}
