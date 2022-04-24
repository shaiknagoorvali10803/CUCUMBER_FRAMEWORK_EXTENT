package pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.DriverFactory;

public class Dashboard {// Make this page POM later

	public WebDriverWait driverWait;

	@FindBy(xpath = "//h1[normalize-space()='Dashboard']")
	WebElement dashboard_menu;

	@FindBy(xpath = "//li/a[text()='Logout']")
	WebElement lnkLogout;

	@FindBy(xpath = "//span[normalize-space()='Assign Leave']")
	WebElement assignleave_link;

	@FindBy(xpath = "//a[@id='menu_leave_assignLeave']")
	WebElement assignleave_menu;

	@FindBy(xpath = "//span[normalize-space()='Leave List']")
	WebElement leavelist_link;

	@FindBy(xpath = "//a[@id='menu_leave_viewLeaveList']")
	WebElement leavelist_menu;

	// a[@id='menu_leave_assignLeave']

	public Dashboard() {
		System.out.println("Dashboard constructor");
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
		driverWait = new WebDriverWait(DriverFactory.getInstance().getDriver(),30);
	}

	public String verifyassignleave_link() throws InterruptedException {
		System.out.println("Dashboard assignleave");
		driverWait.until(ExpectedConditions.visibilityOf(assignleave_link)).isDisplayed();
		assignleave_link.click();
		Thread.sleep(2000);
		return assignleave_menu.getText();
	}

	public String verifyleavelist_link() throws InterruptedException {
		System.out.println("Dashboard leave list");
		driverWait.until(ExpectedConditions.visibilityOf(leavelist_link)).isDisplayed();
		leavelist_link.click();
		Thread.sleep(2000);
		return leavelist_menu.getText();
	}

	public String verifyUserAccess() throws InterruptedException {
		System.out.println("Dashboard verify user access");
		Thread.sleep(2000);
		driverWait.until(ExpectedConditions.visibilityOf(dashboard_menu)).isDisplayed();
		Thread.sleep(2000);
		return dashboard_menu.getText();
	}

}
