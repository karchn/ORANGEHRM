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

public class LDAP_Configurationpage {

	WebDriver driver;

	public LDAP_Configurationpage(WebDriver driverhere) {

		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[7]")
	WebElement click_Configuration;

	@FindBy(xpath = "//a[text()='LDAP Configuration']/parent::li")
	WebElement LDAPConfiguration;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div/div/label/span")
	WebElement enabled;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/input")
	WebElement server_host;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/input")
	WebElement server_port;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[2]/i")
	WebElement Encryption_dropdown;

	@FindBy(xpath = "//*[text()='TLS']")
	WebElement Encriptionselect;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[1]/div/div[2]/input")
	WebElement NAME;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[2]/div/div[2]/input")
	WebElement password;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/div/div[1]/div/div[2]/input")
	WebElement BaseName;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/div/div[3]/div/div[2]/input")
	WebElement userAttributeName;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/div/div[4]/div/div[2]/input")
	WebElement UserSearchFilter;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/div/div[3]/div/div[2]/input")
	WebElement UniqueIDAttribute;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/div/div[5]/div/div[2]/input")
	WebElement datamapping_firstname1;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/div/div[11]/div/div[2]/input")
	WebElement datamapping_lastname1;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/div/div[14]/div/div[2]/input")
	WebElement datamapping_UserStatus1;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/div/div[17]/div/div[2]/input")
	WebElement datamapping_workmail1;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/div/div[20]/div/div[2]/input")
	WebElement datamapping_employeeid1;

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[8]/button[2]")
	WebElement savebutton;

	public CloseBrowser Config() throws IOException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Properties prop = new Properties();// this method is already there in util class
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
		prop.load(fs);

		try {

			click_Configuration.click();
			LDAPConfiguration.click();
			Thread.sleep(2000);

			enabled.click();
			
			server_host.click();
			server_host.sendKeys(Keys.CONTROL + "a");
			server_host.sendKeys(Keys.DELETE);
			Thread.sleep(2000);
			String serverhost = prop.getProperty("serverhost");
			server_host.sendKeys(serverhost);
			
			server_port.click();
			server_port.sendKeys(Keys.CONTROL + "a");
			server_port.sendKeys(Keys.DELETE);
			Thread.sleep(2000);
			String serverport = prop.getProperty("serverport");
			server_port.sendKeys(serverport);
			
			Encryption_dropdown.click();
			String select = prop.getProperty("SelectEncryption");			
			WebElement encryptionname = driver.findElement(By.xpath("//*[text()='"+select+"']"));
			encryptionname.click();
			
			NAME.click();
			NAME.sendKeys(Keys.CONTROL + "a");
			NAME.sendKeys(Keys.DELETE);
			Thread.sleep(2000);
			String Bind_Settings_DistinguishedName = prop.getProperty("Bind_Settings_DistinguishedName");
			NAME.sendKeys(Bind_Settings_DistinguishedName);
			
			password.click();
			password.sendKeys(Keys.CONTROL + "a");
			password.sendKeys(Keys.DELETE);
			Thread.sleep(2000);
			String Bind_Settings_password = prop.getProperty("Bind_Settings_password");
			password.sendKeys(Bind_Settings_password);
			
			BaseName.click();
			BaseName.sendKeys(Keys.CONTROL + "a");
			BaseName.sendKeys(Keys.DELETE);
			Thread.sleep(2000);
			String Base_Name = prop.getProperty("Base_Name");
			BaseName.sendKeys(Base_Name);
			
			userAttributeName.click();
			userAttributeName.sendKeys(Keys.CONTROL + "a");
			userAttributeName.sendKeys(Keys.DELETE);
			Thread.sleep(1000);
			String user_AttributeName = prop.getProperty("user_AttributeName");
			userAttributeName.sendKeys(user_AttributeName);
			
			UserSearchFilter.click();
			UserSearchFilter.sendKeys(Keys.CONTROL + "a");
			UserSearchFilter.sendKeys(Keys.DELETE);
			Thread.sleep(1000);
			String search_filter = prop.getProperty("search_filter");
			UserSearchFilter.sendKeys(search_filter);
			
			UniqueIDAttribute.click();
			UniqueIDAttribute.sendKeys(Keys.CONTROL + "a");
			UniqueIDAttribute.sendKeys(Keys.DELETE);
			Thread.sleep(1000);
			String UniqueID_Attribute = prop.getProperty("UniqueID_Attribute");
			UniqueIDAttribute.sendKeys(UniqueID_Attribute);
			
			datamapping_firstname1.click();
			datamapping_firstname1.sendKeys(Keys.CONTROL + "a");
			datamapping_firstname1.sendKeys(Keys.DELETE);
			Thread.sleep(2000);
			String datamapping_firstname = prop.getProperty("datamapping_firstname");
			datamapping_firstname1.sendKeys(datamapping_firstname);
			
			datamapping_lastname1.click();
			datamapping_lastname1.sendKeys(Keys.CONTROL + "a");
			datamapping_lastname1.sendKeys(Keys.DELETE);
			Thread.sleep(2000);
			String datamapping_lastname = prop.getProperty("datamapping_lastname");
			datamapping_lastname1.sendKeys(datamapping_lastname);
			
			datamapping_UserStatus1.click();
			datamapping_UserStatus1.sendKeys(Keys.CONTROL + "a");
			datamapping_UserStatus1.sendKeys(Keys.DELETE);
			Thread.sleep(2000);
			String datamapping_UserStatus = prop.getProperty("datamapping_UserStatus");
			datamapping_UserStatus1.sendKeys(datamapping_UserStatus);
			
			datamapping_workmail1.click();
			datamapping_workmail1.sendKeys(Keys.CONTROL + "a");
			datamapping_workmail1.sendKeys(Keys.DELETE);
			Thread.sleep(2000);
			String datamapping_workmail = prop.getProperty("datamapping_workmail");
			datamapping_workmail1.sendKeys(datamapping_workmail);
			
			datamapping_workmail1.click();
			datamapping_workmail1.sendKeys(Keys.CONTROL + "a");
			datamapping_workmail1.sendKeys(Keys.DELETE);
			Thread.sleep(2000);
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
