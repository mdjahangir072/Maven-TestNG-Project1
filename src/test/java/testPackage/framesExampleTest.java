package testPackage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class framesExampleTest {
	
	static WebDriver driver;
	
	
	@Test
	public static void TestFB () throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
	//	Scanner scn=new Scanner(System.in);
	//	String browser=scn.next();
		
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
			DesiredCapabilities capibilities=DesiredCapabilities.firefox();
			capibilities.setCapability("marionette", true);
			driver=new FirefoxDriver(capibilities);
			driver=new FirefoxDriver();
			break;
		
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "D:\\JavaPrograms\\MyEclipseProjects\\ETL Hive Selenium\\driver\\chromedriver.exe");
			driver=new ChromeDriver();
			break;
		default:
			System.out.println("Wrong Browser Supplied");
		
		
		}
		
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	//	driver.findElement(By.id("email")).sendKeys("md.jahangir072@gmail.com");
	//	driver.findElement(By.id("pass")).sendKeys("");
		
		driver.switchTo().frame("login_page");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//input[@name='fldLoginUserId']")).sendKeys("12233");
		driver.switchTo().defaultContent();
		System.out.println(driver.getTitle());
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@name='fldLoginUserId']")).sendKeys("1223377777777777");
		driver.findElement(By.xpath("//img[@alt='continue']")).click();
		

		driver.close();
		
		}	
	
	}


