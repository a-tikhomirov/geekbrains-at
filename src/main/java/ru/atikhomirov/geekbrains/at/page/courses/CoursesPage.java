package ru.atikhomirov.geekbrains.at.page.courses;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.atikhomirov.geekbrains.at.page.common.ContentPage;

import java.util.List;

public class CoursesPage extends ContentPage {

    private HeaderNavTab headerNavTab;

    @FindBy(xpath = "//form/ul//label")
    private List<WebElement> filters;

    @FindBy(xpath = "//a/div/div/span")
    private List<WebElement> courses;

    public CoursesPage(WebDriver driver) {
        super(driver);
        headerNavTab = new HeaderNavTab(driver, this);
    }

    @Step("Установить в {state} фильтр {filter}")
    private void setFilter(boolean state, String filterName){
        WebElement checkbox = findElement(filters, filterName);
        if (checkbox.isSelected() != state) clickCheckbox(checkbox);
    }

    @Step("Проверить наличие курса \"{course}\" в списке курсов")
    private void checkCourse(String course) {
        checkElementDisplayed(findElement(courses, course));
    }

    //@Step("Установить в [{state}] фильтры: {args}")
    public CoursesPage setFilter(boolean state, String... args) {
        for (String filterName : args) {
            setFilter(state, filterName);
        }
        return this;
    }

    //@Step("Проверить наличие курсов: {args}")
    public CoursesPage checkDisplayedCourses(String... args) {
        for (String expectedCourse : args) {
            checkCourse(expectedCourse);
        }
        return this;
    }

    public HeaderNavTab getHeaderNavTab() {
        return headerNavTab;
    }
}
