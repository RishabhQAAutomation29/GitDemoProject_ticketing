package pageobjects;

import static reporting.ComplexReportFactory.getTest;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import utils.Config;
import utils.PropertiesLoader;
import utils.WebBasePage;

// author Rishabh
public class AddTicketPage extends WebBasePage {
	WebDriver driver;
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";

	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public AddTicketPage(WebDriver driver) {
		super(driver, "Add Ticket Page");
		this.driver = driver;
	}

	String ticketSubject = nameGenerator();
	String department = "Sales";
	String priority = "High";
	String product = "Others";
	String ticketCategory = "Router";
	String Ticketfor = "OnBehalf";
	String UserorClient = "User";
	String user = "Matthew";

	// click on full menu
	public void clickFullMenu() {
		click(By.cssSelector("a#navbarDropdownPortfolio"), "Full Menu", 20);
	}

	// click on ticketing
	public void clickTicketingOption() {
		click(By.cssSelector("#menuitem22"), "Ticketing", 10);
	}

	// click on Ticketing submenu
	public void ticketingSubMenu() {
		click(By.linkText("Add Ticket"), "Ticketing Sub Menu", 5);
	}

	// click on Ticketing submenu SLA
		public void clickSLA() {
			click(By.xpath("//a[@data-original-title='SLA']"), "SLA from full menu", 5);
		}
	
	// Click on Add ticket icon
	public void clickAddTicketIcon() {
		click(By.linkText("Add Ticket"), "Add Ticket", 5);
	}

	// Click on enter ticket Subject
	public void enterTicketSubject() {
		findElementVisibility(By.cssSelector("input#a"), 10);
		enter(By.cssSelector("input#TicketSubject"), ticketSubject, "Subject", 20);
	}

	// Select Department DropDown
	public void selectDepartment() {
		String value = (department.equals("Human Resource")) ? "281424"
				: (department.equals("Sales")) ? "281423" : (department == "Utility Locate Technician") ? "281422" : "";
		selectValueWithValue(By.cssSelector("#DepartmentId"), value, "Department", 10);
	}

	// Select Priority DropDown
	public void selectPriority() {
		String value = (priority.equals("High")) ? "140834" : (priority.equals("Low")) ? "140836" : "";
		selectValueWithValue(By.cssSelector("#PriorityId"), value, "Department", 10);
	}

	// Select Product DropDown
	public void selectProduct() {
		String value = (product.equals("Others")) ? "86" : "";
		selectValueWithValue(By.cssSelector("#ProductId"), value, "Department", 10);
	}

	// Select CCUser
	public void selectCCUsers() {
		click(By.xpath("//label[text()='CC Users:']//following::button[1]"), "CC User", 5);
		click(By.xpath("(//input[@class='checkmultiselect'])[3]"), "User", 8);
	}

	// Select Category DropDown
	public void selectCategory() {
		click(By.xpath("//label[text()='Ticket Category:']"), "Title", 10);
	}

	// Select TicketFor
	public void selectTicketForOnBehalf() {
		String id = (Ticketfor.equals("Self")) ? "#rdo_0" : (Ticketfor.equals("OnBehalf")) ? "#rdo_1" : "";
		clickByJavascript(By.cssSelector(id), "Ticket For On Behalf option", 8);
	}

	// Select OnBehalf
	public void selectUserOnBehalf() {
		String id = (UserorClient.equals("User")) ? "#rdo_2" : (UserorClient.equals("Client")) ? "#rdo_3" : "";
		clickByJavascript(By.cssSelector(id), "Ticket For", 8);
	}

	// Select OnBehalf of Client
	public void selectUserOnBehalfClient() {
		clickByJavascript(By.cssSelector("#rdo_3"), "On Behalf of Client", 8);
	}

	// Select User DropDowm
	public void userDropDown() {
//		click(By.xpath("//*[@id='OnBehalfUserId']/option[1]"), "click on Select", 10);
		click(By.xpath("//*[@id='OnBehalfUserId']/option[2]"), "Harry jasnon ( Sales ) ", 10);
	}

