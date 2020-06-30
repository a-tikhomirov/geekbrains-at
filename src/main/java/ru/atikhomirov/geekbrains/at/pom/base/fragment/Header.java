package ru.atikhomirov.geekbrains.at.pom.base.fragment;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.atikhomirov.geekbrains.at.pom.base.ContentPage;

import static com.codeborne.selenide.Selenide.$;

@Component
public class Header implements IOwnedFragment {
    private ContentPage ownerPage;

    @Autowired
    private Search search;

    private final SelenideElement section =
            $(By.id("top-menu"));

    private final SelenideElement labelHeader =
            $(By.className("gb-header__title"));

    private final SelenideElement buttonSearch =
            $("[class*=\"gb-header\"] a[class=\"show-search-form\"]");

    @Step("Проверить, что текст заголовка страницы соответствует тексту: \"{expectedTitle}\"")
    public ContentPage checkTitle(String expectedTitle) {
        labelHeader.shouldBe(Condition.exactText(expectedTitle));
        return ownerPage;
    }

    @Step("Нажать кнопку поиска в секции header")
    public Search clickSearch() {
        buttonSearch.click();
        return search;
    }

    @Step("Проверить элементы страницы в секции header")
    public ContentPage checkSection() {
        section.shouldBe(Condition.visible);
        labelHeader.shouldBe(Condition.visible);
        buttonSearch.shouldBe(Condition.visible);
        return ownerPage;
    }

    @Override
    public void setOwner(ContentPage ownerPage) {
        this.ownerPage = ownerPage;
    }
}
