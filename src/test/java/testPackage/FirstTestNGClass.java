package testPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FirstTestNGClass {
  @Test
  public void f() throws InterruptedException {
	  
	  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/src/main/resources/driver/chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver=new ChromeDriver(capabilities);

		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys("md.jahangir072@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("");
		
		
		
		
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//a[@action='cancel']")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='userNavigationLabel']")).click();
		Thread.sleep(5000);		
		driver.findElement(By.xpath("//span[text()='Log Out']")).click();	
		
	/*	Select day= new Select(driver.findElement(By.id("day")));
		day.selectByVisibleText("10");
		Select month= new Select(driver.findElement(By.id("month")));
		month.selectByVisibleText("Dec");
		Select year= new Select(driver.findElement(By.id("year")));
		year.selectByVisibleText("1992");
		
		WebElement gender=driver.findElement(By.xpath("//input[@type='radio' and @value=2]"));
		gender.click();
		WebElement create=driver.findElement(By.xpath("//button[@type='submit' and @name=\"websubmit\"]"));
		create.click();*/
		
		driver.close();	
	  
	  
  }
}
