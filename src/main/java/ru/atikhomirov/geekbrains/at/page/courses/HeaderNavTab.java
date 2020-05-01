package ru.atikhomirov.geekbrains.at.page.courses;

import io.qameta.allure.Step;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.atikhomirov.geekbrains.at.page.common.PageObject;

public class HeaderNavTab extends PageObject {
    private CoursesPage ownerPage;

    @FindBy(css = "[class*=\"nav nav-tabs\"] [href=\"#prof-compact\"]")
    private WebElement buttonNavProfessions;

    @FindBy(css = "[class*=\"nav nav-tabs\"] [href=\"#free\"]")
    private WebElement buttonFreeIntensives;

    @FindBy(css = "[class*=\"nav nav-tabs\"] [href=\"#cour-new\"]")
    private WebElement buttonNavCourses;

    @FindBy(css = "[class*=\"nav nav-tabs\"] [href*=\"forbusiness\"]")
    private WebElement buttonForBusiness;

    public HeaderNavTab(WebDriver driver, CoursesPage ownerPage) {
        super(driver);
        this.ownerPage = ownerPage;
    }

    private WebElement getButton(Button button) {
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
        waitClickable(getButton(button)).click();
        return ownerPage;
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
