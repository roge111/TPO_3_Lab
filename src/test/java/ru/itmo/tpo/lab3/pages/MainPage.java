package ru.itmo.tpo.lab3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.itmo.tpo.lab3.support.DriverSupport;
import ru.itmo.tpo.lab3.support.XPathLocators;

import java.util.List;
import java.util.Set;

/**
 * Page Object для sravni.bet.
 * Переработан после экспорта Selenium Page Object Generator: локаторы на XPath, явные ожидания.
 */
public class MainPage {

    private final WebDriver driver;
    private final String baseUrl;

    public MainPage(WebDriver driver) {
        this(driver, XPathLocators.BASE_URL);
    }

    public MainPage(WebDriver driver, String baseUrl) {
        this.driver = driver;
        this.baseUrl = baseUrl;
    }

    public MainPage openHome() {
        driver.get(baseUrl + "/");
        return this;
    }

    public MainPage openPath(String path) {
        String url = path.startsWith("http") ? path : baseUrl + path;
        driver.get(url);
        return this;
    }

    public void waitHomeLoaded() {
        DriverSupport.wait(driver).until(d ->
                !d.findElements(DriverSupport.xpath(XPathLocators.BET_CARD)).isEmpty()
                        || !d.findElements(DriverSupport.xpath(XPathLocators.MAIN_HEADING_MATCHES)).isEmpty()
                        || d.getCurrentUrl().contains("sravni.bet"));
    }

    public void waitMatchCenterLoaded() {
        DriverSupport.waitVisible(driver, DriverSupport.xpath(XPathLocators.MATCH_CENTER_HEADING));
    }

    public void waitTournamentLoaded() {
        DriverSupport.waitVisible(driver, DriverSupport.xpath(XPathLocators.TOURNAMENT_HEADING));
    }

    public void clickSportTab(String sportName) {
        DriverSupport.click(driver, DriverSupport.xpath(XPathLocators.sportTab(sportName)));
    }

    public void clickDateTag(int indexOneBased) {
        DriverSupport.click(driver, DriverSupport.xpath(XPathLocators.dateTag(indexOneBased)));
    }

    public void clickFilterTomorrow() {
        DriverSupport.click(driver, DriverSupport.xpath(XPathLocators.FILTER_TOMORROW));
    }

    public int countMatchLinks() {
        return driver.findElements(DriverSupport.xpath(XPathLocators.MATCH_LINK)).size();
    }

    public void clickFirstMatchLink() {
        DriverSupport.click(driver, DriverSupport.xpath(XPathLocators.MATCH_LINK_FIRST));
    }

    public int countBetCards() {
        return driver.findElements(DriverSupport.xpath(XPathLocators.BET_CARD)).size();
    }

    public List<WebElement> betCards() {
        return driver.findElements(DriverSupport.xpath(XPathLocators.BET_CARD));
    }

    public void clickFirstBetCard() {
        DriverSupport.click(driver, DriverSupport.xpath(XPathLocators.BET_CARD_FIRST));
    }

    public void clickGetFreebet() {
        By button = DriverSupport.xpath(XPathLocators.GET_FREEBET_BUTTON);
        By link = DriverSupport.xpath(
                "//a[.//*[contains(normalize-space(),'Получить фрибет')] or contains(normalize-space(),'Получить фрибет')][1]");
        if (!driver.findElements(link).isEmpty()) {
            DriverSupport.click(driver, link);
        } else {
            DriverSupport.click(driver, button);
        }
    }

    public void clickFirstNewsArticle() {
        DriverSupport.click(driver, DriverSupport.xpath(
                "//a[contains(@href,'/mag/novosti/') and string-length(@href) > string-length('/mag/novosti/')][1]"));
    }

    public void clickFirstForecastDetails() {
        DriverSupport.click(driver, DriverSupport.xpath(XPathLocators.FORECAST_MORE_LINK));
    }

    public void searchEncyclopedia(String query) {
        By[] candidates = {
                DriverSupport.xpath(XPathLocators.ENCYCLOPEDIA_SEARCH_INPUT),
                DriverSupport.xpath(XPathLocators.ENCYCLOPEDIA_SEARCH_FALLBACK),
                DriverSupport.xpath("//textarea[1]"),
                DriverSupport.xpath("//input[not(@type='hidden')]")
        };
        WebElement field = null;
        for (By locator : candidates) {
            if (!driver.findElements(locator).isEmpty()) {
                field = DriverSupport.waitVisible(driver, locator);
                break;
            }
        }
        if (field == null) {
            DriverSupport.click(driver, DriverSupport.xpath(
                    "//*[contains(normalize-space(),'Что вы хотите найти')]"));
            field = driver.switchTo().activeElement();
        }
        field.clear();
        field.sendKeys(query);
        DriverSupport.click(driver, DriverSupport.xpath(XPathLocators.ENCYCLOPEDIA_FIND_BUTTON));
    }

    public void clickEncyclopediaArticleByHrefPart(String hrefPart) {
        DriverSupport.click(driver, DriverSupport.xpath(
                "//a[contains(@href,'" + hrefPart + "')][1]"));
    }

    /**
     * Выполняет действие и возвращает URL партнёра (новая вкладка или переход в текущей).
     */
    public String openPartnerFromAction(Runnable action) {
        Set<String> handlesBefore = driver.getWindowHandles();
        String urlBefore = driver.getCurrentUrl();
        action.run();
        if (driver.getWindowHandles().size() > handlesBefore.size()) {
            String newHandle = DriverSupport.waitNewWindow(driver, handlesBefore);
            driver.switchTo().window(newHandle);
            return driver.getCurrentUrl();
        }
        DriverSupport.wait(driver).until(d -> !d.getCurrentUrl().equals(urlBefore));
        return driver.getCurrentUrl();
    }

    public void switchToMainWindow(String handle) {
        driver.switchTo().window(handle);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String currentUrl() {
        return driver.getCurrentUrl();
    }

    public String pageSource() {
        return driver.getPageSource();
    }

    public boolean pageContainsText(String text) {
        return pageSource().contains(text);
    }

    public void waitMatchPageLoaded() {
        DriverSupport.wait(driver).until(d ->
                d.getCurrentUrl().contains("/stat/futbol/")
                        && (!d.findElements(DriverSupport.xpath(XPathLocators.MATCH_H2H)).isEmpty()
                        || !d.findElements(DriverSupport.xpath(XPathLocators.MATCH_LINEUP)).isEmpty()
                        || !d.findElements(By.xpath("//h1")).isEmpty()));
    }

    public void waitEncyclopediaArticleLoaded() {
        DriverSupport.waitVisible(driver, DriverSupport.xpath(XPathLocators.ENCYCLOPEDIA_ARTICLE_HEADING));
    }

    public void waitElementWithText(String partialText) {
        DriverSupport.wait(driver).until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(.,'" + partialText + "')]")));
    }
}
