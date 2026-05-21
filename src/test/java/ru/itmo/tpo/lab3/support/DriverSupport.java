package ru.itmo.tpo.lab3.support;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;
import java.util.function.Function;

public final class DriverSupport {

    public static final Duration WAIT_TIMEOUT = Duration.ofSeconds(20);

    private DriverSupport() {
    }

    public static WebDriverWait wait(WebDriver driver) {
        return new WebDriverWait(driver, WAIT_TIMEOUT);
    }

    public static WebElement waitClickable(WebDriver driver, By locator) {
        return wait(driver).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitVisible(WebDriver driver, By locator) {
        return wait(driver).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void click(WebDriver driver, By locator) {
        scrollIntoView(driver, waitClickable(driver, locator));
        waitClickable(driver, locator).click();
    }

    public static void scrollIntoView(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", element);
    }

    public static String waitNewWindow(WebDriver driver, Set<String> handlesBefore) {
        return wait(driver).until((Function<WebDriver, String>) d -> {
            Set<String> current = d.getWindowHandles();
            if (current.size() <= handlesBefore.size()) {
                return null;
            }
            current.removeAll(handlesBefore);
            return current.iterator().next();
        });
    }

    public static By xpath(String expression) {
        return By.xpath(expression);
    }
}
