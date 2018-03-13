package testNG1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FacebookLoginTest {
	WebDriver driver;
  @BeforeTest
  public void Setup() {
	  System.setProperty("webdriver.chrome.driver","C:\\selenium jar file\\chromedriver\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");
		String exptitle= "Facebook – log in or sign up";
		String currentWindow= driver.getWindowHandle();
		for(String winhndle : driver.getWindowHandles()) {
			if(driver.switchTo().window(winhndle).getTitle().equals(exptitle)) {
				break;
			}
			else {
				driver.switchTo().window(currentWindow);
			}
		}
	  
  }
  @Test
  public void LoginCheck() {
	  driver.findElement(By.id("email")).sendKeys("9502904578");
	  driver.findElement(By.id("pass")).sendKeys("revanthkumar");
	  driver.findElement(By.id("loginbutton")).submit();
	  driver.findElement(By.id("email")).isDisplayed();
	  
  }
  @AfterTest
  public void CloseFB() {
	  driver.navigate().back();
	  driver.findElement(By.xpath(".//*[@id='u_0_l']")).sendKeys("missionacomplished");
	  driver.quit();
  }
}
