package swag;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/swag",
    glue = "swag", // Update with the package name where your step definitions are located
    plugin = {"pretty", "html:target/cucumber-reports"} // Generates HTML report in the target/cucumber-reports directory
)
public class RunCucumberTest {
}
