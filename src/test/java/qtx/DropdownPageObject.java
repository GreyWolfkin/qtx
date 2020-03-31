package qtx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPageObject extends PageObjectSuperClass {

	public DropdownPageObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public DropdownPageObject setDropDownList(String value) {
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

	public DropdownPageObject goToPage() {
		navigate("/dropdown");
		return this;
	}
}
