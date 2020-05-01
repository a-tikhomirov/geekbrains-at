package ru.atikhomirov.geekbrains.at;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ru.atikhomirov.geekbrains.at.common.BaseTest;
import ru.atikhomirov.geekbrains.at.page.CareerPage;
import ru.atikhomirov.geekbrains.at.section.Search;

import static org.hamcrest.Matchers.*;

@Feature(value = "Проверка страниц")
@Story(value = "Проверка поиска")
@DisplayName("Проверка поиска")
@Execution(ExecutionMode.CONCURRENT)
public class SearchTest extends BaseTest {

    @Description("Проверка результатов поиска по ключевому слову Java")
    @DisplayName("Проверка элементов")
    @Test
    void checkSearchResults() {
        openPage("https://geekbrains.ru/career");
        new CareerPage()
                .getHeader().clickSearch()
                .enterSearchText("Java")
                .checkCount(Search.Tab.Professions, greaterThanOrEqualTo(2))
                .checkCount(Search.Tab.Courses, greaterThan(15))
                .checkCount(Search.Tab.Webinars, allOf(
                        greaterThan(180),
                        lessThan(300)
                ))
                .checkCount(Search.Tab.Blogs, greaterThan(300))
                .checkCount(Search.Tab.Forums, not(350))
                .checkCount(Search.Tab.Tests, not(0));
    }
}
