package qtx;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DownloadObject extends PageObjectSuperClass {

	@FindBy(xpath="//a[@href='download/testfile.txt']")
	WebElement downloadLink;

	private String downloadPath;

	public DownloadObject(WebDriver driverInstance, String downloadPath) {
		super(driverInstance);
		this.downloadPath = downloadPath;
		Path path1 = Paths.get(downloadPath + "testfile.txt");
		Path path2 = Paths.get(downloadPath + "testfile.txt.crdownload");
		try {
			Files.deleteIfExists(path1);
			Files.deleteIfExists(path2);
		} catch(IOException ex) {
			System.out.println(ex);
		}
	}

	public DownloadObject goToPage() {
		navigate("/download");
		return this;
	}

	public DownloadObject downloadFile() {
		downloadLink.click();
		return this;
	}

	public DownloadObject waitforDownload() throws InterruptedException {
		File f = new File(downloadPath + "testfile.txt.crdownload");
		long filesize1;
		long filesize2;
		do {
			filesize1 = f.length();
			Thread.sleep(100);
			filesize2 = f.length();
		} while (filesize2 != filesize1);
		return this;
	}

	public String readFromFile() throws IOException {
		FileReader fr = new FileReader(downloadPath + "testfile.txt");
		String fileText = "";
		int i;
		while((i=fr.read()) != -1) {
			fileText += Character.toString((char)i);
		}
		fr.close();
		return fileText;
	}



}
