package com.itkhanz.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private static ThreadLocal<String> sessionId = new ThreadLocal<String>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    protected static void setDriver(WebDriver dr) {
        driver.set(dr);
        setSessionId(((RemoteWebDriver)getDriver()).getSessionId().toString());
    }

    public static String getSessionId() {
        return sessionId.get();
    }

    protected static void setSessionId(String sId) { sessionId.set(sId); }

    public static WebDriver initializeDriver(String browser) {
        if (getDriver() == null) {
            new DriverFactory(browser);
        }
        return getDriver();
    }

    public static void shutdownDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
            sessionId.remove();
        }
    }
}
