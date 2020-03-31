package qtx;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTables extends TestSuperClass {
	
	@Test
	public void canGetInfoFromTable() {
		String actualAmountDue = new TablesObject(driver)
				.goToPage()
				.getAmountDue();
		
		String expectedAmountDue = "$100.00";
		
		Assert.assertEquals(actualAmountDue, expectedAmountDue, "Did not retrieve amount due");
	}

}
