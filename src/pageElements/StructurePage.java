package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StructurePage {

	WebDriver driver;
	public StructurePage(WebDriver driverhere) {
		
		this.driver=driverhere;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//span[@class='oxd-topbar-body-nav-tab-item'])[3]")
	WebElement click_organization;
	
	@FindBy(xpath="//a[text()='Structure']/parent::li")
	WebElement Structure;
	
	@FindBy(xpath="//span[@class='oxd-switch-input oxd-switch-input--active --label-left']")
	WebElement clickEdit;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary org-structure-add']")
	WebElement clickonadd;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement UnitIdentification;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[3]")
	WebElement name;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div/div/div/form/div[3]/div/div[2]/textarea")
	WebElement Description;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	WebElement savebutton;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div/div/div/form/div[2]/div/span")
	WebElement message;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div/div/div/form/div[4]/button[1]")
	WebElement cancelbutton;
	
	public Qualification_Skillspage structurepage() throws IOException {
		
		Properties prop = new Properties();// this method is already there in util class
		FileInputStream fs = new FileInputStream(
		System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
		prop.load(fs);
		
		try {
		click_organization.click();
		Structure.click();
		clickEdit.click();
		clickonadd.click();
		
		String Unit_Identification = prop.getProperty("Unit_Identification");
		UnitIdentification.sendKeys(Unit_Identification);		
//		
//		String Unit_Name = prop.getProperty("Unit_Name");
//		name.sendKeys(Unit_Name);

		cancelbutton.click();	

		}
		catch(Exception e) {
			
				System.out.println("I am in exception block of Organization Structure page");
		}
		
		Qualification_Skillspage qf = new Qualification_Skillspage(driver);
		return qf;
	}
}
