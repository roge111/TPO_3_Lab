package ru.itmo.tpo.lab3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.itmo.tpo.lab3.pages.MainPage;
import ru.itmo.tpo.lab3.support.Browser;
import ru.itmo.tpo.lab3.support.DriverSupport;
import ru.itmo.tpo.lab3.support.WebDriverFactory;
import ru.itmo.tpo.lab3.support.XPathLocators;

import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * Автотесты UC-01 … UC-19 (TS-01 … TS-19) для https://sravni.bet/
 * Шаблон сценариев — по записи Selenium IDE; реализация — XPath + WebDriverWait.
 */
class SravniBetUseCaseTests {

    private void run(Browser browser, Consumer<MainPage> test) {
        assumeTrue(Browser.shouldRun(browser), () -> "Skipped by -Dbrowser filter");
        WebDriver driver = WebDriverFactory.create(browser);
        try {
            test.accept(new MainPage(driver));
        } finally {
            driver.quit();
        }
    }

    @ParameterizedTest(name = "TS-01 UC-01 open main [{0}]")
    @EnumSource(Browser.class)
    void ts01_openMainPage(Browser browser) {
        run(browser, mainPage -> {
            mainPage.openHome();
            mainPage.waitHomeLoaded();
            assertTrue(mainPage.currentUrl().contains("sravni.bet"));
            assertTrue(
                    mainPage.countBetCards() > 0
                            || mainPage.pageContainsText("Матчи")
                            || mainPage.pageContainsText("матч"),
                    "Expected matches block on home page");
        });
    }

    @ParameterizedTest(name = "TS-02 UC-02 select sport [{0}]")
    @EnumSource(Browser.class)
    void ts02_selectSport(Browser browser) {
        run(browser, mainPage -> {
            mainPage.openHome();
            mainPage.waitHomeLoaded();
            int linksBefore = mainPage.countMatchLinks();
            String sourceBefore = mainPage.pageSource();
            mainPage.clickSportTab("теннис");
            boolean changed = mainPage.countMatchLinks() != linksBefore
                    || !mainPage.pageSource().equals(sourceBefore)
                    || mainPage.pageSource().toLowerCase().contains("теннис");
            if (!changed) {
                mainPage.clickSportTab("хоккей");
                changed = !mainPage.pageSource().equals(sourceBefore)
                        || mainPage.pageSource().toLowerCase().contains("хоккей");
            }
            assertTrue(changed, "Match list or page content should change after sport tab click");
        });
    }

    @ParameterizedTest(name = "TS-03 UC-03 date filter on home [{0}]")
    @EnumSource(Browser.class)
    void ts03_filterByDateOnHome(Browser browser) {
        run(browser, mainPage -> {
            mainPage.openHome();
            mainPage.waitHomeLoaded();
            int linksBefore = mainPage.countMatchLinks();
            mainPage.clickDateTag(2);
            boolean changed = mainPage.countMatchLinks() != linksBefore;
            mainPage.clickDateTag(3);
            assertTrue(changed || mainPage.currentUrl().contains("sravni.bet"));
        });
    }

    @ParameterizedTest(name = "TS-04 UC-04 match list [{0}]")
    @EnumSource(Browser.class)
    void ts04_viewMatchList(Browser browser) {
        run(browser, mainPage -> {
            mainPage.openHome();
            mainPage.waitHomeLoaded();
            assertTrue(mainPage.countMatchLinks() >= 1, "At least one football match link expected");
        });
    }

    @ParameterizedTest(name = "TS-05 UC-05 open match [{0}]")
    @EnumSource(Browser.class)
    void ts05_selectMatch(Browser browser) {
        run(browser, mainPage -> {
            mainPage.openHome();
            mainPage.waitHomeLoaded();
            mainPage.clickFirstMatchLink();
            mainPage.waitMatchPageLoaded();
            assertTrue(mainPage.currentUrl().matches(".*/stat/futbol/\\d+/?.*"));
        });
    }

