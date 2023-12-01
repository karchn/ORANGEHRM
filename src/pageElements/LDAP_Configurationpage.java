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

public class LDAP_Configurationpage extends AbstractMethods{

	WebDriver driver;

	public LDAP_Configurationpage(WebDriver driverhere) {

		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[7]")
	WebElement click_Configuration;

	@FindBy(xpath = "//a[text()='LDAP Configuration']/parent::li")
	WebElement LDAPConfiguration;
	
	@FindBy(xpath="//span[@class='oxd-switch-input oxd-switch-input--active --label-left']")
	WebElement enabled;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement server_host;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
	WebElement server_port;

	@FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]")
	WebElement Encryption_dropdown;

	@FindBy(xpath = "//*[text()='TLS']")
	WebElement Encriptionselect;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[4]")
	WebElement NAME;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[5]")
	WebElement password;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[6]")
	WebElement BaseName;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[7]")
	WebElement userAttributeName;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[8]")
	WebElement UserSearchFilter;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[9]")
	WebElement UniqueIDAttribute;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[10]")
	WebElement datamapping_firstname1;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[12]")
	WebElement datamapping_lastname1;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[13]")
	WebElement datamapping_UserStatus1;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[14]")
	WebElement datamapping_workmail1;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[15]")
	WebElement datamapping_employeeid1;

	@FindBy(xpath = "(//button[@type='button'])[4]")
	WebElement savebutton;

	By enabled1 = by.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-left']");
	public CloseBrowser config() throws IOException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Properties prop = new Properties();// this method is already there in util class
		FileInputStream fs = new FileInputStream(
		System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
		prop.load(fs);

		try {

			click_Configuration.click();
			LDAPConfiguration.click();
			Wait_Till_Link_Is_Clickable(enabled1);

			enabled.click();
			
			server_host.click();
			server_host.sendKeys(Keys.CONTROL + "a");
			server_host.sendKeys(Keys.DELETE);
			String serverhost = prop.getProperty("serverhost");
			server_host.sendKeys(serverhost);
			
			server_port.click();
			server_port.sendKeys(Keys.CONTROL + "a");
			server_port.sendKeys(Keys.DELETE);
			String serverport = prop.getProperty("serverport");
			server_port.sendKeys(serverport);
			
			Encryption_dropdown.click();
			String select = prop.getProperty("SelectEncryption");			
			WebElement encryptionname = driver.findElement(By.xpath("//*[text()='"+select+"']"));
			encryptionname.click();
			
			NAME.click();
			NAME.sendKeys(Keys.CONTROL + "a");
			NAME.sendKeys(Keys.DELETE);
			String Bind_Settings_DistinguishedName = prop.getProperty("Bind_Settings_DistinguishedName");
			NAME.sendKeys(Bind_Settings_DistinguishedName);
			
			password.click();
			password.sendKeys(Keys.CONTROL + "a");
			password.sendKeys(Keys.DELETE);
			String Bind_Settings_password = prop.getProperty("Bind_Settings_password");
			password.sendKeys(Bind_Settings_password);
			
			BaseName.click();
			BaseName.sendKeys(Keys.CONTROL + "a");
			BaseName.sendKeys(Keys.DELETE);
			String Base_Name = prop.getProperty("Base_Name");
			BaseName.sendKeys(Base_Name);
			
			userAttributeName.click();
			userAttributeName.sendKeys(Keys.CONTROL + "a");
			userAttributeName.sendKeys(Keys.DELETE);
			String user_AttributeName = prop.getProperty("user_AttributeName");
			userAttributeName.sendKeys(user_AttributeName);
			
			UserSearchFilter.click();
			UserSearchFilter.sendKeys(Keys.CONTROL + "a");
			UserSearchFilter.sendKeys(Keys.DELETE);
			String search_filter = prop.getProperty("search_filter");
			UserSearchFilter.sendKeys(search_filter);
			
			UniqueIDAttribute.click();
			UniqueIDAttribute.sendKeys(Keys.CONTROL + "a");
			UniqueIDAttribute.sendKeys(Keys.DELETE);
			String UniqueID_Attribute = prop.getProperty("UniqueID_Attribute");
			UniqueIDAttribute.sendKeys(UniqueID_Attribute);
			
			datamapping_firstname1.click();
			datamapping_firstname1.sendKeys(Keys.CONTROL + "a");
			datamapping_firstname1.sendKeys(Keys.DELETE);
			String datamapping_firstname = prop.getProperty("datamapping_firstname");
			datamapping_firstname1.sendKeys(datamapping_firstname);
			
			datamapping_lastname1.click();
			datamapping_lastname1.sendKeys(Keys.CONTROL + "a");
			datamapping_lastname1.sendKeys(Keys.DELETE);
			String datamapping_lastname = prop.getProperty("datamapping_lastname");
			datamapping_lastname1.sendKeys(datamapping_lastname);
			
			datamapping_UserStatus1.click();
			datamapping_UserStatus1.sendKeys(Keys.CONTROL + "a");
			datamapping_UserStatus1.sendKeys(Keys.DELETE);
			String datamapping_UserStatus = prop.getProperty("datamapping_UserStatus");
			datamapping_UserStatus1.sendKeys(datamapping_UserStatus);
			
			datamapping_workmail1.click();
			datamapping_workmail1.sendKeys(Keys.CONTROL + "a");
			datamapping_workmail1.sendKeys(Keys.DELETE);
			String datamapping_workmail = prop.getProperty("datamapping_workmail");
			datamapping_workmail1.sendKeys(datamapping_workmail);
			
			datamapping_workmail1.click();
			datamapping_workmail1.sendKeys(Keys.CONTROL + "a");
			datamapping_workmail1.sendKeys(Keys.DELETE);
			String datamapping_employeeid = prop.getProperty("datamapping_employeeid");
			datamapping_employeeid1.sendKeys(datamapping_employeeid);
			
			savebutton.click();
			
		} catch (Exception e) {
			System.out.println("I am in the exception block of ldap configuration");

		}
		
		CloseBrowser cs = new CloseBrowser(driver);
		return cs;
	}
}
