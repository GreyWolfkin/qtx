package qtx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragAndDropObject extends PageObjectSuperClass{
	
	@FindBy(xpath="//*[@id='column-a']")
	WebElement firstBox;
	
	@FindBy(xpath="//*[@id='column-b']")
	WebElement secondBox;
	
	Actions builder;
	
	public DragAndDropObject(WebDriver driverInstance) {
		super(driverInstance);
		builder = new Actions(driver);
	}

	public DragAndDropObject goToPage() {
		navigate("/drag_and_drop");
		return this;
	}

	public DragAndDropObject dragAndDropBox() {
		// Using dragAndDrop generates odd error
		// firstBox appears to be "grabbed", but
		// does not move until the mouse is manually
		// moved by user. Once mouse is manually
		// moved, application closes and Assert fails
		/*
		builder
		.dragAndDrop(firstBox, secondBox)
		// .moveToElement(firstBox)
		// .clickAndHold()
		// .moveToElement(secondBox)
		// .release()
		// .build()
		.perform();
		*/
		System.out.println(firstBox.findElement(By.tagName("header")).getText());
		System.out.println(secondBox.findElement(By.tagName("header")).getText());
		return this;
	}

	public String getFirstColumnHeader() {
		String header = firstBox.findElement(By.tagName("header")).getText();
		return header;
	}

}
