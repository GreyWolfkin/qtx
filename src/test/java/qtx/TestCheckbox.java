package qtx;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCheckbox extends TestSuperClass {

	@Test
	public void canCheckBoxes() {
		boolean actualResult = new CheckboxObject(driver)
				.goToPage()
				.clickOnBoxes()
				.getResult();

		boolean expectedResult = true;

		Assert.assertEquals(actualResult, expectedResult, "Boxes not correctly checked");
	}
}
