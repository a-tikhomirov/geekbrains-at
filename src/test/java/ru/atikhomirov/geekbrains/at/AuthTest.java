package ru.atikhomirov.geekbrains.at;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ru.atikhomirov.geekbrains.at.common.BaseTest;
import ru.atikhomirov.geekbrains.at.page.AuthPage;

@Feature(value = "Проверка страниц")
@Story(value = "Проверка авторизации")
@DisplayName("Проверка авторизации")
@Execution(ExecutionMode.CONCURRENT)
public class AuthTest extends BaseTest {
    private String login = "hao17583@bcaoo.com";
    private String password = "hao17583";

    @BeforeEach
    public void SetUp(){
        setUpChromeDriver();
        openPage("https://geekbrains.ru/login");
    }

    @Description("Проверка авторизации на странице https://geekbrains.ru/login")
    @DisplayName("Проверка отображения страницы \"Главная\"")
    @Test
    public void checkMain(){
        (new AuthPage(driver))
                .login(login, password)
                .getHeader().checkTitle("Главная");
        stopDriver();
    }

    @AfterEach
    void tearDown() {
        stopDriver();
    }
}
