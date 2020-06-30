package ru.atikhomirov.geekbrains.at.pom.fragment;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;
import ru.atikhomirov.geekbrains.at.pom.base.Actions;

import static com.codeborne.selenide.Selenide.$;

@Component
public class CoursesHeaderNavTab extends Actions {

    @Step("Нажать на кнопку \"{button}\" в секции headerNavigationTab")
    public void clickButton(Button button){
        waitClickable(button.element).click();
    }

    public enum Button {
        Professions(
                "Профессии",
                $("[class*=\"nav nav-tabs\"] [href=\"#prof-compact\"]")),
        Intensives(
                "Бесплатные интенсивы",
                $("[class*=\"nav nav-tabs\"] [href=\"#free\"]")),
        Courses(
                "Курсы",
                $("[class*=\"nav nav-tabs\"] [href=\"#cour-new\"]")),
        ForBusiness(
                "Компаниям",
                $("[class*=\"nav nav-tabs\"] [href*=\"forbusiness\"]"));

        private String name;
        private SelenideElement element;

        Button(String name, SelenideElement element) {
            this.name = name;
            this.element = element;
        }

        public String getName() {
            return name;
        }
    }
}
