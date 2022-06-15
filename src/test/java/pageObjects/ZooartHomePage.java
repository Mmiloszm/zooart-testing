package pageObjects;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class ZooartHomePage {

    public SelenideElement loginOrRegisterButton =   $(By.className("icon-user"));
    SelenideElement searchLabel = $(By.id("menu_search_text"));
    public SelenideElement searchButton = $(By.className("icon-search"));
    public SelenideElement expandBasketButton = $(By.id("projector_button_basket"));
    public SelenideElement basketButton = $(By.className("bsk_wrap"));
    public SelenideElement advancedSearchButton = $(By.linkText("Wyszukiwanie zaawansowane"));

    public ZooartHomePage open(){
        Selenide.open("https://zooart.com.pl/");
        return this;
    }

    public ZooartHomePage fillSearchLabel(String itemName){
        searchLabel.setValue(itemName);
        return this;
    }
}
