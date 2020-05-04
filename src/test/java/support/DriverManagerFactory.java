package support;

public class DriverManagerFactory {
	public static DriverManager getManager(String driverType) {

		switch(driverType) {
		case "chrome":
			return new ChromeDriverManager();
		case "firefox":
			return new FirefoxDriverManager();
		default:
			System.out.println(driverType + " is not a supported driver");
		}
		return null;
	}
}
