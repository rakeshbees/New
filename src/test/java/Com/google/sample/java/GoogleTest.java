package Com.google.sample.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleTest {

	WebDriver driver;

	@BeforeClass

	public void Setup()

	{
		System.setProperty("webdriver.chrome.driver", "/Users/rakesh/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void GoogleLogo()

	{
		boolean b = driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed();

	}

	@Test
	public void GoogleTitle()

	{
		String Str = driver.getTitle();
		System.out.println(Str);
		Assert.assertEquals(Str, "Google");
	}

	@AfterMethod

	public void Teardown(ITestResult result)

	{

		if (ITestResult.FAILURE == result.getStatus())
			;
		CaptureScreenshot(driver, result.getName());
		driver.quit();

	
	}

	private void CaptureScreenshot(WebDriver driver2, String name) {
		// TODO Auto-generated method stub
		
	}

}
