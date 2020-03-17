package qtx;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFrames extends TestSuperClass {
	
	@Test
	public void canReadFromNestedFrames() {
		String[] actualNestedFramesText = new FramesPage(driver)
				.goToPage("/nested_frames")
				.getTextFromFrames();
		
		String[] expectedNestedFramesText = new String[] {"Left", "Middle", "Right"};
		
		for(int i = 0; i < actualNestedFramesText.length; i++) {
			String actual = actualNestedFramesText[i];
			String expected = expectedNestedFramesText[i];
			Assert.assertEquals(actual, expected, "Incorrect text from Nested Frame");
		}
	}
	
	/*
	@Test
	public void canReadFromIframe() {
		String actualIframeText = new FramesPage(driver)
				.goToPage("/iframe")
				.inputText()
				.getTextFromIframe();
		
		String expectedIframeText = "";
		
		Assert.assertEquals(actualIframeText, expectedIframeText, "Incorrect text in iFrame");
	}
	*/

}
