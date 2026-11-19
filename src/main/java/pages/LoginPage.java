package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	private WebDriver driver;

	// constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailField;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordField;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginBtn;

	@FindBy(xpath = "//span[@class='title text-black text-md']")
	private WebElement successMessage;

	@FindBy(xpath = "//span[@class='title text-black text-md']")
	private WebElement invalidCredntialMessage;

	public void loginAllProcess(String email, String password) throws InterruptedException {

		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		loginBtn.click();

		String acutalMessag = successMessage.getText();
		Assert.assertEquals(acutalMessag, "Login Successful", "Login Successful message does not match");
		Thread.sleep(5000);
	}

	public void loginWithInvalidCredntials(String invalidEmail, String invalidPasss) throws InterruptedException {

		emailField.sendKeys(invalidEmail);
		passwordField.sendKeys(invalidPasss);
		loginBtn.click();
		Thread.sleep(2000);

		String acutalMessag = invalidCredntialMessage.getText();
		Assert.assertEquals(acutalMessag, "Your email and password both are invalid!1", "Invalid Successful message does not match");
		Thread.sleep(5000);
	}

}