package qtx;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxPageTest extends TestSuperClass {
		
	@Test
	public void canCheckBoxes() {
		boolean actualResult = new CheckboxPageObject(driver)
		.goToPage()
		.clickOnBoxes()
		.getResult();
		
		boolean expectedResult = true;
		
		Assert.assertEquals(actualResult, expectedResult, "Boxes not correctly checked");
	}
}
