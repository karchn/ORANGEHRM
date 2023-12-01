package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LanguagePakages_Configuration extends AbstractMethods{

	WebDriver driver;
	public LanguagePakages_Configuration(WebDriver driverhere) {
		super(driverhere);
		this.driver=driverhere;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[@class='--active oxd-topbar-body-nav-tab --parent']")
	WebElement click_Configuration;
	
	@FindBy(xpath="//a[text()='Language Packages']/parent::li")
	WebElement Language_Packages;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement addLanguage;
	
	@FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
	WebElement Languagename_Dropdown;
	
	@FindBy(xpath="//*[text() ='English (India)']")
	WebElement selectname;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitbutton;

	By click_Configuration1 = By.xpath("//li[@class='--active oxd-topbar-body-nav-tab --parent']");
	By addLanguage1 = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
	By Languagename_Dropdown1 = By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']");
	
	public Module_Configuration language_pakage() throws IOException {
		implicitlywaitmethod();
		Properties prop = new Properties();// this method is already there in util class
	    FileInputStream fs =new FileInputStream(System.getProperty("user.dir")+("\\src\\testData\\GlobalInput.properties"));
	    prop.load(fs);
	    
          try {
        	  Wait_Till_Link_Is_Clickable(click_Configuration1);
        	  click_Configuration.click();
        	  Language_Packages.click();
        	  
        	 Wait_Till_Link_Is_Clickable(addLanguage1);
        	  addLanguage.click();
        	  Languagename_Dropdown.click();
        	   Wait_Till_Link_Is_Clickable(Languagename_Dropdown1);
        	 
        	 String language = prop.getProperty("language");
        	 WebElement name= driver.findElement(By.xpath("//*[text() ='"+language+"']"));
           	 name.click();
           	 
        	  submitbutton.click();
          }
          catch(Exception e) {
        	  System.out.println("I am in exception block of language pakages of configuration tab");
          }
          
          Module_Configuration mc = new Module_Configuration(driver);
          return mc;
	}
}
