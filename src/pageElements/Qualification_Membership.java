package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Qualification_Membership {

	WebDriver driver;
	public Qualification_Membership(WebDriver driverhere) {
		
		this.driver=driverhere;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//span[@class='oxd-topbar-body-nav-tab-item'])[4]")
	WebElement click_Qualifications;
	
	@FindBy(xpath="//a[text()='Memberships']/parent::li")
	WebElement clickMemberships;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement addbutton;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")
	WebElement addMembershipname;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveclick;
	

	public Nationalities Membershippage() throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Properties prop = new Properties();// this method is already there in util class
	    FileInputStream fs =new FileInputStream(System.getProperty("user.dir")+("\\src\\testData\\GlobalInput.properties"));
	    prop.load(fs);
	    
	    try {
		click_Qualifications.click();
		clickMemberships.click();
		addbutton.click();
		
		Thread.sleep(2000);
		 String add_membership_name = prop.getProperty("add_membership_name");				
		 addMembershipname.sendKeys(add_membership_name);
		 
		 saveclick.click();
		 
	    }catch(Exception e) {
	    	System.out.println("I am in exception block of qualification_Memberships tab");
	    }
	    
	    Nationalities nl = new Nationalities(driver);
	    return nl;
	}
}
