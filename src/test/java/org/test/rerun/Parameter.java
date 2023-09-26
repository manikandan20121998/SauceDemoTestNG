package org.test.rerun;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameter {
	
	@Parameters({"Username","Password"})
	@Test()
	private void para(@Optional("raja")String user,@Optional("rani")String pass) {

		System.out.println(user);
		System.out.println(pass);
		System.out.println(user);
		System.out.println("complete");
	}
	
	

}
