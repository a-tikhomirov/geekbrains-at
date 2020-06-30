package ru.atikhomirov.geekbrains.at.pom.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.atikhomirov.geekbrains.at.pom.base.ContentPage;
import ru.atikhomirov.geekbrains.at.pom.base.fragment.Footer;
import ru.atikhomirov.geekbrains.at.pom.base.fragment.Header;
import ru.atikhomirov.geekbrains.at.pom.base.fragment.Search;
import ru.atikhomirov.geekbrains.at.pom.base.fragment.Sidebar;
import ru.atikhomirov.geekbrains.at.pom.fragment.CoursesHeaderNavTab;

import static com.codeborne.selenide.Selenide.$$;

@Component
public class CoursesPage extends ContentPage {

    @Getter
    private CoursesHeaderNavTab headerNavTab;

    private final ElementsCollection filters =
            $$(By.xpath("//div[@class=\"course-filter-wrapper\"]//li[@class=\"list-group-item\"]"));

    private final ElementsCollection courses =
            $$(By.xpath("//div[@class=\"course-cards-wrapper\"]//div[@class=\"gb-course-card__title-wrapper\"]"));

    @Autowired
    public CoursesPage(Header header, Footer footer, Sidebar sidebar, Search search, CoursesHeaderNavTab headerNavTab) {
        super(header, footer, sidebar, search);
        this.headerNavTab = headerNavTab;
    }

    @Step("Установить в [{state}] фильтры: {names}")
    public CoursesPage setFilter(boolean state, String... names) {
        filters.shouldHaveSize(14);
        setCheckBoxes(filters, state, names);
        return this;
    }

    @Step("Проверить наличие курсов: {args}")
    public CoursesPage checkDisplayedCourses(String... args) {
        for (String expectedCourse : args) {
            getElementFromCollection(courses, Condition.text(expectedCourse)).shouldBe(Condition.visible);
        }
        return this;
    }

    public CoursesPage openSection(CoursesHeaderNavTab.Button section) {
        headerNavTab.clickButton(section);
        return this;
    }
}
