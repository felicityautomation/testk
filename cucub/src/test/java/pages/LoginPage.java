package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.WebActions;

public class LoginPage {
	//Driver and it's initilazation
	RemoteWebDriver driver;
		
	public LoginPage(RemoteWebDriver driver) {
		this.driver=driver;
	}
	//Locators
	By inputUsername=By.id("loginusername");
	By inputPassword=By.id("loginpassword");
	By buttonLogin=By.xpath("//button[text()='Log in']");
	
	
	public void login(String username,String password) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(inputUsername));
		WebActions.setText(driver, inputUsername, username);
		WebActions.setText(driver, inputPassword, password);
		WebActions.click(driver, buttonLogin);
//		driver.findElement(inputUsername).sendKeys(username);
//		driver.findElement(inputPassword).sendKeys(password);
//		driver.findElement(buttonLogin).click();
	}

}
