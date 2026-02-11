import org.testng.annotations.Test;
import pageObjectModel.buyGoldSwipeToBuy;

public class swipeToBuy {

    @Test
    public void swipeToBuyInstantSave(){
        buyGoldSwipeToBuy swipe=new buyGoldSwipeToBuy();
        swipe.swipeCard();
    }
}
