package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobcategoriesPage {

	WebDriver driver;
	public JobcategoriesPage(WebDriver driverhere) {
		
		this.driver=driverhere;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//span[@class='oxd-topbar-body-nav-tab-item'])[2]")
	WebElement click_job;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement clickonadd;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement savebutton;
	
	@FindBy(xpath="//a[text()='Job Categories']/parent::li")
	WebElement Jobcategories;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")
	WebElement Jobcategories_name;
	
	public WorkShiftPage Job_Categories() throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		try {
		click_job.click();
		Jobcategories.click();
		clickonadd.click();
		Jobcategories_name.click();
		
		Properties prop = new Properties();// this method is already there in util class
	    FileInputStream fs =new FileInputStream(System.getProperty("user.dir")+("\\src\\testData\\GlobalInput.properties"));
	    prop.load(fs);
	    String Jobcategoriesname = prop.getProperty("Jobcategoriesname");				
	    Jobcategories_name.sendKeys(Jobcategoriesname);
	    
	    savebutton.click();
		}
		catch(Exception e) {
			System.out.println("In the Exception block of jobcategories");
			System.out.println("jobcategories not getting added ");
		}
	    WorkShiftPage ws = new WorkShiftPage(driver);
	    return ws;
		}

}