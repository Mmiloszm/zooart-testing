package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ZooartLoginPage {

    SelenideElement username = $(By.id("signin_login_input"));
    SelenideElement password = $(By.id("signin_pass_input"));
    public SelenideElement loginButton = $(".btn.signin_button");
    SelenideElement invalidLoginOrPassword = $(By.className("return_label"));
    public SelenideElement registerFormButton = $("#signin-form_box_left > div > a");

    public ZooartLoginPage setUsername(String strUserName) {
        username.setValue(strUserName);
        return this;
    }

    public ZooartLoginPage setPassword(String strPassword) {
        password.setValue(strPassword);
        return this;
    }

    public void badLoginOrPassInfoVisible() {
        invalidLoginOrPassword.shouldHave(Condition.matchText("nie jest poprawne."));
    }
}
