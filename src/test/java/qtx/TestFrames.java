package qtx;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFrames extends TestSuperClass {

	@Test
	public void canReadFromNestedFrames() {
		String[] actualNestedFramesText = new FramesObject(driver)
				.goToPage("/nested_frames")
				.getTextFromFrames();

		String[] expectedNestedFramesText = new String[] {"LEFT", "MIDDLE", "RIGHT", "BOTTOM"};

		for(int i = 0; i < actualNestedFramesText.length; i++) {
			String actual = actualNestedFramesText[i];
			String expected = expectedNestedFramesText[i];
			Assert.assertEquals(actual, expected, "Incorrect text from Nested Frame");
		}

	}

}
