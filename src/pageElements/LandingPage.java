package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.AbstractMethods;

public class LandingPage extends AbstractMethods {

	WebDriver driver;

	public LandingPage(WebDriver driverhere) {
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}

	public void GoTo() throws IOException {
		Properties prop = new Properties();// this method is already there in util class
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
		prop.load(fs);
		String url = prop.getProperty("url");
		driver.get(url);
		driver.manage().window().maximize();
	}

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")
	WebElement enterusername;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")
	WebElement enterpassword;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitbutton;

	public UserManagement enterlogindetails(String username, String password) throws InterruptedException {
		Thread.sleep(4000);
		enterusername.sendKeys(username);
		enterpassword.sendKeys(password);
		submitbutton.sendKeys(Keys.ENTER);
		UserManagement um = new UserManagement(driver);
		return um;
	}

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a")
	WebElement Admin;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement clickonadd;

	@FindBy(xpath = "//div[text()='-- Select --'][1]")
	WebElement userrole;

	@FindBy(xpath = "//*[text()='Admin']")
	WebElement selectadmin;

	public void clickonadmin() throws InterruptedException {
		Admin.click();
		Thread.sleep(3000);
		clickonadd.click();

	}

	public void adduser() throws InterruptedException {
		Thread.sleep(3000);
		userrole.click();
		Thread.sleep(3000);
		selectadmin.click();

	}
}
