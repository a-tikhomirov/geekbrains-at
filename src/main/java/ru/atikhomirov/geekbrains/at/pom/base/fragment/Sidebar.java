package ru.atikhomirov.geekbrains.at.pom.base.fragment;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.NotFoundException;
import org.springframework.stereotype.Component;
import ru.atikhomirov.geekbrains.at.pom.base.ContentPage;
import ru.atikhomirov.geekbrains.at.pom.base.ReturnPage;

import static com.codeborne.selenide.Selenide.$;

@Component
public class Sidebar extends ReturnPage {
    private final SelenideElement icon =
            $("[class='svg-icon icon-logo']");

    private final SelenideElement buttonCourses =
            $("[class*='main-page-hidden'] [href='/courses']");

    private final SelenideElement buttonEvents =
            $("[class*='main-page-hidden'] [href='/events']");

    private final SelenideElement buttonTopics =
            $("[class*='main-page-hidden'] [href='/topics']");

    private final SelenideElement buttonPosts =
            $("[class*='main-page-hidden'] [href='/posts']");

    private final SelenideElement buttonTests =
            $("[class*='main-page-hidden'] [href='/tests']");

    private final SelenideElement buttonCareer =
            $("[class*='main-page-hidden'] [href='/career']");

    @Step("Нажать на кнопку \"{button}\" в секции sidebar")
    public ContentPage clickButton(Button button) {
        ContentPage nextPage;
        switch (button) {
            case Courses:
                waitClickable(buttonCourses).click();
                nextPage = coursesPage();
                //nextPage = eventsPage();
                break;
            case Events:
                waitClickable(buttonEvents).click();
                nextPage = eventsPage();
                break;
            case Topics:
                waitClickable(buttonTopics).click();
                nextPage = topicsPage();
                break;
            case Posts:
                waitClickable(buttonPosts).click();
                nextPage = postsPage();
                break;
            case Tests:
                waitClickable(buttonTests).click();
                nextPage = testsPage();
                break;
            case Career:
                waitClickable(buttonCareer).click();
                nextPage = careerPage();
                break;
            default:
                throw new NotFoundException("Элемента " + button.name + " нет в классе " + getClass().getName());
        }
        return nextPage;
    }

    public enum Button {
        Courses("Курсы"),
        Events("Вебинары"),
        Topics("Форум"),
        Posts("Блог"),
        Tests("Тесты"),
        Career("Карьера");

        private final String name;

        Button(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
