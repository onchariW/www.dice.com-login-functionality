package com.dice;

import org.testng.annotations.Test;
import com.dice.base.BaseTest;

public class SecondTest extends BaseTest {

	@Test
	public void secondMethods() {
		driver.get("https://www.dice.com/");
		logger.info(" My second test PASSED .");
	}
}
