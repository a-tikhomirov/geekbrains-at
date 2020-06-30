package ru.atikhomirov.geekbrains.at.pom.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;

@Component
public class AuthPage {

    @Autowired
    private MainPage mainPage;

    private final SelenideElement inputEmail =
            $("input[name=\"user[email]\"]");

    private final SelenideElement inputPassword =
            $("input[name=\"user[password]\"]");

    private final SelenideElement buttonLogin =
            $("[data-testid=\"login-submit\"]");

    @Step("Авторизоваться с данными {email} / {passwd}")
    public MainPage login(String email, String passwd) {
        inputEmail.shouldBe(Condition.enabled).setValue(email);
        inputPassword.shouldBe(Condition.enabled).setValue(passwd);
        buttonLogin.shouldBe(Condition.enabled).click();
        return mainPage;
    }
}
