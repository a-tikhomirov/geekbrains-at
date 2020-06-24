package ru.atikhomirov.geekbrains.at.page.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public abstract class PageObject {
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

    // Get elements values
    protected String getElementText(WebElement element) {
        return waitVisible(element).getText();
    }

    protected int getElementInt(WebElement element) { return Integer.parseInt(getElementText(element)); }
}
