import org.testng.annotations.Test;
import pageObjectModel.buyGoldFromFloatingCTA;

public class buyGoldFlowLocker {

    @Test(dependsOnMethods = "LoginFlow.onboardingVideoScreenFlow")
    public void buyGold() {
        buyGoldFromFloatingCTA buy = new buyGoldFromFloatingCTA();
        buy.instantSaveFlow();
    }
}
