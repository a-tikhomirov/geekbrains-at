package ru.atikhomirov.geekbrains.at.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class AuthPage {
    private SelenideElement inputEmail =
            $(By.id("user_email"));

    private SelenideElement inputPassword =
            $(By.id("user_password"));

    private SelenideElement buttonLogin =
            $("[data-testid=\"login-submit\"]");

    @Step("Авторизоваться с данными {email} / {passwd}")
    public MainPage login(String email, String passwd) {
        inputEmail.setValue(email);
        inputPassword.setValue(passwd);
        buttonLogin.click();
        return page(MainPage.class);
    }
}
