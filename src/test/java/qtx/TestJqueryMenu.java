package qtx;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestJqueryMenu extends TestSuperClass {

	private String downloadPath = System.getProperty("user.home") + "\\downloads\\";

	@Test
	public void canDownloadFileFromPath() throws InterruptedException {
		File actualDownloadedFile = new JqueryMenuObject(driver, downloadPath)
				.goToPage()
				.clickItemByMenuPath(new String[] {"Enabled", "Downloads", "Excel"})
				.getDownloadedFile();

		File expectedDownloadedFile = new File(downloadPath + "menu.xls.crdownload");

		Assert.assertEquals(actualDownloadedFile, expectedDownloadedFile, "Did not download correct file");
	}

}
