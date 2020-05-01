package ru.atikhomirov.geekbrains.at.page.courses;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.NotFoundException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class HeaderNavTab {

    private SelenideElement buttonNavProfessions =
            $("[class*=\"nav nav-tabs\"] [href=\"#prof-compact\"]");

    private SelenideElement buttonFreeIntensives =
            $("[class*=\"nav nav-tabs\"] [href=\"#free\"]");

    private SelenideElement buttonNavCourses =
            $("[class*=\"nav nav-tabs\"] [href=\"#cour-new\"]");

    private SelenideElement buttonForBusiness =
            $("[class*=\"nav nav-tabs\"] [href*=\"forbusiness\"]");

    private SelenideElement getButton(Button button) {
        switch (button){
            case Professions: {
                return buttonNavProfessions;
            }
            case Intensives: {
                return buttonFreeIntensives;
            }
            case Courses: {
                return buttonNavCourses;
            }
            case ForBusiness: {
                return buttonForBusiness;
            }
            default: {
                throw new NotFoundException("Элемента " + button.name + " нет в классе " + getClass().getName());
            }
        }
    }

    @Step("Нажать на кнопку \"{button}\" в секции headerNavigationTab")
    public CoursesPage clickButton(Button button){
        getButton(button).click();
        return page(CoursesPage.class);
    }

    public enum Button {
        Professions("Профессии"),
        Intensives("Бесплатные интенсивы"),
        Courses("Курсы"),
        ForBusiness("Компаниям");

        private String name;

        Button(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
