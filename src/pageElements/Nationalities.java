package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Nationalities {

	WebDriver driver;
	public Nationalities(WebDriver driverhere) {
		
		this.driver=driverhere;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Nationalities']/parent::li")
	WebElement click_Nationalities;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement addbutton;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")
	WebElement addnationalityname;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveclick;

	public Corporate_BrandingPage nationalities() throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Properties prop = new Properties();// this method is already there in util class
	    FileInputStream fs =new FileInputStream(System.getProperty("user.dir")+("\\src\\testData\\GlobalInput.properties"));
	    prop.load(fs);
	    
	    try {
	    click_Nationalities.click();
		addbutton.click();
		
		Thread.sleep(2000);
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
