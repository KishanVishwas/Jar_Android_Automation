package pageObjectModel;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static basePackage.driverFactory.driver;
import static basePackage.driverFactory.wait;
import static locaters.login_page.*;


public class onboardingFlow  {

    public void langaugeSelection(){
        try {
            // Wait for the language screen to load
            wait.until(ExpectedConditions.presenceOfElementLocated(langaugePageText));
            // Try to find and click English
            WebElement english = driver.findElement(English);
            if (english.isDisplayed()) {
                System.out.println("✅ English is visible. Selecting English...");
                english.click();
            }
        } catch (NoSuchElementException e) {
            System.out.println("⚠️ English not found. Selecting Hindi instead...");
            try {
                WebElement hindi = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"हिंदी\"]"));
                hindi.click();
                System.out.println("✅ Hindi selected successfully.");
            } catch (Exception ex) {
                System.out.println("❌ Hindi also not found!");
            }
        }
        try {
            WebElement applyBtn = driver.findElement(AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View[2]"));
            applyBtn.click();
            System.out.println("▶️ Clicked Apply button.");
        } catch (Exception ex) {
            System.out.println("⚠️ Apply button not found or not clickable yet.");
        }
    }
    public void onboardingVideo(){
      try{
       wait.until(ExpectedConditions.elementToBeClickable(skipOnboardingvideo)).click();
       wait.until(ExpectedConditions.presenceOfElementLocated(startSavingJoueyCTA)).click();
          System.out.println("Onboarding video as played");
        }
      catch (NoSuchElementException e){
          System.out.println("Onboarding video is not playing");
        }

      if (driver.findElement(welcomeBackText).isDisplayed()){
          wait.until(ExpectedConditions.elementToBeClickable(useOtherNumberCTA)).click();
      }
        WebElement NonOfAbove = driver.findElement(nonOfTheAbove);
        if (NonOfAbove.isDisplayed()) {
            NonOfAbove.click();
        }
    }
    public void userLogin(){
        WebElement NonOfAbove = driver.findElement(nonOfTheAbove);
        if (NonOfAbove.isDisplayed()) {
            NonOfAbove.click();
        }
    }
}
