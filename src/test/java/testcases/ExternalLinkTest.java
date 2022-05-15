package testcases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.ExternalLinkAction;
import action.LoginAction;
import utils.WebTestBase;

public class ExternalLinkTest extends WebTestBase{

	@Test(priority = 0)
	public void verifyExternalLinkPageUrl() {
		test = getTest("TC_Ticketing_ExternalLink_343");
		new LoginAction(driver).logoutLogin();
		ExternalLinkAction externalLinkAction = new ExternalLinkAction(driver);
		externalLinkAction.navigateToExternalLink();
		externalLinkAction.verifyManageLayoutUrl();
	}
	
	@Test(dependsOnMethods = "verifyExternalLinkPageUrl")
	public void verifyValidationMessage() {
		test = getTest("TC_Ticketing_ExternalLink_344,359");
		ExternalLinkAction externalLinkAction = new ExternalLinkAction(driver);
		externalLinkAction.clickSaveButton();
		externalLinkAction.checkValidationMessage();
	}
	
	@Test(priority = 2)
	public void verifyFrameText() {
		test = getTest("TC_Ticketing_ExternalLink_346");
		ExternalLinkAction externalLinkAction = new ExternalLinkAction(driver);
		new LoginAction(driver).logoutLogin();
		externalLinkAction.navigateToExternalLink();
		externalLinkAction.enterHeaderFrameText();
		externalLinkAction.saveButton();

	}
	
	@Test(dependsOnMethods = "verifyExternalLinkPageUrl")
	public void verifyCharactersLength() {
		test = getTest("TC_Ticketing_ExternalLink_346");
		ExternalLinkAction externalLinkAction = new ExternalLinkAction(driver);
		externalLinkAction.verifyCharactersLength();
		externalLinkAction.externalLink();
	}
}
