package testPackage;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ScreenCaptureTest {
	
	static WebDriver driver;
	
	
	@Test
	public static void ScreenCapture () throws InterruptedException, IOException, AWTException {
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
			System.setProperty("webdriver.ie.driver", "D:\\JavaPrograms\\MyEclipseProjects\\ETLHiveSelenium\\driver\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			break;
			
		
		case "Firefox":
			System.setProperty("webdriver.gecko.driver", "D:\\JavaPrograms\\MyEclipseProjects\\ETLHiveSelenium\\driver\\geckodriver.exe");
		//	DesiredCapabilities capibilities=DesiredCapabilities.firefox();
		//	capibilities.setCapability("marionette", true);
			//driver=new FirefoxDriver(capibilities);
			driver=new FirefoxDriver();
			break;
		
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "D:\\JavaPrograms\\MyEclipseProjects\\ETLHiveSelenium\\driver\\chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver=new ChromeDriver(capabilities);
			break;
			
		case "HeadLess":
			driver= new HtmlUnitDriver();
			break;
			
		default:
			System.out.println("Wrong Browser Supplied");
		
		
		}
		
		
		
		driver.get("http://www.google.com/");
		ScreenCaptureTest.captureScreenShot(driver, "google");
		
		driver.manage().window().maximize();
		ScreenCaptureTest.captureScreenShot(driver, "maximize");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//driver.findElement(By.xpath("//a[contains(text(),'animatecolors.xlsm')]")).click();
		Thread.sleep(2000);
		driver.close();
		
		
		}	
	
	
	public static void captureScreenShot(WebDriver idriver, String screnshotname)
		{
			File src=((TakesScreenshot)idriver).getScreenshotAs(OutputType.FILE);
			
			try {
					FileUtils.copyFile(src, new File ("D:\\JavaPrograms\\MyEclipseProjects\\ETLHiveSelenium\\screenshot\\"+screnshotname+".jpeg"));
					
				}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
	
	}


