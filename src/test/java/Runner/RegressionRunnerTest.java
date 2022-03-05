package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        monochrome = true,
        dryRun = false,
        plugin = {"Pretty","html:reports/Reg.html"},
        tags = "@searchEmployee"
)

public class RegressionRunnerTest {
}
