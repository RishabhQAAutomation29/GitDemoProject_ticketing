package testcases;

import org.testng.annotations.Test;
import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.AddGroupAction;
import action.LoginAction;
import action.TicketGroupListingAction;
import utils.WebTestBase;

public class TicketGroupListingTest extends WebTestBase {

	CompanySetupAddUserTest companySetupAddUserTest;
	
	
//	@Test(dependsOnMethods = "verifySearchFunctionality")
//	public void createUsers() {
//		companySetupAddUserTest.addNewUser();
//	}
	
	@Test(priority = 0)
	public void verifySearchFunctionality() {

		test = getTest("TC_Ticketing_GroupListing_1,2,3,4,7,10,22,23,29");
		new LoginAction(driver).logoutLogin();
		TicketGroupListingAction ticketingListingAction = new TicketGroupListingAction(driver);
		AddGroupAction addGroupAction = new AddGroupAction(driver);
		ticketingListingAction.navigateGroupListing();
		ticketingListingAction.clickAddGroupButton();
		addGroupAction.addGroup();
		addGroupAction.validateCharactersLength();
		addGroupAction.saveButton();
		ticketingListingAction.verifyButtonsVisibility();
		ticketingListingAction.verifyGroupNameSearched();

	}

	@Test(priority = 1)
	public void verifyResetFunctionality() {

		test = getTest("TC_Ticketing_GroupListing_29");
		new LoginAction(driver).logoutLogin();
		TicketGroupListingAction ticketingListingAction = new TicketGroupListingAction(driver);
		AddGroupAction addGroupAction = new AddGroupAction(driver);
		ticketingListingAction.navigateGroupListing();
		ticketingListingAction.clickAddGroupButton();
		addGroupAction.addGroup();
		addGroupAction.validateCharactersLength();
		addGroupAction.saveButton();
		ticketingListingAction.verifyResetNameSearched();
	}
}
