package stepdefs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Utils.DriverFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.LoginPage;
import testContext.TestContextAPI;

public class LoginPageStepDefinitions {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginPageStepDefinitions.class);
	LoginPage login;
	TestContextAPI testContext;
	
	public LoginPageStepDefinitions(TestContextAPI testContext) {
		login = new LoginPage();
		this.testContext = testContext;
		testContext.setName("nagoor");

	}

	@Given("I have browser opened and url is navigated")
	public void i_have_browser_opened_and_url_is_navigated() {
		DriverFactory.getInstance().getDriver().get("https://opensource-demo.orangehrmlive.com/");
	}

	@When("user validate the application logo")
	public void user_validate_the_application_logo() {
		login.isHRMLogoDisplayed();
		System.out.println("value Injected using PicoContainer is :"+ testContext.getName());
	  System.out.println("value Injected using Environmet Variables -D is :"+ System.getProperty("environment"));
		  System.out.println("value Injected using Using maven profiles -P is:" + System.getProperty("testtype"));
		  System.out.println("value Injected using Using maven profiles -P is:" + System.getProperty("test_tunner"));

	}

	@Then("user should be able login with valid credentials")
	public void user_should_be_able_login_with_valid_credentials() throws InterruptedException {
		login.verifyLoginAsValidUser();
		Thread.sleep(2000);
		login.logout();
		Thread.sleep(3000);
		System.out.println("value Injected using PicoContainer is :"+ testContext.getName());
		 System.out.println("value Injected using Environmet Variables -D is :"+ System.getProperty("environment"));
		  System.out.println("value Injected using Using maven profiles -P is:" + System.getProperty("testtype"));
		  System.out.println("value Injected using Using maven profiles -P is:" + System.getProperty("test_tunner"));


	}

	@Then("user should be able login with invalid credentials")
	public void user_should_be_able_login_with_invalid_credentials() throws InterruptedException {
		login.verifyLoginAsInvalidUser();
		login.isLoginFailedErrorDisplayed();
		Thread.sleep(12000);
		System.out.println("value Injected using PicoContainer is :"+ testContext.getName());
		 System.out.println("value Injected using Environmet Variables -D is :"+ System.getProperty("environment"));
		  System.out.println("value Injected using Using maven profiles -P is:" + System.getProperty("testtype"));
		  System.out.println("value Injected using Using maven profiles -P is:" + System.getProperty("test_tunner"));


	}
}
