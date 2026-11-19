package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {

	protected WebDriver driver;

	protected String url = "https://practice.qabrains.com/";

	protected Properties dataProp;

	@BeforeMethod
	public void setUp() {

		dataProp = new Properties();

		File dataFile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\utils\\testdata.propertise");

		try {
			FileInputStream fis = new FileInputStream(dataFile);
			dataProp.load(fis);
			fis.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	// Capture Screenshot
	public String captureScreenshot(String testName) {
		File srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String folderPath = "C:\\Users\\HP\\eclipse-workspace\\SeleniumClass04Batch37\\Screenshort";
		String destinationPath = folderPath + testName + ".png";
		try {
			File screenshotFolder = new File(folderPath);
			if (!screenshotFolder.exists()) {
				screenshotFolder.mkdirs();
			}
			FileHandler.copy(srcScreenshot, new File(destinationPath));
			System.out.println("Screenshot saved: " + destinationPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destinationPath;
	}

}
