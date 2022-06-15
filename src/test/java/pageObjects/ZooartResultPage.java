package pageObjects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;

public class ZooartResultPage {

    public SelenideElement sortMenu = $("#s_setting_0 > .caret");
    public SelenideElement priceHighToLow = $(By.linkText("Sortuj po cenie malejąco"));
    public SelenideElement firstItem = $(By.xpath("//*[@id=\"search\"]/div[1]/div/div[3]"));
    public SelenideElement firstItemTextElement = $(By.xpath("//*[@id=\"search\"]/div[1]/div/h3/a"));
    public SelenideElement numberOfItemsMenu =  $("#s_setting_1 > .caret");
    public SelenideElement select60Items = $(By.linkText("60"));
    public SelenideElement addFirstItemToFavorite = $(".product_wrapper:nth-child(1) .icon-heart");
    public SelenideElement firstItemAfterAdvancedSearch = $(By.xpath("//*[@id=\"search\"]/div[1]/div/div[2]/span"));
    public SelenideElement favoriteList = $(".wishes_count");
    public SelenideElement randomBrand = $("#filter_producer_1331637766_box label");
    public SelenideElement numberOfItemsInCategoryInFilterTool = $("#filter_producer_val1331637766_quantity > span");
    public SelenideElement submitFilterOptions = $(By.id("filter_producer_submit"));
    public ElementsCollection visibleItemsCollection = $$(".product_wrapper");

    public float convertPriceOfFirstItem(){
        String price = firstItemAfterAdvancedSearch.getText();
        String result = price.substring(0, price.indexOf("\n"));
        result = result.
                replaceAll("[^\\,0123456789]","").
                replace(",", ".");
        return Float.parseFloat(result);
    }

    public void checkIfThereAreGivenNumberItemsVisible(int numberOfItems){
        visibleItemsCollection.should(CollectionCondition.size(numberOfItems));
    }

    public String getFirstItemNameInUpperCase(){
        return firstItemTextElement.getText().toUpperCase(Locale.ROOT);
    }

    public int getNumberOfItemsInShopOfPrevSelectedBrand(){
        return Integer.parseInt(numberOfItemsInCategoryInFilterTool.getText());
    }

}
