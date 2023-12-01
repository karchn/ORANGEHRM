package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayGradePage extends AbstractMethods{

	WebDriver driver;

	public PayGradePage(WebDriver driverhere) {
                super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//span[@class='oxd-topbar-body-nav-tab-item'])[2]")
	WebElement click_job;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement clickonadd;

	@FindBy(xpath = "(//button[@type='button'])[3]")
	WebElement savebutton;

	@FindBy(xpath = "//a[text()='Pay Grades']/parent::li")
	WebElement paygrades;

	@FindBy(xpath ="(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement add_gradename;

	public EmployementStatusPage paygradepage() throws IOException, InterruptedException {
		
		
		try {
			click_job.click();
			paygrades.click();
			clickonadd.click();
			add_gradename.click();

			try {
			Properties prop = new Properties();// this method is already there in util class
			FileInputStream fs = new FileInputStream(
					System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
			prop.load(fs);
			String pay_grade = prop.getProperty("pay_grade");
			add_gradename.sendKeys(pay_grade);
			}
			catch(Exception e) {
				
			}
			savebutton.click();
		} 
		catch (Exception e) {
			System.out.println("In the Exception block of pay_grade");
			System.out.println("grade not getting added ");
		}
		EmployementStatusPage emp = new EmployementStatusPage(driver);
		return emp;
	}
}
