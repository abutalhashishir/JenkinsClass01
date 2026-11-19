package test;

import org.testng.annotations.Test;

import base.Base;
import pages.LoginPage;

public class LoginTest extends Base{
	
	@Test(priority = 1)
	public void loginTest() throws InterruptedException {
		
		LoginPage loginPage = new LoginPage(driver);		
		loginPage.loginAllProcess(dataProp.getProperty("email"), dataProp.getProperty("password"));
		
	}
	
	@Test(priority = 2)
	public void InvalidloginTest() throws InterruptedException {
		
		LoginPage loginPage = new LoginPage(driver);		
		loginPage.loginWithInvalidCredntials(dataProp.getProperty("invalidEmail"), dataProp.getProperty("invalidPasss"));		
	}
}
