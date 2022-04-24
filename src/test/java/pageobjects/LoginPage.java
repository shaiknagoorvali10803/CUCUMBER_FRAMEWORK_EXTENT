package pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.DriverFactory;


public class LoginPage  {
	
  public WebDriverWait driverWait;

		@FindBy(id="txtUsername")
		WebElement txtUsername;
		
		@FindBy(id="txtPassword")
		WebElement txtPassword;
		
		@FindBy(name="Submit")
		WebElement btnLogin;
		
		@FindBy(id="spanMessage")
		WebElement lblInvalidCredentials;
		
		@FindBy(id="welcome")
		WebElement lblWelcome;
			
		@FindBy(xpath="//li/a[text()='Logout']")
		WebElement lnkLogout;
		
		@FindBy(xpath="//div[@id='divLogo']//img")
		WebElement imgLogo;
	
	public LoginPage() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
		driverWait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 30);
	}
		
	public void enterCredentials(String username, String password) {
		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
		
	}
	public void clickOnLoginButton() {
		btnLogin.click();
	}
	public String getInvalidCredentialsMessage() {
		return lblInvalidCredentials.getText();
	}
	
	public void logout() throws InterruptedException {
		driverWait.until(ExpectedConditions.visibilityOf(lblWelcome)).isDisplayed();
		lblWelcome.click();
		Thread.sleep(2000);
		lnkLogout.click();
		
		}
	public boolean isHRMLogoDisplayed() {
		return imgLogo.isDisplayed();
	}
	
	public boolean isLoginFailedErrorDisplayed() {
		return lblInvalidCredentials.isDisplayed();
	}
	
	public void verifyLoginAsValidUser() {
		//DriverFactory.getInstance().getDriver().get("https://opensource-demo.orangehrmlive.com/");
		txtUsername.sendKeys("Admin");
		txtPassword.sendKeys("admin123");	
		btnLogin.click();
	}
	
	public void verifyLoginAsInvalidUser() {
		//DriverFactory.getInstance().getDriver().get("https://opensource-demo.orangehrmlive.com/");
		txtUsername.sendKeys("Admin");
		txtPassword.sendKeys("Admin");	
		btnLogin.click();
		
	}
	
	

}
