package testCases;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParametersDemo {

	@Test
	@Parameters({"myName"})
	public void test(@Optional String name) {
		System.out.println("My name is: " + name);
	}
}
