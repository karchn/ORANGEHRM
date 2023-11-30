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

public class LanguagePakages_Configuration {

	WebDriver driver;
	public LanguagePakages_Configuration(WebDriver driverhere) {
		
		this.driver=driverhere;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[7]")
	WebElement click_Configuration;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[7]/ul/li[4]")
	WebElement Language_Packages;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[1]/div/button")
	WebElement addLanguage;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div/div/div/form/div[1]/div/div[2]/div/div/div[2]/i")
	WebElement Languagename_Dropdown;
	
	@FindBy(xpath="//*[text() ='English (India)']")
	WebElement selectname;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div/div/div/form/div[3]/button[1]")
	WebElement submitbutton;
	
	public Module_Configuration language_pakage() throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Properties prop = new Properties();// this method is already there in util class
	    FileInputStream fs =new FileInputStream(System.getProperty("user.dir")+("\\src\\testData\\GlobalInput.properties"));
	    prop.load(fs);
	    
          try {
        	  Thread.sleep(2000);
        	  click_Configuration.click();
        	  Language_Packages.click();
        	  
        	  Thread.sleep(3000);
        	  addLanguage.click();
        	  Languagename_Dropdown.click();
        	  Thread.sleep(2000);
        	 
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
