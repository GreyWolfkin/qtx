package qtx;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDropdownList extends TestSuperClass {

	@Test
	public void canSelectFromDropDown() {
		String expectedSelection = "Option 2";
		String actualSelection = new DropdownListObject(driver)
				.goToPage()
				.setDropDownList(expectedSelection)
				.getDropDownListValue();

		Assert.assertEquals(actualSelection, expectedSelection, "Failed to click option");
	}
}
