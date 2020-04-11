package qtx;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class EntryAdObject extends PageObjectSuperClass {
	
	@FindBy(id="modal")
	WebElement modalBlock;
	
	public EntryAdObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public EntryAdObject goToPage() {
		navigate("/entry_ad");
		return this;
	}

	public EntryAdObject waitForWindow() {
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
