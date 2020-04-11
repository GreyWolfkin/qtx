package qtx;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestContextMenu extends TestSuperClass {
	
	@Test
	public void canRightClick() {
		String actualAlertText = new ContextMenuObject(driver)
				.goToPage()
				.rightClickBox()
				.getAlertText();
		
		String expectedAlertText = "You selected a context menu";
		
		Assert.assertEquals(actualAlertText, expectedAlertText, "Incorrect Text Found");
	}

}
