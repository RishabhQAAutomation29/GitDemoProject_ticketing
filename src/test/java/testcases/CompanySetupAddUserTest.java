package testcases;

import org.testng.annotations.Test;
import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.CompanySetupAction;
import action.LoginAction;
import utils.WebTestBase;

public class CompanySetupAddUserTest extends WebTestBase {

	@Test(priority = 0)
	public void addNewUser() {
		test = getTest("TC_Ticketing_Company_Setup_UserConfiguration");
		new LoginAction(driver).logoutLogin();
		CompanySetupAction companySetupAction = new CompanySetupAction(driver);
		companySetupAction.navigateUsersListScreen(); 
		companySetupAction.deleteUser();
		companySetupAction.addNewUsers();
		companySetupAction.addSkills();
	}
}

