package pageObjectModel;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import static locaters.elementLocators.homeTab;
import static locaters.elementLocators.saveInstantlyCTA;
import static utilsPackage.waitUtils.waitForPresenceElementLocated;

@Slf4j
public class buyGoldFromFloatingCTA {

    public void instantSaveScreen(){
        try {
            WebElement instantSave=waitForPresenceElementLocated(saveInstantlyCTA);
            instantSave.click();
        }
        catch (TimeoutException e){
            waitForPresenceElementLocated(homeTab);
            log.info("HomeScreen Redirected");
        }

    }
}
