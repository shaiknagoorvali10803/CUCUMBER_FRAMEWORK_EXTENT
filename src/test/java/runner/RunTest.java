package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
( 		features="classpath:features",
		glue="",
		tags="",
		plugin = {"pretty",
	             "html:target/cucumber-reports/cucumber-pretty.html",
	                "json:target/cucumber-reports/CucumberTestReport.json",
	                "junit:target/cucumber-reports/report.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
				"timeline:test-output-thread/",
				"rerun:target/failedRerun.txt"
		},
		dryRun = false,
		monochrome = true
		)
public class RunTest {

}

