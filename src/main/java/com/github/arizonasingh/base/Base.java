package com.github.arizonasingh.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;


public class Base extends ConfigManager {
    private WebDriver driver;

    public WebDriver getDriver() {
        switch(getBrowser()){
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("test-type");
                options.addArguments("no-sandbox");
                options.addArguments("disable-extensions");
                options.addArguments("start-maximized");
                options.addArguments("--js-flags=--expose-gc");
                options.addArguments("disable-plugins");
                options.addArguments("--disable-popup-blocking");
                options.addArguments("--disable-default-apps");
                options.addArguments("test-type=browser");
                options.addArguments("disable-infobars");
                options.addArguments("log-level=3");
                options.setHeadless(true);
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "ie":
                driver = new InternetExplorerDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("This browser is not supported");
                System.exit(0);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

}
