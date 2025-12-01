import org.testng.annotations.Test;
import pageObjectModel.WeeklySaving;

public class weeklySavingsFlow {

    @Test(dependsOnMethods = "LoginFlow.onboardingVideoScreenFlow")
    public void weeklySavings() throws InterruptedException{
        WeeklySaving WS=new WeeklySaving();
        WS.setWeeklySaving("100");
        WS.stopWeeklySaving();
    }
}
