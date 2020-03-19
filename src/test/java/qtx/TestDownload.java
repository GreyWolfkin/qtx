package qtx;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDownload extends TestSuperClass {

	private String downloadPath = System.getProperty("user.home") + "\\downloads\\";

	@Test
	public void canDownloadAndReadFile() throws InterruptedException, IOException {
		String actualFileText = new DownloadObject(driver, downloadPath)
				.goToPage()
				.downloadFile()
				.waitforDownload()
				.readFromFile();

		String expectedFileText = "this is a test file";

		Assert.assertEquals(actualFileText, expectedFileText, "Incorrect File Downloaded");
	}

}
