package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CreateLeadPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyHomePage;
import pages.MyLeadsPage;
import pages.ViewLeadPage;
import wdMethods.ProjectMethods;

public class TC003_CreateLead extends ProjectMethods{

	@BeforeTest
	public void setData() {
		testCaseName="TC003_CreateLead";
		testDescription="Login and created new lead";
		testNodes="Leads";
		category="Smoke";
		authors="Suganthi";
		browserName="chrome";
		dataSheetName="TC003";
	}
	
	@Test(dataProvider="fetchData")
	public void CreateLead(String Uname, String Pwd, String compName,String fName, String lName, String vFirstName) {
		
		new LoginPage().enterUserName(Uname).enterPassword(Pwd).clickLogIn();
		new HomePage().clickCRMSFALink();
		new MyHomePage().clickLeadsLink();
		new MyLeadsPage().clickCreateLeadLink();
		new CreateLeadPage().enterCompanyName(compName).enterFirstName(fName).enterLastName(lName).clickSubmitButton();
		new ViewLeadPage().verifyFirstName(vFirstName);
	}
	
}




