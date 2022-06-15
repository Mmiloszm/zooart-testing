package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class ZooartRegisterPage {

    SelenideElement passLabel = $(By.id("client_password"));
    SelenideElement repeatPassLabel = $(By.id("repeat_password"));
    SelenideElement invalidPass = $("#client_new_login > div > div:nth-child(3) > div > span.help-block.validate_message.text-danger");

    public void checkIfInformationOfInvalidPassExist(){
        invalidPass.should(Condition.exist);
    }

    public ZooartRegisterPage setPassword(String pass){
        passLabel.setValue(pass);
        return this;
    }

    public ZooartRegisterPage repeatPassword(String pass){
        repeatPassLabel.setValue(pass);
        return this;
    }
}
