package utility;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserUitl {
	
	public static void quitDriver(RemoteWebDriver driver) {
		driver.quit();
	}
	
	public static RemoteWebDriver getDriver() {
		
		String browser=System.getProperty("browser");
		System.out.println("Browser value:="+browser);
		Logger log=LoggerUtil.getLogger("BrowserUitl.getDriver()");
		log.debug("Launching the browser driver of type :="+browser);
		if(browser==null) {
			log.debug("Browser value is null. So launching the browser with default as firefox");
			browser="chrome";
		}
		
		RemoteWebDriver driver;
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		return driver;
	}

}
