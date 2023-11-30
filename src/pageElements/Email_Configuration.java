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

public class Email_Configuration {

	WebDriver driver;
	public Email_Configuration(WebDriver driverhere) {
		
		this.driver=driverhere;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[7]")
	WebElement click_Configuration;
	
	@FindBy(xpath="//a[text()='Email Configuration']/parent::li")
	WebElement EmailConfiguration;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/input")
	WebElement Email;
	
	@FindBy(xpath="(//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input'])[1]")
	WebElement SecureSMTP;
	
	@FindBy(xpath="(//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input'])[2]")
	WebElement SMTP;
	
	@FindBy(xpath="(//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input'])[3]")
	WebElement SendMail;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")
	WebElement SMTPHost;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")
	WebElement SMTPPort;
	
	@FindBy(xpath="(//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input'])[4]")
	WebElement SMTPYes;
	
	@FindBy(xpath="(//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input'])[5]")
	WebElement SMTPNo;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/div/div[1]/div/div[2]/input")
	WebElement SMTPUser;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/div/div[2]/div/div[2]/input")
	WebElement SMTPPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitbutton;
	
	public Email_Subscriptions emailconfiguration() throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Properties prop = new Properties();// this method is already there in util class
	    FileInputStream fs =new FileInputStream(System.getProperty("user.dir")+("\\src\\testData\\GlobalInput.properties"));
	    prop.load(fs);
	    
	    try {
	    	click_Configuration.click();	
	    	EmailConfiguration.click();
	    	
	    	String EmailID = prop.getProperty("EmailID");
	    	Email.sendKeys(Keys.CONTROL + "a");
	    	Email.sendKeys(Keys.DELETE);
	    	Thread.sleep(2000);
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
	    	Thread.sleep(2000);
	    	Email.sendKeys(EmailID);
	    	
	    	String SMTP_Host = prop.getProperty("SMTP_Host");
	    	SMTPHost.sendKeys(Keys.CONTROL + "a");
	    	SMTPHost.sendKeys(Keys.DELETE);
	    	Thread.sleep(2000);
	    	SMTPHost.sendKeys(SMTP_Host);
	    	
	    	String SMTP_Port = prop.getProperty("SMTP_Port");
	    	SMTPPort.sendKeys(Keys.CONTROL + "a");
	    	SMTPPort.sendKeys(Keys.DELETE);
	    	Thread.sleep(2000);
	    	SMTPPort.sendKeys(SMTP_Port);
	    	
	    	SMTPYes.click();
	    	
	    	String SMTP_User = prop.getProperty("SMTP_User");
	    	SMTPUser.sendKeys(Keys.CONTROL + "a");
	    	SMTPUser.sendKeys(Keys.DELETE);
	    	Thread.sleep(2000);
	    	SMTPUser.sendKeys(SMTP_User);
	    	
	    	String SMTP_Password = prop.getProperty("SMTP_Password");
	    	SMTPPassword.sendKeys(Keys.CONTROL + "a");
	    	SMTPPassword.sendKeys(Keys.DELETE);
	    	Thread.sleep(2000);
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
