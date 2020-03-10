package qtx;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InputPageTest extends TestSuperClass {

	@Test
	public void canInputValues() {
		float expectedValue = 6.55f;

		float actualValue = new InputPageObject(driver)
				.goToPage()
				.inputValue(expectedValue)
				.readValue();

		Assert.assertEquals(actualValue, expectedValue, "Did not successfully input value");
	}

}
