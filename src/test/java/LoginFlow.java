import basePackage.baseSetup;
import org.testng.annotations.Test;
import pageObjectModel.onboardingFlow;

public class LoginFlow extends baseSetup {

    @Test(description = "Displaying the Onboarding and user is getting login to his account")
    public void onboardingVideoScreenFlow() {
        onboardingFlow onboard = new onboardingFlow();
        onboard.langaugeSelection();
        onboard.onboardingVideo();
        onboard.userLogin("9999911111","123456");
        onboard.userRedirectiontoHome();
    }
}
