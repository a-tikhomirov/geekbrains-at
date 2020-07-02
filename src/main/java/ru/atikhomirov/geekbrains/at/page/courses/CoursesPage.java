package ru.atikhomirov.geekbrains.at.page.courses;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.atikhomirov.geekbrains.at.page.common.ContentPage;

import static com.codeborne.selenide.Selenide.$$;

public class CoursesPage extends ContentPage {

    private HeaderNavTab headerNavTab;

    private ElementsCollection filters =
            $$(By.xpath("//div[@class=\"course-filter-wrapper\"]//li[@class=\"list-group-item\"]"));

    private ElementsCollection courses =
            $$(By.xpath("//div[@class=\"course-cards-wrapper\"]//div[@class=\"gb-course-card__title-wrapper\"]"));

    protected SelenideElement getElementFromCollection(ElementsCollection collection, Condition condition) {
        return collection.findBy(condition);
    }

    public CoursesPage() {
        super();
        headerNavTab = new HeaderNavTab();
    }

    @Step("Установить в [{state}] фильтры: {args}")
    public CoursesPage setFilter(boolean state, String... args) {
        for (String filterName : args) {
            SelenideElement checkBox = getElementFromCollection(filters, Condition.text(filterName))
                    .waitUntil(Condition.visible, 5000)
                    .waitUntil(Condition.enabled, 5000)
                    .find(By.className("js-checkbox"));
            if (checkBox.is(Condition.selected) != state) {
                checkBox.click();
            }
        }
        return this;
    }

    @Step("Проверить наличие курсов: {args}")
    public CoursesPage checkDisplayedCourses(String... args) {
        for (String expectedCourse : args) {
            getElementFromCollection(courses, Condition.text(expectedCourse)).shouldBe(Condition.visible);
        }
        return this;
    }

    public HeaderNavTab getHeaderNavTab() {
        return headerNavTab;
    }
}
