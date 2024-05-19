package swag;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "swag", plugin = {
        "json:target/cucumber-report.json" })
public class RunCucumberTest {
}
