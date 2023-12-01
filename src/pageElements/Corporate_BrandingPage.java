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

public class Corporate_BrandingPage extends AbstractMethods {

	WebDriver driver;
	public Corporate_BrandingPage(WebDriver driverhere) {
		
		this.driver=driverhere;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[6]")
	WebElement click_Corporate_Branding;
	
	@FindBy(xpath="(//div[@class='oxd-file-button'])[1]")
	WebElement addClientLogo;
	
	@FindBy(xpath="(//div[@class='oxd-file-button'])[2]")
	WebElement addClientBanner;
	
	@FindBy(xpath="(//div[@class='oxd-file-button'])[3]")
	WebElement addLoginBanner;
	
	@FindBy(xpath="(//button[@class='oxd-button oxd-button--medium oxd-button--ghost'])[1]")
	WebElement resetToDefault;

	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement clickonpublish; 
	
	@FindBy(xpath="(//div[@class='oxd-file-button'])[1]")
	WebElement addClientLogo1;

	@FindBy(xpath="(//div[@class='oxd-file-button'])[2]")
	WebElement addClientBanner1;

	@FindBy(xpath="(//div[@class='oxd-file-button'])[3]")
	WebElement addLoginBanner1;

	By add_ClientLogo1 = By.xpath("(//div[@class='oxd-file-button'])[1]");
	By add_ClientBanner1 = By.xpath("(//div[@class='oxd-file-button'])[2]");
	By add_LoginBanner1 = By.xpath("(//div[@class='oxd-file-button'])[3]");
	
	public Email_Configuration corporateBrandingPage() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Properties prop = new Properties();// this method is already there in util class
	    FileInputStream fs =new FileInputStream(System.getProperty("user.dir")+("\\src\\testData\\GlobalInput.properties"));
	    prop.load(fs);
	    
	    try {
	    click_Corporate_Branding.click();
	    resetToDefault.click();
	    Wait_Till_Link_Is_Clickable(add_ClientLogo1);
	    
	    
	    addClientLogo1.sendKeys(System.getProperty("user.dir")+"\\src\\testData\\Client_logo.png");	  
	    Wait_Till_Link_Is_Clickable(add_ClientBanner1);   	    
	    addClientBanner1.sendKeys(System.getProperty("user.dir")+"\\src\\testData\\Cient_Banner.png");
	    Wait_Till_Link_Is_Clickable(add_LoginBanner1);
	    addLoginBanner1.sendKeys(System.getProperty("user.dir")+"\\src\\testData\\Login_Banner.png");
	   
	    clickonpublish.click();
	    }
	    catch(Exception e) {
	    	System.out.println("In the Exception block of Corporate_barnding tab");
	    }
	    
	    Email_Configuration ec = new Email_Configuration(driver);
	    return ec;
	}
}
