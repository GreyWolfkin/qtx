package qtx;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowsObject extends PageObjectSuperClass {
	
	@FindBy(xpath="//div[@class='example']/a")
	WebElement newWindowLink;
	
	String mainWindow;
	String childWindow;
	String storedText;
	
	public WindowsObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public WindowsObject goToPage() {
		navigate("/windows");
		return this;
	}

	public WindowsObject openNewWindow() {
		newWindowLink.click();
		return this;
	}

	public WindowsObject focusOnNewWindow() {
		mainWindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		
		while(i1.hasNext()) {
			childWindow=i1.next();
			
			if(!mainWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
			}
		}
		return this;
	}

	public WindowsObject storeText() {
		storedText = driver.findElement(By.xpath("//h3")).getText();
		return this;
	}

	public WindowsObject closeWindow() {
		driver.close();
		return this;
	}

	public WindowsObject focusOnOldWindow() {
		driver.switchTo().window(mainWindow);
		return this;
	}

	public String retrieveText() {
		return storedText;
	}
	
	

}
