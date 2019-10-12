package com.dice;


import org.testng.annotations.Test;
import com.dice.base.BaseTest;

public class FirstTest extends BaseTest {

	@Test
	public void firstTestMethods() {
		driver.get("https://www.dice.com/");
		logger.info("My first test PASSED .");
	}

}
