package com.itkhanz.base;

public class BrowserManager {

    private static ThreadLocal<String> browser = new ThreadLocal<String>();

    public static String getBrowser() {
        return browser.get();
    }

    public static void setBrowser(String browserName) { browser.set(browserName); }

}
