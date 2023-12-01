package tests;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import utilities.Basetest;
import utilities.ExcelUtility1;

public class AdminFlow extends Basetest{

	pageElements.LandingPage lp;
	pageElements.UserManagement vp;
	pageElements.JobTitlepage jp;
	pageElements.GeneralInfoPage gp;
	pageElements.PayGradePage pg;
	pageElements.EmployementStatusPage emp;
	pageElements.JobcategoriesPage jc;
	pageElements.WorkShiftPage ws;
	pageElements.LocationsPage lo;
	pageElements.StructurePage sp;
	pageElements.Qualification_Skillspage qf;
	pageElements.Qualification_EducationPage ep;
	pageElements.Qualification_Licenses el;
	pageElements.Qualification_Languages ql;
	pageElements.Qualification_Membership qm;
	pageElements.Nationalities nl;
	pageElements.Corporate_BrandingPage cb;
	pageElements.Email_Configuration ec;
	pageElements.Email_Subscriptions es;
	pageElements.Localization_Configuration lc;
	pageElements.LanguagePakages_Configuration lang;
	pageElements.Module_Configuration mc;
	pageElements.RegisterOAuth_Client rc;
	pageElements.LDAP_Configurationpage ldap;
	pageElements.CloseBrowser cs;
	
	@Test
	public void adminmenuflow() throws Exception {
		lp = LaunchApplication();

		ExcelUtility1 xs = new ExcelUtility1();

		String username = xs.Get_Username(1, 0).toString();
		String password = xs.Get_password(1, 1).toString();
		vp = lp.enterlogindetails(username, password);

		// UserManagement_page
		vp.clickonadmin();
		vp.adduser();
		jp = vp.system_user();
	}

	@Test
	public void jobpageflow() throws Exception {
		// jobpage
		pg = jp.jobtitle();
		emp = pg.paygradepage();
		jc = emp.employement_Statuspage();
		ws = jc.job_Categories();

		Properties prop = new Properties();// this method is already there in util class
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
		prop.load(fs);
		String starting_time_am_pm = prop.getProperty("starting_time_am_pm");
		String Ending_time_am_pm = prop.getProperty("Ending_time_am_pm");

		gp = ws.work_Shifts(starting_time_am_pm, Ending_time_am_pm);
	}

	@Test(dependsOnMethods = { "adminmenuflow", "jobpageflow" })
	public void organizationflow() throws Exception {
		lo = gp.organization_generalInfo();
		sp = lo.locations();
		qf = sp.structurepage();
	}

	@Test(dependsOnMethods = { "adminmenuflow", "jobpageflow", "Organizationflow" })
	public void qualificationflow() throws Exception {
		// Qualification
		ep = qf.addskills();
		el = ep.educationPage();
		ql = el.licensespage();
		qm = ql.languagepage();
		nl = qm.membershippage();
	}

	@Test(dependsOnMethods = { "adminmenuflow", "jobpageflow", "Organizationflow", "qualificationflow" })
	public void nationalityflow() throws Exception {
		// Nationality
		cb = nl.nationalities();
	}

	@Test(dependsOnMethods = { "adminmenuflow", "jobpageflow", "Organizationflow", "qualificationflow",
			"nationalityflow" })
	public void corporate_brandingflow() throws Exception {
		// corporate-branding
		ec = cb.corporateBrandingPage();

	}

	@Test(dependsOnMethods={"adminmenuflow","jobpageflow","Organizationflow","qualificationflow","nationalityflow","corporate_brandingflow"})
       public void configurationflow() throws Exception {
		es=ec.emailconfiguration();
		lc=es.emailsubscription();
		lang = lc.localization();
		mc=lang.language_pakage();
		rc=mc.module();
		ldap= rc.oauthClient_registration();
		cs=ldap.config();
	       
       	@Test(dependsOnMethods={"adminmenuflow","jobpageflow","Organizationflow","qualificationflow","nationalityflow","corporate_brandingflow","configurationflow"})
       public void closebrowserflow() throws Exception {
		//closebrowser
		cs.closebrowser();
		
	}

}

