package pageObjectModel;

import locaters.buyGoldFlowLocators;

import static basePackage.driverFactory.driver;
import static utilsPackage.waitUtils.dragCoinToEnd;
import static utilsPackage.waitUtils.scrollUntilElementFound;

public class buyGoldSwipeToBuy {

    buyGoldFlowLocators buyG = new buyGoldFlowLocators(driver);

    public void swipeCard(){
        scrollUntilElementFound(driver,buyG.getSwipeToBuy());
        dragCoinToEnd(buyG.getSwipeCoinElementStartPoint(),buyG.getSwipeCoinEndPoint());
        buyGoldFromFloatingCTA buy=new buyGoldFromFloatingCTA();
        buy.buyGoldAsZomatoAndNonZomato();
    }
}
