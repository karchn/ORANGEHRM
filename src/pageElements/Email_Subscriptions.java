package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Email_Subscriptions extends AbstractMethods {

	WebDriver driver;
	public Email_Subscriptions(WebDriver driverhere) {
		
		this.driver=driverhere;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[@class='--active oxd-topbar-body-nav-tab --parent']")
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
		
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement addbutton;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement addname;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[3]")
	WebElement email;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement savebutton;
	
	@FindBy(xpath="(//button[@type='button'])[4]")
	WebElement cancelbutton;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div/div/div/form/div[2]/div/span")
	WebElement message;
	
	@FindBy(xpath="(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[1]")
	WebElement deletebutton;
	
	@FindBy(xpath="(//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin'])[1]")
	WebElement confirmdelete;
	
	By delete_button = By.xpath=("(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[1]");
	By Leave_Approvals = By.xpath=("(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[2]");
	By Leave_Assignments = By.xpath=("(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[3]");
	By Leave_Cancellations = By.xpath=("(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[4]");
	By Leave_Rejections = By.xpath=("(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[5]");
	By confirm_delete = By.xpath=("(//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin'])[1]";
	
	public Localization_Configuration emailsubscription() throws IOException, InterruptedException {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	Properties prop = new Properties();// this method is already there in util class
	FileInputStream fs =new FileInputStream(System.getProperty("user.dir")+("\\src\\testData\\GlobalInput.properties"));
	prop.load(fs);
	    
	    try {
	    	
	    	click_Configuration.click();
	    	EmailSubscriptions.click();
	    	Leaveapplication.click();
	    	Wait_Till_Link_Is_Clickable(delete_button);
	    	
	    	try {
	    	deletebutton.click();
		Wait_Till_Link_Is_Clickable(confirm_delete);
	    	confirmdelete.click();
	    	}
	    	catch(Exception e) {
	    		
	    	}
	    
	    	addbutton.click();
	    	String Subscriber_name = prop.getProperty("Subscriber_name");
	    	addname.sendKeys(Subscriber_name);
	    	
	    	String EmailID = prop.getProperty("EmailID");
	    	email.sendKeys(EmailID);
	    	
		savebutton.click();
	
	    }
	    catch(Exception e) {
	    	System.out.println("I am in exception block of leave application in email subscription tab");
	    }
	    
		driver.navigate().back();
		Wait_Till_Link_Is_Clickable(Leave_Approvals);
		
		 try {
		    
			LeaveApprovals.click();
		    	Wait_Till_Link_Is_Clickable(delete_button);
		    	
		    	try {
			    	deletebutton.click();
				Wait_Till_Link_Is_Clickable(confirm_delete);
			    	confirmdelete.click();
			    	
			    	}
			    	catch(Exception e) {
			    		
			    	}
		    	
		    	addbutton.click();
		    	String Subscriber_name = prop.getProperty("Subscriber_name");
		    	addname.sendKeys(Subscriber_name);
		    	
		    	String EmailID = prop.getProperty("EmailID");
		    	email.sendKeys(EmailID);
		    	 	
			savebutton.click();						
		    }
		    catch(Exception e) {
		    	System.out.println("I am in exception block of leave approval in email subscription tab");
		    }
		 
		    driver.navigate().back();
		    Wait_Till_Link_Is_Clickable(Leave_Assignments);
			
			 try {
			    
				 LeaveAssignments.click();
			    	 Wait_Till_Link_Is_Clickable(delete_button);
			    	
			    	try {
				    	deletebutton.click();
					Wait_Till_Link_Is_Clickable(confirm_delete);
				    	confirmdelete.click();
				    	
				    	}
				    	catch(Exception e) {
				    		
				    	}
			    	
			    	addbutton.click();
			    	String Subscriber_name = prop.getProperty("Subscriber_name");
			    	addname.sendKeys(Subscriber_name);
			    	
			    	
			    	String EmailID = prop.getProperty("EmailID");
			    	email.sendKeys(EmailID);
	                        savebutton.click();					
		
			    }
			    catch(Exception e) {
			    	System.out.println("I am in exception block of Leave Assignments in email subscription tab");
			    }
		 
			    driver.navigate().back();
			    Wait_Till_Link_Is_Clickable(Leave_Cancellations);
				
				 try {
				    
					LeaveCancellations.click();
				    	Wait_Till_Link_Is_Clickable(delete_button);
				    	
				    	try {
					    	deletebutton.click();
						Wait_Till_Link_Is_Clickable(confirm_delete);
					    	confirmdelete.click();
					    	
					    	}
					    	catch(Exception e) {
					    		
					    	}
				    	
				    	addbutton.click();
				    	String Subscriber_name = prop.getProperty("Subscriber_name");
				    	addname.sendKeys(Subscriber_name);
				    	
				    	
				    	String EmailID = prop.getProperty("EmailID");
				    	email.sendKeys(EmailID);

					savebutton.click();							
				    }
				    catch(Exception e) {
				    	System.out.println("I am in exception block of Leave Cancellations in email subscription tab");
				    }
				 
				    driver.navigate().back();
				    Wait_Till_Link_Is_Clickable(Leave_Rejections);
					
					 try {
					    
						LeaveRejections.click();
					    	Wait_Till_Link_Is_Clickable(delete_button);
					    	
					    	try {
						    	deletebutton.click();
							Wait_Till_Link_Is_Clickable(confirm_delete);
						    	confirmdelete.click();
						    	
						    	}
						    	catch(Exception e) {
						    		
						    	}
					    	
					    	addbutton.click();
					    	String Subscriber_name = prop.getProperty("Subscriber_name");
					    	addname.sendKeys(Subscriber_name);
					    	
					    	
					    	String EmailID = prop.getProperty("EmailID");
					    	email.sendKeys(EmailID);
					    
						savebutton.click();						
					    }
					    catch(Exception e) {
					    	System.out.println("I am in exception block of Leave Rejections in email subscription tab");
					    }
					 
					 Localization_Configuration lc =  new Localization_Configuration(driver);
					 return lc;
	}
}
