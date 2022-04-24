package stepdefs;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.java.en.Then;
import pageobjects.Dashboard;
import pageobjects.LoginPage;
import testContext.TestContextAPI;
public class DashboardPageStepDefinitions {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(DashboardPageStepDefinitions.class);
  LoginPage login;
  Dashboard dashboard;
  TestContextAPI testContext;
  
  public DashboardPageStepDefinitions(TestContextAPI testContext) {
	  login = new LoginPage();
	  dashboard = new Dashboard();
	  this.testContext = testContext;
	  }

 @Then("i will veryfy the Dashboard content Apple leave")
  public void user_should_be_able_verify_applyleave() throws InterruptedException {
	  login.verifyLoginAsValidUser();
	  String verifyUserAccess = dashboard.verifyUserAccess();
	  Assert.assertEquals(verifyUserAccess, "Dashboard");
	  Thread.sleep(2000);
	  dashboard.verifyassignleave_link();
	  Thread.sleep(2000);
	  login.logout();
	  System.out.println("value Injected using PicoContainer is :"+ testContext.getName());
	  System.out.println("value Injected using Environmet Variables -D is :"+ System.getProperty("environment"));
	  System.out.println("value Injected using Using maven profiles -P is:" + System.getProperty("testtype"));
	  System.out.println("value Injected using Using maven profiles -P is:" + System.getProperty("test_tunner"));
	       
  }
  
  
  @Then("i will veryfy the Dashboard content leave link")
  public void user_should_be_able_verify_leavelink() throws InterruptedException {
	  login.verifyLoginAsValidUser();
	  String verifyUserAccess = dashboard.verifyUserAccess();
	  Assert.assertEquals(verifyUserAccess, "Dashboard");
	  Thread.sleep(2000);
	  dashboard.verifyleavelist_link();
	  Thread.sleep(12000);
	  
	  /** Dependency Injection */
	  
	  System.out.println("value Injected using PicoContainer is :"+ testContext.getName());
	  System.out.println("value Injected using Environmet Variables -D is :"+ System.getProperty("environment"));
	  System.out.println("value Injected using Using maven profiles -P is:" + System.getProperty("testtype"));
	  System.out.println("value Injected using Using maven profiles -P is:" + System.getProperty("test_tunner"));
	  
     
  }
}
