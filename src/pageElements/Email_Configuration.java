package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Email_Configuration extends AbstractMethods {

	WebDriver driver;
	public Email_Configuration(WebDriver driverhere) {
		super(driverhere);
		this.driver=driverhere;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[@class='--active oxd-topbar-body-nav-tab --parent']")
	WebElement click_Configuration;
	
	@FindBy(xpath="//a[text()='Email Configuration']/parent::li")
	WebElement EmailConfiguration;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement Email;
	
	@FindBy(xpath="(//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input'])[1]")
	WebElement SecureSMTP;
	
	@FindBy(xpath="(//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input'])[2]")
	WebElement SMTP;
	
	@FindBy(xpath="(//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input'])[3]")
	WebElement SendMail;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[3]")
	WebElement SMTPHost;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[4]")
	WebElement SMTPPort;
	
	@FindBy(xpath="(//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input'])[4]")
	WebElement SMTPYes;
	
	@FindBy(xpath="(//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input'])[5]")
	WebElement SMTPNo;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[5]")
	WebElement SMTPUser;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[6]")
	WebElement SMTPPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitbutton;

	By SMTP_Host = By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]");
	By Email_ID = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	By SMTP_Port = By.xpath("(//input[@class='oxd-input oxd-input--active'])[4]");
	By SMTP_User = By.xpath("(//input[@class='oxd-input oxd-input--active'])[5]");
	By SMTP_Password = By.xpath("(//input[@class='oxd-input oxd-input--active'])[6]");
	
	public Email_Subscriptions emailconfiguration() throws IOException {
		implicitlywaitmethod();
		Properties prop = new Properties();// this method is already there in util class
	    FileInputStream fs =new FileInputStream(System.getProperty("user.dir")+("\\src\\testData\\GlobalInput.properties"));
	    prop.load(fs);
	    
	    try {
	    	click_Configuration.click();	
	    	EmailConfiguration.click();
	    	
	    	String EmailID = prop.getProperty("EmailID");
	    	Email.sendKeys(Keys.CONTROL + "a");
	    	Email.sendKeys(Keys.DELETE);
	    	Wait_Till_Link_Is_Clickable(Email_ID);
	    	Email.sendKeys(EmailID);
	    	
	    	submitbutton.click();
	    }catch(Exception e) {
	    	System.out.println("I am in exception block of when sendmail radio button is clicked in email configuration tab");
	    	
	    }
	    
	    try {
	    	click_Configuration.click();	
	    	EmailConfiguration.click();
	    	
	    	SecureSMTP.click();
	    	
	    	String EmailID = prop.getProperty("EmailID");
	    	Email.sendKeys(Keys.CONTROL + "a");
	    	Email.sendKeys(Keys.DELETE);
	        Wait_Till_Link_Is_Clickable(Email_ID);
	    	Email.sendKeys(EmailID);
	    	
	    	String SMTP_Host = prop.getProperty("SMTP_Host");
	    	SMTPHost.sendKeys(Keys.CONTROL + "a");
	    	SMTPHost.sendKeys(Keys.DELETE);
	    	Wait_Till_Link_Is_Clickable(SMTP_Host);
	    	SMTPHost.sendKeys(SMTP_Host);
	    	
	    	String SMTP_Port = prop.getProperty("SMTP_Port");
	    	SMTPPort.sendKeys(Keys.CONTROL + "a");
	    	SMTPPort.sendKeys(Keys.DELETE);
	    	Wait_Till_Link_Is_Clickable(SMTP_Port);
	    	SMTPPort.sendKeys(SMTP_Port);
	    	
	    	SMTPYes.click();
	    	
	    	String SMTP_User = prop.getProperty("SMTP_User");
	    	SMTPUser.sendKeys(Keys.CONTROL + "a");
	    	SMTPUser.sendKeys(Keys.DELETE);
	    	Wait_Till_Link_Is_Clickable(SMTP_User);
	    	SMTPUser.sendKeys(SMTP_User);
	    	
	    	String SMTP_Password = prop.getProperty("SMTP_Password");
	    	SMTPPassword.sendKeys(Keys.CONTROL + "a");
	    	SMTPPassword.sendKeys(Keys.DELETE);
	    	Wait_Till_Link_Is_Clickable(SMTP_Password);
	    	SMTPPassword.sendKeys(SMTP_Password);
	    	
	    	submitbutton.click();
	    	
	    }
	    catch(Exception e) {
	    	System.out.println("I am in exception block of when securesmtp radio button is clicked in email configuration tab");	
	    }
	    Email_Subscriptions es = new Email_Subscriptions(driver); 
	    return es;
	    
	}
}
