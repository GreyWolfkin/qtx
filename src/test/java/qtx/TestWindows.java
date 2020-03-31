package qtx;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestWindows extends TestSuperClass {
	
	@Test
	public void canNavigateWindows() {
		String actualText = new WindowsObject(driver)
				.goToPage()
				.openNewWindow()
				.focusOnNewWindow()
				.storeText()
				.closeWindow()
				.focusOnOldWindow()
				.retrieveText();
		
		String expectedText = "New Window";
		
		Assert.assertEquals(actualText, expectedText, "Did not retrieve text");
	}

}
