import basePackage.baseSetup;
import org.testng.annotations.Test;
import pageObjectModel.onboardingFlow;

public class loginFlow extends baseSetup {

    @Test
    public void onboardingVideoScreenFlow(){
        onboardingFlow onboard=new onboardingFlow();
        onboard.langaugeSelection();
    }

}
