package qtx;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ContextMenuObject extends PageObjectSuperClass {
	
	@FindBy(id="hot-spot")
	WebElement hotSpot;
	
	Actions builder;
	
	public ContextMenuObject(WebDriver driverInstance) {
		super(driverInstance);
		builder = new Actions(driver);
	}

	public ContextMenuObject goToPage() {
		navigate("/context_menu");
		return this;
	}

	public ContextMenuObject rightClickBox() {
		builder.contextClick(hotSpot).perform();
		return this;
	}

	public String getAlertText() {
		return driver.switchTo().alert().getText();
	}

}
