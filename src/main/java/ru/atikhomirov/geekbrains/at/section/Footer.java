package ru.atikhomirov.geekbrains.at.section;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.atikhomirov.geekbrains.at.page.common.ContentPage;

import static com.codeborne.selenide.Selenide.$;

public class Footer {
    private ContentPage ownerPage;

    private SelenideElement section =
            $("[class=\"site-footer\"]");

    private SelenideElement buttonFacebook =
            $("[class*=\"site-footer\"] [href*=\"facebook\"]");

    private SelenideElement buttonVK =
            $("[class*=\"site-footer\"] [href*=\"vk\"]");

    private SelenideElement buttonInstagramm =
            $("[class*=\"site-footer\"] [href*=\"instagram\"]");

    private SelenideElement buttonYoutube =
            $("[class*=\"site-footer\"] [href*=\"youtube\"]");

    private SelenideElement buttonTelegram =
            $("[class*=\"site-footer\"] [href*=\"telegram\"]");

    private SelenideElement buttonFeedbacks =
            $("[class*=\"site-footer\"] [href=\"/feedbacks\"]");

    private SelenideElement buttonHelp =
            $("[class*=\"site-footer\"] [href*=\"geekbrains.zendesk.com\"]");

    private SelenideElement buttonAbout =
            $("[class*=\"site-footer\"] [href=\"/company\"]");

    private SelenideElement buttonLiscense =
            $("[class*=\"site-footer\"] [href=\"/license.pdf\"]");

    private SelenideElement buttonCareer =
            $("[class*=\"site-footer\"] [href=\"/career/682\"]");

    private SelenideElement buttonForBusiness =
            $("[class*=\"site-footer\"] [href=\"https://forbusiness.geekbrains.ru\"]");

    private SelenideElement buttonPhone =
            $("[class=\"site-footer__phone\"]");

    public Footer(ContentPage ownerPage) {
        this.ownerPage = ownerPage;
    }

    @Step("Проверить элементы страницы в секции footer")
    public ContentPage checkSection(){
        section.isDisplayed();
        buttonFacebook.isDisplayed();
        buttonVK.isDisplayed();
        buttonInstagramm.isDisplayed();
        buttonYoutube.isDisplayed();
        buttonTelegram.isDisplayed();
        buttonFeedbacks.isDisplayed();
        buttonHelp.isDisplayed();
        buttonAbout.isDisplayed();
        buttonLiscense.isDisplayed();
        buttonCareer.isDisplayed();
        buttonForBusiness.isDisplayed();
        buttonPhone.isDisplayed();
        return ownerPage;
    }

    @Step("Проверить текст элементов страницы в секции footer")
    public ContentPage checkElementsText() {
        buttonFeedbacks.waitUntil(Condition.text("Отзывы"), 5000);
        buttonHelp.waitUntil(Condition.text("Помощь"),5000);
        buttonAbout.waitUntil(Condition.text("О проекте"),5000);
        buttonLiscense.waitUntil(Condition.text("Лицензия"),5000);
        buttonCareer.waitUntil(Condition.text("Вакансии"),5000);
        buttonForBusiness.waitUntil(Condition.text("Компаниям"),5000);
        buttonPhone.waitUntil(Condition.text("8 800 700-68-41"),5000);
        return ownerPage;
    }
}
