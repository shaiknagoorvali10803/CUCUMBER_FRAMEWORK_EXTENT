package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty",
	             "rerun:target/failedRerun.txt"
		},
		monochrome = true,
		glue = {"StepDefinitions"}, 
		features = {"@target/failedRerun.txt"}, 
		tags = {},
		dryRun = false
		
		)

public class FailedRerunTest {
	

}
