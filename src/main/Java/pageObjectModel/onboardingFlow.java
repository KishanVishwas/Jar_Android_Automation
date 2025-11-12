package pageObjectModel;

import io.appium.java_client.AppiumBy;
import locaters.login_page;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static basePackage.actions.takeScreenShot;
import static basePackage.driverFactory.driver;
import static basePackage.driverFactory.wait;
import static locaters.login_page.*;


public class onboardingFlow  {

    public void langaugeSelection(){
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(langaugePageText));
           WebElement english= wait.until(ExpectedConditions.elementToBeClickable(English));
           if (english.isDisplayed()){
               System.out.println("English langauge is visible and selecting");
               english.click();
           }
           wait.until(ExpectedConditions.elementToBeClickable(applylangauge)).click();  // clicking on Apply cta after selecting ENglish language
        }
        catch (NoSuchElementException e) {
            takeScreenShot(driver,"Language selection screen");
        }
    }
    public void onboardingVidio(){
      try{
       wait.until(ExpectedConditions.elementToBeClickable(skipOnboardingvideo)).click();
       wait.until(ExpectedConditions.visibilityOf((WebElement) startSavingJoueyCTA)).click();
          System.out.println("Onboarding video as played");
        }
      catch (NoSuchElementException e){
          System.out.println("Onboarding video is not playing");
        }

      if (driver.findElement(welcomeBackText).isDisplayed()){
          driver.findElement(useOtherNumberCTA).click();
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
