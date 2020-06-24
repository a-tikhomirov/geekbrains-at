package ru.atikhomirov.geekbrains.at.section;

import io.qameta.allure.Step;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.atikhomirov.geekbrains.at.page.CareerPage;
import ru.atikhomirov.geekbrains.at.page.common.ContentPage;
import ru.atikhomirov.geekbrains.at.page.common.PageAsserts;
import ru.atikhomirov.geekbrains.at.page.courses.CoursesPage;

public class Sidebar extends PageAsserts {
    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/courses\"]")
    private WebElement buttonCourses;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/events\"]")
    private WebElement buttonEvents;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/topics\"]")
    private WebElement buttonTopics;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/posts\"]")
    private WebElement buttonPosts;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/tests\"]")
    private WebElement buttonTests;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/career\"]")
    private WebElement buttonCareer;

    public Sidebar(WebDriver driver) {
        super(driver);
    }

    @Step("Нажать на кнопку \"{button}\" в секции sidebar")
    public ContentPage clickButton(Button button) {
        switch (button) {
            case Courses:
                buttonCourses.click();
                return new CoursesPage(driver);
            case Events:
                buttonEvents.click();
                break;
            case Topics:
                buttonTopics.click();
                break;
            case Posts:
                buttonPosts.click();
                break;
            case Tests:
                buttonTests.click();
                break;
            case Career:
                buttonCareer.click();
                return new CareerPage(driver);
            default:
                throw new NotFoundException("Элемента " + button.name + " нет в классе " + getClass().getName());
        }
        return new ContentPage(driver);
    }

    public enum Button {
        Courses("Курсы"),
        Events("Вебинары"),
        Topics("Форум"),
        Posts("Блог"),
        Tests("Тесты"),
        Career("Карьера");

        private String name;

        Button(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
