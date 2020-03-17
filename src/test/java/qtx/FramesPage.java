package qtx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramesPage extends PageObjectSuperClass {
	
	@FindBy(xpath="//*frame[name='frame-top']")
	WebElement frameTop;
	/*
	@FindBy(name="frame-left")
	WebElement frameLeft;
	
	@FindBy(name="frame-middle")
	WebElement frameMiddle;
	
	@FindBy(name="frame-right")
	WebElement frameRight;
	*/
	@FindBy(name="frame-bottom")
	WebElement frameBottom;
	
	public FramesPage(WebDriver driverInstance) {
		super(driverInstance);
	}
	
	public FramesPage goToPage(String subUrl) {
		navigate(subUrl);
		return this;
	}
	
	public String[] getTextFromFrames() {
		WebElement frameLeft = frameTop.findElement(By.name("frame-left"));
		WebElement frameMiddle = frameTop.findElement(By.name("frame-middle"));
		WebElement frameRight = frameTop.findElement(By.name("frame-right"));
		
		String frameLeftText = frameLeft.getText().trim();
		String frameMiddleText = frameMiddle.getText().trim();
		String frameRightText = frameRight.getText().trim();
		
		return new String[] {frameLeftText, frameMiddleText, frameRightText};
	}

}
