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

public class LocationsPage extends AbstractMethods{

	WebDriver driver;
	public LocationsPage(WebDriver driverhere) {
		super(driverhere);
		this.driver=driverhere;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//span[@class='oxd-topbar-body-nav-tab-item'])[3]")
	WebElement click_organization;
	
	@FindBy(xpath="//a[text()='Locations']/parent::li")
	WebElement clicklocations;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement addbutton;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement Organization_Name;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[6]")
	WebElement phone;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[7]")
	WebElement fax;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[8]")
	WebElement Adress_Street1;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[3]")
	WebElement City_Name;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[4]")
	WebElement State_Name;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[5]")
	WebElement Zip_code;
	
	@FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
	WebElement clickonArrow;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[8]/div/div[2]/textarea")
	WebElement Notes;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit_button;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")
	WebElement name;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input")
	WebElement cityname;
	
	@FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
	WebElement clickarrow;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement clicksearch;
	
	public StructurePage locations() throws IOException, InterruptedException {
		implicitlywaitmethod();
		Properties prop = new Properties();// this method is already there in util class
		FileInputStream fs = new FileInputStream(
		System.getProperty("user.dir") + ("\\src\\testData\\GlobalInput.properties"));
		prop.load(fs);
		
		try {
		click_organization.click();
		clicklocations.click();
		addbutton.click();
		
		Organization_Name.click();
		Organization_Name.sendKeys(Keys.CONTROL + "a");
		Organization_Name.sendKeys(Keys.DELETE);
		String OrganizationName = prop.getProperty("OrganizationName");
		Organization_Name.sendKeys(OrganizationName);
		
		City_Name.click();
		City_Name.sendKeys(Keys.CONTROL + "a");
		City_Name.sendKeys(Keys.DELETE);	
		String CityName = prop.getProperty("CityName");
		City_Name.sendKeys(CityName);
		
		State_Name.click();
		Thread.sleep(2000);
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
		
		Adress_Street1.click();
		Adress_Street1.sendKeys(Keys.CONTROL + "a");
		Adress_Street1.sendKeys(Keys.DELETE);
		String AdressStreet1 = prop.getProperty("AdressStreet1");
		Adress_Street1.sendKeys(AdressStreet1);
		
		Notes.click();
		Notes.sendKeys(Keys.CONTROL + "a");
		Notes.sendKeys(Keys.DELETE);
		String Notes_info = prop.getProperty("Notes_info");
		Notes.sendKeys(Notes_info);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView();", submit_button);  
	    
		submit_button.click();
		
		}
		catch(Exception e) {
			System.out.println("I am in exception block of loctors add page");
		}
		
		try {
		click_organization.click();
		clicklocations.click();		
		name.click();
		String name1 = prop.getProperty("name1");
		name.sendKeys(name1);
		
		cityname.click();	
		String CityName1 = prop.getProperty("CityName");
		cityname.sendKeys(CityName1);
		
		clickarrow.click();
		
		String country1 = prop.getProperty("country");
		WebElement select_Country1 = driver.findElement(By.xpath("//*[text()='"+country1+"']"));
		select_Country1.click();
		
		clicksearch.click();
		}
		catch(Exception e) {
			System.out.println("I am in exception block of loctors page");
		}
		StructurePage sp = new StructurePage(driver);
		return sp;
	}
}
