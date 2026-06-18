package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.LaunchBase;
import pages.DashboardPage;
import pages.LoginPage;

public class DashboardTests extends LaunchBase{
	
	
	@Test(priority=1)
	public void testInfo() {
 
		LoginPage lp = new LoginPage(d);
		lp.enterUsername("Admin");
		lp.enterPass("admin123");
		lp.LoginB();
		
		DashboardPage dp = new DashboardPage(d);
		dp.InfoDetails();
		
		String name = dp.empName();
		System.out.println("Emp first name: "+ name);
		Assert.assertNotNull(name);
		Assert.assertFalse(name.isEmpty(), "Emp name is empty");
		
	}
	
	@Test(priority=2)
	public void logout() {
		LoginPage lp = new LoginPage(d);
		lp.enterUsername("Admin");
		lp.enterPass("admin123");
		lp.LoginB();
		
		DashboardPage dp = new DashboardPage(d);
		dp.Drpdwn();
		dp.loggigout();
		
		Assert.assertEquals(d.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test(priority = 3)
	public void loginDependencyDemo() {

	    LoginPage lp = new LoginPage(d);
	    lp.enterUsername("Admin");
	    lp.enterPass("admirioi");
	    lp.LoginB();

	    Assert.assertEquals(
	            d.getCurrentUrl(),
	            "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index",    "Login failed due to invalid credentials");
	}
	
	
	@Test(priority = 4, dependsOnMethods = "loginDependencyDemo")
	public void dashboardDependencyDemo() {

	    DashboardPage dp = new DashboardPage(d);
	    dp.InfoDetails();

	    String name = dp.empName();
	    Assert.assertNotNull(name);
	}

}
