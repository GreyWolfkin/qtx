package qtx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesObject extends PageObjectSuperClass {

	public FramesObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public FramesObject goToPage(String subUrl) {
		navigate(subUrl);
		return this;
	}

	public String[] getTextFromFrames() {
		switchTo("top");
		switchTo("left");
		String left = getText();

		switchTo("parent");
		switchTo("middle");
		String middle = getText();

		switchTo("parent");
		switchTo("right");
		String right = getText();

		switchTo("default");
		switchTo("bottom");
		String bottom = getText();

		return new String[] {left, middle, right, bottom};
	}

	private void switchTo(String loc) {
		switch(loc) {
		case "parent":
			driver.switchTo().parentFrame();
			break;
		case "default":
			driver.switchTo().defaultContent();
			break;
		default:
			driver.switchTo().frame("frame-" + loc);
			break;
		}
	}

	private String getText() {
		return driver.findElement(By.xpath("/html/body")).getText();
	}

}
