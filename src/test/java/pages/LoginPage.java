package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    	private WebDriver d;
    	
    	
    	private By usernameBox = By.xpath("//input[@placeholder='Username']");
    	private By passBox = By.xpath("//input[@placeholder='Password']");
    	private By LoginBtn = By.xpath("//button[normalize-space()='Login']");
    	private By erroMsg =  By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");

    	
    	public LoginPage(WebDriver d) {
    		this.d = d;
    	}
    	
    	
    	public void enterUsername(String uname) {
    		d.findElement(usernameBox).sendKeys(uname);
    	}
       
    	public void enterPass(String pass) {
    		d.findElement(passBox).sendKeys(pass);
    	}
    	
    	public void LoginB() {
    		d.findElement(LoginBtn).click();
    	}
    	
    	
    public String getErrMsg() {
    	return d.findElement(erroMsg).getText();
    }
    
	
}
