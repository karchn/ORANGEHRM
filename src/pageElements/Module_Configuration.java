package pageElements;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Module_Configuration {

	WebDriver driver;
	public Module_Configuration(WebDriver driverhere) {
		
		this.driver=driverhere;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[7]")
	WebElement click_Configuration;
	
	@FindBy(xpath="//a[text()='Modules']/parent::li")
	WebElement Modules;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button")
	WebElement submitbutton;
	
	public RegisterOAuth_Client module() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
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
