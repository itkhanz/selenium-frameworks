package framework.domainObjects;

import framework.utils.CookieUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class Cookies {
    private io.restassured.http.Cookies cookies;

    public io.restassured.http.Cookies getCookies() {
        return cookies;
    }

    public void setCookies(io.restassured.http.Cookies cookies) {
        this.cookies = cookies;
    }

    /**
     * This method injects selenium cookies to the browser. It calls the method from CookieUtils class
     * that returns the list of selenium cookies converted from rest assured cookies.
     * We iterate through the List of selenium cookies and inject them to the browser. After adding cookies to the browser, we refresh the page.
     * @param driver webdriver instance
     */
    public void injectCookiesToBrowser(WebDriver driver){
        List<Cookie> seleniumCookies = new CookieUtils().convertRestAssuredCookiesToSeleniumCookies(cookies);
        int i = 0;
        for(Cookie cookie: seleniumCookies){
            System.out.println("COUNTER " + i + ": " + cookie.toString());
            driver.manage().addCookie(cookie);
            i++;
        }
        driver.navigate().refresh();
    }
}
