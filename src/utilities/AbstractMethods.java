package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractMethods {

	WebDriver driver;
	
	public AbstractMethods(WebDriver driverhere) {
		this.driver = driverhere;
		
	}
	
	
	public void Wait_Till_Link_Is_Clickable(By FindBy) {
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(FindBy));				
	}
	
	
	
	public void Hoveranyelement(WebElement el) {
		
		Actions ac = new Actions(driver);
		ac.moveToElement(el).build().perform();
	}
	
}
