package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployementStatusPage extends AbstractMethods{

	WebDriver driver;
	public EmployementStatusPage(WebDriver driverhere) {
		super(driverhere);
		this.driver=driverhere;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//span[@class='oxd-topbar-body-nav-tab-item'])[2]")
	WebElement click_job;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement clickonadd;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement savebutton;
	
	@FindBy(xpath="//a[text()='Employment Status']/parent::li")
	WebElement Employementstatus;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement Emplyementstatus_name;
	
	public JobcategoriesPage employement_Statuspage() throws IOException {
		implicitlywaitmethod();
		
		try {
		click_job.click();
		Employementstatus.click();
		clickonadd.click();
		Emplyementstatus_name.click();
		
	    Properties prop = new Properties();// this method is already there in util class
	    FileInputStream fs =new FileInputStream(System.getProperty("user.dir")+("\\src\\testData\\GlobalInput.properties"));
	    prop.load(fs);
	    String Employement_status = prop.getProperty("Employement_status");				
	    Emplyementstatus_name.sendKeys(Employement_status);
	    
	    savebutton.click();
		}
		catch(Exception e) {
			System.out.println("In the Exception block of Employement_Statuspage");
			System.out.println("Employement_Status not getting added ");
		}
	    JobcategoriesPage jc = new JobcategoriesPage(driver);
	    return jc;
		}
		
}