	// click on add more button
	public void addMoreDocumentField() {
		click(By.cssSelector("#addmailBlackListed"), "Add More Document", 5);
	}

	// upload file
	public void uploadDocument() {
		findElementVisibility(
				By.xpath("//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']"), 20);
		driver.findElement(By.xpath("//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']"))
				.sendKeys(Config.testfilePDF);

	}

	// clear Document
	public void clearDocumentFunctionality() {
		click(By.cssSelector("a.round-icon-small.btn-danger-light.clsattclear"), "Clear uploaded Document", 15);
		verifyFileUploadTrue();
	}

	// enter document in Template
	public void enterDescription() {
		click(By.cssSelector("#cke_12"), "Source", 15);
		enter(By.cssSelector(".cke_source"), prop.getProperty("ticketDescription"), "Description", 15);
	}

	// click on save draft
	public void clickSaveDraft() {
		click(By.cssSelector("a#btnSaveDraft"), "Save as Draft", 8);
	}

	// click on submit ticket
	public void clickSubmitTicket() {
		click(By.cssSelector("#btnSaveTicket"), "Submit button", 10);
	}

	// click on back to list
	public void clickBackToList() {
		click(By.cssSelector("a#btnback"), "Back To List", 10);
	}

	//

	public void movetoEditPage() {
		click(By.xpath("(//a[text()='" + ticketSubject + "']//following::a[@class='btnright'])[1]"), "Option Arrow", 8);
		click(By.xpath("(//a[text()='" + ticketSubject + "']//following::span[contains(text(),'Edit')])[1]"), "Edit",
				5);
	}

	// click on submit ticket
	public void submitTicket() {
		click(By.cssSelector("a#btnSaveTicket"), "Submit", 10);
	}

	// click on Assigned to department dropdown
	public void clickAssignedToDepartment() {
		click(By.cssSelector("#DepartmentId"), "Drop down select by department", 20);
	}

	// click on Ticket Category dropdown
	public void clickTicketCategory() {
		click(By.cssSelector("#TicketCategoryId"), "Ticket Category Depatment", 10);
	}

	// click on Assigned to Priority dropdown
	public void clickPriorityDropDown() {
		click(By.cssSelector("#PriorityId"), "Drop down select by Priority", 10);
	}

	// click on Assigned to Product dropdown
	public void clickProductDropDown() {
		click(By.cssSelector("#ProductId"), "Drop down select by Product", 10);
	}

	// Verify success message
	public void verifySuccessMessage() {
		findElementVisibility(By.cssSelector("#divAddTicket p"), 50);
		String successMessage = getText(By.cssSelector("#divAddTicket p"), 50);
		if (successMessage.equals("Ticket has been successfully Submitted with reference number")) {
			getTest().log(LogStatus.PASS, "Ticket succesfully submitted");
			logger.info("Success message displayed is :: " + successMessage);
		} else {
			getTest().log(LogStatus.FAIL, "Ticket not succesfully submitted");
			takeScreenshot("Ticket Success message not displayed successfully.");
			Assert.fail("Ticket Success message not displayed successfully.");
			logger.info("Success message is not displayed.");
		}
	}

	// Ticket listing page
	public void verifyTicketListingPage() {
		String elementinListingPage = getText(By.cssSelector("span#showHideMenuParent"), 10);
		if (elementinListingPage.equals("TICKETING")) {
			getTest().log(LogStatus.PASS, "Ticket Listing page is successfully displayed");
			logger.info("Ticket Listing page is successfully displayed");
		} else {
			getTest().log(LogStatus.FAIL, "Ticket Listing page is not successfully displayed");
			logger.info("Ticket Listing page is not successfully displayed");
			Assert.fail("Ticket Listing page is not successfully displayed");

		}
	}

