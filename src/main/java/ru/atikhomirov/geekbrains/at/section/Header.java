package ru.atikhomirov.geekbrains.at.section;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.atikhomirov.geekbrains.at.page.common.ContentPage;
import ru.atikhomirov.geekbrains.at.page.common.PageObject;

public class Header extends PageObject {
    private ContentPage ownerPage;

    @FindBy(css = "[id=\"top-menu\"]")
    protected WebElement section;

    @FindBy(css = "[class=\"gb-header__title\"]")
    protected WebElement labelHeader;

    @FindBy(css = "[class*=\"gb-header\"] a[class=\"show-search-form\"]")
    protected WebElement buttonSearch;

    public Header(WebDriver driver, ContentPage ownerPage) {
        super(driver);
        this.ownerPage = ownerPage;
    }

    @Step("Проверить элементы страницы в секции header")
    public ContentPage checkSection() {
        checkElementDisplayed(new WebElement[] {
                section,
                buttonSearch
        });
        return ownerPage;
    }

    @Step("Проверить, что текст заголовка страницы соответствует тексту: \"{expectedTitle}\"")
    public ContentPage checkTitle(String expectedTitle) {
        checkText(labelHeader, expectedTitle);
        return ownerPage;
    }

    @Step("Нажать кнопку поиска в секции header")
    public Search clickSearch() {
        buttonSearch.click();
        return new Search(driver, ownerPage);
    }
}
