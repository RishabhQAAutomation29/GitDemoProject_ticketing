package pageobjects;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.scc.automation.TestBase;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class ExternalLinkPage extends WebBasePage {

	WebDriver driver;

	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";

	private static Properties prop = new PropertiesLoader(FILE_NAME).load();
	static String pattern = "yyMMddHHmmss";
	static Date date = new Date();
	static SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	public static int characterLength;

	static String datevalue = dateformat.format(date);

	public ExternalLinkPage(WebDriver driver) {
		super(driver, "External Link Page");
		this.driver = driver;
	}

	// click on full menu
	public void clickFullMenu() {
		click(By.cssSelector("#navbarDropdownPortfolio"), "Full Menu", 20);
	}

	// click on ticketing
	public void clickTicketingOption() {
		click(By.cssSelector("#menuitem22  a"), "Ticketing", 20);
//		click(By.cssSelector("#menuitem16"), "Ticketing", 20);
	}

	// click External Link
	public void clickExternalLink() {
		click(By.xpath(
				"//ul[@class='submenu clschild_40361 d-flex']//a[@data-original-title='External Link' and @id='cadmin_messageboard_link']"),
				"External Link", 40);
	}

	// verify Manage Layout External Link Url
	public void validateManageLayout() {
		getCurrentUrl(prop.getProperty("manageExternalLinkUrl"), "Manage Layout External-Link");
	}

	// click Save button
	public void clickSaveButton() {
		click(By.cssSelector("#btnSave"), "Save button", 20);
	}

	public void clickAdvanced() {
		click(By.cssSelector("#details-button"), "Save button", 20);
	}
	
	public void clickProceed() {
		click(By.cssSelector("#proceed-link"), "Save button", 20);
	}
	
	// verify Validation messages
	public void verifyValidationMessage() {
		verifySuccessMessage(By.id("spnContent"), prop.getProperty("headerTextValidation"), 15);

		int iteration = 0;
		for (int i = 1; i <= 2; i++) {
			iteration++;
			String validationMessage = getText(By.id("spnContent" + iteration), 20);
			verifySuccessMessage(By.id("spnContent" + 1), prop.getProperty("footerTextValidation"), 15);
			verifySuccessMessage(By.id("spnContent" + 2), prop.getProperty("homePageValidation"), 15);
		}
	}

	// enter enter Welcome Text
	public void enterWelcomeText() {
		enter(By.cssSelector("#WelcomeText"), prop.getProperty("enterWelcomeText"), "enter Welcome Text", 40);
	}

	public String getTextFieldAttribute() {

		String textAreaCharacters = getAtribute(By.cssSelector("#WelcomeText"), "value", 40);
		return textAreaCharacters;
	}

	public int getTextFieldValue(String CharactersCount) {
		String textAreaCharacters = CharactersCount;
		int charactersLength = textAreaCharacters.length();
		logger.debug("characters length ::" + charactersLength);
		return charactersLength;
	}

	public void checkWelcomeTextCharactersLength() {
		String textAreaValue = getTextFieldAttribute();
		getTextFieldValue(textAreaValue);
		int characterToCheck = getTextFieldValue(textAreaValue);
		verifyCharactersLength(characterToCheck, Integer.parseInt(prop.getProperty("welcomeTextCharactersLength")),
				"Characters length is");
	}

	public void switchToFrame() {

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		int size = driver.findElements(By.tagName("iframe")).size();

		for (int i = 0; i <= size; i++) {
			driver.switchTo().frame(i);

			if (i == 0) {
				enter(By.tagName("body"), prop.getProperty("headerDescription"), "Add Header Description", 20);
				driver.switchTo().defaultContent();

			} else if (i == 1) {
				enter(By.tagName("body"), prop.getProperty("footerDescription"), "Add footer Description", 20);
				driver.switchTo().defaultContent();

			} else {
				enter(By.tagName("body"), prop.getProperty("homePageDescription"), "Add homePage Description", 20);
				driver.switchTo().defaultContent();
				break;
			}
		}
	}

	// enter External Layout Link
	public void enterExternalLayoutLink() {
		enter(By.cssSelector("#ExternalLayoutLink"), prop.getProperty("enterExternalLink"), "enter External Link", 40);
	}

	public void verifyLayoutSuccessMessage() {
		verifySuccessMessage(By.cssSelector("#notifymessage div"), prop.getProperty("layoutSuccessMessage"), 40);
	}

	public String getExternaLink() {

		String externalLinkHttp = getText(
				By.xpath("//div[@class='input-group-prepend']//span[@class='input-group-text' and text()='https://']"),
				20);
//		String externalBaseLink = gettextByJSexecuter(By.cssSelector("#ExternalLayoutLink"), "external Base link",20);

		String externalBaseLink = prop.getProperty("enterExternalLink");
		String externalLastLink = getText(By.xpath(
				"//div[@class='input-group-prepend']//span[@class='input-group-text' and text()='.support.talygen.com']"),
				20);

		String externalLinkUrl = externalLinkHttp + externalBaseLink + externalLastLink;
		logger.debug("external Link Url :: " + externalLinkUrl);
		System.out.println("external Link Url :: " + externalLinkUrl);
		return externalLinkUrl;

	}

	public void switchToTab() {
//	    ((JavascriptExecutor)driver).executeScript("window.open()");
//
//	    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//
//	    driver.switchTo().window(tabs.get(1)); //switches to new tab
		String externalLinkUrl = getExternaLink();
//	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//	    driver.get("https://google.com");
//	    ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');");

		((JavascriptExecutor)driver).executeScript("window.open();");

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(tabs.get(1)); // switch back to main screen

		driver.get(externalLinkUrl);
		clickAdvanced();
		clickProceed();
//		String a = "window.open(externalLinkUrl,'_blank');";
		// replace link with your desired link
//		((JavascriptExecutor)driver).executeScript(a);

	}
	
	
}
