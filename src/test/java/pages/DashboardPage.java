package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	
	private WebDriver d;
	
	private By infoTab = By.xpath("//span[normalize-space()='My Info']");
	private By drpdwn = By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
	private By logout = By.xpath("//a[normalize-space()='Logout']");
	private By empN = By.xpath("//input[@placeholder='First Name']");
	
	public DashboardPage(WebDriver d) {
		this.d = d;
	}
	
	public void InfoDetails() {
		d.findElement(infoTab).click();
	}
	
	public void Drpdwn() {
	    WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(drpdwn)).click();
	}

	public void loggigout() {
	    WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(logout)).click();
	}
	
	public String empName() {
	    WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));

	    WebElement element = d.findElement(empN);

	    wait.until(ExpectedConditions.attributeToBeNotEmpty(element, "value"));

	    return element.getAttribute("value");
	}
	
}
