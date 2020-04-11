package qtx;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RetrievePasswordObject extends PageObjectSuperClass {
	
	@FindBy(id="email")
	WebElement emailField;
	
	@FindBy(id="form_submit")
	WebElement submitButton;
	
	@FindBy(id="content")
	WebElement confirmationText;
	
	public RetrievePasswordObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public RetrievePasswordObject goToPage() {
		navigate("/forgot_password");
		return this;
	}

	public RetrievePasswordObject inputEmail(String email) {
		emailField.sendKeys(email);
		return this;
	}

	public RetrievePasswordObject clickButton() {
		submitButton.click();
		return this;
	}

	public String getText() {
		return confirmationText.getText();
	}

}
