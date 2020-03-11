package qtx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxPageObject extends PageObjectSuperClass {

	private WebElement checkbox1;
	private WebElement checkbox2;
	private String pathToForm = "//*[@id='checkboxes']";

	public CheckboxPageObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public CheckboxPageObject goToPage() {
		navigate("/checkboxes");
		return this;
	}

	public CheckboxPageObject clickOnBoxes() {
		String pathToFirstBox = pathToForm + "/input[1]";
		String pathToSecondBox = pathToForm + "/input[2]";
		checkbox1 = driver.findElement(By.xpath(pathToFirstBox));
		checkbox2 = driver.findElement(By.xpath(pathToSecondBox));
		checkbox1.click();
		checkbox2.click();
		return this;
	}

	public boolean getResult() {
		boolean box1Checked = false;
		boolean box2Checked = false;
		if(isAttributePresent(checkbox1, "checked")) {
			box1Checked = true;
		}
		if(isAttributePresent(checkbox2, "checked")) {
			box2Checked = true;
		}
		if(box1Checked && !box2Checked) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isAttributePresent(WebElement element, String attribute) {
		String value = element.getAttribute(attribute);
		if(value != null) {
			return true;
		}
		return false;
	}
}

// Adding something unnecessary
