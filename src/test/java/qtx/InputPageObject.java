package qtx;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputPageObject extends PageObjectSuperClass {

	@FindBy(tagName="input")
	WebElement numberField;

	protected WebDriverWait wait;

	public InputPageObject(WebDriver driverInstance) {
		super(driverInstance);
		wait = new WebDriverWait(driver, 5);
	}

	public InputPageObject goToPage() {
		navigate("/inputs");
		return this;
	}

	public InputPageObject inputValue(float value) {
		String input = Float.toString(value);
		numberField.sendKeys(input);
		wait.until(ExpectedConditions.attributeContains(numberField, "value", input));
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
