package qtx;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {
	
	@Override
	protected void startService() {
		
	}
	
	@Override
	protected void stopService() {
		
	}
	
	@Override
	protected void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		
		long time = 10;
		TimeUnit unit = TimeUnit.SECONDS;
		driver.manage().timeouts().implicitlyWait(time, unit);
		driver.manage().timeouts().pageLoadTimeout(time, unit);
	}
}
