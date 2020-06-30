package ru.atikhomirov.geekbrains.at.pom.base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.atikhomirov.geekbrains.at.pom.base.fragment.Footer;
import ru.atikhomirov.geekbrains.at.pom.base.fragment.Header;
import ru.atikhomirov.geekbrains.at.pom.base.fragment.Search;
import ru.atikhomirov.geekbrains.at.pom.base.fragment.Sidebar;

import static com.codeborne.selenide.Selenide.$;

@Component
public abstract class ContentPage extends Actions {

    @Getter
    protected Header header;
    @Getter
    protected Footer footer;
    @Getter
    protected Sidebar sidebar;
    @Getter
    protected Search search;

    private final SelenideElement buttonClosePopUp =
            $("div button svg[class='svg-icon icon-popup-close-button ']");

    @Autowired
    public ContentPage(Header header, Footer footer, Sidebar sidebar, Search search) {
        this.header = header;
        this.footer = footer;
        this.sidebar = sidebar;
        this.search = search;
        this.header.setOwner(this);
        this.footer.setOwner(this);
        this.search.setOwner(this);
    }

    public ContentPage closePopUp() {
        buttonClosePopUp.waitUntil(Condition.visible, 5000).click();
        return this;
    }
}
