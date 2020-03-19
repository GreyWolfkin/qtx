package qtx;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSlider extends TestSuperClass {

	@Test
	public void canAdjustSlider() {

		float actualSliderResult = new SliderObject(driver)
				.goToPage()
				.moveSlider()
				.getResultValue();

		float expectedResult = 5;

		Assert.assertEquals(actualSliderResult, expectedResult, "Slider not succesfully moved");
	}
}
