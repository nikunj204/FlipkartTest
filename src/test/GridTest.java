package test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridTest {
	
	@Test
	public void test1() throws MalformedURLException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\TiaaUser\\OneDrive\\Desktop\\Selenium\\driver1\\chromedriver.exe");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		
		String URl = "http://192.168.56.1:4444/wd/hub"; 
		
		WebDriver driver = new RemoteWebDriver(new URL(URl),cap);
		
		//WebDriver driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");
			
	}

}
