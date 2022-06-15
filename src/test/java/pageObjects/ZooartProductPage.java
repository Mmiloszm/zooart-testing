package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class ZooartProductPage {

    SelenideElement productPrice = $(By.id("projector_price_value"));

    public float convertSoloPriceToFloat(){
        String price = productPrice.getText();
        price = price.
                replaceAll("[^\\,0123456789]","").
                replace(",", ".");
        return Float.parseFloat(price);
    }

}
