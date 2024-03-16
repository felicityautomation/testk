package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GenericUtility {
	
	public static void takeScreenshot(RemoteWebDriver driver,String filePath) throws IOException {
		File screenshot=driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(filePath));
	}

}
