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
        Condition clickable = Condition.and("can be clicked", Condition.visible, Condition.enabled);
        return collection.findBy(condition).waitUntil(clickable, 5000);
    }

    public CoursesPage() {
        super();
        headerNavTab = new HeaderNavTab();
    }

    @Step("Установить в [{state}] фильтры: {args}")
    public CoursesPage setFilter(boolean state, String... args) {
        for (String filterName : args) {
            SelenideElement checkBox = getElementFromCollection(filters, Condition.text(filterName))
                    .find(By.className("js-checkbox"));
            if (checkBox.isSelected() != state) checkBox.click();
        }
        return this;
    }

    @Step("Проверить наличие курсов: {args}")
    public CoursesPage checkDisplayedCourses(String... args) {
        for (String expectedCourse : args) {
            getElementFromCollection(courses, Condition.text(expectedCourse));
        }
        return this;
    }

    public HeaderNavTab getHeaderNavTab() {
        return headerNavTab;
    }
}
