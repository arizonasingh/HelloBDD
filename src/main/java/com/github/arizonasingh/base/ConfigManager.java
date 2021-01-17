package com.github.arizonasingh.base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private String browser;
    private String appURL;

    public ConfigManager() {
        System.setProperty("cucumber.reporting.config.file", "src/main/resources/config.properties");

        try (InputStream input = ConfigManager.class.getClassLoader().getResourceAsStream("config.properties")) {

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties file");
                return;
            }

            Properties prop = new Properties();
            prop.load(input);
            input.close();

            setBrowser(prop.getProperty("browser"));
            setAppURL(prop.getProperty("appURL"));
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
