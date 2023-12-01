package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WorkShiftPage extends AbstractMethods {

	WebDriver driver;

	public WorkShiftPage(WebDriver driverhere) {
                super(driverhere)
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//span[@class='oxd-topbar-body-nav-tab-item'])[2]")
	WebElement click_job;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement clickonadd;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement savebutton;

	@FindBy(xpath = "//a[text()='Work Shifts']/parent::li")
	WebElement WorkShifts;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement WorkShifts_name;

	@FindBy(xpath = "(//i[@class='oxd-icon bi-clock oxd-time-input--clock'])[1]")
	WebElement workinghours_from;

	@FindBy(xpath = "//input[@class='oxd-input oxd-input--active oxd-time-hour-input-text']")
	WebElement startingtime_hours;

	@FindBy(xpath = "//input[@class='oxd-input oxd-input--active oxd-time-minute-input-text']")
	WebElement startingtime_minutes;

	@FindBy(xpath = "//input[@name='pm']")
	WebElement startingtime_am_or_pm;

	@FindBy(xpath = "(//i[@class='oxd-icon bi-clock oxd-time-input--clock'])[2]")
	WebElement workinghours_to;

	@FindBy(xpath = "//input[@class='oxd-input oxd-input--active oxd-time-hour-input-text']")
	WebElement Endingtime_hours;

	@FindBy(xpath = "//input[@class='oxd-input oxd-input--active oxd-time-minute-input-text']")
	WebElement Endingtime_minutes;

	public GeneralInfoPage work_Shifts(String time, String time1) throws IOException, InterruptedException {
		implicitlywaitmethod();

		try {
		click_job.click();
		WorkShifts.click();
		clickonadd.click();
		WorkShifts_name.click();

		Properties prop = new Properties();// this method is already there in util class
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
		prop.load(fs);
		String WorkShiftsname = prop.getProperty("WorkShiftsname");
		WorkShifts_name.sendKeys(WorkShiftsname);

		workinghours_from.click();
		startingtime_hours.click();
		startingtime_hours.sendKeys(Keys.ARROW_RIGHT);

		startingtime_hours.sendKeys(Keys.CONTROL + "a");
		startingtime_hours.sendKeys(Keys.DELETE);
		
		String workinghours_fromtimehrs = prop.getProperty("workinghours_fromtimehrs");
		startingtime_hours.sendKeys(workinghours_fromtimehrs);

		startingtime_minutes.sendKeys(Keys.ARROW_RIGHT);
		startingtime_minutes.sendKeys(Keys.CONTROL + "a");
		startingtime_minutes.sendKeys(Keys.DELETE);
		
		String workinghours_fromtimemin = prop.getProperty("workinghours_fromtimemin");
		startingtime_minutes.sendKeys(workinghours_fromtimemin);

		WebElement select_time = driver.findElement(By.xpath("//input[@name='" + time + "']"));
		select_time.click();

		workinghours_to.click();
		Endingtime_hours.click();
		Endingtime_hours.sendKeys(Keys.ARROW_RIGHT);
		Endingtime_hours.sendKeys(Keys.CONTROL + "a");
		Endingtime_hours.sendKeys(Keys.DELETE);
		
		String workinghours_totimehrs = prop.getProperty("workinghours_totimehrs");
		Endingtime_hours.sendKeys(workinghours_totimehrs);

		Endingtime_minutes.sendKeys(Keys.ARROW_RIGHT);
		Endingtime_minutes.sendKeys(Keys.CONTROL + "a");
		Endingtime_minutes.sendKeys(Keys.DELETE);
		
		String workinghours_totimemin = prop.getProperty("workinghours_totimemin");
		Endingtime_minutes.sendKeys(workinghours_totimemin);

		WebElement select_time_to = driver.findElement(By.xpath("//input[@name='" + time1 + "']"));
		select_time_to.click();
		savebutton.click();
		}
		catch (Exception e) {
			System.out.println("In the Exception block of workshiftpage");
			System.out.println("workshifts not getting added ");
		}
		GeneralInfoPage op = new GeneralInfoPage(driver);
		return op;
	}
}
