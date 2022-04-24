package stepdefs;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import Utils.DriverFactory;
import Utils.ExcelReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.ContactUsPage;

public class ContactUsSteps {
	
	private ContactUsPage contactUsPage = new ContactUsPage(DriverFactory.getInstance().getDriver());

	@Given("user navigates to contact us page")
	public void user_navigates_to_contact_us_page() {
		DriverFactory.getInstance().getDriver().get("http://automationpractice.com/index.php?controller=contact");
	}

	@When("user fills the form from given sheetname {string} and rownumber {int}")
	public void user_fills_the_form_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException  {
		
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testData =reader.getData(".\\src\\test\\resources\\testData\\TestData.xlsx", sheetName);
		
		String heading = testData.get(rowNumber).get("subjectheading");
		String email = testData.get(rowNumber).get("email");
		String orderRef = testData.get(rowNumber).get("orderref");
		String message = testData.get(rowNumber).get("message");
		
		contactUsPage.fillContactUsForm(heading, email, orderRef, message);

	}

	@When("user clicks on send button")
	public void user_clicks_on_send_button() {
		contactUsPage.clickSend();
	}

	@Then("it shows a successful message {string}")
	public void it_shows_a_successful_message(String expSuccessMessage) {
		String actualSuccMessg = contactUsPage.getSuccessMessg();
		Assert.assertEquals(actualSuccMessg, expSuccessMessage);
	}

}
