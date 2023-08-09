package com.itkhanz.tests;

import com.itkhanz.base.BrowserManager;
import com.itkhanz.base.DriverManager;
import com.itkhanz.pages.HomePage;
import com.itkhanz.pages.LoginPage;
import com.itkhanz.utils.json.JSONUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Objects;

import static com.itkhanz.config.ConfigurationManager.configuration;


public class BaseTest {
    private static final Logger logger = LogManager.getLogger(BaseTest.class);
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;

    @Parameters({"browser"})
    @BeforeTest
    public void setup(String browserName) {
        setLogsRouting(browserName);
        BrowserManager.setBrowser(browserName);
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        if (Objects.equals(System.getProperty("suiteName"), "single-browser")) {
            setLogsRouting(System.getProperty("browser"));
            BrowserManager.setBrowser(System.getProperty("browser"));
        }
        driver = DriverManager.initializeDriver(BrowserManager.getBrowser());
        logger.info("********** Webdriver session created: {} ************", DriverManager.getSessionId());
        logger.info("Starting Test: {}", method.getName());
    }

    @AfterMethod
    public void teardown() {
        String sessionID = DriverManager.getSessionId();
        DriverManager.shutdownDriver();
        logger.info("********** Webdriver session terminated: {} ************", sessionID);
    }

    protected HomePage performLogin() {
        loginPage = new LoginPage(driver);
        HashMap<String, String> userMap = JSONUtils.getUserCredentials(configuration().environment());
        return loginPage.login(userMap.get("username"), userMap.get("password"));
    }

    private void setLogsRouting(String browser) {
        System.out.printf("Setting logs for %s browser%n", browser);
        String strFile = "logs" + File.separator + browser;
        File logFolder = new File(strFile);
        if (!logFolder.exists()) {
            logFolder.mkdirs();
        }
        //route logs to separate file for each thread
        ThreadContext.put("ROUTINGKEY", strFile); //LOG4J2
    }
}
