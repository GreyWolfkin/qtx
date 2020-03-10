package qtx;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SliderPageTest extends TestSuperClass {
	
	@Test
	public void canAdjustSlider() {

		float actualSliderResult = new SliderPageObject(driver)
				.goToPage()
				.moveSlider()
				.getResultValue();
				
		float expectedResult = 5;
		
		Assert.assertEquals(actualSliderResult, expectedResult, "Slider not succesfully moved");
	}
}
