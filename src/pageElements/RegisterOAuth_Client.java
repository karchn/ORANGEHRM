package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterOAuth_Client {

	WebDriver driver;
	public RegisterOAuth_Client(WebDriver driverhere) {
		
		this.driver=driverhere;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[7]")
	WebElement click_Configuration;
	
	@FindBy(xpath="//a[text()='Register OAuth Client']/parent::li")
	WebElement Register_OAuth_Client;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[1]/div/button")
	WebElement addbutton;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/input")
	WebElement OAuthCleient_Name;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/input")
	WebElement OAuthCleient_URL;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")
	WebElement savebutton;
	
	public LDAP_Configurationpage OAuthClient_registration() throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Properties prop = new Properties();// this method is already there in util class
	    FileInputStream fs =new FileInputStream(System.getProperty("user.dir")+("\\src\\testData\\GlobalInput.properties"));
	    prop.load(fs);
	    
	    try {
	    	 click_Configuration.click();
	    	 Register_OAuth_Client.click();
	    	 addbutton.click();
	    	 Thread.sleep(1000);
	    	 
	    	 String Add_OAuth_Client_Name = prop.getProperty("OAuth_Client_Name");				
	    	 OAuthCleient_Name.sendKeys(Add_OAuth_Client_Name);
	    	 
	    	 String Redirect_URI = prop.getProperty("OAuthCleient_URL");				
	    	 OAuthCleient_URL.sendKeys(Redirect_URI);
	    	 
	    	 savebutton.click();
	    	 
	    }
	    catch(Exception e) {
	    	System.out.println("I am in the exception block of register OAuth client tab of configuration");
	    }
	    
	    LDAP_Configurationpage ldap = new LDAP_Configurationpage(driver);
	    return ldap;
	}
}
