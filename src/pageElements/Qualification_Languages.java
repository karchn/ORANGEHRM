package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Qualification_Languages extends AbstractMethods {

	WebDriver driver;
	public Qualification_Languages(WebDriver driverhere) {
		super(driverhere);
		this.driver=driverhere;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//span[@class='oxd-topbar-body-nav-tab-item'])[4]")
	WebElement click_Qualifications;
	
	@FindBy(xpath="//a[text()='Languages']/parent::li")
	WebElement clickLanguages;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement addbutton;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement addlanguage;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveclick;
	
	By addlanguage1 = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	
	public Qualification_Membership languagepage() throws IOException {
		implicitlywaitmethod();
		Properties prop = new Properties();// this method is already there in util class
	    FileInputStream fs =new FileInputStream(System.getProperty("user.dir")+("\\src\\testData\\GlobalInput.properties"));
	    prop.load(fs);
	    
	    try {
		click_Qualifications.click();
		clickLanguages.click();
		addbutton.click();
		
		Wait_Till_Link_Is_Clickable(addlanguage1);
		 String add_language = prop.getProperty("add_language");				
		 addlanguage.sendKeys(add_language);
		 
		 saveclick.click();
		 
	    }catch(Exception e) {
	    	System.out.println("I am in exception block of qualification_Language tab");
	    }
	    
	    Qualification_Membership qm = new Qualification_Membership(driver);
	    return qm;
	}

}
