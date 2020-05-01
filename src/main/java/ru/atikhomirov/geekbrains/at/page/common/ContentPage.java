package ru.atikhomirov.geekbrains.at.page.common;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.atikhomirov.geekbrains.at.section.Footer;
import ru.atikhomirov.geekbrains.at.section.Header;
import ru.atikhomirov.geekbrains.at.section.Search;
import ru.atikhomirov.geekbrains.at.section.Sidebar;

import static com.codeborne.selenide.Selenide.$;

public class ContentPage {
    private Header header;
    private Footer footer;
    private Sidebar sidebar;
    private Search search;

    private SelenideElement buttonClosePopUp =
            $("div button svg[class='svg-icon icon-popup-close-button ']");

    public ContentPage closePopUp() {
        buttonClosePopUp.waitUntil(Condition.visible, 5000).click();
        return this;
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

    public ContentPage() {
        header = new Header(this);
        footer = new Footer(this);
        sidebar = new Sidebar();
        search = new Search(this);
    }
}
