package ru.atikhomirov.geekbrains.at.section;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.atikhomirov.geekbrains.at.page.common.ContentPage;

import static com.codeborne.selenide.Selenide.$;

public class Header {
    private ContentPage ownerPage;

    private SelenideElement section =
            $(By.id("top-menu"));

    private SelenideElement labelHeader =
            $(By.className("gb-header__title"));

    private SelenideElement buttonSearch =
            $("[class*=\"gb-header\"] a[class=\"show-search-form\"]");

    public Header(ContentPage ownerPage) {
        this.ownerPage = ownerPage;
    }

    @Step("Проверить, что текст заголовка страницы соответствует тексту: \"{expectedTitle}\"")
    public ContentPage checkTitle(String expectedTitle) {
        labelHeader.shouldBe(Condition.exactText(expectedTitle));
        return ownerPage;
    }

    @Step("Нажать кнопку поиска в секции header")
    public Search clickSearch() {
        buttonSearch.click();
        return ownerPage.getSearch();
    }

    @Step("Проверить элементы страницы в секции header")
    public ContentPage checkSection() {
        section.isDisplayed();
        labelHeader.isDisplayed();
        buttonSearch.isDisplayed();
        return ownerPage;
    }
}
