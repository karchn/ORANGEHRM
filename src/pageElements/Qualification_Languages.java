package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Qualification_Languages {

	WebDriver driver;
	public Qualification_Languages(WebDriver driverhere) {
		
		this.driver=driverhere;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//span[@class='oxd-topbar-body-nav-tab-item'])[4]")
	WebElement click_Qualifications;
	
	@FindBy(xpath="//a[text()='Languages']/parent::li")
	WebElement clickLanguages;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement addbutton;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")
	WebElement addlanguage;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveclick;
	
	public Qualification_Membership languagepage() throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Properties prop = new Properties();// this method is already there in util class
	    FileInputStream fs =new FileInputStream(System.getProperty("user.dir")+("\\src\\testData\\GlobalInput.properties"));
	    prop.load(fs);
	    
	    try {
		click_Qualifications.click();
		clickLanguages.click();
		addbutton.click();
		
		Thread.sleep(2000);
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
