package qtx;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestExitIntent extends TestSuperClass {
	
	@Test
	public void canHandlePopUpWindow() {
		String actualText = new ExitIntentObject(driver)
				.goToPage()
				.loseFocus() // Throws MoveTargetOutOfBoundsException
				.waitForWindow()
				.getText();
		
		String expectedText = "It's commonly used to encourage a user to take an action (e.g., give their e-mail address to sign up for something).";
		
		Assert.assertEquals(actualText, expectedText, "Incorrect Text Found");
	}

}
