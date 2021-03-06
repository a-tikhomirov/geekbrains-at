package ru.atikhomirov.geekbrains.at;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.atikhomirov.geekbrains.at.common.BaseTest;
import ru.atikhomirov.geekbrains.at.page.CareerPage;
import ru.atikhomirov.geekbrains.at.section.Sidebar;

@Feature(value = "Проверка страниц")
@Story(value = "Проверка навигации")
@DisplayName("Проверка навигации")
@Execution(ExecutionMode.CONCURRENT)
public class NavigationTest extends BaseTest {

    static Sidebar.Button[] stringProvider() {
        return  Sidebar.Button.values();
    }

    @Description("Проверка элементов навигации sidebar страницы https://geekbrains.ru/career")
    @DisplayName("Проверка элементов и заголовка Header, проверка элементов Footer")
    @ParameterizedTest(name = "{index} ==> Проверка перехода на страницу \"{0}\"...")
    @MethodSource("stringProvider")
    void checkSideBarNavigation(Sidebar.Button button) {
        openPage("https://geekbrains.ru/career");
        new CareerPage()
                .getSidebar().clickButton(button)
                .getHeader().checkSection()
                .getHeader().checkTitle(button.getName())
                .getFooter().checkSection()
                .getFooter().checkElementsText();
    }
}
