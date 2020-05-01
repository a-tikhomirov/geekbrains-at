package ru.atikhomirov.geekbrains.at.common;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

public class BaseTest {
    @Step("Открыть страницу: {url}")
    public void openPage(String url) {
        Selenide.open(url);
    }
}
