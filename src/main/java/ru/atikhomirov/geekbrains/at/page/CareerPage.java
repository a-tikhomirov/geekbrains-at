package ru.atikhomirov.geekbrains.at.page;

import org.openqa.selenium.WebDriver;
import ru.atikhomirov.geekbrains.at.page.common.ContentPage;
import ru.atikhomirov.geekbrains.at.page.common.OpenUrl;

public class CareerPage extends ContentPage implements OpenUrl {
    private static final String URL = "https://geekbrains.ru/career";

    public CareerPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CareerPage openUrl() {
        driver.get(URL);
        return this;
    }
}
