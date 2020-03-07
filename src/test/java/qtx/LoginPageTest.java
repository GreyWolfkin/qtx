package qtx;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends TestSuperClass {

	@Test
	public void canLogin() {

		String username = "tomsmith";
		String password = "SuperSecretPassword!";
		String expectedBannerText = "You logged into a secure area!\n×";
		
		String actualBannerText = new LoginPageObject(driver)
				.goToPage()
				.login(username, password)
				.getLoginConfirmationText();

		Assert.assertEquals(actualBannerText, expectedBannerText, "Login Unsuccessful");

	}
}
