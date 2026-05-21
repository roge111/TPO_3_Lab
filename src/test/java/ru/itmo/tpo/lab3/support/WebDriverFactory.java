package ru.itmo.tpo.lab3.support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public final class WebDriverFactory {

    private WebDriverFactory() {
    }

    public static WebDriver create(Browser browser) {
        WebDriver driver;
        switch (browser) {
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("-width=1536", "-height=798");
                driver = new FirefoxDriver(options);
            }
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--window-size=1536,798");
                options.addArguments("--disable-search-engine-choice-screen");
                driver = new ChromeDriver(options);
            }
            default -> throw new IllegalArgumentException("Unknown browser: " + browser);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        return driver;
    }
}
