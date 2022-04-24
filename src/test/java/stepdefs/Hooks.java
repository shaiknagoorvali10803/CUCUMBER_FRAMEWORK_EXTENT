package stepdefs;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import Utils.BrowserFactory;
import Utils.DriverFactory;
import Utils.LoggingException;
import Utils.ScenarioContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.qameta.allure.Allure;
import testContext.TestContextAPI;


public class Hooks {
	ScenarioContext scenarioContext;
	public static Logger logger;

	
	TestContextAPI testContext;
	public Hooks(TestContextAPI testContext) {
		this.testContext = testContext;
	}

	@Before("@Chrome")
	public void onlyChromeBrowser(final Scenario scenario) throws MalformedURLException {
		DriverFactory.getInstance().setDriver(BrowserFactory.init_driver("chrome"));
		scenarioContext = new ScenarioContext();
		scenarioContext.setScenario(scenario);
		this.testContext.setScn(scenario);
		logger = Logger.getLogger("MyStore");
		PropertyConfigurator.configure("log4j.properties");
	}

	@After()
	public void afterMethod(final Scenario scenario) throws LoggingException {
		scenarioContext = new ScenarioContext();
		scenarioContext.clearContextData();
		if (scenario.isFailed()) {
			try {
				captureScreenshot(DriverFactory.getInstance().getDriver(), scenario);
			} catch (ClassCastException | IOException e) {
				throw new LoggingException(e);
			}
		}
		DriverFactory.getInstance().getDriver().close();
		DriverFactory.getInstance().getDriver().quit();
		}

	private String captureScreenshot(final WebDriver driver, final Scenario scenario) throws IOException {
		final Date now = new Date();
		final String dateString = new SimpleDateFormat("dd-MMM-yyy").format(now);
		final String dateAndTimeString = new SimpleDateFormat("dd-MMM-yyyy hh-mm-ss a z").format(now);

		final TakesScreenshot screenShot = (TakesScreenshot) driver;
		final File source = screenShot.getScreenshotAs(OutputType.FILE);
		final String dest = ".." + File.separator + "target" + File.separator + "cucumber-html-reports" + File.separator
				+ dateString + File.separator + "Error_" + dateAndTimeString + ".png";
		final File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(destination.getAbsolutePath());
		return dest;
	}
	
	 @After public void af(Scenario scenario) throws InterruptedException,
	  IOException, IllegalMonitorStateException { if (scenario.isFailed()) {
	  Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot)DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES))); } }

	
	 
}
