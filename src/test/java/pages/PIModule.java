package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIModule {
	
	private WebDriver d;
	
	private By pimTab = By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']");
	private By AddEmp = By.xpath("//div[@class='oxd-topbar-body']//li[3]");
	private By firstN = By.xpath("//input[@placeholder='First Name']");
	private By midN = By.xpath("//input[@placeholder='Middle Name']");
	private By lastN = By.xpath("//input[@placeholder='Last Name']");
	private By empID = By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']");
	private By saveBtn = By.xpath("//button[normalize-space()='Save']");
	private By drpdwn = By.xpath("//div[@class='orangehrm-custom-fields']//div[@class='orangehrm-card-container']//form[@class='oxd-form']//div[@class='oxd-form-row']//div[@class='oxd-grid-3 orangehrm-full-width-grid']//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']");
	private By saveBtn2 = By.xpath("//div[@class='orangehrm-custom-fields']//button[@type='submit'][normalize-space()='Save']");
	private By doB = By.xpath("//label[normalize-space()='Date of Birth']/following::input[1]");
	private By EmpList = By.xpath("//div[@class='oxd-topbar-body']//li[2]");
	private By searchByEmpN = By.xpath("//label[normalize-space()='Employee Name']/following::input[1]");
	private By EStatus = By.xpath("(//div[@class=\"oxd-select-text--after\"])[1]");
	private By search = By.xpath("//button[normalize-space()='Search']");

	
	
	public  PIModule(WebDriver d) {
		this.d =d;
	}
	
	public void clickPIM() {
		d.findElement(pimTab).click();
	}
	
	public void AddEmpl() {
		d.findElement(AddEmp).click();
	}
	
	public void fN(String fname) {
		d.findElement(firstN).sendKeys(fname);
	}
	
	public void lN(String lName) {
		d.findElement(lastN).sendKeys(lName);
	}
	
	public void eID(String num) {
		d.findElement(empID).sendKeys(num);
	}
	
	public void saving() {
		d.findElement(saveBtn).click();
	}
	
	public String sucessMsg() {
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(5));
	    WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//*[contains(@class,'toast') or contains(@class,'oxd-toast') or contains(@class,'message') or contains(.,'success')]")
	        ));
		return msg.getText();
	}

	
	public void ClickEmpList() {
		d.findElement(EmpList).click();
	}
	
   
	public void searchEmp(String name) throws InterruptedException {
		d.findElement(searchByEmpN).sendKeys(name);
		Thread.sleep(2000);
		d.findElement(searchByEmpN).sendKeys(Keys.ARROW_DOWN);
		d.findElement(searchByEmpN).sendKeys(Keys.ENTER);
	}
	
	
	public void EmpStatus(String status) {
		
		d.findElement(EStatus).click();
		
		WebDriverWait wait = new WebDriverWait(d,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='"+ status+ "']"))).click();
	}


	public String FinalSearch(String found) {
		d.findElement(search).click();
		
		WebDriverWait wait = new WebDriverWait(d,Duration.ofSeconds(10));
	WebElement result =	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'"+found+"')]")));
		return result.getText();
	}
	
}
