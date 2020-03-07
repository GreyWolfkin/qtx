package qtx;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public abstract class PageObjectSuperClass {
	
	protected WebDriver driver;
	private String baseUrl = "http://the-internet.herokuapp.com";
	
	protected PageObjectSuperClass(WebDriver driverInstance) {
		driver = driverInstance;
		PageFactory.initElements(driver, this);
	}
	
	protected void navigate(String url) {
		driver.get(baseUrl + url);
	}
}
