package testPackage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ScrollTest {
	
	static WebDriver driver;
	
	
	@Test
	public static void moveToElement () throws InterruptedException, IOException {
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
		
		driver.get("https://www.jqueryui.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		JavascriptExecutor je2= (JavascriptExecutor)driver;
		je2.executeScript("scroll(0, 400)");
		
		JavascriptExecutor je=  (JavascriptExecutor)driver;
		WebElement widget=driver.findElement(By.xpath("//a[text()='Widget Factory']"));
		je.executeScript("arguments[0].scrollIntoView(true)", widget);
		widget.click();
		
		driver.close();
		
		
	
		
		}	
	
	}


