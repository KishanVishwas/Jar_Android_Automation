import basePackage.baseSetup;
import org.testng.annotations.Test;
import pageObjectModel.onboardingFlow;

public class loginFlow extends baseSetup {

    @Test
    public void onboardingVideoScreenFlow() throws InterruptedException {
        onboardingFlow onboard=new onboardingFlow();
        onboard.langaugeSelection();
        onboard.onboardingVideo();
        onboard.userLogin("9999911111", "123456");
    }
}
