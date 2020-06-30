package ru.atikhomirov.geekbrains.at.common;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(SpringConfig.class)
public class BaseTest {
    @Step("Открыть страницу: {url}")
    public void openPage(String url) {
        Selenide.clearBrowserCookies();
        Selenide.open(url);
    }
}
