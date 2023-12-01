package pageElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.AbstractMethods;

public class UserManagement extends AbstractMethods{

	 WebDriver driver;
	public UserManagement(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	   @FindBy(xpath="(//a[@class='oxd-main-menu-item'])[1]")
	   WebElement Admin;
	   
	   @FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	   WebElement clickonadd;
	  	  	  
	   By addclick = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
	      
	   
	   public void clickonadmin() throws InterruptedException {
		   Admin.click();
		   Wait_Till_Link_Is_Clickable(addclick);
		   clickonadd.click();
		   
	   }
	   
	   @FindBy(xpath="//div[text()='-- Select --'][1]")
	   WebElement  userrole;
	   
	   @FindBy(xpath="//*[text()='Admin']")
	   WebElement  selectadmin;
	   
	   @FindBy(xpath="(//div[text()='-- Select --'])[2]")
	   WebElement statusselect;
	   
	   @FindBy(xpath="//*[text()='Enabled']")
	   WebElement  selectenabled;
	   
	  @FindBy(xpath="//input[@placeholder='Type for hints...']")
	  WebElement Employeename;
	   
	  
	  @FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	  WebElement username;
	  
	  @FindBy(xpath="//button[@type='submit']")
	  WebElement submitbutton;
	  
	  @FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--ghost']")
	  WebElement cancelbutton;
	  
	  By user_role = By.xpath("//div[text()='-- Select --'][1]");
	   By select_admin = By.xpath("//*[text()='Admin']");
	   By status_select = By.xpath("(//div[text()='-- Select --'])[2]");
	   By select_enabled = By.xpath("//*[text()='Enabled']");
	   
	   
	   public void adduser() throws InterruptedException {
		 
		   Wait_Till_Link_Is_Clickable(user_role);
		   userrole.click();
		   Wait_Till_Link_Is_Clickable(select_admin);
		   selectadmin.click();
		  
		   Wait_Till_Link_Is_Clickable(user_role);
		   statusselect.click();
		   Wait_Till_Link_Is_Clickable(select_admin);
		   selectenabled.click();
		   
		   try {
			   Employeename.sendKeys("Guna  Seelan"); 
			   username.sendKeys("Archana");
			   submitbutton.click();
			   
		   }
		   catch(Exception e){
			   System.out.println("In Exception block");
			   System.out.println("Unable to get employee name..---so clicking on cancel");
			   cancelbutton.click();
		   }		  
			
		   
		   }
		  
	  @FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	  WebElement systemusername;
	  
	  @FindBy(xpath="//div[text()='-- Select --'][1]")
	  WebElement system_userrole;
	  
	  @FindBy(xpath="//*[text()='Admin']")
	  WebElement userrole_Admin;
	  
	  @FindBy(xpath="//input[@placeholder='Type for hints...']")
	  WebElement Employee_name;
	  
	  @FindBy(xpath="(//div[text()='-- Select --'])[2]")
	  WebElement status;
	  
	  @FindBy(xpath="//*[text()='Enabled']")
	  WebElement enabled_status;
	  
	  @FindBy(xpath="//button[@type='submit']")
	  WebElement searchbutton;
	  
	   public JobTitlepage System_user() throws InterruptedException {
		 implicitlywaitmethod();
		
		   try {
		   systemusername.sendKeys("archana");
		
		   system_userrole.click();
		
		   userrole_Admin.click();
		
		   Employee_name.sendKeys("Dominic Chase");
		   status.click();
		   enabled_status.click();
		   searchbutton.click();
		   
		   }
		   catch (Exception e) {
				System.out.println("In the Exception block of usermanagement");
			}
		   JobTitlepage jp = new JobTitlepage(driver);
		   return jp;
		   
		   }
		   
	   }

