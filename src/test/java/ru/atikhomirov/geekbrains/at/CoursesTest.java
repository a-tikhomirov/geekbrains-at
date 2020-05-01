package ru.atikhomirov.geekbrains.at;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ru.atikhomirov.geekbrains.at.common.BaseTest;
import ru.atikhomirov.geekbrains.at.page.AuthPage;
import ru.atikhomirov.geekbrains.at.page.courses.CoursesPage;
import ru.atikhomirov.geekbrains.at.page.courses.HeaderNavTab;
import ru.atikhomirov.geekbrains.at.section.Sidebar;

@Feature(value = "Проверка страниц")
@Story(value = "Проверка страницы Курсы")
@DisplayName("Проверка страницы Курсы")
@Execution(ExecutionMode.CONCURRENT)
public class CoursesTest extends BaseTest {
    private String login = "hao17583@bcaoo.com";
    private String password = "hao17583";

    @Description("Проверка результатов фильтрации на странице https://geekbrains.ru/courses")
    @DisplayName("Проверка результатов фильтрации")
    @Test()
    void checkCourses() {
        openPage("https://geekbrains.ru/login");
        ((CoursesPage) new AuthPage()
                .login(login, password)
                .getSidebar().clickButton(Sidebar.Button.Courses)
                .getHeader().checkTitle("Курсы")
        )
                .getHeaderNavTab().clickButton(HeaderNavTab.Button.Courses)
                .setFilter(true, "Бесплатные", "Тестирование")
                .checkDisplayedCourses("Тестирование ПО. Уровень 1", "Тестирование ПО. Уровень 2");
    }

}
