package ru.atikhomirov.geekbrains.at.section;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.hamcrest.Matcher;
import org.openqa.selenium.By;
import ru.atikhomirov.geekbrains.at.page.common.ContentPage;

import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.MatcherAssert.assertThat;

public class Search{
    private ContentPage ownerPage;

    private SelenideElement inputSearch =
            $("input[class=\"search-panel__search-field\"]");

    private SelenideElement buttonCloseSearch =
            $("class=\"search-panel__search-reset\"");

    private SelenideElement tabEveryWhere =
            $("[class='search-page-tabs'] [data-tab='all']");

    private SelenideElement tabProfessions =
            $("[class=\"search-page-tabs\"] [data-tab=\"professions\"]");

    private SelenideElement tabCourses =
            $("[class=\"search-page-tabs\"] [data-tab=\"courses\"]");

    private SelenideElement tabWebinars =
            $("[class=\"search-page-tabs\"] [data-tab=\"webinars\"]");

    private SelenideElement tabBlogs =
            $("[class=\"search-page-tabs\"] [data-tab=\"blogs\"]");

    private SelenideElement tabForums =
            $("[class=\"search-page-tabs\"] [data-tab=\"forums\"]");

    private SelenideElement tabTests =
            $("[class=\"search-page-tabs\"] [data-tab=\"tests\"]");

    private SelenideElement tabCompanies =
            $("[class='search-page-tabs'] [data-tab='companies']");

    private SelenideElement buttonCompaniesGeekbrains =
            $("[class*=\"search-page-block\"] [class=\"company-item__pic\"] [alt*=\"GeekBrains\"]");

    private SelenideElement getButton(Tab tab) {
        switch (tab) {
            case Everywhere:
                return tabEveryWhere;
            case Professions:
                return tabProfessions;
            case Courses:
                return tabCourses;
            case Webinars:
                return tabWebinars;
            case Blogs:
                return tabBlogs;
            case Forums:
                return tabForums;
            case Tests:
                return tabTests;
            case Companies:
                return tabCompanies;
            default:
                throw new IllegalStateException("Unexpected value: " + tab);
        }
    }

    public Search(ContentPage ownerPage) {
        this.ownerPage = ownerPage;
    }

    @Step("Ввести поисковый запрос \"{text}\"")
    public Search enterSearchText(String text) {
        inputSearch.setValue(text).pressEnter();
        return this;
    }

    @Step("Проверка элемента {tab} на соответствие условию {matcher}")
    public Search checkCount(Tab tab, Matcher<Integer> matcher) {
        String actualCount = getButton(tab).waitUntil(Condition.visible, 15000).find(By.cssSelector("span")).getText();
        assertThat(Integer.parseInt(actualCount), matcher);
        return this;
    }

    @Step("Закрыть поиск")
    public ContentPage clickCloseSearch() {
        buttonCloseSearch.click();
        return ownerPage;
    }

    public enum Tab {
        Everywhere("Везде"),
        Professions("Профессии"),
        Courses("Курсы"),
        Webinars("Вебинары"),
        Blogs("Блоги"),
        Forums("Форумы"),
        Tests("Тесты"),
        Companies("Компании");

        private String text;

        Tab(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
}
