package ru.atikhomirov.geekbrains.at.pom.page;

import org.springframework.stereotype.Component;
import ru.atikhomirov.geekbrains.at.pom.base.ContentPage;
import ru.atikhomirov.geekbrains.at.pom.base.fragment.Footer;
import ru.atikhomirov.geekbrains.at.pom.base.fragment.Header;
import ru.atikhomirov.geekbrains.at.pom.base.fragment.Search;
import ru.atikhomirov.geekbrains.at.pom.base.fragment.Sidebar;

@Component
public class EventsPage extends ContentPage {
    public EventsPage(Header header, Footer footer, Sidebar sidebar, Search search) {
        super(header, footer, sidebar, search);
    }
}
