package qtx;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JqueryMenuPage extends PageObjectSuperClass {
	
	private String fileName;
	private String downloadPath;
	
	public JqueryMenuPage(WebDriver driverInstance, String downloadPath) {
		super(driverInstance);
		this.downloadPath = downloadPath;
		Path path = Paths.get(downloadPath + "menu.xls");
		try {
			Files.deleteIfExists(path);
		} catch(IOException ex) {
			System.out.println(ex);
		}
	}
	
	public JqueryMenuPage goToPage() {
		navigate("/jqueryui/menu");
		return this;
	}
	
	public JqueryMenuPage clickItemByMenuPath(String[] path) {
		for(String string:path) {
			WebElement item = driver.findElement(By.xpath("//*[@class='ui-menu-item']//*[text()='" + string + "']"));
			if(item.getAttribute("href").contains("/download/")) {
				fileName = item.getAttribute("href").replace("http://the-internet.herokuapp.com/download/jqueryui/menu/", "");
			}
			item.click();
		}
		return this;
	}

	public File getDownloadedFile() throws InterruptedException {
		File f = new File(downloadPath + fileName + ".crdownload");
		long filesize1;
		long filesize2;
		do {
			filesize1 = f.length();
			Thread.sleep(100);
			filesize2 = f.length();
		} while (filesize2 != filesize1);
		return f;
	}

}
