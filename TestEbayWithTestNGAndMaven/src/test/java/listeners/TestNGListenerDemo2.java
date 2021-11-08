package listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.TestNGListeners.class)//this line can be removed if using testng.xml to bind listeners
public class TestNGListenerDemo2 {

	@Test
	public void test5() {
		System.out.println("I am inside test 5");
	}
	
	@Test
	public void test6() {
		System.out.println("I am inside test 6");
		Assert.assertTrue(false);
	}
	
	@Test
	public void test7() {
		System.out.println("I am inside test 7");
		throw new SkipException("This test is skipped");
	}
	
	@Test
	public void test8() {
		System.out.println("I am inside test 8");
	}
}
