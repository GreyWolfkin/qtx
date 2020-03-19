package qtx;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHover extends TestSuperClass {

	@Test
	public void canHoverAndNavigate() {
		String actualUrl = new HoverObject(driver)
				.goToPage()
				.hoverOverUser()
				.clickLink()
				.confirmUrl();

		String expectedUrl = "http://the-internet.herokuapp.com/users/3";

		Assert.assertEquals(actualUrl, expectedUrl, "Did not navigate correctly");
	}

}
