package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterOAuth_Client extends AbstractMethods{

	WebDriver driver;
	public RegisterOAuth_Client(WebDriver driverhere) {
		super(driverhere);
		this.driver=driverhere;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//li[@class='--active oxd-topbar-body-nav-tab --parent']")
	WebElement click_Configuration;
	
	@FindBy(xpath="//a[text()='Register OAuth Client']/parent::li")
	WebElement Register_OAuth_Client;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement addbutton;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement OAuthCleient_Name;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[3]")
	WebElement OAuthCleient_URL;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement savebutton;

	By OAuthCleient_Name1 = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	
	public LDAP_Configurationpage oauthClient_registration() throws IOException {
	    implicitlywaitmethod();
	    Properties prop = new Properties();// this method is already there in util class
	    FileInputStream fs =new FileInputStream(System.getProperty("user.dir")+("\\src\\testData\\GlobalInput.properties"));
	    prop.load(fs);
	    
	    try {
	    	 click_Configuration.click();
	    	 Register_OAuth_Client.click();
	    	 addbutton.click();
	    	 Wait_Till_Link_Is_Clickable(OAuthCleient_Name1);
	    	 
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
