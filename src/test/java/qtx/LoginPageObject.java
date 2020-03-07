package qtx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject extends PageObjectSuperClass {
	
	public LoginPageObject(WebDriver driverInstance) {
		super(driverInstance);
	}
	
	public LoginPageObject goToPage() {
		navigate("/login");
		return this;
	}
	
	public SecurePageObject login(String username, String password) {
		WebElement usernameTextField = driver.findElement(By.id("username"));
		WebElement passwordTextField = driver.findElement(By.id("password"));
		WebElement submitButton = driver.findElement(By.tagName("button"));
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		submitButton.click();
		return new SecurePageObject(driver);
	}

}
