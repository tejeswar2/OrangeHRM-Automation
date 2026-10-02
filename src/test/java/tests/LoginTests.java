package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.LaunchBase;
import pages.LoginPage;

public class LoginTests extends LaunchBase  {
	//testing the jenkins pipeline
	@Test
	public void testLogin() {
		LoginPage lp = new LoginPage(d);
		lp.enterUsername("Admin");
		lp.enterPass("admin123");
		lp.LoginB();
		
		Assert.assertEquals(d.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");

	}

	
	
	@DataProvider(name="invalidCred")
	public Object[][] inavlidLogin(){
		Object[][] data = {
				{"admam", "admin124"},
				{"Admin", "admin134"},
				{"Adman", "admin123"},
				
		};		
		return data;
	}
	
	@Test(dataProvider = "invalidCred")
	public void testInvalidLogin(String usern, String pw) {
		LoginPage lp2 = new LoginPage(d);
		lp2.enterUsername(usern);
        lp2.enterPass(pw);
        lp2.LoginB();
        
        Assert.assertEquals(lp2.getErrMsg() ,"Invalid credentials");
	}
	
	
	
	
}
