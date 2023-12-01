package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Nationalities extends AbstractMethods {

	WebDriver driver;
	public Nationalities(WebDriver driverhere) {
		super(driverhere);
		this.driver=driverhere;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Nationalities']/parent::li")
	WebElement click_Nationalities;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement addbutton;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement addnationalityname;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveclick;

	By addnationalityname1 = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	
	public Corporate_BrandingPage nationalities() throws IOException {
		implicitlywaitmethod();
		Properties prop = new Properties();// this method is already there in util class
	    FileInputStream fs =new FileInputStream(System.getProperty("user.dir")+("\\src\\testData\\GlobalInput.properties"));
	    prop.load(fs);
	    
	    try {
	    click_Nationalities.click();
		addbutton.click();
		
		Wait_Till_Link_Is_Clickable(addnationalityname1);
		 String Nationality_name = prop.getProperty("Nationality_name");				
		 addnationalityname.sendKeys(Nationality_name);
		 
		 saveclick.click();
		 
	    }catch(Exception e) {
	    	System.out.println("I am in exception block of nationality tab");
	    }
	    
	    Corporate_BrandingPage cb = new Corporate_BrandingPage(driver);
	    return cb;
	}
}
