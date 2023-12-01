package pageElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Localization_Configuration extends AbstractMethods{

	WebDriver driver;
	public Localization_Configuration(WebDriver driverhere) {
		
		this.driver=driverhere;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[@class='--active oxd-topbar-body-nav-tab --parent']")
	WebElement click_Configuration;
	
	@FindBy(xpath="//a[text()='Localization']/parent::li")
	WebElement Localization;
	
	@FindBy(xpath="(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]")
	WebElement Language_Dropdown;
	
	@FindBy(xpath="(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])2]")
	WebElement DateFormat_Dropdown;
	
	@FindBy(xpath="//*[text() ='yyyy-mm-dd ( 2023-11-27 )']")
	WebElement selectDateFormat;
	
	@FindBy(xpath="//*[text() ='English (United States)']")
	WebElement selectLanguage;
	
	@FindBy(xpath="(//div[@class='oxd-select-text oxd-select-text--active'])[1]")
	WebElement language;
	
	@FindBy(xpath="(//div[@class='oxd-select-text oxd-select-text--active'])[2]")
	WebElement dateformat;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitbutton;
	
	public LanguagePakages_Configuration localization() throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Properties prop = new Properties();// this method is already there in util class
	    FileInputStream fs =new FileInputStream(System.getProperty("user.dir")+("\\src\\testData\\GlobalInput.properties"));
	    prop.load(fs);
	    
          try {
        	  click_Configuration.click();
        	  Localization.click();
        	  
        		  Language_Dropdown.click();
        		  selectLanguage.click();   	  
          }		
    
            catch(Exception e) {
    	     System.out.println("Getting an Exception at language text box of Configuration-Localization tab");
             }
          
           try {
        	  
        	  click_Configuration.click();
        	  Localization.click();
        	  LocalDate dateObj = LocalDate.now();
              DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
              String date = dateObj.format(formatter);
        	  System.out.println("Current date="+date);
        	  
        	  String Data_Format=dateformat.getText(); 
        	  
        	WebElement selectDateFormat= driver.findElement(By.xpath("//*[text() ='yyyy-mm-dd ("+date+")']"));
        	 String date_formatText=selectDateFormat.getText();
        	 
        	 String date_formatText1= "yyyy-mm-dd".concat(date_formatText);
        	 
        	  if(Data_Format.equals(date_formatText1)) {
        		  System.out.println("Date format is correct");
        	  }
        	  else {
        		 
        		  DateFormat_Dropdown.click();
        		  selectDateFormat.click();
        		  
        	  }       	  
           }		
           
           catch(Exception e) {
   	     System.out.println("Getting an Exception at dataformat text box of Configuration-Localization tab");
            } 
        	 
           LanguagePakages_Configuration lang = new LanguagePakages_Configuration(driver);
           return lang;
           }
	}
        	  
