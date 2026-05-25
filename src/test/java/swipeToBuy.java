import basePackage.driverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.buyGoldSwipeToBuy;

public class swipeToBuy {

    @Test
    public void swipeToBuyInstantSave() {
        buyGoldSwipeToBuy swipe = new buyGoldSwipeToBuy();
        swipe.swipeCard();
        Assert.assertNotNull(driverFactory.driver, "Driver session lost after swipe to buy flow");
    }
}