package pageobjects;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class SLAPage extends WebBasePage {

	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	WebDriver driver;

	public SLAPage(WebDriver driver) {
		super(driver, "SLA Page");
		this.driver = driver;
	}

	// Click on Add SLA icon
	public void addSLA() {
		click(By.cssSelector("#ancCreateFeedBack"), "Add SLA", 20);
	}

	// Search policy Name
	public void searchPolicyName(String searchedPolicyName) {
		enter(By.cssSelector("#search"), searchedPolicyName, "search policy name", 40);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	}

	// click Search Button
	public void clickOnGoButton() {
		staticWait(3000);
		findElementInVisibility(By.cssSelector("#notifymessage div"), 50);

		click(By.xpath("//a[@id='Go']"), "GO button", 20);
	}

	// click Policy name Button
	public void clickOnPolicyNameCheckBox() {

		staticWait(6000);
//		findElementInVisibility(By.cssSelector("#notifymessage div"), 50);
		clickByJavascript(By.id("chk_1"), "Policy Name checkbox", 20);
	}

	// click Active Status
	public void clickActive() {
		findElementVisibility(
				By.xpath("//a[@class='p-action-btn text-white activeicon iconenable  aActiveInactive enable']"), 40);
		click(By.xpath("//a[@class='p-action-btn text-white activeicon iconenable  aActiveInactive enable']"),
				"Active Button", 20);
	}

	// click Ok Pop-up Button
	public void clickOkStatusPopup() {
		findElementVisibility(By.cssSelector("button.btn.btn-success.formbtn.widthhalf"), 40);
		click(By.cssSelector("button.btn.btn-success.formbtn.widthhalf"), "OK Pop-Up button", 20);
	}

	public void verifyStatusSuccessMessage() {
		verifySuccessMessage(By.cssSelector("#notifymessage div"), prop.getProperty("statusUpdateMessage"), 40);
	}
}
