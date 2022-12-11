package framework.utils;


import io.restassured.http.Cookies;
import org.openqa.selenium.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookieUtils {

    /**
     * This method converts Rest Assured cookies to the Selenium cookies.
     * In rest assured we have the Cookies object that represents a collection of cookies, but in Selenium we have a Cookie object
     * we need to return a List of Cookie objects from this method
     * @param cookies rest assured cookies
     * @return list of selenium cookie objects
     */
    public List<Cookie> convertRestAssuredCookiesToSeleniumCookies(Cookies cookies){
        List<io.restassured.http.Cookie> restAssuredCookies;
        restAssuredCookies = cookies.asList();
        List<Cookie> seleniumCookies = new ArrayList<>();
        for(io.restassured.http.Cookie cookie: restAssuredCookies){
            seleniumCookies.add(new Cookie(cookie.getName(), cookie.getValue(), cookie.getDomain(),
                    cookie.getPath(), cookie.getExpiryDate(), cookie.isSecured(), cookie.isHttpOnly(),
                    cookie.getSameSite()));
        }
        return seleniumCookies;
    }
}
