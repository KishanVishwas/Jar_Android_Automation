package basePackage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static basePackage.driverFactory.driver;
import static basePackage.driverFactory.wait;

public class actions {
    public static void takeScreenShot(AppiumDriver driver, String fileName){
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String path = System.getProperty("user.home") + "/Desktop/Screenshot_" + fileName + "_" + timeStamp + ".png";

        try {
            FileHandler.copy(screenShot, new File(path));
            System.out.println("new file saved at " + path);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }

    }
}
