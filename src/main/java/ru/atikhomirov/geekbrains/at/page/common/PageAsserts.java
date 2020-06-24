package ru.atikhomirov.geekbrains.at.page.common;

import org.hamcrest.Matcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public abstract class PageAsserts extends PageObject{
    public PageAsserts(WebDriver driver) {
        super(driver);
    }

    protected void checkText(WebElement element, String expectedText) {
        assertThat(getElementText(element), equalToCompressingWhiteSpace(expectedText));
    }

    protected void checkText(WebElement element, Matcher<Integer> matcher) {
        assertThat(getElementInt(element), matcher);
    }

    protected void checkElementDisplayed(WebElement element) {
        assertThat("Element is displayed", element.isDisplayed(), is(equalTo(true)));
    }

    protected void checkElementDisplayed(WebElement[] elements) {
        for (WebElement element : elements) {
            checkElementDisplayed(element);
        }
    }
}
