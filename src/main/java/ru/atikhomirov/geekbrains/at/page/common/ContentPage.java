package ru.atikhomirov.geekbrains.at.page.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.atikhomirov.geekbrains.at.section.*;


public class ContentPage extends PageObject {
    private Header header;
    private Footer footer;
    private Sidebar sidebar;
    private Search search;

    @FindBy(css = "div button svg[class='svg-icon icon-popup-close-button ']")
    private WebElement buttonClosePopUp;

    public ContentPage closePopUp() {
        waitClickable(buttonClosePopUp).click();
        return this;
    }

    public ContentPage(WebDriver driver) {
        super(driver);
        header = new Header(driver, this);
        footer = new Footer(driver, this);
        sidebar = new Sidebar(driver);
    }

    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }

    public Sidebar getSidebar() {
        return sidebar;
    }

    public Search getSearch() {
        return search;
    }
}
