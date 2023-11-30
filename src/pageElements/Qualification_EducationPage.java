package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Qualification_EducationPage {

	WebDriver driver;
	public Qualification_EducationPage(WebDriver driverhere) {
		
		this.driver=driverhere;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//span[@class='oxd-topbar-body-nav-tab-item'])[4]")
	WebElement click_Qualifications;
	
	@FindBy(xpath="//a[text()='Education']/parent::li")
	WebElement clickEducation;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement addbutton;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")
	WebElement addEduLevel;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveclick;
	
	public Qualification_Licenses EducationPage() throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Properties prop = new Properties();// this method is already there in util class
	    FileInputStream fs =new FileInputStream(System.getProperty("user.dir")+("\\src\\testData\\GlobalInput.properties"));
	    prop.load(fs);
	    
	    try {
		click_Qualifications.click();
		clickEducation.click();
		addbutton.click();
		
		Thread.sleep(2000);
		 String add_education_level = prop.getProperty("add_education_level");				
		 addEduLevel.sendKeys(add_education_level);
		 
		 saveclick.click();
		 
	    }catch(Exception e) {
	    	System.out.println("I am in exception block of qualification_Education tab");
	    }
	    
	    Qualification_Licenses el = new Qualification_Licenses(driver);
	    return el;
	}
}
