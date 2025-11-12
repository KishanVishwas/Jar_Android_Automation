package pageObjectModel;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static basePackage.actions.takeScreenShot;
import static basePackage.driverFactory.driver;
import static basePackage.driverFactory.wait;

public class onboardingFlow {

    public void langaugeSelection(){
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Choose the app language you prefer.\"]")));
           WebElement english= wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text=\"English\"]")));
           if (english.isDisplayed()){
               System.out.println("English langauge is visible and selecting");
               english.click();
           }
           wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View[2]"))).click();  // clicking on Apply cta after selecting ENglish language
        }
        catch (NoSuchElementException e) {

            takeScreenShot(driver,"Language selection screen");
        }

    }
}
