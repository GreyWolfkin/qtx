package qtx;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestForgotPassword extends TestSuperClass {
	
	@Test
	public void canRetrievePassword() {
		String actualText = new RetrievePasswordObject(driver)
				.goToPage()
				.inputEmail("test@test.com")
				.clickButton()
				.getText();
		
		String expectedText = "Your e-mail's been sent!";
		
		Assert.assertEquals(actualText, expectedText, "Incorrect Text Found");
	}

}
