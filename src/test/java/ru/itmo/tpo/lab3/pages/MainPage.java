package ru.itmo.tpo.lab3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.itmo.tpo.lab3.support.DriverSupport;
import ru.itmo.tpo.lab3.support.XPathLocators;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object для sravni.bet.
 * Переработан после экспорта Selenium Page Object Generator: локаторы на XPath, явные ожидания.
 */
public class MainPage {

    private static final Duration MATCH_CENTER_WAIT = Duration.ofSeconds(40);
    private static final Duration PARTNER_WAIT = Duration.ofSeconds(40);

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
        try {
            driver.get(url);
        } catch (TimeoutException ex) {
            // Firefox иногда не завершает load из-за фоновых запросов — останавливаем и ждём DOM
            ((JavascriptExecutor) driver).executeScript("window.stop();");
        }
        return this;
    }

    public void waitHomeLoaded() {
        DriverSupport.wait(driver).until(d ->
                !d.findElements(DriverSupport.xpath(XPathLocators.BET_CARD)).isEmpty()
                        || !d.findElements(DriverSupport.xpath(XPathLocators.MAIN_HEADING_MATCHES)).isEmpty()
                        || d.getCurrentUrl().contains("sravni.bet"));
    }

    public void waitMatchCenterLoaded() {
        waitMatchCenterContentLoaded();
    }

    public void waitTournamentLoaded() {
        DriverSupport.waitVisible(driver, DriverSupport.xpath(XPathLocators.TOURNAMENT_HEADING));
    }

    public void clickAllMatches() {
        DriverSupport.click(driver, DriverSupport.xpath(XPathLocators.ALL_MATCHES_BUTTON));
        waitUrlContains("/stat/football");
        waitMatchCenterTodayReady();
    }

    public void openMatchCenterFromHome() {
        openHome();
        waitHomeLoaded();
        clickAllMatches();
    }

    /** Возврат на «сегодня» — кнопки снова «Вчера / Сегодня / Завтра». */
    public void returnToMatchCenterToday() {
        openPath("/stat/football/");
        waitMatchCenterTodayReady();
    }

    public void clickSportTab(String sportName) {
        DriverSupport.click(driver, DriverSupport.xpath(XPathLocators.sportTab(sportName)));
    }

    /** Вкладка спорта в матч-центре (`/stat/football/`, `/stat/tennis/` и т.д.). */
    public void clickMatchCenterSportTab(String sportSlug) {
        DriverSupport.click(driver, DriverSupport.xpath(XPathLocators.sportTabLink(sportSlug)));
    }

    public void waitUrlContains(String fragment) {
        DriverSupport.wait(driver).until(d -> d.getCurrentUrl().contains(fragment));
    }

    public void waitUrlChangedFrom(String previousUrl) {
        DriverSupport.wait(driver).until(d -> !d.getCurrentUrl().equals(previousUrl));
    }

    public void clickMatchCenterYesterday() {
        waitMatchCenterDateFiltersClickable();
        String urlBefore = currentUrl();
        DriverSupport.click(driver, DriverSupport.xpath(XPathLocators.MATCH_CENTER_YESTERDAY));
        waitMatchCenterDateApplied(urlBefore, "yesterday");
    }

    public void clickMatchCenterToday() {
        waitMatchCenterDateFiltersClickable();
        DriverSupport.click(driver, DriverSupport.xpath(XPathLocators.MATCH_CENTER_TODAY));
        waitMatchCenterTodayReady();
    }

    public void clickMatchCenterTomorrow() {
        waitMatchCenterDateFiltersClickable();
        String urlBefore = currentUrl();
        DriverSupport.click(driver, DriverSupport.xpath(XPathLocators.MATCH_CENTER_TOMORROW));
        waitMatchCenterDateApplied(urlBefore, "tomorrow");
    }

    public void openMatchCenterCalendar() {
        waitMatchCenterDateFiltersClickable();
        DriverSupport.click(driver, DriverSupport.xpath(XPathLocators.MATCH_CENTER_CALENDAR_BUTTON));
        matchCenterWait().until(ExpectedConditions.visibilityOfElementLocated(
                DriverSupport.xpath(XPathLocators.MATCH_CENTER_CALENDAR)));
        matchCenterWait().until(ExpectedConditions.visibilityOfElementLocated(
                DriverSupport.xpath(XPathLocators.CALENDAR_DAY_CELL)));
    }

    public void pickCalendarDayOtherThanToday() {
        String urlBefore = currentUrl();
        String today = LocalDate.now().toString();
        openMatchCenterCalendar();
        By day = DriverSupport.xpath(XPathLocators.calendarDayOtherThan(today));
        WebElement dayCell = matchCenterWait().until(
                ExpectedConditions.visibilityOfElementLocated(day));
        DriverSupport.scrollIntoView(driver, dayCell);
        dayCell.click();
        matchCenterWait().until(d ->
                d.getCurrentUrl().contains("date=") || !d.getCurrentUrl().equals(urlBefore));
        waitMatchCenterContentLoaded();
    }

    private WebDriverWait matchCenterWait() {
        return new WebDriverWait(driver, MATCH_CENTER_WAIT);
    }

    private void waitDocumentReady() {
        matchCenterWait().until(d ->
                "complete".equals(((JavascriptExecutor) d).executeScript("return document.readyState")));
    }

    private void waitMatchCenterDateApplied(String urlBefore, String urlFragment) {
        matchCenterWait().until(d -> {
            String url = d.getCurrentUrl();
            return url.toLowerCase().contains(urlFragment.toLowerCase()) || !url.equals(urlBefore);
        });
        waitMatchCenterContentLoaded();
    }

    private void waitMatchCenterTodayReady() {
        matchCenterWait().until(d -> {
            String url = d.getCurrentUrl();
            return !url.contains("yesterday") && !url.contains("tomorrow") && !url.contains("date=");
        });
        waitMatchCenterContentLoaded();
        waitMatchCenterDateFiltersClickable();
    }

    private void waitMatchCenterContentLoaded() {
        waitDocumentReady();
        matchCenterWait().until(d ->
                !d.findElements(DriverSupport.xpath(XPathLocators.MATCH_CENTER_HEADING)).isEmpty()
                        || !d.findElements(DriverSupport.xpath(XPathLocators.MATCH_CENTER_ACCORDION)).isEmpty());
    }

    /** Кнопки «Вчера / Сегодня / Завтра» кликабельны — React-виджет дат полностью готов. */
    private void waitMatchCenterDateFiltersClickable() {
        waitDocumentReady();
        waitMatchCenterContentLoaded();
        matchCenterWait().until(ExpectedConditions.visibilityOfElementLocated(
                DriverSupport.xpath(XPathLocators.MATCH_CENTER_TODAY_SELECTED)));
        matchCenterWait().until(ExpectedConditions.elementToBeClickable(
                DriverSupport.xpath(XPathLocators.MATCH_CENTER_YESTERDAY)));
        matchCenterWait().until(ExpectedConditions.elementToBeClickable(
                DriverSupport.xpath(XPathLocators.MATCH_CENTER_TOMORROW)));
        matchCenterWait().until(ExpectedConditions.elementToBeClickable(
                DriverSupport.xpath(XPathLocators.MATCH_CENTER_CALENDAR_BUTTON)));
    }

    public void clickFilterTomorrow() {
        clickMatchCenterTomorrow();
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

    /**
     * Клик по коэффициенту и ожидание партнёрского перехода.
     * Перебирает несколько betCard (как в Selenium IDE — не первая в DOM).
     */
    public String openPartnerViaBetCard() {
        int[] cardIndices = {3, 1, 2, 4, 5};
        TimeoutException lastTimeout = null;
        for (int index : cardIndices) {
            By title = DriverSupport.xpath(
                    "(" + XPathLocators.BET_CARD + ")[" + index + "]//*[contains(@class,'betCardTitle')]");
            By card = DriverSupport.xpath("(" + XPathLocators.BET_CARD + ")[" + index + "]");
            for (By locator : new By[]{title, card}) {
                if (driver.findElements(locator).isEmpty()) {
                    continue;
                }
                resetToHomeIfNeeded();
                try {
                    return openPartnerFromAction(() -> clickElement(locator));
                } catch (TimeoutException ex) {
                    lastTimeout = ex;
                }
            }
        }
        if (lastTimeout != null) {
            throw lastTimeout;
        }
        throw new IllegalStateException("No betCard found for partner redirect");
    }

    private void resetToHomeIfNeeded() {
        if (!driver.getCurrentUrl().contains("sravni.bet") || driver.getWindowHandles().size() > 1) {
            for (String handle : Set.copyOf(driver.getWindowHandles())) {
                driver.switchTo().window(handle);
                if (!driver.getCurrentUrl().contains("sravni.bet")) {
                    driver.close();
                }
            }
            Set<String> remaining = driver.getWindowHandles();
            driver.switchTo().window(remaining.iterator().next());
            if (!driver.getCurrentUrl().contains("sravni.bet")) {
                openHome();
            }
            waitHomeLoaded();
        }
    }

    private void clickElement(By locator) {
        WebElement element = DriverSupport.waitClickable(driver, locator);
        DriverSupport.scrollIntoView(driver, element);
        try {
            element.click();
        } catch (RuntimeException ex) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
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

    public void waitForecastsPageLoaded() {
        DriverSupport.wait(driver).until(d ->
                !d.findElements(DriverSupport.xpath(XPathLocators.FORECAST_PAGE_HEADING)).isEmpty()
                        || !d.findElements(DriverSupport.xpath(XPathLocators.FORECAST_ARTICLE_LINK)).isEmpty());
    }

    public void openFirstForecastArticle() {
        By article = DriverSupport.xpath(XPathLocators.FORECAST_ARTICLE_LINK);
        WebElement link = DriverSupport.waitVisible(driver, article);
        String href = link.getAttribute("href");
        if (href != null && !href.isBlank()) {
            openPath(href);
        } else {
            DriverSupport.click(driver, article);
        }
        DriverSupport.wait(driver).until(d -> {
            String url = d.getCurrentUrl();
            return url.contains("/prognozy/") && !url.endsWith("/football/") && !url.endsWith("/football");
        });
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
     * Драйвер остаётся на вкладке/окне с партнёрским URL.
     */
    public String openPartnerFromAction(Runnable action) {
        Set<String> handlesBefore = Set.copyOf(driver.getWindowHandles());
        String root = driver.getWindowHandle();
        action.run();

        WebDriverWait partnerWait = new WebDriverWait(driver, PARTNER_WAIT);
        return partnerWait.until(d -> {
            Set<String> handlesNow = d.getWindowHandles();
            if (handlesNow.size() > handlesBefore.size()) {
                for (String handle : handlesNow) {
                    if (handlesBefore.contains(handle)) {
                        continue;
                    }
                    d.switchTo().window(handle);
                    String partnerUrl = d.getCurrentUrl();
                    if (isExternalPartnerUrl(partnerUrl)) {
                        return partnerUrl;
                    }
                    if (partnerPageSourceIndicatesRedirect(d)) {
                        return isExternalPartnerUrl(partnerUrl) ? partnerUrl : "partner-redirect-detected";
                    }
                }
                d.switchTo().window(root);
                return null;
            }
            String partnerUrl = d.getCurrentUrl();
            if (isExternalPartnerUrl(partnerUrl)) {
                return partnerUrl;
            }
            if (partnerPageSourceIndicatesRedirect(d)) {
                return isExternalPartnerUrl(partnerUrl) ? partnerUrl : "partner-redirect-detected";
            }
            return null;
        });
    }

    private static boolean isExternalPartnerUrl(String url) {
        return url != null
                && !url.isBlank()
                && !"about:blank".equals(url)
                && !url.contains("sravni.bet");
    }

    private static boolean partnerPageSourceIndicatesRedirect(WebDriver d) {
        String source = d.getPageSource();
        return source.contains("startracking.ru")
                || source.contains("goto.")
                || source.contains("window.location")
                || source.contains("fonbet")
                || source.contains("winline")
                || source.contains("pari.ru");
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
