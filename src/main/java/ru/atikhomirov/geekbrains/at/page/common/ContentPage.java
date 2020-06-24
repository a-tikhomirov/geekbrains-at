package ru.atikhomirov.geekbrains.at.page.common;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.atikhomirov.geekbrains.at.section.Footer;
import ru.atikhomirov.geekbrains.at.section.Header;
import ru.atikhomirov.geekbrains.at.section.Search;
import ru.atikhomirov.geekbrains.at.section.Sidebar;


public class ContentPage extends PageAsserts {
    @Getter private Header header;
    @Getter private Footer footer;
    @Getter private Sidebar sidebar;
    @Getter private Search search;

    @FindBy(css = "svg[class='svg-icon icon-popup-close-button ']")
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
}
