package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeneralInfoPage extends AbstractMethods {

	WebDriver driver;
	public GeneralInfoPage(WebDriver driverhere) {
		super(driverhere);
		this.driver=driverhere;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//span[@class='oxd-topbar-body-nav-tab-item'])[3]")
	WebElement click_organization;
	
	@FindBy(xpath="//a[text()='General Information']/parent::li")
	WebElement clickgeneralinfo;
	
	@FindBy(xpath="//span[@class='oxd-switch-input oxd-switch-input--active --label-left']")
	WebElement clickEdit;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement Organization_Name;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[3]")
	WebElement Registration_number;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[4]")
	WebElement Tax_ID;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[5]")
	WebElement phone;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[6]")
	WebElement fax;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[7]")
	WebElement Emai_ID;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[8]")
	WebElement Adress_Street1;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[9]")
	WebElement Adress_Street2;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[10]")
	WebElement City_Name;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[11]")
	WebElement State_Name;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[12]")
	WebElement Zip_code;
	
	@FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
	WebElement clickonArrow;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[6]/div/div/div[2]/textarea")
	WebElement Notes;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit_button;
	
	
	public LocationsPage organization_generalInfo() throws IOException, InterruptedException {
	implicitlywaitmethod();	
	Properties prop = new Properties();// this method is already there in util class
	FileInputStream fs = new FileInputStream(
	System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
	prop.load(fs);
	
	try {
	click_organization.click();
	clickgeneralinfo.click();
	clickEdit.click();
	
	Organization_Name.click();
	Organization_Name.sendKeys(Keys.CONTROL + "a");
	Organization_Name.sendKeys(Keys.DELETE);
	String OrganizationName = prop.getProperty("OrganizationName");
	Organization_Name.sendKeys(OrganizationName);
	
	Registration_number.click();
	Registration_number.sendKeys(Keys.CONTROL + "a");
	Registration_number.sendKeys(Keys.DELETE);
	String Registrationnumber = prop.getProperty("Registrationnumber");
	Registration_number.sendKeys(Registrationnumber);
	
	Tax_ID.click();
	Tax_ID.sendKeys(Keys.CONTROL + "a");
	Tax_ID.sendKeys(Keys.DELETE);
	String TaxID = prop.getProperty("TaxID");
	Tax_ID.sendKeys(TaxID);
	
	phone.click();
	phone.sendKeys(Keys.CONTROL + "a");
	phone.sendKeys(Keys.DELETE);
	String phoneno = prop.getProperty("phoneno");
	phone.sendKeys(phoneno);
	
	fax.click();
	fax.sendKeys(Keys.CONTROL + "a");
	fax.sendKeys(Keys.DELETE);
	String faxno = prop.getProperty("faxno");
	fax.sendKeys(faxno);
	
	Emai_ID.click();
	Emai_ID.sendKeys(Keys.CONTROL + "a");
	Emai_ID.sendKeys(Keys.DELETE);
	String EmailID = prop.getProperty("EmailID");
	Emai_ID.sendKeys(EmailID);
	
	Adress_Street1.click();
	Adress_Street1.sendKeys(Keys.CONTROL + "a");
	Adress_Street1.sendKeys(Keys.DELETE);
	String AdressStreet1 = prop.getProperty("AdressStreet1");
	Adress_Street1.sendKeys(AdressStreet1);
	
	Adress_Street2.click();
	Adress_Street2.sendKeys(Keys.CONTROL + "a");
	Adress_Street2.sendKeys(Keys.DELETE);
	String AdressStreet2 = prop.getProperty("AdressStreet2");
	Adress_Street2.sendKeys(AdressStreet2);
	
	City_Name.click();
	City_Name.sendKeys(Keys.CONTROL + "a");
	City_Name.sendKeys(Keys.DELETE);	
	String CityName = prop.getProperty("CityName");
	City_Name.sendKeys(CityName);
	
	State_Name.click();
	State_Name.sendKeys(Keys.CONTROL + "a");
	State_Name.sendKeys(Keys.DELETE);
	String StateName = prop.getProperty("StateName");
	State_Name.sendKeys(StateName);
	
	Zip_code.click();
	Zip_code.sendKeys(Keys.CONTROL + "a");
	Zip_code.sendKeys(Keys.DELETE);
	String Zipcode = prop.getProperty("Zipcode");
	Zip_code.sendKeys(Zipcode);
	
	clickonArrow.click();
	
	String country = prop.getProperty("country");
	WebElement select_Country = driver.findElement(By.xpath("//*[text()='"+country+"']"));
	select_Country.click();
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", Notes); 
    
	Notes.click();
	Notes.sendKeys(Keys.CONTROL + "a");
	Notes.sendKeys(Keys.DELETE);
	String Notes_info = prop.getProperty("Notes_info");
	Notes.sendKeys(Notes_info);
	
	submit_button.click();
	}
	catch(Exception e) {
		System.out.println("In the Exception block of generalinfopage");
		System.out.println("generalinfo not getting added ");
	}
	LocationsPage lo = new LocationsPage(driver);
	return lo;
	}
	
	
}
