package test;

import org.testng.annotations.Test;

import base.Base;
import pages.FormSubmissionPage;
import pages.LoginPage;

public class FormSubmissionTest extends Base{
	
	@Test
	public void formSubmissionTest() throws InterruptedException {
		
		LoginPage loginPage = new LoginPage(driver);		
		loginPage.loginAllProcess(dataProp.getProperty("email"), dataProp.getProperty("password"));
		
		FormSubmissionPage formSubmissionPage =  new FormSubmissionPage(driver);		
		formSubmissionPage.FormSubmissinFlow();		
	}

}
