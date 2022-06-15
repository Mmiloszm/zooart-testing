package pageObjects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class ZooartFavoritePage {

    ElementsCollection allFavoriteItems = $$(By.className("basket_name"));

    public void checkIfItemIsVisibleInFavoriteList(String itemName){
        allFavoriteItems.shouldHave(CollectionCondition.itemWithText(itemName));
    }
}
