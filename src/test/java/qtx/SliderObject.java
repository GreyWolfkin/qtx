package qtx;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SliderObject extends PageObjectSuperClass {

	@FindBy(tagName="input")
	WebElement slider;

	@FindBy(id="range")
	WebElement range;

	Actions builder;

	public SliderObject(WebDriver driverInstance) {
		super(driverInstance);
		builder = new Actions(driverInstance);
	}

	public SliderObject goToPage() {
		navigate("/horizontal_slider");
		return this;
	}

	public SliderObject moveSlider() {
		int widthOfElement = slider.getSize().getWidth();
		int xOffset = (int)-0.5 * widthOfElement;

		Action clickAndDragSlider = builder
				.moveToElement(slider, xOffset, 0)
				.clickAndHold()
				.moveByOffset(widthOfElement, 0)
				.release()
				.build();

		clickAndDragSlider.perform();
		return this;
	}

	public float getResultValue() {
		return Float.parseFloat(range.getText());
	}

}
