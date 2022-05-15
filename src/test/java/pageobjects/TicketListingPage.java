package pageobjects;

import static reporting.ComplexReportFactory.getTest;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import utils.PropertiesLoader;
import utils.WebBasePage;
import utils.WebTestBase;

public class TicketListingPage extends WebBasePage {
	WebDriver driver;
	AddTicketPage addTicketPage;

	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";

	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public TicketListingPage(WebDriver driver) {
		super(driver, "Ticket Listing Page");
		this.driver = driver;
		this.addTicketPage = new AddTicketPage(driver);

	}

	String cannedReply = "Check";

	public void ticketListing() {
		click(By.linkText("Ticketing"), "click on Ticket listing", 20);
	}

	public void homeBreadcrumb() {
		click(By.xpath("//div[@id='SiteMapLink']/ol/li/a"), "Click om Home Breadcrumb", 20);
	}

	public void validateUrlOfHomePage() {
		getCurrentUrl(prop.getProperty("homePageUrl"), "On clicking Home Page Breadcrumb");
	}

	public void ticketNumber() {
		click(By.cssSelector("#TicketNumberQS"), "click on Ticket Number", 20);
	}

	public void enterValueInTicketNo() {
		enter(By.cssSelector("#ticketNumber"), prop.getProperty("ticketNumberValue"), "enter value in Ticket Number",
				20);
	}

	public void clickOnResetButton() {
		click(By.cssSelector("#ResetFilters"), "Click on Reset Button", 20);
	}

	public void clickOnActionButton() {
		findElementVisibility(By.xpath("//i[@class='fa fa-ellipsis-h action_icon']"),20);
		clickByJavascript(By.xpath("//i[@class='fa fa-ellipsis-h action_icon']"),
				"Action Button", 20);
	}

	
	
	public void clickOnViewButton() {
		staticWait(3000);
		click(By.xpath("//i[@class='fa fa-eye text-info action-icon']//following::span[@class='text'][1]"),
				"Click on View Button", 20);
	}

	// Validate reset button functionality through Ticket number placeholader value
	public String verifyTicketNoPlaceholder(String attributeValue, String name, By by) {

		WebElement ele = findElementVisibility(by, 10);
		String attribute = ele.getAttribute(attributeValue);
		if (attribute.contains(prop.getProperty("ticketPlaceholder"))) {
			logger.info(name + " is empty on clicking reset button.");
			getTest().log(LogStatus.PASS, name + "is empty on clicking reset button.");
		} else {
			getTest().log(LogStatus.FAIL, name + "is not empty on clicking reset button.");
			logger.info(name + "is not empty on clicking reset button.");
			Assert.fail(name + "is not empty on clicking reset button.");
			takeScreenshot(name + " is not empty on clicking reset button.");

		}
		return attribute;
	}

	public void ticketNoPlaceholder() {
		verifyTicketNoPlaceholder("placeholder", "Ticket number plaveholder", By.cssSelector("#ticketNumber"));
	}

	public void clickCollapseButton() {
		click(By.xpath("//span[@data-target='.multi-collapse']"), "Collapse button", 20);
	}

	public void collapseExpandFunctionality() {
		toCheckElementIsDisplayed(By.cssSelector("#divTicketListing"), 20,
				" left side items are expand on clicking expand button");
	}

	public void enterTicketNumber() {
		enter(By.cssSelector("#ticketNumber"), prop.getProperty("ticketNo"), "value entered is ", 20);

	}

	public void enterGeneratedTicketNumber(String getTicketNo) {
		
		enter(By.cssSelector("#ticketNumber"), getTicketNo, "value entered is " + getTicketNo, 20);
	}

	public void clickSearchIcon() {
		click(By.xpath("//a[@id='Search']//i[@class='fa fa-search'][1]"), " Search icon ", 20);
	}

