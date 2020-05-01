package ru.atikhomirov.geekbrains.at.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class AuthPage {
    private SelenideElement inputEmail =
            $("input[name=\"user[email]\"]");

    private SelenideElement inputPassword =
            $("input[name=\"user[password]\"]");

    private SelenideElement buttonLogin =
            $("[data-testid=\"login-submit\"]");

    @Step("Авторизоваться с данными {email} / {passwd}")
    public MainPage login(String email, String passwd) {
        inputEmail.shouldBe(Condition.enabled).setValue(email);
        inputPassword.shouldBe(Condition.enabled).setValue(passwd);
        buttonLogin.shouldBe(Condition.enabled).click();
        return page(MainPage.class);
    }
}
