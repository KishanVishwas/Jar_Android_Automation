import org.testng.annotations.Test;
import pageObjectModel.dailySavingsPOM;

public class dailySavingsFlow {

    @Test(dependsOnMethods = "LoginFlow.onboardingVideoScreenFlow")
    public void dailySavings(){
        dailySavingsPOM ds=new dailySavingsPOM();
        ds.setupDailySaving();
//        ds.stopDailySaving();

    }
}
