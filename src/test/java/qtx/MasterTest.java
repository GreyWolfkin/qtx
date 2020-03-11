package qtx;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MasterTest extends TestSuperClass {
	
	@DataProvider(name = "jsProvider")
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

	@Test(priority=1)
	public void canLogin() {
		String username = "tomsmith";
		String password = "SuperSecretPassword!";
		
		String actualBannerText = new LoginPageObject(driver)
		.goToPage()
		.login(username, password)
		.getLoginConfirmationText();
		
		String expectedBannerText = "You logged into a secure area!\n×";
		
		Assert.assertEquals(actualBannerText, expectedBannerText, "Did not successfully login");
	}
	
	@Test(priority=2)
	public void canSelectFromDropdown() {
		String expectedSelection = "Option 2";
		String actualSelection = new DropDownPageObject(driver)
				.goToPage()
				.setDropDownList(expectedSelection)
				.getDropDownListValue();
		
		Assert.assertEquals(actualSelection, expectedSelection, "Did not select correct Dropdown value");
	}
	
	@Test(priority=3)
	public void canCheckBoxes() {
		String firstPath = "/input[1]";
		String secondPath = "/input[2]";
		boolean expectedResult = true;
		boolean actualResult = new CheckboxPageObject(driver)
		.goToPage()
		.clickOnBoxes(firstPath, secondPath)
		.getResult();
		
		Assert.assertEquals(actualResult, expectedResult, "Did not correctly check boxes");
	}
	
	@Test(priority=4)
	public void canMoveSlider() {
		float actualResult = new SliderPageObject(driver)
				.goToPage()
				.moveSlider()
				.confirmResultValue();
		float expectedResult = 5;
		
		Assert.assertEquals(actualResult, expectedResult, "Did not sufficiently move slider");
	}
	
	@Test(priority=5)
	public void canInputValues() {
		float expectedValue = 6.55f;

		float actualValue = new InputPageObject(driver)
				.goToPage()
				.inputValue(expectedValue)
				.readValue();

		Assert.assertEquals(actualValue, expectedValue, "Did not successfully input value");
	}
	
	@Test(priority=6, dataProvider="provider")
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
