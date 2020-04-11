package qtx;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAddAndRemoveElements extends TestSuperClass {
	
	AddAndRemoveElementsObject page;
	
	@Test(priority=1)
	public void canAddElements() {
		page = new AddAndRemoveElementsObject(driver);
		int actualNumElements = page
				.goToPage()
				.addElement(18)
				.getNumElements();
		
		int expectedNumElements = 18;
		
		Assert.assertEquals(actualNumElements, expectedNumElements, "Incorrect number of elements added");
	}
	
	@Test(priority=2)
	public void canDeleteElements() {
		int actualNumElements = page
				.deleteElement(18)
				.getNumElements();
		
		int expectedNumElements = 0;
		
		Assert.assertEquals(actualNumElements, expectedNumElements, "Incorrect number of elements");
	}

}
