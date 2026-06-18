package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import listeners.ExtentTestNGListener;

@Listeners(ExtentTestNGListener.class)
public class LaunchBase {


	public WebDriver d;
	
	@BeforeMethod
	public void launch() {
		d = new ChromeDriver();
		   d.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
		    d.manage().window().maximize();
		d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@AfterMethod
	public void tearDown() {
		if(d!=null) {
			d.quit();
		}
	}
}
