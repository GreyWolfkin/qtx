package qtx;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecurePageObject extends PageObjectSuperClass {
	
	@FindBy(id="flash")
	private WebElement banner;
	
	public SecurePageObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public String getLoginConfirmationText() {
		return banner.getText();
	}
}
