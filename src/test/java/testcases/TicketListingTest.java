package testcases;

import org.testng.annotations.Test;
import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.AddTicketAction;
import action.LoginAction;
import action.TicketListingAction;
import action.UpdateTicketAction;
import utils.WebTestBase;

public class TicketListingTest extends WebTestBase {
	@Test(priority = 0)
	public void verifyUrlOnClickingBreadCrumb() {

		test = getTest("TC_Ticketing_TicketListing_60");
		new LoginAction(driver).logoutLogin();
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
		ticketListingAction.navigatetoTicketListing();
		ticketListingAction.clickHome();
		ticketListingAction.verifyhomePageUrl();
	}

	@Test()
	public void verifyResetButtonFunctionality() {

		test = getTest("TC_Ticketing_TicketListing_62,72,69,73,91");
		new LoginAction(driver).logoutLogin();
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
		ticketListingAction.navigatetoTicketListing();
		ticketListingAction.clickOnTicketNumber();
		ticketListingAction.ticketNumberValues();
		ticketListingAction.resetButton();
		ticketListingAction.clickOnTicketNumber();
		ticketListingAction.ticketNoPlaceholderValue();
		ticketListingAction.viewTicket();
		UpdateTicketAction updateTicketAction = new UpdateTicketAction(driver);
		updateTicketAction.checkfunctionalityOfClaimButton();
	}

	@Test()
	public void verifyExpandCollapseFeature() {

		test = getTest("TC_Ticketing_TicketListing_61");
		new LoginAction(driver).logoutLogin();
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
		ticketListingAction.navigatetoTicketListing();
		ticketListingAction.checkExpandCollapseFunctionality();
	}

	@Test()
	public void verifySearchFunctionality() {

		test = getTest("TC_Ticketing_TicketListing_66");
		new LoginAction(driver).logoutLogin();
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
		ticketListingAction.navigatetoTicketListing();
		ticketListingAction.clickOnTicketNumber();
		ticketListingAction.validateSearch();
		ticketListingAction.validateSearchWithResetButton();
	}

	@Test()
	public void verifyUnassignedTicketWidget() {

		test = getTest("TC_Ticketing_TicketListing_118,119");
		new LoginAction(driver).logoutLogin();
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
		ticketListingAction.navigatetoTicketListing();
		ticketListingAction.unassignedTicketWidget();
	}

	@Test()
	public void verifyReplyCount() {

		test = getTest("TC_Ticketing_TicketListing_74,75,93");
		new LoginAction(driver).logoutLogin();
		TicketListingAction ticketListingAction = new TicketListingAction(driver);

		AddTicketAction addticketAction = new AddTicketAction(driver);
		ticketListingAction.navigatetoTicketListing();
		addticketAction.addTicketOnSelf();
		ticketListingAction.verifyReplyFunctionality();
	}

	@Test()
	public void verifyFollowUpFunctionality() {

		test = getTest("TC_Ticketing_TicketListing_70,77,108");
		new LoginAction(driver).logoutLogin();
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
		AddTicketAction addticketAction = new AddTicketAction(driver);
		ticketListingAction.navigatetoTicketListing();
		addticketAction.addTicketOnSelf();
		ticketListingAction.verifyFollowUp();

	}

	@Test()
	public void verifyMergeButtonFunctionality() {

		test = getTest("TC_Ticketing_TicketListing_71");
		new LoginAction(driver).logoutLogin();
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
		ticketListingAction.navigatetoTicketListing();
		ticketListingAction.viewTicket();
		UpdateTicketAction updateTicketAction = new UpdateTicketAction(driver);
		updateTicketAction.verifyMergeButtonFunctionality();
	}

	@Test()
	public void verifyUpdateTicketFunctionality() {

		test = getTest("TC_Ticketing_TicketListing_76,87,109,102,101,104,105");
		new LoginAction(driver).logoutLogin();
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
		AddTicketAction addticketAction = new AddTicketAction(driver);
		ticketListingAction.navigatetoTicketListing();
		addticketAction.addTicketOnSelf();
		UpdateTicketAction updateTicketAction = new UpdateTicketAction(driver);
		updateTicketAction.updateTicket();
	}

	@Test()
	public void verifyDeleteTicketFunctionality() {

		test = getTest("TC_Ticketing_TicketListing_78,79,68");
		new LoginAction(driver).logoutLogin();
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
		AddTicketAction addticketAction = new AddTicketAction(driver);
		ticketListingAction.navigatetoTicketListing();
		addticketAction.addTicketOnSelf();
		ticketListingAction.verifyDeleteTicket();

	}

	@Test()
	public void verifyNotesFunctionality() {

		test = getTest("TC_Ticketing_TicketListing_84,85,86");
		new LoginAction(driver).logoutLogin();
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
		AddTicketAction addticketAction = new AddTicketAction(driver);
		ticketListingAction.navigatetoTicketListing();
		addticketAction.addTicketOnSelf();
		UpdateTicketAction updateTicketAction = new UpdateTicketAction(driver);
		ticketListingAction.viewTicket();
		updateTicketAction.verifyAddNotesFunctionality();
		updateTicketAction.verifyEditNotesFunctionality();
		updateTicketAction.verifyDeleteNotesFunctionality();
	}

	@Test()
	public void verifyAttachmentTabFunctionality() {

		test = getTest("TC_Ticketing_TicketListing_94");
		new LoginAction(driver).logoutLogin();
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
		AddTicketAction addticketAction = new AddTicketAction(driver);
		ticketListingAction.navigatetoTicketListing();
		addticketAction.addTicketOnSelf();
		UpdateTicketAction updateTicketAction = new UpdateTicketAction(driver);
		ticketListingAction.viewTicket();
		updateTicketAction.clickOnAttachmentTab();
	}

	@Test()
	public void verifyWidgetsFunctionality() {

		test = getTest("TC_Ticketing_TicketListing_117");
		new LoginAction(driver).logoutLogin();
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
		ticketListingAction.navigatetoTicketListing();
		ticketListingAction.verifyWidgets();
	}

	@Test()
	public void verifyCannedReplyFunctionality() {

		test = getTest("TC_Ticketing_TicketListing_93");
		new LoginAction(driver).logoutLogin();
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
		AddTicketAction addticketAction = new AddTicketAction(driver);
		ticketListingAction.navigatetoTicketListing();
		addticketAction.addTicketOnSelf();
		ticketListingAction.viewTicket();
		UpdateTicketAction updateTicketAction = new UpdateTicketAction(driver);
		updateTicketAction.verifyCannedReplies();

	}

	@Test()
	public void verifyDraftReplyFunctionality() {

		test = getTest("TC_Ticketing_TicketListing_88");
		new LoginAction(driver).logoutLogin();
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
		AddTicketAction addticketAction = new AddTicketAction(driver);
		ticketListingAction.navigatetoTicketListing();
		addticketAction.addTicketOnSelf();
		ticketListingAction.viewTicket();
		UpdateTicketAction updateTicketAction = new UpdateTicketAction(driver);
		updateTicketAction.verifyTicketReplyDraftedFunctionality();

	}
}
