package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Qualification_Skillspage extends AbstractMethods {

	WebDriver driver;
	public Qualification_Skillspage(WebDriver driverhere) {
		super(driverhere);
		this.driver=driverhere;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//span[@class='oxd-topbar-body-nav-tab-item'])[4]")
	WebElement click_Qualifications;
	
	@FindBy(xpath="//a[text()='Skills']/parent::li")
	WebElement clickSkills;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement addbutton;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement addname;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/textarea")
	WebElement adddescription;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveclick;

	By click_Qualifications1 = By.xpath("(//span[@class='oxd-topbar-body-nav-tab-item'])[4]");
	By addname1 = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	
	public Qualification_EducationPage addskills() throws IOException, InterruptedException {
		implicitlywaitmethod();
		Properties prop = new Properties();// this method is already there in util class
	    FileInputStream fs =new FileInputStream(System.getProperty("user.dir")+("\\src\\testData\\GlobalInput.properties"));
	    prop.load(fs);
	    
	    try {
	       Wait_Till_Link_Is_Clickable(click_Qualifications1);
		click_Qualifications.click();
		clickSkills.click();
		addbutton.click();
		
		 Wait_Till_Link_Is_Clickable(addname1);
		 String add_skill_name = prop.getProperty("add_skill_name");				
		 addname.sendKeys(add_skill_name);
		 
		 String add_skill_description = prop.getProperty("add_skill_description");				
		 adddescription.sendKeys(add_skill_description);
		 
		 saveclick.click();
		 
	    }catch(Exception e) {
	    	System.out.println("I am in exception block of qualification_skill tab");
	    }
	    
	    Qualification_EducationPage ep = new Qualification_EducationPage(driver);
	    return ep;
	    
	}
	
}
