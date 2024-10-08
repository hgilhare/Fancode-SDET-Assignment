package TestRunnerFile;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/featurefile",
        glue = "stepdefinationFile",
        plugin = "html:target/reports/test2.html"
)
public class Testrunner {
}
