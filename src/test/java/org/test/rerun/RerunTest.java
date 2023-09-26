package org.test.rerun;

import java.io.IOException;

import org.base.BaseClass;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(WithOutknown.class)
public class RerunTest  {

  @Test
  public void test1() {
    System.out.println("test1");
  }

  @Test
  public void test2() {
System.out.println("test2");
  }

  @Test(retryAnalyzer=WithKown.class)
  public void test3() {
Assert.assertTrue(false);
  }
  
  @AfterMethod
  private void aftermethod(ITestResult r) throws IOException {

	  String name = r.getName();
	  int s = r.getStatus();
	  if (s==2) {
		BaseClass.screenshot(name);
	}
}

}