	public void matchSearchedValues() {
		String ticketNumber;
		try {
			findElementsVisibility(By.xpath("//table[@id='tblticketlistigdata']//tr[@id='tr502150']//td[1]"));
			ticketNumber = getText(By.xpath("//table[@id='tblticketlistigdata']//tr[@id='tr502150']//td[1]"), 20);
			if (ticketNumber.equals("2021052419aa0948534-841017")) {
				System.out.println("" + prop.getProperty("ticketNo"));
				getTest().log(LogStatus.PASS, ticketNumber + " is successfully matched");
				logger.debug(ticketNumber + " is successfully matched");
			} else {
				getTest().log(LogStatus.FAIL, ticketNumber + " is not matched");
				logger.debug(ticketNumber + " is not matched");
				takeScreenshot(ticketNumber + " is not matched");
				Assert.fail("" + ticketNumber + " is not matched");
				ticketNumber = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void matchSearchWithResetButton() {
		String ticketNumber;
		try {
			findElementsVisibility(By.xpath("//table[@id='tblticketlistigdata']//tr[@id='tr502150']//td[1]"));
			ticketNumber = getText(By.xpath("//table[@id='tblticketlistigdata']//tr[@id='tr502150']//td[1]"), 20);
			if (ticketNumber.equals("20210524185554785-841017")) {
				getTest().log(LogStatus.FAIL, ticketNumber + " is not matched");
				logger.debug(ticketNumber + " is not matched");
				takeScreenshot(ticketNumber + " is not matched");
				Assert.fail("" + ticketNumber + " is not matched");
				ticketNumber = "";
			} else {
				getTest().log(LogStatus.PASS, ticketNumber + " is successfully matched");
				logger.debug(ticketNumber + " is successfully matched");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickUnassignedWidget() {
		click(By.cssSelector("#main-content ul > li.one_wid"), " unassigned widgets ", 20);
	}

	public void verifyTicketStatus() {
		String ticketStatus;
		try {
			findElementsVisibility(By.xpath("//td[@class='text-center overflow-visible']"));
			ticketStatus = getText(By.xpath("//td[@class='text-center overflow-visible']"), 20);
			if (ticketStatus.equals("Open")) {
				getTest().log(LogStatus.PASS, ticketStatus + " is successfully matched");
				logger.debug(ticketStatus + " is successfully matched");
			} else {
				getTest().log(LogStatus.FAIL, ticketStatus + " is not matched");
				logger.debug(ticketStatus + " is not matched");
				takeScreenshot(ticketStatus + " is not matched");
				Assert.fail("" + ticketStatus + " is not matched");
				ticketStatus = "";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnHoldWidgets() {
		staticWait(2000);
		click(By.cssSelector("ul li.two_wid"), " on hold widget", 20);
	}

	public void clickOnReplyButton() {
		clickByJavascript(By.xpath("//table[@id='tblticketlistigdata']//tbody/tr//td[7]/a"), " reply button", 15);
	}

	public void clickOnShowAddTicket() {
		findElementVisibility(By.id("showadddata"), 20);
		click(By.id("showadddata"), " show add/Hide button", 20);
	}

	// Select CannedReply DropDown
	public void selectCannedReply() {
//			String value = (cannedReply.equals("Check")) ? "Check" : "Select Template";
		click(By.xpath("//select[@id='ddlReplyTemplate']/option[3]"), " check ", 20);
//			selectValueWithValue(By.xpath("//select[@id='ddlReplyTemplate']/option[2]"), value, "Check", 10);
	}

	public void clickOnSubmitReply() {
		click(By.id("aTicketReplySave"), " submitReply button", 20);
	}

	public void validateCountOfReplyButton(String name) {

		String getReplyCount = getText(
				By.xpath("//tr[1]//td[@class='text-center single-action']//span[@class='noti-circle noti-green']"), 20);
		int replyCount = Integer.parseInt(getReplyCount);
		List<WebElement> options = driver.findElements(By.xpath("//div[@class='conversation-box-con']"));

		for (int i = 0; i < options.size(); i++) {
			if (options.size() == replyCount) {
				getTest().log(LogStatus.PASS, name + " is successfully matched");
				logger.debug(name + " is successfully matched" + options.size());
			} else {
				getTest().log(LogStatus.FAIL, name + " is not matched");
				logger.debug(name + " is not matched");
				takeScreenshot(name + " is not matched");
				Assert.fail("" + name + " is not matched");

			}
		}
	}

	public void clickFollowUp() {
		click(By.id("aIndexfollowup"), "Add follow up button", 20);
	}

	public void clickAddFollowUp() {
		click(By.id("andaddfolowups"), "Add button", 20);
	}

	public void clickOnDatePicker() {
		click(By.xpath(
				"//input[@class='form-control hasdatetimepicker']//following::div[@data-original-title='Select Date']"),
				"time picker", 20);

		click(By.xpath("//table[@class='table table-sm']//tbody//tr[2]//td[1]"), "time picker", 20);
		// table[@class='table table-sm']//tbody//tr[2]//td[1]aaa
//		click(By.cssSelector("td.day.active.today"), "select follow up Date", 20);
	}

	public void clickOnTimePicker() {
		click(By.xpath(
				"//input[@class='form-control hasdatetimepicker']//following::div[@data-original-title='Select Time']"),
				"time picker", 20);
	}

	public void checkFollowUpPopup() {
		toCheckElementIsDisplayed(By.xpath("//div[@id='divfollowUpPop']"), 20, "follow up Pop-up is displayed.");
	}

	public void clickOnTicketSubject() {
		clickByJavascript(By.xpath("//table[@id='tblticketlistigdata']//tbody//tr//td[2]/a"), "ticket subject", 20);
	}

	public void selectTime() {
		click(By.xpath("//div[@class='timepicker']//table//tr[2]//td[1]//span"), "select time", 20);

		click(By.xpath(
				"//div[@class='timepicker']//table[@class='table-condensed']//tbody//tr[1]//td[@data-action='selectHour'][1]"),
				"select time", 20);
		click(By.xpath("//div[@class='timepicker']//table//tr[2]//td[3]//span"), "select time", 20);
	}

	public void enterFollowUpComment() {
		enter(By.cssSelector("#FollowUpDescription"), prop.getProperty("followUpDescription"), "Add follow up", 20);
	}

	public void aaveFollowUp() {
		click(By.id("afollowUpNoteSave"), "Save button", 20);
	}

	public void followUpSuccessMessage() {
		verifySuccessMessage(By.id("notifymessage"), prop.getProperty("followUpValidation"),30);
	}

	public void verifyDeleteFunctionality() {
		clickOnActionButton();
	}

	public void navigateToTicketListingPage() {
		pageNavigate(prop.getProperty("ticketListingPageUrl"), "Navigate to Ticket listing page");
	}

	public void clickDeleteButton() {
		click(By.cssSelector("#aIndexDelete"), "Delete button", 20);
	}
	public void clickOnDeletePopUp() {
		click(By.cssSelector("button.btn.btn-success.formbtn.widthhalf"), "ok button for deleting records.", 20);
	}
	
	public void deleteRecordMessage() {
		
		verifySuccessMessage(By.id("notifymessage"), prop.getProperty("deleteTicketMessage"),30);
	}
	
	public void verifyCannedReplies(){
		toCheckElementIsDisplayed(By.id("collapseOne1"), 30, "Canned reply");
	}
	
	public void checkWidgets() {
		
		toCheckElementIsDisplayed(By.xpath("//li[@class='one_wid']"), 30, "Unassigned Widget");
		toCheckElementIsDisplayed(By.xpath("//li[@class='two_wid']"), 30, "On Hold Widget");
		toCheckElementIsDisplayed(By.xpath("//li[@class='three_wid']"), 30, "Response due Widget");
		toCheckElementIsDisplayed(By.xpath("//li[@class='four_wid']"), 30, "Resolve due Widget");
		toCheckElementIsDisplayed(By.xpath("//li[@class='five_wid']"), 30, "Response over due Widget");
		toCheckElementIsDisplayed(By.xpath("//li[@class='six_wid']"), 30, "Resolve over due Widget");
	}
	
}
