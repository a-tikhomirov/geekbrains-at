package ru.atikhomirov.geekbrains.at.common;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(SpringConfig.class)
public class BaseTest {
    @Step("Открыть страницу: {url}")
    public void openPage(String url) {
        Configuration.startMaximized = true;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch (Configuration.browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-extensions");
                //chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("incognito");
                capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                Configuration.browserCapabilities = capabilities;
//                Configuration.browserCapabilities = DesiredCapabilities.chrome();
//                ChromeOptions chromeOptions = new ChromeOptions();
//                chromeOptions.addArguments("incognito");
//                chromeOptions.addArguments("--start-maximized");
//                Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY,chromeOptions);
                break;
            case "firefox":
                Configuration.browserCapabilities = DesiredCapabilities.firefox();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("-private");
                Configuration.browserCapabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS,firefoxOptions);
                break;
        }
        //Selenide.clearBrowserCookies();
        Selenide.open(url);
    }
}
