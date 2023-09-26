package org.test.saucedemo;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(WithOutKnownFailed.class)
public class SauceDemo {
	public static WebDriver driver;
		@BeforeClass
		private void BeforeClass() {
			WebDriverManager.chromedriver().setup();
		    driver=new ChromeDriver();
			driver.get("https://saucedemo.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		@AfterClass
		private void AfterClass() {
		//	driver.close();
		}
		@BeforeMethod
		private void BeforeMethodss() {

			System.out.println("Starting time"+new Date());
		}
	@AfterMethod
	private void AfterMethodss() {

		System.out.println("Ending time"+new Date());
	}
    //fail
	@Test(groups="regression",priority=-1,invocationCount=2)
	private void Test1() {
		SoftAssert s=new SoftAssert();
		driver.get("https://saucedemo.com/");
		WebElement user = driver.findElement(By.id("user-name"));
		user.sendKeys("standard_user");
		String userat = user.getAttribute("value");
	//	Assert.assertEquals(userat, "mani");
		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys("secret_sauce");
		String actat = pass.getAttribute("value");
	    s=new SoftAssert();
	    s.assertEquals(actat, "maddy");
		WebElement log = driver.findElement(By.id("login-button"));
		log.click();
	}
	//pass
	@Test(groups="sanity",priority=1,invocationCount=2)
	private void Test2() {
		SoftAssert s=new SoftAssert();
		driver.get("https://saucedemo.com/");
		WebElement user = driver.findElement(By.id("user-name"));
		user.sendKeys("manikandan");
		String userat = user.getAttribute("value");
		s.assertEquals(userat, "manikandan");
		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys("7879879");
		WebElement log = driver.findElement(By.id("login-button"));
		log.click();
	}
	//pass
	@Test(groups="smoke",priority=0,invocationCount=2)
	private void Test3() {
		SoftAssert s=new SoftAssert();
		driver.get("https://saucedemo.com/");
		WebElement log = driver.findElement(By.id("login-button"));
		log.click();
		String currentUrl = driver.getCurrentUrl();
		boolean con = currentUrl.contains("sauce");
		s.assertTrue(con);
	}
	//fail
	@Test(groups="retest",priority=1,invocationCount=2)
	private void Test4() {
		SoftAssert s=new SoftAssert();
		driver.get("https://saucedemo.com/");
		WebElement user = driver.findElement(By.id("user-name"));
		user.sendKeys("manikandan");
		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys("secret_sauce");
		String atat = pass.getAttribute("value");
		s.assertEquals(atat, "manikandan");
		WebElement log = driver.findElement(By.id("login-button"));
		log.click();
		s.assertAll();
		
	}
	//pass
	@Test(groups="regression",priority=2,invocationCount=3,enabled=false)
	private void Test5() {
		driver.get("https://saucedemo.com/");
		WebElement user = driver.findElement(By.id("user-name"));
		user.sendKeys("mani");
		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys("maddy");
		WebElement log = driver.findElement(By.id("login-button"));
		log.click();
	}
	
	@Test(groups="sanity",priority=3,invocationCount=2)
	private void Test6() {
		driver.get("https://saucedemo.com/");
		WebElement user = driver.findElement(By.id("user-name"));
		user.sendKeys("standard_user");
		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys("madyysbbs");
		WebElement log = driver.findElement(By.id("login-button"));
		log.click();
	}
	@DataProvider(name="login",indices= {1,3},parallel=false)
	private Object[][] data() {

		Object ob[][]=new Object[][] {
			{"mani","maddy"},
			{"manoj","vasanth"},
			{"maran","manickam"},
			{"vanthiyan","devan"}
		};
		return ob;
	}
	@Test(groups="smoke",priority=-5,dataProvider="login",dataProviderClass=SauceDemo.class)
	private void datapro(String user,String pass) {
		driver.get("https://saucedemo.com/");
		WebElement user1 = driver.findElement(By.id("user-name"));
		user1.sendKeys(user);
		WebElement pass1 = driver.findElement(By.id("password"));
		pass1.sendKeys(pass);
		WebElement log = driver.findElement(By.id("login-button"));
		log.click();
		
	}
	
	@DataProvider(name="register")
	private Object[][]  regis() {

		Object obj[][]=new Object[][] {
			{"dhilip","777687"},
			{"vinoth","677878"},
			{"maari","677878"},
			{"santhosh","78898"}
		};
		return obj;
	}
	
	@Test(groups="sanity",priority=-6,dataProvider="register",dataProviderClass=SauceDemo.class)
	private void datapro1(String user,String pass) {
		driver.get("https://saucedemo.com/");
		WebElement user1 = driver.findElement(By.id("user-name"));
		user1.sendKeys(user);
		WebElement pass1 = driver.findElement(By.id("password"));
		pass1.sendKeys(pass);
		WebElement log = driver.findElement(By.id("login-button"));
		log.click();
	
	}
	
	
}
