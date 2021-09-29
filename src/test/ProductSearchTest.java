package test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductSearchTest {
	
	WebDriver driver;
	WebDriver driver1;
	
	String USERNAME = "nikunjshah_NXSQOK";
	String AUTOMATE_KEY = "aq6gyHEp29BRcvxGUhrq";
	String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	
	@Test
	public void SeachTest() throws MalformedURLException {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver1.exe");
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "94");
		caps.setCapability("name", "First Test");

		driver = new RemoteWebDriver(new URL(URL), caps);
		
		//driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		HomePage homepage = new HomePage(driver);
		
		homepage.SeachProdudct("Samsung Galaxy S10");
		homepage.ApplyFilters();
		homepage.SortResults();
		homepage.DisplayName();
		
		driver.quit();
		
	}
	
	@Test
	public void SeachTest1() throws MalformedURLException {
		
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		caps.setCapability("browser", "Firefox");
		caps.setCapability("browser_version", "90.0");
		caps.setCapability("browserstack.local", "false");
		caps.setCapability("browserstack.selenium_version", "3.10.0");
		
		caps.setCapability("name", "First Test");

		driver1 = new RemoteWebDriver(new URL(URL), caps);
		
		//driver1 = new FirefoxDriver();
		driver1.get("https://www.flipkart.com/");
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		HomePage homepage = new HomePage(driver1);
		
		homepage.SeachProdudct("Samsung Galaxy S10");
		homepage.ApplyFilters();
		homepage.SortResults();
		homepage.DisplayName();
		
		driver1.quit();
		
	}

}