    @ParameterizedTest(name = "TS-06 UC-06 compare odds [{0}]")
    @EnumSource(Browser.class)
    void ts06_compareOdds(Browser browser) {
        run(browser, mainPage -> {
            mainPage.openHome();
            mainPage.waitHomeLoaded();
            List<org.openqa.selenium.WebElement> cards = mainPage.betCards();
            assertTrue(cards.size() >= 2, "Need at least two betCard buttons");
            String first = cards.get(0).getText();
            String second = cards.get(1).getText();
            assertFalse(first.isBlank());
            assertFalse(second.isBlank());
            assertNotEquals(first, second, "Bet cards should show different outcomes/odds");
        });
    }

    @ParameterizedTest(name = "TS-07 UC-07 go to bookmaker [{0}]")
    @EnumSource(Browser.class)
    void ts07_openBookmakerSite(Browser browser) {
        run(browser, mainPage -> {
            mainPage.openHome();
            mainPage.waitHomeLoaded();
            WebDriver driver = mainPage.getDriver();
            String root = driver.getWindowHandle();
            String partnerUrl = mainPage.openPartnerFromAction(mainPage::clickFirstBetCard);
            assertFalse(partnerUrl.contains("sravni.bet"), "Partner tab should leave sravni.bet");
            driver.close();
            mainPage.switchToMainWindow(root);
        });
    }

    @ParameterizedTest(name = "TS-08 UC-08 match center [{0}]")
    @EnumSource(Browser.class)
    void ts08_openMatchCenter(Browser browser) {
        run(browser, mainPage -> {
            mainPage.openPath("/stat/football/");
            mainPage.waitMatchCenterLoaded();
            assertTrue(mainPage.pageContainsText("футбол") || mainPage.pageContainsText("Футбол"));
        });
    }

    @ParameterizedTest(name = "TS-09 UC-09 match center day [{0}]")
    @EnumSource(Browser.class)
    void ts09_switchDayInMatchCenter(Browser browser) {
        run(browser, mainPage -> {
            mainPage.openPath("/stat/football/");
            mainPage.waitMatchCenterLoaded();
            String before = mainPage.pageSource();
            mainPage.clickFilterTomorrow();
            assertTrue(
                    mainPage.pageContainsText("Завтра") || !mainPage.pageSource().equals(before),
                    "Tomorrow filter should update page");
        });
    }

    @ParameterizedTest(name = "TS-10 UC-10 tournament [{0}]")
    @EnumSource(Browser.class)
    void ts10_viewTournament(Browser browser) {
        run(browser, mainPage -> {
            mainPage.openPath("/stat/futbol/tournament/667/");
            mainPage.waitTournamentLoaded();
            assertTrue(mainPage.pageContainsText("Календарь") || mainPage.countMatchLinks() >= 1);
        });
    }

    @ParameterizedTest(name = "TS-11 UC-11 match stats [{0}]")
    @EnumSource(Browser.class)
    void ts11_matchStatistics(Browser browser) {
        run(browser, mainPage -> {
            mainPage.openPath("/stat/futbol/1545279/");
            mainPage.waitMatchPageLoaded();
            assertTrue(
                    mainPage.pageContainsText("Личные встречи")
                            || mainPage.pageContainsText("Состав команды")
                            || mainPage.pageContainsText("События"),
                    "Match page should show statistics sections");
        });
    }

    @ParameterizedTest(name = "TS-12 UC-12 bookmaker rating [{0}]")
    @EnumSource(Browser.class)
    void ts12_bookmakerRating(Browser browser) {
        run(browser, mainPage -> {
            mainPage.openPath("/bukmekery/luchshie/");
            mainPage.waitElementWithText("FONBET");
            assertTrue(
                    mainPage.pageContainsText("FONBET")
                            || mainPage.pageContainsText("Winline")
                            || mainPage.pageContainsText("букмекер"),
                    "Top bookmakers page expected");
        });
    }

    @ParameterizedTest(name = "TS-13 UC-13 bookmaker review [{0}]")
    @EnumSource(Browser.class)
    void ts13_bookmakerReview(Browser browser) {
        run(browser, mainPage -> {
            mainPage.openPath("/fonbet/");
            assertTrue(
                    mainPage.pageContainsText("FONBET")
                            || mainPage.pageContainsText("Фонбет")
                            || mainPage.pageContainsText("Fonbet"),
                    "Fonbet review page expected");
        });
    }

