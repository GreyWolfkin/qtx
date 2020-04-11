package qtx;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestEntryAd extends TestSuperClass {
	
	@Test
	public void canHandlePopUpWindow() {
		String actualText = new EntryAdObject(driver)
		.goToPage()
		.waitForWindow()
		.getText();
		
		String expectedText = "It's commonly used to encourage a user to take an action (e.g., give their e-mail address to sign up for something or disable their ad blocker).";
		
		Assert.assertEquals(actualText, expectedText, "PopUpWindow Text Incorrect");
	}

}
