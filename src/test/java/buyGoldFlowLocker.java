import org.testng.annotations.Test;
import pageObjectModel.buyGoldFromFloatingCTA;

public class buyGoldFlowLocker {

    @Test()
    public void buyGold() {
        buyGoldFromFloatingCTA buy = new buyGoldFromFloatingCTA();
        buy.instantSaveScreen();
        buy.amountEntering();
    }
}
