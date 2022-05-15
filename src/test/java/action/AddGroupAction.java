package action;

import org.openqa.selenium.WebDriver;

import pageobjects.AddGroupPage;
import pageobjects.TicketGroupListingPage;

public class AddGroupAction {

	WebDriver driver;

	AddGroupPage addGroupPage;
	TicketGroupListingPage ticketGroupListingPage;

	public AddGroupAction(WebDriver driver) {

		this.driver = driver;
		this.addGroupPage = new AddGroupPage(driver);
		this.ticketGroupListingPage = new TicketGroupListingPage(driver);

	}

	public void addGroup() {
		addGroupPage.enterGroupName();
		addGroupPage.selectSkill();
	}

	public void validateCharactersLength() {
		addGroupPage.enterGroupNameWithLetters();
		addGroupPage.checkCharactersLength();

	}

	public void selectDeptSkills() {
		addGroupPage.selectSkill();
		addGroupPage.selectSalesDept();

	}
	


	public void selectRouting() {
		addGroupPage.selectRoutingButton();
	}

	public void addFirstUser() {
		addGroupPage.selectFirstAddButton();
	}

	public void addGroupConfiguration() {
		addGroupPage.selectMarkAsDefault();
		addGroupPage.enterDefaultValue();
		addGroupPage.enterGroupDescription();
		addGroupPage.descriptionCharactersLength();
	}

	public void saveButton() {
		addGroupPage.clickSaveButton();
//		addGroupPage.verifysuccessMessage();

	}

	public void cancelButton() {
		addGroupPage.clickCancelButton();
	}

	public void validateNoRecordsMessage() {
		addGroupPage.verifyNoRecordsMessage();
	}
}
