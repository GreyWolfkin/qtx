package qtx;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDragAndDrop extends TestSuperClass {
	
	// Test fails, see DragAndDropObject for more details
	
	@Test
	public void canDragAndDropBox() {
		String actualFirstColumnHeader = new DragAndDropObject(driver)
				.goToPage()
				.dragAndDropBox()
				.getFirstColumnHeader();
		
		String expectedFirstColumnHeader = "B";
		
		Assert.assertEquals(actualFirstColumnHeader, expectedFirstColumnHeader, "Incorrect header found");
	}

}
