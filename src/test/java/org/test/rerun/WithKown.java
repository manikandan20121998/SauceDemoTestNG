package org.test.rerun;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class WithKown implements IRetryAnalyzer{
 
	
	int mincount=0,maxcount=5;
	public boolean retry(ITestResult result) {
       if (mincount<maxcount) {
    	   mincount++;
    	   return true;
	}
       return false;
	}

}
