package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ZooartBasketPage {

    SelenideElement deliveryPrice = $(By.xpath("//*[@id=\"content\"]/div[4]/div/div[2]/div[1]/div[2]"));

    public void isDeliveryPriceFree(){
        deliveryPrice.shouldHave(Condition.matchText("gratis!"));
    }
}
