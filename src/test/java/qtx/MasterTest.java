package qtx;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MasterTest extends TestSuperClass{

	@Test(priority=1)
	public void canLogin() {
		String username = "tomsmith";
		String password = "SuperSecretPassword!";
		
		String actualBannerText = new LoginPageObject(driver)
		.goToPage()
		.login(username, password)
		.getLoginConfirmationText();
		
		String expectedBannerText = "You logged into a secure area!\n×";
		
		Assert.assertEquals(actualBannerText, expectedBannerText, "Did not successfully login");
	}
	
	@Test(priority=2)
	public void canSelectFromDropdown() {
		String expectedSelection = "Option 2";
		String actualSelection = new DropDownPageObject(driver)
				.goToPage()
				.setDropDownList(expectedSelection)
				.getDropDownListValue();
		
		Assert.assertEquals(actualSelection, expectedSelection, "Did not select correct Dropdown value");
	}
	
	@Test(priority=3)
	public void canCheckBoxes() {
		String firstPath = "/input[1]";
		String secondPath = "/input[2]";
		boolean expectedResult = true;
		boolean actualResult = new CheckboxPageObject(driver)
		.goToPage()
		.clickOnBoxes(firstPath, secondPath)
		.getResult();
		
		Assert.assertEquals(actualResult, expectedResult, "Did not correctly check boxes");
	}
	
	@Test(priority=4)
	public void canMoveSlider() {
		float actualResult = new SliderPageObject(driver)
				.goToPage()
				.moveSlider()
				.confirmResultValue();
		float expectedResult = 5;
		
		Assert.assertEquals(actualResult, expectedResult, "Did not sufficiently move slider");
	}

}
