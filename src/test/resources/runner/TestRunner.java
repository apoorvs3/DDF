package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		publish = true,
		dryRun=true,
		features={"./src/test/resources/features/StockData.feature"},
		glue="steps",
		monochrome=true,
		plugin={"pretty"}
		)

public class TestRunner {

}