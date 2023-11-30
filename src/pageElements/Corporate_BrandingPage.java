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

public class Corporate_BrandingPage {

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

	public Email_Configuration CorporateBrandingPage() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Properties prop = new Properties();// this method is already there in util class
	    FileInputStream fs =new FileInputStream(System.getProperty("user.dir")+("\\src\\testData\\GlobalInput.properties"));
	    prop.load(fs);
	    
	    try {
	    click_Corporate_Branding.click();
	    resetToDefault.click();
	    Thread.sleep(4000);
	    
	    
	    WebElement addClientLogo1 =driver.findElement(By.xpath("(//div[@class='oxd-file-button'])[1]"));	  
	    addClientLogo1.sendKeys(System.getProperty("user.dir")+"\\src\\testData\\Client_logo.png");
	    Thread.sleep(2000);
	    
	    WebElement addClientBanner1 =driver.findElement(By.xpath("(//div[@class='oxd-file-button'])[2]"));	  
	    addClientBanner1.sendKeys(System.getProperty("user.dir")+"\\src\\testData\\Cient_Banner.png");
	    Thread.sleep(2000);
	    
	    WebElement addLoginBanner1 =driver.findElement(By.xpath("(//div[@class='oxd-file-button'])[3]"));	  
	    addLoginBanner1.sendKeys(System.getProperty("user.dir")+"\\src\\testData\\Login_Banner.png");
	    Thread.sleep(2000);

	    clickonpublish.click();
	    }
	    catch(Exception e) {
	    	System.out.println("In the Exception block of Corporate_barnding tab");
	    }
	    
	    Email_Configuration ec = new Email_Configuration(driver);
	    return ec;
	}
}
