import basePackage.baseSetup;
import org.testng.annotations.Test;
import pageObjectModel.WeeklySaving;
import pageObjectModel.onboardingFlow;

public class LoginFlow extends baseSetup {

    @Test(description = "Displaying the Onboarding and user is getting login to his account", priority = 1)
    public void onboardingVideoScreenFlow() throws InterruptedException {
        onboardingFlow onboard = new onboardingFlow();
         WeeklySaving  WS=  new WeeklySaving();
        onboard.langaugeSelection();
        onboard.onboardingVideo();
        onboard.userLogin("9999911111", "123456");
        onboard.userRedirectiontoHome();
    }
}
