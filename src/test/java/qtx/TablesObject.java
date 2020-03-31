package qtx;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TablesObject extends PageObjectSuperClass {
	
	@FindBy(xpath="//td[text()='jdoe@hotmail.com']/following-sibling::td[1]")
	WebElement amountDue;
	
	public TablesObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public TablesObject goToPage() {
		navigate("/tables");
		return this;
	}

	public String getAmountDue() {
		return amountDue.getText();
	}

}
