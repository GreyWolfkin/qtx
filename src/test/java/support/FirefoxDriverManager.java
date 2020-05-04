package support;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {

	@Override
	protected void startService() {

	}

	@Override
	protected void stopService() {

	}

	@Override
	protected void createDriver() {
		System.setProperty("webdriver.firefox.driver", "C:\\geckodriver.exe");
		driver = new FirefoxDriver();

		long time = 10;
		TimeUnit unit = TimeUnit.SECONDS;
		driver.manage().timeouts().implicitlyWait(time, unit);
		driver.manage().timeouts().pageLoadTimeout(time, unit);
	}
}