package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Qualification_EducationPage extends AbstractMethods{

	WebDriver driver;
	public Qualification_EducationPage(WebDriver driverhere) {
		super(driverhere);
		this.driver=driverhere;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//span[@class='oxd-topbar-body-nav-tab-item'])[4]")
	WebElement click_Qualifications;
	
	@FindBy(xpath="//a[text()='Education']/parent::li")
	WebElement clickEducation;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement addbutton;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement addEduLevel;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveclick;

	By addEduLevel1= By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	
	public Qualification_Licenses educationPage() throws IOException {
	implicitlywaitmethod();
	Properties prop = new Properties();// this method is already there in util class
	FileInputStream fs =new FileInputStream(System.getProperty("user.dir")+("\\src\\testData\\GlobalInput.properties"));
	prop.load(fs);
	    
	    try {
		click_Qualifications.click();
		clickEducation.click();
		addbutton.click();
		
		Wait_Till_Link_Is_Clickable(addEduLevel1);
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
