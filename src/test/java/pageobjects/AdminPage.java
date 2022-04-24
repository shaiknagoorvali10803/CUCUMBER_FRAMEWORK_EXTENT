package pageobjects;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.DriverFactory;

public class AdminPage  {// Make this page POM later


	@FindBy(id = "menu_admin_viewAdminModule")
	WebElement admin_link;

	@FindBy(id = "menu_admin_employmentStatus")
	WebElement users;
	
	@FindBy(id = "menu_admin_Job")
	WebElement employmentStatus;
	
	@FindBy(id = "btnAdd")
	WebElement addbtn;
	
	@FindBy(id = "empStatus_name")
	WebElement empStatus_name;
	
	@FindBy(id = "btnSave")
	WebElement save_btn;
	
	@FindBy(xpath = "//*///div[@class='message success fadable']")
	WebElement message_save;
	
	
	  private void setup() {
	    PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	  }

	private WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 30);

	public void navigateToUserManagement() throws InterruptedException {
		admin_link.click();
		Thread.sleep(2000);
		Actions action = new Actions(DriverFactory.getInstance().getDriver());
		action.moveToElement(employmentStatus).perform();
		Thread.sleep(2000);
		users.click();
		Thread.sleep(2000);

	}
	
	public String randomNumber()
    {
   
        Random rand = new Random();
        return Integer.toString(rand.nextInt(1000));
        
    }
	

}
