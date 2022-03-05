package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/failed.txt",
        glue = "steps",
        monochrome = true,
       // dryRun = false,
        plugin = {"pretty"}

)

public class FailedRunnerTest {
}
