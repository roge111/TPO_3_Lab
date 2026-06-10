package ru.itmo.tpo.lab3.support;

/**
 * XPath-локаторы для sravni.bet (без привязки к динамическим id и хеш-классам CSS Modules).
 */
public final class XPathLocators {

    public static final String BASE_URL = "https://sravni.bet";

    public static final String MAIN_HEADING_MATCHES =
            "//h1[contains(.,'Матчи')]";
    public static final String BET_CARD =
            "//button[contains(@class,'betCard')]";
    public static final String BET_CARD_FIRST =
            "(" + BET_CARD + ")[1]";
    /** Как в записи Selenium IDE: 3-я карточка исхода в строке матча */
    public static final String BET_CARD_THIRD =
            "(" + BET_CARD + ")[3]";
    public static final String BET_CARD_THIRD_TITLE =
            BET_CARD_THIRD + "//*[contains(@class,'betCardTitle')]";
    public static final String ALL_MATCHES_BUTTON =
            "//a[contains(@href,'/stat/football/')]//*[normalize-space()='Все матчи' or normalize-space()='все матчи']";
    public static final String SPORT_TAB =
            "//*[self::button or self::a or self::div][contains(translate(normalize-space(.), 'АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ', 'абвгдеёжзийклмнопрстуфхцчшщъыьэюя'), '%s')]";
    public static final String SPORT_TAB_LINK =
            "//a[contains(@href,'/stat/%s/')]";
    public static final String MATCH_CENTER_DATE_BAR =
            "//button[contains(@class,'calendarButton')]/ancestor::div[contains(@class,'container')][1]";
    public static final String MATCH_CENTER_YESTERDAY =
            MATCH_CENTER_DATE_BAR + "//button[contains(@class,'dateTag') and contains(.,'Вчера')]";
    public static final String MATCH_CENTER_TODAY =
            MATCH_CENTER_DATE_BAR + "//button[contains(@class,'dateTag') and contains(.,'Сегодня')]";
    public static final String MATCH_CENTER_TOMORROW =
            MATCH_CENTER_DATE_BAR + "//button[contains(@class,'dateTag') and contains(.,'Завтра')]";
    public static final String MATCH_CENTER_TODAY_SELECTED =
            MATCH_CENTER_DATE_BAR + "//button[contains(@class,'dateTagSelected')]";
    public static final String MATCH_CENTER_CALENDAR_BUTTON =
            "//button[contains(@class,'calendarButton')]";
    public static final String MATCH_CENTER_CALENDAR =
            "//div[@data-qa='Calendar']";
    public static final String MATCH_LINK =
            "//a[contains(@href,'/stat/futbol/')]";
    public static final String MATCH_LINK_FIRST =
            "(" + MATCH_LINK + ")[1]";
    public static final String MATCH_CENTER_HEADING =
            "//h1[contains(translate(., 'ФУТБОЛ', 'футбол'), 'футбол')]";
    public static final String MATCH_CENTER_ACCORDION =
            "//div[@data-qa='Accordion']";
    /** @deprecated используйте {@link #MATCH_CENTER_TOMORROW} */
    public static final String FILTER_TOMORROW = MATCH_CENTER_TOMORROW;
    public static final String TOURNAMENT_HEADING =
            "//h1[contains(translate(., 'ТОВАРИЩЕСК', 'товарищеск'), 'товарищеск')]";
    public static final String MATCH_H2H =
            "//*[contains(.,'Личные встречи')]";
    public static final String MATCH_LINEUP =
            "//*[contains(.,'Состав команды')]";
    public static final String BOOKMAKER_TOP =
            "//*[contains(.,'FONBET') or contains(.,'Winline') or contains(.,'Фонбет')]";
    public static final String BOOKMAKER_FONBET_HEADING =
            "//h1[contains(.,'FONBET') or contains(.,'Фонбет') or contains(.,'Fonbet')]";
    public static final String FREEBET_TEXT =
            "//*[contains(translate(., 'ФРИБЕТ', 'фрибет'), 'фрибет')]";
    public static final String GET_FREEBET_BUTTON =
            "//*[contains(normalize-space(),'Получить фрибет')]";
    public static final String FORECAST_PAGE_HEADING =
            "//h1[contains(.,'Прогноз')]";
    public static final String FORECAST_ARTICLE_LINK =
            "(//a[contains(@href,'/prognozy/') and contains(@href,'prognoz')])[1]";
    public static final String FORECAST_MORE_LINK =
            "(//a[contains(@href,'/prognozy/') and contains(.,'Подробнее')])[1]";
    public static final String ENCYCLOPEDIA_SEARCH_INPUT =
            "//input[contains(@placeholder,'найти') or contains(@placeholder,'Найти')]";
    public static final String ENCYCLOPEDIA_SEARCH_FALLBACK =
            "(//input[not(@type='hidden')])[1]";
    public static final String ENCYCLOPEDIA_FIND_BUTTON =
            "//*[normalize-space()='Найти']";
    public static final String ENCYCLOPEDIA_ARTICLE_HEADING =
            "//h1[contains(translate(., 'ТОТАЛ', 'тотал'), 'тотал')]";
    public static final String ENCYCLOPEDIA_RESULT_LINK =
            "//a[contains(@href,'/enciklopediya/') and contains(@href,'total')]";

    private XPathLocators() {
    }

    public static String sportTab(String sportNameLower) {
        return String.format(SPORT_TAB, sportNameLower);
    }

    public static String sportTabLink(String sportSlug) {
        return String.format(SPORT_TAB_LINK, sportSlug);
    }

    public static final String CALENDAR_DAY_CELL =
            "//div[@data-qa='Calendar']//div[@data-date]";

    public static String calendarDayByDate(String isoDate) {
        return "//div[@data-qa='Calendar']//div[@data-date='" + isoDate + "']";
    }

    public static String calendarDayOtherThan(String isoDate) {
        return "//div[@data-qa='Calendar']//div[@data-date and @data-date!='" + isoDate + "'][1]";
    }
}
