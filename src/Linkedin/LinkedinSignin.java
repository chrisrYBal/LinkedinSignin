package Linkedin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class LinkedinSignin {
  WebDriver driver;	
  String pswrdtestErrorMessage;
  String usertestErrorMessage;
  String contactNumber = "09360555985";
  String password = "@testsample06";
  @BeforeTest
  public void OpenBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\zip\\exe\\chromedriver_win32v1\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage();
		driver.get("https://www.linkedin.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
  }
  @Test
  public void pswrdtestErrorMessage() throws InterruptedException {
	  driver.findElement(By.id("username")).sendKeys(contactNumber);
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//button[@class='btn__primary--large from__button--floating']")).click();
	  Thread.sleep(2000);
	  String EM = "Please enter a password.";
	  pswrdtestErrorMessage = driver.findElement(By.id("error-for-password")).getText();
	  if(pswrdtestErrorMessage.equals(EM)) {
		  System.out.println("Password" + "\n" + "Expected and Actual Error Message Matched:" + "\n" + pswrdtestErrorMessage + "\n" );
	  }else {
		  System.out.println("Password" + "\n" + "Expected and Actual Error Message Mismatched:" + pswrdtestErrorMessage + "\n" );
	  }
	  Thread.sleep(2000);
	  
  }
  @Test(dependsOnMethods = ("pswrdtestErrorMessage"))
  public void usertestErrorMessage() throws InterruptedException {
	  driver.findElement(By.id("username")).clear();
	  driver.findElement(By.id("password")).sendKeys(password);
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//button[@class='btn__primary--large from__button--floating']")).click();
	  Thread.sleep(2000);
	  String EM = "Please enter an email address or phone number";
	  usertestErrorMessage = driver.findElement(By.id("error-for-username")).getText();
	  if(usertestErrorMessage.equals(EM)) {
		  System.out.println("User Email/Contact Number" + "\n" + "Expected and Actual Error Message Matched:" + "\n" + usertestErrorMessage + "\n" );
	  }else {
		  System.out.println("User Email/Contact Number" + "\n" + "Expected and Actual Error Message Mismatched:" + usertestErrorMessage + "\n" );
	  }
	  Thread.sleep(2000);
	  
  }
  @AfterTest
  public void CloseBrowser() {
	  driver.quit();
  }

}
