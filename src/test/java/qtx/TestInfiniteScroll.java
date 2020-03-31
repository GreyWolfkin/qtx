package qtx;

import org.testng.annotations.Test;

public class TestInfiniteScroll extends TestSuperClass {
	
	@Test
	public void canGetDynamicParagraph() {
		new InfiniteScrollObject(driver)
		.goToPage()
		.scrollToDynamicParagraph()
		.getDynamicParagraph();
	}

}
