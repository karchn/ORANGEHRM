package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Email_Subscriptions {

	WebDriver driver;
	public Email_Subscriptions(WebDriver driverhere) {
		
		this.driver=driverhere;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[7]")
	WebElement click_Configuration;
	
	@FindBy(xpath="//a[text()='Email Subscriptions']/parent::li")
	WebElement EmailSubscriptions;
	
	@FindBy(xpath="(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[1]")
	WebElement Leaveapplication;
	
	@FindBy(xpath="(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[2]")
	WebElement LeaveApprovals;
	
	@FindBy(xpath="(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[3]")
	WebElement LeaveAssignments;
	
	@FindBy(xpath="(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[4]")
	WebElement LeaveCancellations;
	
	@FindBy(xpath="(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[5]")
	WebElement LeaveRejections;
		
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[1]/div/button")
	WebElement addbutton;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div/div/div/form/div[1]/div/div[2]/input")
	WebElement addname;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div/div/div/form/div[2]/div/div[2]/input")
	WebElement email;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div/div/div/form/div[3]/button[2]")
	WebElement savebutton;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div/div/div/form/div[3]/button[1]")
	WebElement cancelbutton;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div/div/div/form/div[2]/div/span")
	WebElement message;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div/div/div[4]/div/button[1]")
	WebElement deletebutton;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")
	WebElement confirmdelete;
	
	
	public Localization_Configuration emailsubscription() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Properties prop = new Properties();// this method is already there in util class
	    FileInputStream fs =new FileInputStream(System.getProperty("user.dir")+("\\src\\testData\\GlobalInput.properties"));
	    prop.load(fs);
	    
	    try {
	    	
	    	click_Configuration.click();
	    	EmailSubscriptions.click();
	    	Leaveapplication.click();
	    	Thread.sleep(2000);
	    	
	    	try {
	    	deletebutton.click();
	    	confirmdelete.click();
	    	Thread.sleep(2000);
	    	}
	    	catch(Exception e) {
	    		
	    	}
	    
	    	addbutton.click();
	    	String Subscriber_name = prop.getProperty("Subscriber_name");
	    	addname.sendKeys(Subscriber_name);
	    	
	    	Thread.sleep(1000);
	    	
	    	String EmailID = prop.getProperty("EmailID");
	    	email.sendKeys(EmailID);
	    	
	    	Thread.sleep(1000);
	    	
			
//	    	if((message.getText()).equalsIgnoreCase("Already exists")) {
//		    System.out.println("Email ID alreay exists");
//			cancelbutton.click();	
//			}
//	    	
//			else {
				savebutton.click();
	
	    }
	    catch(Exception e) {
	    	System.out.println("I am in exception block of leave application in email subscription tab");
	    }
	    
		driver.navigate().back();
		Thread.sleep(1000);
		
		 try {
		    
			 LeaveApprovals.click();
		    	Thread.sleep(1000);
		    	
		    	try {
			    	deletebutton.click();
			    	confirmdelete.click();
			    	Thread.sleep(2000);
			    	}
			    	catch(Exception e) {
			    		
			    	}
		    	
		    	addbutton.click();
		    	String Subscriber_name = prop.getProperty("Subscriber_name");
		    	addname.sendKeys(Subscriber_name);
		    	
		    	Thread.sleep(1000);
		    	
		    	String EmailID = prop.getProperty("EmailID");
		    	email.sendKeys(EmailID);
		    	
		    	Thread.sleep(1000);		    	

					savebutton.click();						
		    }
		    catch(Exception e) {
		    	System.out.println("I am in exception block of leave approval in email subscription tab");
		    }
		 
		    driver.navigate().back();
			Thread.sleep(1000);
			
			 try {
			    
				 LeaveAssignments.click();
			    	Thread.sleep(1000);
			    	
			    	try {
				    	deletebutton.click();
				    	confirmdelete.click();
				    	Thread.sleep(2000);
				    	}
				    	catch(Exception e) {
				    		
				    	}
			    	
			    	addbutton.click();
			    	String Subscriber_name = prop.getProperty("Subscriber_name");
			    	addname.sendKeys(Subscriber_name);
			    	
			    	Thread.sleep(1000);
			    	
			    	String EmailID = prop.getProperty("EmailID");
			    	email.sendKeys(EmailID);
			    	
			    	Thread.sleep(1000);
		    	

						savebutton.click();					
		
			    }
			    catch(Exception e) {
			    	System.out.println("I am in exception block of Leave Assignments in email subscription tab");
			    }
		 
			    driver.navigate().back();
				Thread.sleep(1000);
				
				 try {
				    
					    LeaveCancellations.click();
				    	Thread.sleep(1000);
				    	
				    	try {
					    	deletebutton.click();
					    	confirmdelete.click();
					    	Thread.sleep(2000);
					    	}
					    	catch(Exception e) {
					    		
					    	}
				    	
				    	addbutton.click();
				    	String Subscriber_name = prop.getProperty("Subscriber_name");
				    	addname.sendKeys(Subscriber_name);
				    	
				    	Thread.sleep(1000);
				    	
				    	String EmailID = prop.getProperty("EmailID");
				    	email.sendKeys(EmailID);
				    	
				    	Thread.sleep(1000);

							savebutton.click();							
				    }
				    catch(Exception e) {
				    	System.out.println("I am in exception block of Leave Cancellations in email subscription tab");
				    }
				 
				    driver.navigate().back();
					Thread.sleep(1000);
					
					 try {
					    
						    LeaveRejections.click();
					    	Thread.sleep(1000);
					    	
					    	try {
						    	deletebutton.click();
						    	confirmdelete.click();
						    	Thread.sleep(2000);
						    	}
						    	catch(Exception e) {
						    		
						    	}
					    	
					    	addbutton.click();
					    	String Subscriber_name = prop.getProperty("Subscriber_name");
					    	addname.sendKeys(Subscriber_name);
					    	
					    	Thread.sleep(1000);
					    	
					    	String EmailID = prop.getProperty("EmailID");
					    	email.sendKeys(EmailID);
					    	
					    	Thread.sleep(1000);

								savebutton.click();						
					    }
					    catch(Exception e) {
					    	System.out.println("I am in exception block of Leave Rejections in email subscription tab");
					    }
					 
					 Localization_Configuration lc =  new Localization_Configuration(driver);
					 return lc;
	}
}
