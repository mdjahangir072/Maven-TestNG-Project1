package testPackage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Day1Demo2 {
	
	static WebDriver driver;
	
	@Test
	public static void TestFB2() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		
		//Scanner scn=new Scanner(System.in);
		//String browser=scn.next();
		
		
		Properties prop = new Properties();
		String path = System.getProperty("user.dir") + "/src/main/resources/environment.properties";
		FileInputStream fs= new FileInputStream(path);
		prop.load(fs);
		String browser=prop.getProperty("browser");
		
		
		System.out.println(browser);
		
		System.out.println("Got Browser");
		switch (browser)
		{
		case "IE":
			System.setProperty("webdriver.ie.driver", "D:\\JavaPrograms\\MyEclipseProjects\\ETL Hive Selenium\\driver\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			break;
			
		
		case "Firefox":
			System.setProperty("webdriver.gecko.driver", "D:\\JavaPrograms\\MyEclipseProjects\\ETL Hive Selenium\\driver\\geckodriver.exe");
		//	DesiredCapabilities capibilities=DesiredCapabilities.firefox();
		//	capibilities.setCapability("marionette", true);
		//	driver=new FirefoxDriver(capibilities);
			driver=new FirefoxDriver();
			break;
		
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "D:\\JavaPrograms\\MyEclipseProjects\\ETL Hive Selenium\\driver\\chromedriver.exe");
			driver=new ChromeDriver();
			break;
		default:
			System.out.println("Wrong Browser Supplied");
		
		
		}
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	//	driver.findElement(By.id("email")).sendKeys("md.jahangir072@gmail.com");
	//	driver.findElement(By.id("pass")).sendKeys("");
		
		
	//	WindowsUtils windowsdriver.getWindowHandles();
		
		
		Thread.sleep(5000);
	//	driver.findElement(By.xpath("//input[@value='Log In']")).click();
		
	//	Thread.sleep(5000);
	//	driver.findElement(By.xpath("//a[@action='cancel']")).click();
		
	//	Thread.sleep(5000);
	//	driver.findElement(By.xpath("//div[@id='userNavigationLabel']")).click();
	//	Thread.sleep(5000);		driver.findElement(By.xpath("//span[text()='Log Out']")).click();	
		
		Select day= new Select(driver.findElement(By.id("day")));
		day.selectByVisibleText("10");
		Select month= new Select(driver.findElement(By.id("month")));
		month.selectByVisibleText("Dec");
		Select year= new Select(driver.findElement(By.id("year")));
		year.selectByVisibleText("1992");
		
		driver.close();	
		
		
		}	
	
	}


