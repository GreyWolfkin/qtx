package qtx;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class JsAlertsPageTest extends TestSuperClass {

	@DataProvider(name="provider")
	public Object[][] sendData() { 
		return new Object[][] {
			{"alert", "accept", "null", "I am a JS Alert", "You successfuly clicked an alert"},
			{"confirm", "accept", "null", "I am a JS Confirm", "You clicked: Ok"},
			{"confirm", "dismiss", "null", "I am a JS Confirm", "You clicked: Cancel"},
			{"prompt", "accept", "newText", "I am a JS prompt", "You entered: newText"},
			{"prompt", "dismiss", "newText", "I am a JS prompt", "You entered: null"},
			{"prompt", "accept", "", "I am a JS prompt", "You entered:"},
			{"prompt", "dismiss", "", "I am a JS prompt", "You entered: null"}
		};
	}

	@Test(dataProvider="provider")
	public void canHandleJavascriptAlerts(String button, String instructions, String text, String expectedAlertText, String expectedResultText) {
		String[] results = new JsAlertsPageObject(driver)
				.goToPage()
				.assignElements()
				.performInstructions(button, instructions, text);

		String actualAlertText = results[0];
		String actualResultText = results[1];

		Assert.assertEquals(actualAlertText, expectedAlertText, "Unexpected Alert Text");
		Assert.assertEquals(actualResultText, expectedResultText, "Unexpected Result Text");
	}

}
