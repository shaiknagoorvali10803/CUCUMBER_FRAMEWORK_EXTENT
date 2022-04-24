package StepDefinitions.dataTable;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.ScenarioContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class DataDrivenTest {
	ScenarioContext scenarioContext;

	@Before()
	public void testSetup(Scenario scenario)
	{
		scenarioContext = new ScenarioContext();
		scenarioContext.setScenario(scenario);
		System.out.println("Test Environment Set up ");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("Executing Scenario :" + scenario.getName());
	}

	@After()
	public void tearDown(Scenario scenario) {
		scenarioContext.getScenario().write("Finished scenario");
	}

	@Given("^I've a valid set of data and access to Registration Page$")
	public void userValidityCheck() throws Throwable {

		scenarioContext.getScenario().write("Navigating to Mercury Flight Demo Page");
	}

	@When("^Registration page Displayed$")
	public void userOnRegistration() throws Throwable {
		scenarioContext.getScenario().write("Navigating Registration page");
	}

	@Then("^I enter valid data on page$")
	public void provideData(DataTable userData) throws Throwable {
		System.out.println("----------------------------------------------------------------------");
		List<List<String>> data = userData.asLists();
		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i).toString());
		}

		System.out.println(data.get(0).get(1).toString());
		System.out.println(data.get(1).get(1).toString());
		System.out.println(data.get(2).get(1).toString());
		System.out.println(data.get(3).get(1).toString());
		scenarioContext.getScenario().write("Entering User Registration Details");
		System.out.println("----------------------------------------------------------------------");
	}
	
	@Then("^I enter valid data on registration page and verify post-registration$")
	public void userData(DataTable usertable) throws Throwable {
		System.out.println("----------------------------------------------------------------------");
		scenarioContext.getScenario().write("Entering User Registration Details");
		for (Map<String, String> user : usertable.asMaps()) {
			System.out.println("Registering :" + user.get("firstname") + " " + user.get("lastname"));
		}
		
		List<Map<String, String>> user1 = usertable.asMaps();
		String json = new ObjectMapper().writeValueAsString(user1);
		System.out.println(json);
		System.out.println("----------------------------------------------------------------------");
		
		List<List<String>> data = usertable.asLists();
		String json1 = new ObjectMapper().writeValueAsString(data);
		System.out.println(json1);
		}

	@Then("^Click on Submit Button$")
	public void clickSubmit() throws Throwable {
		scenarioContext.getScenario().write("Clicked on submit button");
	}

	@Then("^Thank you for registering: should be displayed$")
	public void registerText() throws Throwable {
		scenarioContext.getScenario().write("Thanks For registering");
	}
	
	@Then("^Click on Signoff$")
	public void clickClose() throws Throwable {
		scenarioContext.getScenario().write("Close");
	}
	
	@Then("^Close the Browser$")
	public void clickSignOff() throws Throwable {
		scenarioContext.getScenario().write("Signing off");
	}

	}
