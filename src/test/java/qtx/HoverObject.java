package qtx;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HoverObject extends PageObjectSuperClass {

	@FindBy(xpath="//*[@id='content']//div/a[@href='/users/3']/../preceding-sibling::img")
	WebElement user3;

	@FindBy(xpath="//*[@id='content']//div/a[@href='/users/3']")
	WebElement link;

	Actions builder;

	public HoverObject(WebDriver driverInstance) {
		super(driverInstance);
		builder = new Actions(driverInstance);
	}

	public HoverObject goToPage() {
		navigate("/hovers");
		return this;
	}

	public HoverObject hoverOverUser() {
		builder
		.moveToElement(user3)
		.perform();
		return this;
	}

	public HoverObject clickLink() {
		builder
		.click(link)
		.perform();
		return this;
	}

	public String confirmUrl() {
		return driver.getCurrentUrl();
	}

}
