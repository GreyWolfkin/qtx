package qtx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicAuthObject extends PageObjectSuperClass {
	
	public BasicAuthObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public BasicAuthObject goToPageUsing(String user, String pass) {
		driver.get("http://" + user + ":" + pass + "@the-internet.herokuapp.com/basic_auth");
		return this;
	}

	public String getText() {
		return driver.findElement(By.xpath("//div[@class='example']/p")).getText().trim();
	}
}
