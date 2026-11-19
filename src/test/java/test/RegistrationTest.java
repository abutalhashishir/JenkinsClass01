package test;

import org.testng.annotations.Test;

import base.Base;
import pages.RegistrationPage;

public class RegistrationTest extends Base{
	
	@Test
	public void registrationTest() throws InterruptedException {
		
		RegistrationPage registrationPage = new RegistrationPage(driver);
		registrationPage.registratioPageAllProcess(dataProp.getProperty("nameFied"), dataProp.getProperty("Country"),
				dataProp.getProperty("AccountType"),
				dataProp.getProperty("email2"), dataProp.getProperty("password1"),
				dataProp.getProperty("ConfiemPassword"));		
	}
		
}
