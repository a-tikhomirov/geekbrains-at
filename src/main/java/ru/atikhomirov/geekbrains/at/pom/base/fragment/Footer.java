package ru.atikhomirov.geekbrains.at.pom.base.fragment;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;
import ru.atikhomirov.geekbrains.at.pom.base.ContentPage;

import static com.codeborne.selenide.Selenide.$;

@Component
public class Footer implements IOwnedFragment {
    private ContentPage ownerPage;

    public enum SocialNetwork {
        Facebook("Facebook",
                $("[class*=\"site-footer\"] [href*=\"facebook\"]")
        ),
        VK("VK",
                $("[class*=\"site-footer\"] [href*=\"vk\"]")
        ),
        Instagram("Instagran",
                $("[class*=\"site-footer\"] [href*=\"instagram\"]")
        ),
        Youtube("Youtube",
                $("[class*=\"site-footer\"] [href*=\"youtube\"]")
        ),
        Telegram("Telegram",
                $("[class*=\"site-footer\"] [href*=\"telegram\"]")
        );

        private final String name;
        private final SelenideElement element;

        SocialNetwork(String name, SelenideElement element) {
            this.name = name;
            this.element = element;
        }

        public String getName() {
            return name;
        }
    }

    public enum Button {
        Feedback("Отзывы",
                $("[class*=\"site-footer\"] [href=\"/feedbacks\"]")
        ),
        Help("Помощь",
                $("[class*=\"site-footer\"] [href*=\"geekbrains.zendesk.com\"]")
        ),
        About("О Проекте",
                $("[class*=\"site-footer\"] [href=\"/company\"]")
        ),
        License("Лицензия",
                $("[class*=\"site-footer\"] [href=\"/license.pdf\"]")
        ),
        Career("Вакансии",
                $("[class*=\"site-footer\"] [href=\"/career/682\"]")
        ),
        ForBusiness("Компаниям",
                $("[class*=\"site-footer\"] [href=\"https://forbusiness.geekbrains.ru\"]")
        ),
        Phone("8 800 700-68-41",
                $("[class=\"site-footer__phone\"]")
        );

        private final String name;
        private final SelenideElement element;

        Button(String name, SelenideElement element) {
            this.name = name;
            this.element = element;
        }

        public String getName() {
            return name;
        }
    }

    @Step("Проверить элементы страницы в секции footer")
    public ContentPage checkSocialLinks(){
        for(SocialNetwork sc:SocialNetwork.values()) {
            sc.element.shouldBe(Condition.visible);
        }
        return ownerPage;
    }

    @Step("Проверить текст элементов страницы в секции footer")
    public ContentPage checkButtons() {
        for(Button btn:Button.values()) {
            btn.element.shouldBe(Condition.visible);
            btn.element.waitUntil(Condition.text(btn.name), 5000);
        }
        return ownerPage;
    }

    @Override
    public void setOwner(ContentPage ownerPage) {
        this.ownerPage = ownerPage;
    }
}