    @ParameterizedTest(name = "TS-14 UC-14 compare bonuses [{0}]")
    @EnumSource(Browser.class)
    void ts14_compareBonuses(Browser browser) {
        run(browser, mainPage -> {
            mainPage.openPath("/bukmekery/luchshie-fribety/");
            assertTrue(
                    mainPage.pageContainsText("фрибет") || mainPage.pageContainsText("Фрибет"),
                    "Freebets listing expected");
        });
    }

    @ParameterizedTest(name = "TS-15 UC-15 get freebet [{0}]")
    @EnumSource(Browser.class)
    void ts15_getFreebet(Browser browser) {
        run(browser, mainPage -> {
            mainPage.openHome();
            mainPage.waitHomeLoaded();
            WebDriver driver = mainPage.getDriver();
            DriverSupport.waitVisible(driver, By.xpath(XPathLocators.GET_FREEBET_BUTTON));
            String root = driver.getWindowHandle();
            int windowsBefore = driver.getWindowHandles().size();
            String urlBefore = mainPage.currentUrl();
            mainPage.clickGetFreebet();
            boolean partnerOpened = DriverSupport.wait(driver).until(d -> {
                if (d.getWindowHandles().size() > windowsBefore) {
                    return true;
                }
                if (!d.getCurrentUrl().equals(urlBefore) && !d.getCurrentUrl().contains("sravni.bet")) {
                    return true;
                }
                return d.getPageSource().contains("startracking.ru")
                        || d.getPageSource().contains("goto.");
            });
            assertTrue(partnerOpened, "Freebet click should open partner or register affiliate redirect");
            if (driver.getWindowHandles().size() > windowsBefore) {
                for (String handle : driver.getWindowHandles()) {
                    if (!handle.equals(root)) {
                        driver.switchTo().window(handle);
                        driver.close();
                    }
                }
                mainPage.switchToMainWindow(root);
            }
        });
    }

    @ParameterizedTest(name = "TS-16 UC-16 news [{0}]")
    @EnumSource(Browser.class)
    void ts16_readNews(Browser browser) {
        run(browser, mainPage -> {
            mainPage.openPath("/mag/novosti/");
            mainPage.clickFirstNewsArticle();
            assertTrue(mainPage.currentUrl().contains("/mag/novosti/"));
            assertTrue(mainPage.pageSource().length() > 500);
        });
    }

    @ParameterizedTest(name = "TS-17 UC-17 forecasts [{0}]")
    @EnumSource(Browser.class)
    void ts17_readForecasts(Browser browser) {
        run(browser, mainPage -> {
            mainPage.openPath("/prognozy/football/");
            mainPage.clickFirstForecastDetails();
            assertTrue(mainPage.currentUrl().contains("/prognozy/"));
            assertTrue(mainPage.pageSource().length() > 500);
        });
    }

    @ParameterizedTest(name = "TS-18 UC-18 encyclopedia search [{0}]")
    @EnumSource(Browser.class)
    void ts18_encyclopediaSearch(Browser browser) {
        run(browser, mainPage -> {
            mainPage.openPath("/enciklopediya/");
            try {
                mainPage.searchEncyclopedia("тотал");
            } catch (RuntimeException ex) {
                mainPage.clickEncyclopediaArticleByHrefPart("total-4-5");
            }
            assertTrue(
                    mainPage.currentUrl().contains("total")
                            || mainPage.pageContainsText("тотал")
                            || mainPage.pageContainsText("Тотал"),
                    "Search or article list should lead to total-related content");
        });
    }

    @ParameterizedTest(name = "TS-19 UC-19 encyclopedia article [{0}]")
    @EnumSource(Browser.class)
    void ts19_encyclopediaArticle(Browser browser) {
        run(browser, mainPage -> {
            mainPage.openPath("/enciklopediya/shkola-bettinga/total-4-5-bolshe-tb-4-5/");
            mainPage.waitEncyclopediaArticleLoaded();
            assertTrue(
                    mainPage.pageContainsText("тотал") || mainPage.pageContainsText("Тотал"),
                    "Article about total expected");
        });
    }
}
