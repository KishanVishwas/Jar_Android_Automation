import org.testng.annotations.Test;
import pageObjectModel.monthlySavingsPage;

public class monthlySavings {

    @Test
    public void monthlySavingsTest() {
        monthlySavingsPage mS = new monthlySavingsPage();
        mS.monthlySavingsSetupFlow();
        mS.monthlySavingsStopFlow();
    }
}
