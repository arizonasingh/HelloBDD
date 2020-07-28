package com.github.arizonasingh;

import com.github.arizonasingh.base.Base;
import io.cucumber.java8.En;

import static org.junit.jupiter.api.Assertions.*;

import io.cucumber.java8.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class StepDefinitions extends Base implements En {

    private WebDriver driver;

    public StepDefinitions() {

        driver = getDriver();
        GooglePage google = new GooglePage(driver);

        Before((Scenario scenario) -> {
            if (driver == null) {
                driver = getDriver();
            }
        });

        After((Scenario scenario) -> {
            if (driver != null) {
                if(scenario.isFailed()) {
                    final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshot, "image/png", "Screenshot of Failed Scenario: " + scenario.getName());
                }
                driver.quit();
            }
        });

        Given("user is on Google home page", () -> {
            google.openApp(driver);
            assertEquals(driver.getTitle(), "Google", "User is on Google homepage");
        });

        When("user types in {string} in the search box", google::enterGoogleSearch);

        And("user clicks on Search button", google::clickGoogleSearch);

        Then("user should see {string} in the results", (String search) -> {
            String title = driver.getTitle();
            assertEquals(title, search + " - Google Search", "Checking to see if the Google search is correct");
        });
    }
}
