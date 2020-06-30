package ru.atikhomirov.geekbrains.at.pom.base.fragment;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.hamcrest.Matcher;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import ru.atikhomirov.geekbrains.at.pom.base.ContentPage;

import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class Search implements IOwnedFragment {
    private ContentPage ownerPage;

    private final SelenideElement inputSearch =
            $("input[class=\"search-panel__search-field\"]");

    private final SelenideElement buttonCloseSearch =
            $("[class=\"search-panel__search-reset\"]");

    public enum Tab {
        Everywhere(
                "Везде",
                $("[class='search-page-tabs'] [data-tab='all']")
        ),
        Professions(
                "Профессии",
                $("[class=\"search-page-tabs\"] [data-tab=\"professions\"]")
        ),
        Courses(
                "Курсы",
                $("[class=\"search-page-tabs\"] [data-tab=\"courses\"]")
        ),
        Webinars(
                "Вебинары",
                $("[class=\"search-page-tabs\"] [data-tab=\"webinars\"]")
        ),
        Blogs(
                "Блоги",
                $("[class=\"search-page-tabs\"] [data-tab=\"blogs\"]")
        ),
        Forums(
                "Форумы",
                $("[class=\"search-page-tabs\"] [data-tab=\"forums\"]")
        ),
        Tests(
                "Тесты",
                $("[class=\"search-page-tabs\"] [data-tab=\"tests\"]")
        ),
        Companies(
                "Компании",
                $("[class='search-page-tabs'] [data-tab='companies']")
        );

        private final String text;
        private final SelenideElement element;

        Tab(String name, SelenideElement element) {
            this.text = name;
            this.element = element;
        }

        public String getName() {
            return text;
        }
    }

    @Step("Ввести поисковый запрос \"{text}\"")
    public Search enterSearchText(String text) {
        inputSearch.setValue(text).pressEnter();
        return this;
    }

    @Step("Проверка элемента {tab} на соответствие условию {matcher}")
    public Search checkCount(Tab tab, Matcher<Integer> matcher) {
        String actualCount = tab.element.waitUntil(Condition.visible, 15000).find(By.cssSelector("span")).getText();
        assertThat(Integer.parseInt(actualCount), matcher);
        return this;
    }

    @Step("Закрыть поиск")
    public ContentPage clickCloseSearch() {
        buttonCloseSearch.click();
        return ownerPage;
    }

    @Override
    public void setOwner(ContentPage ownerPage) {
        this.ownerPage = ownerPage;
    }
}
