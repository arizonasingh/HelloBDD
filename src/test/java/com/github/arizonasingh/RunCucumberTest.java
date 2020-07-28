package com.github.arizonasingh;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty",
        "html:target/cucumber-reports/html/cucumber-report.html",
        "junit:target/cucumber-reports/xml/cucumber-report.xml",
        "json:target/cucumber-reports/json/cucumber-report.json"})
public class RunCucumberTest {

}