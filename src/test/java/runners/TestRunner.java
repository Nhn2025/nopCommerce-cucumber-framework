package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        glue = "stepDefinitions",
        plugin = {"pretty", "html:target/report.html"},
        monochrome = true
)
public class TestRunner {}
