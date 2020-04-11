package qtx;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class ExitIntentObject extends PageObjectSuperClass {
	
	@FindBy(xpath="//div[@id='ouibounce-modal']")
	WebElement modalBlock;
	
	Actions builder;
	
	public ExitIntentObject(WebDriver driverInstance) {
		super(driverInstance);
		builder = new Actions(driver);
	}

	public ExitIntentObject goToPage() {
		navigate("/exit_intent");
		return this;
	}

	public ExitIntentObject loseFocus() {
		// Throws MoveTargetOutOfBoundsException
		// WebDriver cannot move mouse out of bounds of current window
		// Cannot trigger popup window without use of external automation functionality
		builder.moveToElement(driver.findElement(By.cssSelector("h3")));
		int windowHeight = driver.manage().window().getSize().getHeight();
		builder.moveByOffset(0, windowHeight).perform();
		return this;
	}
	
	public ExitIntentObject waitForWindow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.pollingEvery(Duration.ofMillis(500))
				.withTimeout(Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeToBe(modalBlock, "style", "display: block;"));
		return this;
	}

	public String getText() {
		return modalBlock.findElement(By.xpath(".//div[@class='modal-body']/p")).getText();
	}

}
