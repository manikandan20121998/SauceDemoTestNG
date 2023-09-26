package org.test.rerun;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class WithOutknown implements IAnnotationTransformer{

	public void transform(ITestAnnotation a, Class testClass, Constructor testConstructor, Method testMethod) {

		a.setRetryAnalyzer(WithKown.class);
	}
	

}
