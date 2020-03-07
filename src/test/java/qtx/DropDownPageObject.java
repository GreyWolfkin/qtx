package qtx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownPageObject extends PageObjectSuperClass {

	public DropDownPageObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public DropDownPageObject setDropDownList(String value) {
		getDropDown().selectByVisibleText(value);
		return this;
	}

	public String getDropDownListValue() {
		return getDropDown().getFirstSelectedOption().getText();
	}

	public Select getDropDown() {
		WebElement dropDown = driver.findElement(By.id("dropdown"));
		Select customerDropDownList = new Select(dropDown);
		return customerDropDownList;
	}

	public DropDownPageObject goToPage() {
		navigate("/dropdown");
		return this;
	}
}
