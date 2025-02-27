package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.testng.TestNGCucumberRunner;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/features", // Path to your feature files
        glue = "stepDefinitions", // Package where step definitions are located
        plugin = {"pretty", "json:target/cucumber-report.json"}, // Reports and console output
        monochrome = true // Improves console readability
        //tags =  // Run only scenarios tagged with @SmokeTest
)
public class testRunner {
}
