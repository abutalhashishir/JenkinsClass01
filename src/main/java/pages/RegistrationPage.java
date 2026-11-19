package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class RegistrationPage {
	private WebDriver driver;
	
	//constructor
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//span[normalize-space()='Registration']")
	private WebElement registration;
	
	@FindBy(xpath = "//input[@id='name']")
	private WebElement NameFied;
	
	@FindBy(xpath = "//select[@id='country']")
	private WebElement CountryField;
	
	@FindBy(xpath = "//select[@id='account']")
	private WebElement AccountTypeField;
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailField;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordField;
	
	@FindBy(xpath = "//input[@id='confirm_password']")
	private WebElement confirmPasswordField;
	
	@FindBy(xpath = "//a[normalize-space()='Web Testing']")
	private WebElement webTesting;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//span[@class='title text-black text-md']")
	private WebElement successMessage;
	
	
	
	
	public void registratioPageAllProcess(String nameFied, String Country,String AccountType,String email2, String password1, String ConfiemPassword) throws InterruptedException {
		registration.click();
		NameFied.sendKeys(nameFied);
		Select country = new Select(CountryField);
		country.selectByVisibleText(Country);
		
		Select accountType = new Select(AccountTypeField);
		accountType.selectByVisibleText(AccountType);
		
		emailField.sendKeys(email2);
		passwordField.sendKeys(password1);
		confirmPasswordField.sendKeys(ConfiemPassword);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", webTesting);

		js.executeScript("arguments[0].click();", submitBtn);
		
		
		String acutalMessag = successMessage.getText();
		
		Assert.assertEquals(acutalMessag, "Registration Successful",
                "Registration Successful message not match");
		Thread.sleep(5000);
		
	}
	

}
