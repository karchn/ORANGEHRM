package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Qualification_Licenses extends AbstractMethods{

	WebDriver driver;
	public Qualification_Licenses(WebDriver driverhere) {
		super(driverhere);
		this.driver=driverhere;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//span[@class='oxd-topbar-body-nav-tab-item'])[4]")
	WebElement click_Qualifications;
	
	@FindBy(xpath="//a[text()='Education']/parent::li")
	WebElement clickLicenses;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement addbutton;
	
	@FindBy(xpath="//input[@class='oxd-input oxd-input--active']")
	WebElement addlicensesname;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveclick;

	By addlicensesname1= By.xpath("//input[@class='oxd-input oxd-input--active']");
	
	public Qualification_Languages licensespage() throws IOException {
		implicitlywaitmethod();
		Properties prop = new Properties();// this method is already there in util class
	    FileInputStream fs =new FileInputStream(System.getProperty("user.dir")+("\\src\\testData\\GlobalInput.properties"));
	    prop.load(fs);
	    
	    try {
		click_Qualifications.click();
		clickLicenses.click();
		addbutton.click();
		
		Wait_Till_Link_Is_Clickable(addlicensesname1);
		 String license_name = prop.getProperty("license_name");				
		 addlicensesname.sendKeys(license_name);
		 
		 saveclick.click();
		 
	    }catch(Exception e) {
	    	System.out.println("I am in exception block of qualification_License tab");
	    }
	    
	    Qualification_Languages ql = new Qualification_Languages(driver);
	    return ql;
	}
	
}
