package ru.atikhomirov.geekbrains.at.section;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.NotFoundException;
import ru.atikhomirov.geekbrains.at.page.CareerPage;
import ru.atikhomirov.geekbrains.at.page.common.ContentPage;
import ru.atikhomirov.geekbrains.at.page.courses.CoursesPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class Sidebar {
    private SelenideElement icon =
            $("[class='svg-icon icon-logo']");

    private SelenideElement buttonCourses =
            $("[class*='main-page-hidden'] [href='/courses']");

    private SelenideElement buttonEvents =
            $("[class*='main-page-hidden'] [href='/events']");

    private SelenideElement buttonTopics =
            $("[class*='main-page-hidden'] [href='/topics']");

    private SelenideElement buttonPosts =
            $("[class*='main-page-hidden'] [href='/posts']");

    private SelenideElement buttonTests =
            $("[class*='main-page-hidden'] [href='/tests']");

    private SelenideElement buttonCareer =
            $("[class*='main-page-hidden'] [href='/career']");

    @Step("Нажать на кнопку \"{button}\" в секции sidebar")
    public ContentPage clickButton(Button button) {
        Class contentPage = ContentPage.class;
        switch (button) {
            case Courses:
                buttonCourses.click();
                contentPage = CoursesPage.class;
                break;
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
                contentPage = CareerPage.class;
                break;
            default:
                throw new NotFoundException("Элемента " + button.name + " нет в классе " + getClass().getName());
        }
        return (ContentPage) page(contentPage);
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
