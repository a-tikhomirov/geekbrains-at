package ru.atikhomirov.geekbrains.at;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.springframework.beans.factory.annotation.Autowired;
import ru.atikhomirov.geekbrains.at.common.BaseTest;
import ru.atikhomirov.geekbrains.at.pom.page.AuthPage;

@Feature(value = "Проверка страниц")
@Story(value = "Проверка авторизации")
@DisplayName("Проверка авторизации")
@Execution(ExecutionMode.CONCURRENT)
public class AuthTest extends BaseTest {

    @Autowired
    private AuthPage authPage;

    private String login = "hao17583@bcaoo.com";
    private String password = "hao17583";

    @Description("Проверка авторизации на странице https://geekbrains.ru/login")
    @DisplayName("Проверка отображения страницы \"Главная\"")
    @Test
    public void checkMain(){
        openPage("https://geekbrains.ru/login");
        authPage.login(login, password)
                .header().checkTitle("Главная");
    }
}
