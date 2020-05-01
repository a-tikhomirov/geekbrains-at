package ru.atikhomirov.geekbrains.at.section;

import io.qameta.allure.Step;
import org.hamcrest.Matcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.atikhomirov.geekbrains.at.page.common.ContentPage;
import ru.atikhomirov.geekbrains.at.page.common.PageObject;

public class Search extends PageObject {
    private ContentPage ownerPage;

    @FindBy(css = "input[class=\"search-panel__search-field\"]")
    private WebElement inputSearch;

    @FindBy(css = "class=\"search-panel__search-reset\"")
    private WebElement buttonCloseSearch;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='all']")
    private WebElement tabEveryWhere;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='professions']")
    private WebElement tabProfessions;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='courses']")
    private WebElement tabCourses;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='webinars']")
    private WebElement tabWebinars;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='blogs']")
    private WebElement tabBlogs;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='forums']")
    private WebElement tabForums;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='tests']")
    private WebElement tabTests;

    @FindBy(css = "[class='search-page-tabs'] [data-tab='companies']")
    private WebElement tabCompanies;

    private WebElement getButton(Tab tab) {
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

    public Search(WebDriver driver, ContentPage ownerPage) {
        super(driver);
        this.ownerPage = ownerPage;
    }

    @Step("Ввести поисковый запрос \"{text}\"")
    public Search enterSearchText(String text) {
        waitVisible(inputSearch).sendKeys(text);
        return this;
    }

    @Step("Закрыть поиск")
    public ContentPage clickCloseSearch() {
        waitClickable(buttonCloseSearch).click();
        return ownerPage;
    }

    @Step("Проверка элемента {tab} на соответствие условию {matcher}")
    public Search checkCount(Tab tab, Matcher<Integer> matcher) {
        checkText(getButton(tab), matcher);
        return this;
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

        public String getName() {
            return text;
        }
    }
}
