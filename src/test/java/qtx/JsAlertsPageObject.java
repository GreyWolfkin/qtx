package qtx;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JsAlertsPageObject extends PageObjectSuperClass {

	protected WebElement alertButton;
	protected WebElement confirmButton;
	protected WebElement promptButton;
	protected WebElement result;

	public JsAlertsPageObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public JsAlertsPageObject goToPage() {
		navigate("/javascript_alerts");
		return this;
	}

	public JsAlertsPageObject assignElements() {
		List<WebElement> buttons = driver.findElements(By.tagName("button"));
		for(WebElement button:buttons) {
			String onclick = button.getAttribute("onclick");
			switch(onclick) {
			case "jsAlert()":
				alertButton = button;
				break;
			case "jsConfirm()":
				confirmButton = button;
				break;
			case "jsPrompt()":
				promptButton = button;
				break;
			default:
				System.out.println("ERROR ASSIGNING BUTTON");
			}
		}
		result = driver.findElement(By.id("result"));
		return this;
	}

	public String[] performInstructions(String button, String instructions, String text) {
		String alertText;
		String resultText;
		switch(button) {
		case "alert":
			alertButton.click();
			waitForAlert();
			alertText = alertText();
			acceptAlert();
			resultText = resultText();
			break;
		case "confirm":
			confirmButton.click();
			waitForAlert();
			alertText = alertText();
			if(instructions.equals("accept")) {
				acceptAlert();
			} else {
				dismissAlert();
			}
			resultText = resultText();
			break;
		case "prompt":
			promptButton.click();
			waitForAlert();
			alertText = alertText();
			sendTextToAlert(text);
			if(instructions.equals("accept")) {
				acceptAlert();
			} else {
				dismissAlert();
			}
			resultText = resultText();
			break;
		default:
			alertText = "ALERT ERROR";
			resultText = "RESULT ERROR";
		}
		return new String[] {alertText, resultText};
	}

	private void waitForAlert() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	private String alertText() {
		String text = driver.switchTo().alert().getText();
		return text;
	}

	private String resultText() {
		String text = result.getText();
		return text;
	}

	private void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	private void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	private void sendTextToAlert(String text) {
		driver.switchTo().alert().sendKeys(text);
	}

}
