package com.github.arizonasingh.base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private String browser;
    private String appURL;

    public ConfigManager() {
        try (InputStream input = ConfigManager.class.getClassLoader().getResourceAsStream("config.properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties file");
                return;
            }

            prop.load(input);
            browser = prop.getProperty("browser");
            appURL = prop.getProperty("appURL");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getAppURL() {
        return appURL;
    }

    public void setAppURL(String appURL) {
        this.appURL = appURL;
    }
}
