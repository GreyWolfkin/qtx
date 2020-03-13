package moon;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAccountCreation extends TestSuperClass {
	
	@Test
	public void accountCreationTest() {
		String actualSignedInText = new AccountCreationObject(driver)
		.goToPage()
		.clickButton("login")
		.enterValidEmailAndSubmit()
		.fillOutFields()
		.clickButton("register")
		.getSignedInText();
		
		String expectedSignedInText = "MY ACCOUNT";
		
		Assert.assertEquals(actualSignedInText, expectedSignedInText, "Failed to create Account");
	}
}
