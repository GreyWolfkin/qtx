package qtx;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxPageTest extends TestSuperClass {
	
	private String pathToFirstBox = "/input[1]";
	private String pathToSecondBox = "/input[2]";
	
	@Test
	public void canCheckBoxes() {
		boolean actualResult = new CheckboxPageObject(driver)
		.goToPage()
		.clickOnBoxes(pathToFirstBox, pathToSecondBox)
		.getResult();
		
		boolean expectedResult = true;
		
		Assert.assertEquals(actualResult, expectedResult, "Boxes not correctly checked");
	}
}
