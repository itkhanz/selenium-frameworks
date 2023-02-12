package framework.factory;

import framework.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

public class DriverFactory {
    //private static WebDriver driver;
    //private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initializeDriver(String browser){
        WebDriver driver;
        switch (browser) {
            case "chrome" -> {
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                driver = new FirefoxDriver();
            }
            case "edge" -> {
                driver = new EdgeDriver();
            }
            case "safari" -> {
                driver = new SafariDriver();
            }
            default -> throw new IllegalStateException("INVALID BROWSER: " + browser);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //DriverFactory.driver.set(driver);   //Sets the current thread's copy of this thread-local variable to the specified value
        return driver;
    }

    /*public static WebDriver getDriver() {
        return driver.get();    //Returns the value in the current thread's copy of this thread-local variable.
    }*/


    /**
     * This method initializes the remote webdriver with browser capabilities defined in Test Suite parameters.
     * If the tests are to be executed on Selenium Grid with remote drivers and tests are run with gridMode= true then we initialize remote webdriver
     *
     * @param browserName Name of the browser is set in smoke-tests-distributed.xml file as test parameter "browser" e.g. chrome, firefox, edge, safari
     * @param browserVersion Browser version is set in smoke-tests-distributed.xml file as test parameter "browserVersion"
     * @param platform platform is set in smoke-tests-distributed.xml file as test parameter "platformName" e.g. windows mac, linux
     * @return RemoteWebDriver on hubURL configured in grid.properties with corresponding browser options
     * @throws MalformedURLException
     */
    public static WebDriver initializeRemoteDriver(String browserName, String browserVersion, String platform) throws MalformedURLException {
        WebDriver driver;
        Properties gridProps = PropertyUtils.propertyLoader("src/test/resources/framework/properties/grid.properties");
        String hubAddress  = gridProps.getProperty("hubURL");
        //selenoid grid have url of localhost:4444/wd/hub while Docker grid have url of localhost:44444
        hubAddress += gridProps.getProperty("selenoid").equals("true") ? "wd/hub" : "";
        switch (browserName) {
            case "chrome" -> {
                ChromeOptions options = new ChromeOptions();
                setBrowserOptions(options);
                driver = new RemoteWebDriver(new URL(hubAddress), options);
            }
            case "firefox" -> {
                FirefoxOptions options = new FirefoxOptions();
                setBrowserOptions(options);
                driver = new RemoteWebDriver(new URL(hubAddress), options);
            }
            case "edge" -> {
                EdgeOptions options = new EdgeOptions();
                setBrowserOptions(options);
                driver = new RemoteWebDriver(new URL(hubAddress), options);
            }
            case "safari" -> {
                //Docker grid and selenoid does not provide safari images
                SafariOptions options = new SafariOptions();
                options.setCapability("se:recordVideo", true);
                driver = new RemoteWebDriver(new URL(hubAddress), options);
            }
            default -> throw new IllegalStateException("INVALID BROWSER: " + browserName);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public static <T extends AbstractDriverOptions<?>> void setBrowserOptions(T options) {
        //options.setCapability("browserVersion", browserVersion);
        //options.setCapability("platformName", platform);

        //**************************************//
        //selenoid video recording capabilities
        //**************************************//
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to enable vnc Live Browser Screen */
            put("enableVNC", true);

            /* How to enable video recording */
            put("enableVideo", true);

            /* How To enable saving logs for a session */
            put("enableLog", true);

            /* How to set session timeout */
            put("sessionTimeout", "5m");
        }});

        //*************************************************************************************************************//
        //Docker Grid video recording capabilities: Video recording, screen resolution, and time zones in a Dynamic Grid
        //https://github.com/SeleniumHQ/docker-selenium#video-recording-screen-resolution-and-time-zones-in-a-dynamic-grid
        //*************************************************************************************************************//
        //options.setCapability("se:recordVideo", true);
        //options.setCapability("se:timeZone", "US/Pacific");
        //options.setCapability("se:screenResolution", "1920x1080");

        //**************************************//
        //DesiredCapabilities is deprecated
        //**************************************//
        /*DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName(Browser.CHROME.browserName());
        caps.setVersion(browserVersion);
        caps.setPlatform(Platform.LINUX);
        driver = new RemoteWebDriver(new URL(hubAddress), caps);*/
    }

}
