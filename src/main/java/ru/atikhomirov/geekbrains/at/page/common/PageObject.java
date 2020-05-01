package ru.atikhomirov.geekbrains.at.page.common;

import org.hamcrest.Matcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PageObject {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public PageObject(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    // Wait elements
    protected WebElement waitVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    protected WebElement waitClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    protected WebElement waitCheckBoxState(WebElement element, boolean state) {
        wait.until(ExpectedConditions.elementSelectionStateToBe(element, state));
        return element;
    }

    // Get elements values
    protected String getElementText(WebElement element) {
        return waitVisible(element).getText();
    }

    protected int getElementInt(WebElement element) { return Integer.valueOf(getElementText(element)); }

    // Actions
    protected void clickCheckbox(WebElement element) {
        boolean initialState = element.isSelected();
        element.click();
        waitCheckBoxState(element, !initialState);
    }

    // Check elements
    protected void checkText(WebElement element, String expectedText) {
        assertThat(getElementText(element), equalToCompressingWhiteSpace(expectedText));
    }

    protected void checkText(WebElement element, Matcher matcher) {
        assertThat(getElementInt(element), matcher);
    }

    protected void checkElementDisplayed(WebElement element) {
        boolean displayed = true;
        assertThat(element.isDisplayed(), is(equalTo(displayed)));
    }

    protected void checkElementDisplayed(WebElement[] elements) {
        for (WebElement element : elements) {
            checkElementDisplayed(element);
        }
    }

    // Find element from list

    protected WebElement findElement(List<WebElement> list, String expectedText) {
        List<Object> arrayList = new ArrayList<>();
        for (WebElement webElement : list) {
            String actualText = webElement.getText();
            arrayList.add(actualText);
            if (actualText.toLowerCase().trim().equals(expectedText.toLowerCase().trim())) {
                return webElement;
            }
        }
        throw new RuntimeException("В коллекции элементов: " + arrayList + "\nНе найден элемент с тектом: " + expectedText);
    }
}
