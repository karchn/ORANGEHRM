package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobTitlepage {

	WebDriver driver;

	public JobTitlepage(WebDriver driverhere) {
                super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//span[@class='oxd-topbar-body-nav-tab-item'])[2]")
	WebElement click_job;

	@FindBy(xpath = "//a[text()='Job Titles']/parent::li")
	WebElement clickJobTitle;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement clickonadd;

	@FindBy(xpath = "//input[@class='oxd-input oxd-input--active']")
	WebElement jobtitle;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement savebutton;

	public PayGradePage jobtitle() throws IOException, InterruptedException {
		implicitlywaitmethod();

		try {
		click_job.click();
		clickJobTitle.click();
		clickonadd.click();
		jobtitle.click();

		Properties prop = new Properties();// this method is already there in util class
		FileInputStream fs = new FileInputStream(
		System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
		prop.load(fs);
		String job_title = prop.getProperty("job_title");
		jobtitle.sendKeys(job_title);

		savebutton.click();
		}
		catch (Exception e) {
			System.out.println("In the Exception block of JobTitle");
			System.out.println("JobTitle not getting added ");
		}
		PayGradePage pg = new PayGradePage(driver);
		return pg;

	}

}
