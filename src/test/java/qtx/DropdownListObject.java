package qtx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownListObject extends PageObjectSuperClass {

	public DropdownListObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public DropdownListObject setDropDownList(String value) {
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

	public DropdownListObject goToPage() {
		navigate("/dropdown");
		return this;
	}
}
