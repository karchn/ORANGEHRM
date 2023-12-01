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

	public void goTo() throws IOException {
		Properties prop = new Properties();// this method is already there in util class
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
		prop.load(fs);
		String url = prop.getProperty("url");
		driver.get(url);
		driver.manage().window().maximize();
	}

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[1]")
	WebElement enterusername;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement enterpassword;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitbutton;

	By enterusername1 = By.xpath("(//input[@class='oxd-input oxd-input--active'])[1]");
	
	public UserManagement enterlogindetails(String username, String password) throws InterruptedException {
		Wait_Till_Link_Is_Clickable(enterusername1);
		enterusername.sendKeys(username);
		enterpassword.sendKeys(password);
		submitbutton.sendKeys(Keys.ENTER);
		UserManagement um = new UserManagement(driver);
		return um;
	}

	@FindBy(xpath = "(//a[@class='oxd-main-menu-item'])[1]")
	WebElement Admin;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement clickonadd;

	@FindBy(xpath = "//div[text()='-- Select --'][1]")
	WebElement userrole;

	@FindBy(xpath = "//*[text()='Admin']")
	WebElement selectadmin;

	By clickonadd1 = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
	By userrole1 = By.xpath("//div[text()='-- Select --'][1]");
	By selectadmin1 = By.xpath("//*[text()='Admin']");
	
	public void clickonadmin() throws InterruptedException {
		Admin.click();
		Wait_Till_Link_Is_Clickable(clickonadd1);
		clickonadd.click();

	}

	public void adduser() throws InterruptedException {
		Wait_Till_Link_Is_Clickable(userrole1);
		userrole.click();
		Wait_Till_Link_Is_Clickable(selectadmin1);
		selectadmin.click();

	}
}
