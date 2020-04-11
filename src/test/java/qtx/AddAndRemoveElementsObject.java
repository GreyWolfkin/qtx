package qtx;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddAndRemoveElementsObject extends PageObjectSuperClass {
	
	@FindBy(xpath="//div[@class='example']/button")
	WebElement addButton;
	
	public AddAndRemoveElementsObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public AddAndRemoveElementsObject goToPage() {
		navigate("/add_remove_elements/");
		return this;
	}

	public AddAndRemoveElementsObject addElement(int num) {
		for(int i = 0; i < num; i++) {
			addButton.click();
		}
		return this;
	}
	
	public AddAndRemoveElementsObject deleteElement(int num) {
		WebElement deleteButton;
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		for(int i = 0; i < num; i++) {
			try {
				deleteButton = driver.findElement(By.xpath("//div[@id='elements']/button"));
				deleteButton.click();
			} catch(NoSuchElementException ex) {
				break;
			}
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return this;
	}

	public int getNumElements() {
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		try {
			List<WebElement> buttons = driver.findElements(By.xpath("//div[@id='elements']//button"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return buttons.size();
		} catch(NoSuchElementException ex) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return 0;
		}
	}
}
