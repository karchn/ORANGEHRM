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
	   lp=LaunchApplication();
		
	   //Thread.sleep(5000);
       ExcelUtility1 xs = new ExcelUtility1();
		
		String username = xs.Get_Username(1, 0).toString();
		String password = xs.Get_password(1, 1).toString();
		vp=lp.enterlogindetails(username,password);
		
		
		//UserManagement_page
		Thread.sleep(3000);
        vp.clickonadmin();
        vp.adduser();
        jp=vp.System_user();
        
        //jobpage
        pg= jp.jobtitle();
		emp=pg.paygradepage();
		jc=emp.Employement_Statuspage();
		ws=jc.Job_Categories();
		
		Properties prop = new Properties();// this method is already there in util class
	    FileInputStream fs =new FileInputStream(System.getProperty("user.dir")+("\\src\\testData\\GlobalInput.properties"));
	    prop.load(fs);
	    String starting_time_am_pm = prop.getProperty("starting_time_am_pm");				
	    String Ending_time_am_pm = prop.getProperty("Ending_time_am_pm");
	 	    
	    gp=ws.Work_Shifts(starting_time_am_pm,Ending_time_am_pm);
	    
	    //Organization
	    lo= gp.Organization_generalInfo();
	    sp=lo.locations();
	    qf=sp.structurepage();
	  
	    //Qualification
	    ep=qf.addskills();
	    el=ep.EducationPage();
		ql=el.licensespage();
		qm=ql.languagepage();
		nl=qm.Membershippage();
		
		//Nationality
		cb=nl.nationalities();
		
		//corporate-branding
		ec=cb.CorporateBrandingPage();
		
		//configuration
		es=ec.emailconfiguration();
		lc=es.emailsubscription();
		lang = lc.localization();
		mc=lang.language_pakage();
		rc=mc.module();
		ldap= rc.OAuthClient_registration();
		cs=ldap.Config();
		
		//closebrowser
		cs.closebrowser();
		
	}
		
		
	}

