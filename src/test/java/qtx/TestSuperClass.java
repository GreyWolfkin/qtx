package qtx;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import support.DriverManagerFactory;
import support.DriverType;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class TestSuperClass {
	protected WebDriver driver;

	@Parameters({ "browser-type" })
	@BeforeTest
	public void beforeTest(String driverType) {
		System.out.println(driverType);
		driver = DriverManagerFactory.getManager(driverType).getDriver();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}