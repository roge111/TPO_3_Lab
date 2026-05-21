package ru.itmo.tpo.lab3.support;

public enum Browser {
    CHROME,
    FIREFOX;

    public static boolean shouldRun(Browser browser) {
        String filter = System.getProperty("browser", "all").trim().toLowerCase();
        if ("all".equals(filter)) {
            return true;
        }
        return browser.name().equalsIgnoreCase(filter);
    }
}
