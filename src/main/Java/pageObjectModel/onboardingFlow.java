package pageObjectModel;

import io.appium.java_client.AppiumBy;
import static utilsPackage.waitUtils.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import static basePackage.driverFactory.driver;
import static locaters.elementLocators.*;
public class onboardingFlow  {
    public void langaugeSelection(){
        try {
            // Wait for the language screen to load
            waitForPresenceElementLocated(langaugePageText);
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
       waitForElementToBeClickable(skipOnboardingvideo).click();
//          waitForPresenceElementLocated(startSavingJoueyCTA).click();
          System.out.println("Onboarding video as played");
        }
      catch (NoSuchElementException e){
          System.out.println("Onboarding video is not playing");
        }

      if (waitForPresenceElementLocated(welcomeBackText).isDisplayed()){
          waitForElementToBeClickable(useOtherNumberCTA).click();
      }
        WebElement NonOfAbove = driver.findElement(nonOfTheAbove);
        if (NonOfAbove.isDisplayed()) {
            NonOfAbove.click();
        }
    }
    public void userLogin(String number, String OTP){
        WebElement phnArea=driver.findElement(phoneNumberTextField);
        phnArea.click();
        phnArea.sendKeys(number);
        waitForElementToBeClickable(sendOtpCTA).click();
        WebElement otpArea=waitForElementToBeClickable(enterOtpTextArea);
        otpArea.sendKeys(OTP);
        waitForElementToBeClickable(verifyOtpCTA).click();
    }
}
