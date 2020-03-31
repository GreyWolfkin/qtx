package qtx;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InfiniteScrollObject extends PageObjectSuperClass {

	WebElement dynamicParagraph;
	JavascriptExecutor js;

	public InfiniteScrollObject(WebDriver driverInstance) {
		super(driverInstance);
		js = (JavascriptExecutor)driverInstance;
	}

	public InfiniteScrollObject goToPage() {
		navigate("/infinite_scroll");
		return this;
	}

	public InfiniteScrollObject scrollToDynamicParagraph() {
		while(true) {
			try {
				dynamicParagraph = driver.findElement(By.xpath("//div[@class='jscroll-inner']/div[3]"));
				if(dynamicParagraph.getText().equals("Loading...")) {
					throw new NoSuchElementException("stillLoading");
				}
				return this;
			} catch(NoSuchElementException ex) {
				scroll();
			}
		}
	}

	private void scroll() {
		js.executeScript("window.scrollBy(0,1000)");
		
	}

	public void getDynamicParagraph() {
		System.out.println(dynamicParagraph.getText());
	}

}
