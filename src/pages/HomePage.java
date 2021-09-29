package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HomePage {
	
	WebDriver driver;
	
	// ====================  Web Elements ===================================
	
	@FindBy(xpath="//button[text()='✕']")
	WebElement CloseLogin;
	
	@FindBy(xpath="//input[@title='Search for products, brands and more']")
	WebElement SearchTab;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement SubmitButton;
	
	
	@FindBy(xpath="//a[@title='Mobiles']")
	WebElement MobileCategoty;
	
	@FindBy(xpath="//div[text()='SAMSUNG']//preceding::div[1]")
	WebElement SamsungFilter;
	
	@FindBy(xpath="//span[text()='Price']//following::div[1]")
	WebElement FAssuredFilter;
	

	@FindBy(xpath="//div[text()='Price -- High to Low']")
	WebElement SortHighToLow;
	
	@FindBy(xpath="//div[contains(text(),'SAMSUNG Galaxy') and contains(text(),',')]")
	List<WebElement> NamesList;
	
	@FindBy(xpath="//div[contains(@class,'col col-')]//div[contains(@class,'WHN1')]")
	List<WebElement> PriceList;
	
	@FindBy(xpath="//div[contains(@class,'col col-')]//div[contains(@class,'WHN1')]//preceding::a[@target='_blank']")
	List<WebElement> LinksName;
	
	
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void SeachProdudct(String ProductName) {
		
		CloseLogin.click();
		waitToClick(SearchTab);
		SearchTab.sendKeys(ProductName);
		SubmitButton.click();
	}
	
	public void ApplyFilters() {
		
		MobileCategoty.click();
		ScrollToElement(SamsungFilter);
		waitToClick(SamsungFilter);
		SamsungFilter.click();
		waitToClick(FAssuredFilter);
		ScrollToElement(FAssuredFilter);
		FAssuredFilter.click();
	}
	
	public void SortResults() {
		
		ScrollToElement(SortHighToLow);
		SortHighToLow.click();
	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void DisplayName() {
		
		
		for(int i=0;i<NamesList.size()-1;i++) {
		
			NamesList= driver.findElements(By.xpath("//div[contains(text(),'SAMSUNG Galaxy') and contains(text(),',')]"));
			PriceList= driver.findElements(By.xpath("//div[contains(@class,'col col-')]//div[contains(@class,'WHN1')]"));
			LinksName= driver.findElements(By.xpath("//div[contains(@class,'col col-')]//div[contains(@class,'WHN1')]//preceding::a[@target='_blank']"));
			
		
			System.out.println(NamesList.size());
			
			System.out.println(NamesList.get(i).getText());
			System.out.println(PriceList.get(i).getText());
			System.out.println(LinksName.get(i).getAttribute("href"));
		}
	}
	
	public void waitToClick(WebElement elem) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(elem));
	}
	
	public void ScrollToElement(WebElement elm) {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(elm);
		//actions.perform();
	}

}
