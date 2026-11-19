package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FormSubmissionPage {
	private WebDriver driver;

	// constructor
	public FormSubmissionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='Form Submission']")
	private WebElement FormSubmissionField;
	
	@FindBy(xpath = "//input[@id='name']")
	private WebElement nameField;
	



	public void FormSubmissinFlow() throws InterruptedException {		
		FormSubmissionField.click();
		nameField.sendKeys("User1");
		Thread.sleep(5000);

	}

}