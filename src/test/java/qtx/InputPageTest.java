package qtx;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InputPageTest extends TestSuperClass {
	@DataProvider(name="inputValues")
	public Object[] values() {
		return new Object[] {
				1.21f, 
				2.42f, 
				3.63f, 
				4.84f, 
				6.06f
		};
	}

	@Test(priority=5, dataProvider="inputValues")
	public void canInputValues(float expectedValue) {

		float actualValue = new InputPageObject(driver)
				.goToPage()
				.inputValue(expectedValue)
				.readValue();

		Assert.assertEquals(actualValue, expectedValue, "Did not successfully input value");
	}
}