	// matching dropDowm values
	public boolean verifyDropDownValues(String deptValue, int counter, String valuesFromFile) {
		Boolean match = false;

		String[] exp = new String[] {};
		int count = 0;
		if (counter > 1) {
			exp = valuesFromFile.split(",");
		}
		List<WebElement> options = driver.findElements(By.xpath("//select[@name='" + deptValue + "']//option"));
		staticWait(3000);
		for (WebElement valuesFromWeb : options) {
			for (int i = 0; i < exp.length; i++) {
				if (valuesFromWeb.getText().equals(exp[i])) {
					count++;
				}
			}
		}
		if (count == exp.length) {
			getTest().log(LogStatus.PASS, "Dropdown values is matched");
			logger.info("DropDown values are matched");
		} else {
			getTest().log(LogStatus.FAIL, "Dropdown values is not matched.");
			logger.info("DropDown values are not matched");
			takeScreenshot("Dropdown values is not matched");
			Assert.fail("" + "Dropdown values is not matched");
		}
		return match;
	}

	// verify validation message
	public void verifyValidateMessage(String value) {
		String validationMessage;
		try {
			findElementsVisibility(By.xpath("//span[text()='" + value + "']"));
			validationMessage = getText(By.xpath("//span[text()='" + value + "']"), 20);
			logger.debug("validation message is :: " + validationMessage);
			if (validationMessage.equals(value)) {
				getTest().log(LogStatus.PASS, validationMessage + " is successfully displayed");
			} else {
				getTest().log(LogStatus.FAIL, "Validation message is not successfully displayed");
				logger.debug("validation message is not displayed");
				takeScreenshot(validationMessage);
				Assert.fail("" + validationMessage);
				validationMessage = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// verify Radio buttons
	public void verifyRadioButtons() {
		toCheckElementIsDisplayed(By.xpath("//label[@class='mb-0' and @for='TicketFor']"), 5, "self radio button");
		toCheckElementIsDisplayed(By
				.xpath("//label[@class='custom-control-label' and @for='rdo_1']//following::label[@for='OnBehalf'][1]"),
				5, "On behalf radio button");

	}

	// validate fields with no validation message
	public String checkNoValidations(String attributeValue, String name, By by) {
		WebElement ele = findElementVisibility(by, 2);
		String attribute = ele.getAttribute(attributeValue);
		if (!attribute.contains(attributeValue)) {
			logger.info(name + " Validation Message is displayed");
			getTest().log(LogStatus.PASS, name + " Validation Message is displayed");
		} else {
			logger.info("Validation message is not displayed.");
			getTest().log(LogStatus.FAIL, name + " Validation Message is not displayed");
			Assert.fail("" + name + "Validation Message is displayed");
			takeScreenshot("Validation message is not dispalyed");
		}
		return attribute;
	}

	// click om Self Radio button
	public void clickSelf(String name) {
		try {
			clickByJavascript(By.xpath("//input[@class='form-check-input rdoticketfor custom-control-input']"),
					"click Self radio button", 10);
		} catch (Exception e) {
			logger.info("Unable to click on Self Button.");
			getTest().log(LogStatus.FAIL, name + " Self radio button is not clickable");
			Assert.fail("" + name + "Self radio button is not clickable");
			takeScreenshot("Self radio button is not clickable");

		}
	}

	// click On Behalf radio button
	public void clickOnBehalf(String name) {
		try {
			clickByJavascript(
					By.xpath("//input[@class='form-check-input rdoticketfor rdoBehalf custom-control-input']"),
					"click on On behalf radio button", 10);
		} catch (Exception e) {
			logger.info("On behalf radio button is not clickable.");
			getTest().log(LogStatus.FAIL, name + " On behalf radio button is not clickable");
			Assert.fail("" + name + "On behalf radio button is not clickable");
			takeScreenshot("On behalf radio button is not clickable");

		}
	}

	public void checkPresenceOfRadioButtons() {
		toCheckElementIsDisplayed(By.xpath("//div[@class='form-control pl-0 border-0' ]"), 20,
				"Both Radio buttons are displayed");
	}

	public void radioButtonsPresence() {
		toCheckElementIsDisplayed(By.cssSelector("#rdoTicketFor div div:nth-child(1)"), 20, " Self Radio button");
		toCheckElementIsDisplayed(By.cssSelector("#rdoTicketFor div div div:nth-child(2)"), 20,
				" On behalf Radio button");
	}

	// validate files upload status
	public String verifyFileUploadSuccess(String attributeValue, String name, By by) {
		WebElement ele = findElementVisibility(by, 2);
		String attribute = ele.getAttribute(attributeValue);
		if (!attribute.contains(attributeValue)) {
			logger.info(name + " Succesfully");
			getTest().log(LogStatus.PASS, name + " Succesfully");
		} else {
			logger.info("File is not uploaded Succesfully");
			getTest().log(LogStatus.FAIL, name + " not Succesfully");
			Assert.fail("" + name + "File is not uploaded Succesfully");
			takeScreenshot("File is not uploaded Succesfully");
		}
		return attribute;

	}

	// validate files not upload status
	public String verifyFileNotUpload(String attributeValue, String name, By by) {
		WebElement ele = findElementVisibility(by, 2);
		String attribute = ele.getAttribute(attributeValue);
		if (attribute.contains(attributeValue)) {
			logger.info(name + " Successfully");
			getTest().log(LogStatus.PASS, name + " is not uploaded Succesfully");
//			Assert.fail("" + name + "File is not uploaded Successfully");
//			takeScreenshot("File is not uploaded Successfully");
		} else {
			getTest().log(LogStatus.FAIL, name + " uploaded Succesfully");
			takeScreenshot("FileNotUploadSuccesfully");
			Assert.fail("FileNotUploadSuccesfully");
			logger.info("File is uploaded Succesfully");
		}
		return attribute;
	}

	public void checkAddMoreFunctionality() {
		toCheckElementIsDisplayed(By.cssSelector("#dvfile1000  >div"), 10, "Attachment added successfully");
	}

	public void verifyFileUploadTrue() {
		verifyFileUploadSuccess("autocomplete", "File is ",
				By.xpath("//div[@id='divFiles']//input[@type='text' and @disabled='' and @autocomplete='off' ]"));
	}

	public void verifyFileUploadFalse() {
		verifyFileNotUpload("autocomplete", "File is",
				By.xpath("//div[@id='divFiles']//input[@type='text' and @disabled='' and @autocomplete='off' ]"));

	}

	public void clickOnClearButton() {
		click(By.xpath("//a[@class='round-icon-small btn-danger-light clsattclear' and @data-original-title='Clear']"),
				"Clear Button clicked", 10);
	}

	public void checkFileClearFunctionality() {

		getAtribute(By.xpath("//div[@id='divFiles']//input[@type='text' and @disabled='' and @autocomplete='off' ]"),"disabled",40);
//		verifyFileNotUpload("disabled", "File is Cleared",
//				By.xpath("//div[@id='divFiles']//input[@type='text' and @disabled='' and @autocomplete='off' ]"));
	}

	public void clickOnRemoveButton() {
		click(By.xpath(
				"//a[@class='round-icon-small btn-danger-light clsattremove' and @data-original-title='Remove']"),
				"Click on Remove", 15);
	}

	public void enterDescriptionMoreCharacters() {

		click(By.cssSelector("#cke_12"), "Source", 15);
		enter(By.cssSelector(".cke_source"), prop.getProperty("descriptionWithCharacters"),
				"Description with more than 500 charcters", 15);
	}

	public String referenceNumText() {
		String ticketNoGenerated = getText(By.cssSelector("#divAddTicket > div b"), 20);
		return ticketNoGenerated;
	}

	public void ClickOnuserGuide() {
		click(By.cssSelector("span.user-guide.ml-3"), "click on user guide", 20);
	}

	public void verifyFontOfUserGuide() {
		getCssValue(By.cssSelector("#mCSB_3_container > div"), prop.getProperty("fontCssValue"),
				prop.getProperty("fontExpValue"), 15, "font of User gUide is verified");
	}

	public String getTicketNoText() {
		String getTicketNo = referenceNumText();
		return getTicketNo;
	} 
	
	
	
}
