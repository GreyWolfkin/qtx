package qtx;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InputPageObject extends PageObjectSuperClass {

	@FindBy(tagName="input")
	WebElement numberField;

	public InputPageObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public InputPageObject goToPage() {
		navigate("/inputs");
		return this;
	}

	public InputPageObject inputValue(float value) {
		numberField.sendKeys(Float.toString(value));
		return this;
	}

	public float readValue() {
		String valueString = numberField.getAttribute("value");
		try {
			Float valueFloat = Float.parseFloat(valueString);
			return valueFloat;
		} catch(NumberFormatException ex) {
			System.out.println(ex);
		}
		return 0;
	}

}
