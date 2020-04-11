package qtx;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestBasicAuth extends TestSuperClass {
	
	@Test
	public void canHandleAuthenticationPopup() {
		String actualText = new BasicAuthObject(driver)
		.goToPageUsing("admin", "admin")
		.getText();
		
		String expectedText = "Congratulations! You must have the proper credentials.";
		
		Assert.assertEquals(actualText, expectedText, "Unexpected Text");
	}

}
