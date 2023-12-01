package pageElements;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Module_Configuration extends AbstractMethods{

	WebDriver driver;
	public Module_Configuration(WebDriver driverhere) {
		super(driverhere);
		this.driver=driverhere;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[@class='--active oxd-topbar-body-nav-tab --parent']")
	WebElement click_Configuration;
	
	@FindBy(xpath="//a[text()='Modules']/parent::li")
	WebElement Modules;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitbutton;
	
	public RegisterOAuth_Client module() {
		implicitlywaitmethod();
		click_Configuration.click();
		try {
		Modules.click();
		submitbutton.click();		
		}
		catch(Exception e) {
			System.out.println("I am in exception block of module tab in configuration");
		}
		RegisterOAuth_Client rc = new RegisterOAuth_Client(driver);
		return rc;
	}
}
