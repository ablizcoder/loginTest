package org.example.cucumberframework;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/login-cucumber", "json:target/login.json"},
        features = {"src/test/resources"},
        tags = "@login",
        monochrome = true,
        glue = "org.example.steps"
)
public class TestRunner {
}
