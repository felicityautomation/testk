package steps;

import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import utility.BrowserUitl;
import utility.WebActions;

public class StepDefinitions {
	RemoteWebDriver driver;

	@Given("user is on the browser")
	public void user_is_on_the_browser() {
		driver=BrowserUitl.getDriver();
	}

	@When("user navigates to the login page")
	public void user_navigates_to_the_login_page() {
		WebActions.openUrl(driver,"https://www.demoblaze.com/index.html");
		HomePage homePage=new HomePage(driver);
		homePage.clickOnLoginLink();
	}

	@When("enter user name as {string} and password as {string}")
	public void enter_user_name_as_and_password_as(String userName, String password) {
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login(userName, password);
	}

	
	@Then("user will be on Home page")
	public void user_will_be_on_home_page() throws InterruptedException {
		HomePage homePage=new HomePage(driver);
		Thread.sleep(5000);
		homePage.clickOnLaptopsLink();
	}
	
	@Then("error message is displayed in Login page {string}")
	public void error_message_is_displayed_in_login_page(String string) {
	   
	}

	@Then("close the browser")
	public void close_the_browser() {
	   driver.quit();
	}

}
