package action;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.AddTicketPage;
import pageobjects.TicketListingPage;
import utils.PropertiesLoader;

public class AddTicketAction extends AddTicketPage {

	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	WebDriver driver;
	TicketListingAction ticketListingAction;
	TicketListingPage ticketListingPage;

	public AddTicketAction(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.ticketListingPage = new TicketListingPage(driver);
	}

	public void navigatetoAddTicket() {
	
		clickFullMenu();
		clickTicketingOption();
		ticketingSubMenu();
	}

	public void navigatetoSLA() {
		
		clickFullMenu();
		clickTicketingOption();
		clickSLA();
	}
	
	// common methods
	public void c() {
		clickAddTicketIcon();
		addTicketOnSelf();
        
	}

	public void searchTicket() {
		ticketListingAction.clickOnTicketNumber();
//		ticketListingPage.enterGeneratedTicketNumber();
	}

	public void ticketSettings() {
		enterTicketSubject();
		selectDepartment();
		selectPriority();
		selectProduct();
		selectCCUsers();
		selectCategory();
		selectTicketForOnBehalf();
	}

	public void addTicketOnBehalfOfUser() {
		radioButtonsPresence();
		ticketSettings();
		selectUserOnBehalf();
		userDropDown();
//		addMoreDocumentField();
		submitAndCheckMessage();
	}

	//common use
	public void addTicketOnSelf() {
		clickAddTicketIcon();
		enterTicketSubject();
		selectDepartment();
		selectPriority();
		selectProduct();
		selectCCUsers();
		selectCategory();
		selfButton();
		uploadDocument();
		enterDescription();
		clickSubmitTicket();
		verifySuccessMessage();
		String getTicketNo = getTicketNoText();
		ticketListingPage.navigateToTicketListingPage();
		ticketListingPage.ticketNumber();
		ticketListingPage.enterGeneratedTicketNumber(getTicketNo);
		ticketListingPage.clickSearchIcon();
	}
	
	

	public void selfTicketSettings() {
		ticketSettings();
		selfButton();
		uploadDocument();
		enterDescWWithMoreCharacters();
		clickSubmitTicket();
		verifySuccessMessage();
		textFromReferenceNo();

	}

	public void verifyUserDropDownValidation() {
		ticketSettings();
		onBehalfButton();
		selectUserOnBehalf();
//		submitAndCheckMessage();
	}

	public void submitWithDescription() {
		ticketSettings();
		enterDescription();
		uploadDocument();
		verifyFileUploadTrue();
		clickSubmitTicket();
		verifySuccessMessage();
		
	}

	public void validationForEmptyUser() {
		uploadDocument();
		verifyFileUploadTrue();
		enterDescription();
		clickSubmitTicket();

	}

	public void submitAndCheckMessage() {
		uploadDocument();
		verifyFileUploadTrue();
		enterDescription();
		clickSubmitTicket();
		verifySuccess();
//		checkValidationWithEmptyUser();
	}

	public void editTicket() {
		movetoEditPage();
		submitTicket();
	}

	public void verifyNavigations() {
		verifySuccessMessage();
		clickBackToList();
		verifyTicketListingPage();
	}

	public void departmentDropDown() {
		verifyDropDownValues("DepartmentId", 2, prop.getProperty("departmentDropDownList"));
	}

	public void ticketCategoryDropDown() {
		verifyDropDownValues("TicketCategoryId", 0, prop.getProperty("ticketCategoryDropDown"));
	}

	public void submitButton() {
		submitTicket();
	}

	public void ticketCategory() {
		clickTicketCategory();
	}

	public void validateRadioButtons() {
		verifyRadioButtons();
	}

	public void verifyValidations() {
		verifyValidateMessage(prop.getProperty("subjectValidation"));
		verifyValidateMessage(prop.getProperty("assignedValidation"));
		verifyValidateMessage(prop.getProperty("priorityValidation"));
	}

	public void priorityDropDown() {
		verifyDropDownValues("PriorityId", 2, (prop.getProperty("priorityDropDownList")));
	}

	public void productDropDown() {
		clickProductDropDown();
	}

	public void verifyproductDropDown() {

		verifyDropDownValues("ProductId", 2, prop.getProperty("productDropownList"));
	}

	public void checkNoValidationMessage() {
		checkNoValidations("class", "Product dropdown",
				By.xpath("//select[@id='ProductId' and @class='form-control']"));
	}

	public void onBehalfButton() {
		clickOnBehalf("On Behalf button clicked");
	}

	public void selfButton() {
		clickSelf("Self Button clicked");
	}

	public void checkValidationWithEmptyUser() {
		verifyValidateMessage(prop.getProperty("userDropDown"));
	}

	public void checkClientValidation() {
		verifyValidateMessage(prop.getProperty("clientValidation"));
	}

	public void FileNotUploaded() {
		verifyFileUploadFalse();
	}

	public void validateFileUpload() {
		verifyFileUploadTrue();
	}

	public void verifySuccess() {
		verifySuccessMessage();
	}

	public void verifyNewAttachmentTab() {
		checkAddMoreFunctionality();
	}

	public void ClearButton() {
		clickOnClearButton();
	}

	public void validateClearButtonFunctionality() {
		checkFileClearFunctionality();
	}

	public void createTicketSelf() {
		selfButton();
		submitWithDescription();

	}

//	public void enterAndSearchTicketNo() {
//		ticketListingAction.navigateToTicketListingPage();
//		ticketListingAction.clickOnTicketNumber();
//		
//		ticketListingAction.enterGeneratedTiacketNumber(ticketNo);
//
//	}

	public void removeButton() {
		clickOnRemoveButton();
	}

	public void enterDescWWithMoreCharacters() {
		enterDescriptionMoreCharacters();
	}

	public void textFromReferenceNo() {
		referenceNumText();
	}

	public void userGuide() {
		ClickOnuserGuide();
	}

	public void FontOfUserGuide() {
		verifyFontOfUserGuide();
	}

}
