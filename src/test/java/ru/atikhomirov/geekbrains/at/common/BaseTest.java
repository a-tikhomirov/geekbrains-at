package ru.atikhomirov.geekbrains.at.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    protected void setUpChromeDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        //options.setPageLoadStrategy(PageLoadStrategy.NONE);
        //options.addArguments("start-maximized");
        //options.addArguments("enable-automation");
        //options.addArguments("--headless");
        //options.addArguments("--no-sandbox");
        options.addArguments("incognito");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-popup-blocking");
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Step("Открыть страницу: {url}")
    protected void openPage(String url) {
        //setUpChromeDriver();
        driver.get(url);
    }

    protected void stopDriver() {
        driver.quit();
    }
}
