package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class ZooartAdvancedSearchingPage {

    public SelenideElement maxPriceLabel = $(By.id("pricelimitmax"));
    public SelenideElement expandSortByMenu = $(By.id("s_list_5"));
    public SelenideElement selectSortByPrice = $(By.linkText("Cenie"));
    public SelenideElement sortHighToLow = $(".n59070_price_sub");
    public SelenideElement searchButton =  $(".btn:nth-child(4)");

    public ZooartAdvancedSearchingPage setMaxPrice(String price){
        maxPriceLabel.setValue(price);
        return this;
    }
}
