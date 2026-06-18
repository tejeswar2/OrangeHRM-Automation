package tests;

import pages.LoginPage;
import pages.PIModule;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.LaunchBase;

public class PIMTests extends LaunchBase {
		
	@Test(priority=1)
	public void AddEmp() throws InterruptedException {
		LoginPage lp = new LoginPage(d);
		lp.enterUsername("Admin");
		lp.enterPass("admin123");
		lp.LoginB();
		
		PIModule pm = new PIModule(d);
		pm.clickPIM();
		pm.AddEmpl();
		pm.fN("Mahesh");
		//pm.mN("");
		pm.lN("G");
		pm.eID("98");
		pm.saving();
		//pm.DoB();
		String msg = pm.sucessMsg();
		Assert.assertTrue(msg.toLowerCase().contains("success"));
		pm.ClickEmpList();
		pm.searchEmp("Mahesh");
		//pm.EmpStatus("Full-Time Contract");
		String record = pm.FinalSearch("Record Found");
		Assert.assertTrue(record.contains("Record Found"), "No records found!");
		
		
	}
	
}
	

