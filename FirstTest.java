package testNG.testNG.programs;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class FirstTest {
	protected WebDriver driver;
	
  
  @Test(priority=1)
  public void testStep1() {
	  System.setProperty("webdriver.chrome.driver","C:\\selenium jar file\\chromedriver\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		String title1= "Google";
		String curentwindow= driver.getWindowHandle();
		for(String windhanhle:driver.getWindowHandles()) {
		if (driver.switchTo().window(windhanhle).getCurrentUrl().equalsIgnoreCase(title1)) {
			break;
		}
		else {
			driver.switchTo().window(curentwindow);
		}
		
	}
  } 
  
  @Test(priority=2)
  public void mainMethod() {
	  
	  driver.findElement(By.linkText("Gmail")).click();
	  
	 
	 System.out.println(driver.findElement(By.xpath("html/body/nav/div/a[2]")).getText());
	  
  }
	  
	  
  

  @Test(priority=3)
  public void testStep2() {
	  driver.navigate().back();
	 System.out.println(driver.getCurrentUrl()); 
	  driver.quit();
	  
	  
	  
  }
  

}
