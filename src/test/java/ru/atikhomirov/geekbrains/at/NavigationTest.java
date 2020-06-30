package ru.atikhomirov.geekbrains.at;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import ru.atikhomirov.geekbrains.at.common.BaseTest;
import ru.atikhomirov.geekbrains.at.pom.base.fragment.Sidebar;
import ru.atikhomirov.geekbrains.at.pom.page.CareerPage;

@Feature(value = "Проверка страниц")
@Story(value = "Проверка навигации")
@DisplayName("Проверка навигации")
@Execution(ExecutionMode.CONCURRENT)
public class NavigationTest extends BaseTest {

    @Autowired
    private CareerPage careerPage;

    static Sidebar.Button[] stringProvider() {
        return  Sidebar.Button.values();
    }

    @Description("Проверка элементов навигации sidebar страницы https://geekbrains.ru/career")
    @DisplayName("Проверка элементов и заголовка Header, проверка элементов Footer")
    @ParameterizedTest(name = "{index} ==> Проверка перехода на страницу \"{0}\"...")
    @MethodSource("stringProvider")
    void checkSideBarNavigation(Sidebar.Button button) {
        openPage("https://geekbrains.ru/career");
        careerPage
                .sidebar().clickButton(button)
                .header().checkSection()
                .header().checkTitle(button.getName())
                .footer().checkSocialLinks()
                .footer().checkButtons();
    }
}
