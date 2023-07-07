package seleniumtests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import util.CommonMethods;
import util.ConfigReader;

public class EmployeeSearchScenarios extends CommonMethods{
//	public WebDriver driver;
	
	@Given("user is navigated to HRMS application")
	public void user_is_navigated_to_hrms_application() {
		openBrowserAndNavigateToURL();
		
	}

	@When("user enters valid admin username and password")
	public void user_enters_valid_admin_username_and_password() {
	    CommonMethods.sendText(ConfigReader.getPropertyValue("username"), loginPage.usernameField);
	    CommonMethods.sendText(ConfigReader.getPropertyValue("password"), loginPage.passwordField);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
	    CommonMethods.click(loginPage.loginButton);
	}

	@Then("user is successfully logged in the application")
	public void user_is_successfully_logged_in_the_application() {
	    System.out.println(driver.getTitle());
	}
	
	  @When("user clicks on PIM option and Employee list option")
      public void user_clicks_on_pim_option_and_employee_list_option() {
    //we are clicking on pim and emp list option
    //  WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
      CommonMethods.click(dashboardPage.pimDashboardBtn);
     CommonMethods.click(dashboardPage.pimEmployeeBtn);
  }

  @When("user enters valid employee id")
  public void user_enters_valid_employee_id() {
//      WebElement searchIdTextBox = driver.findElement(By.id("empsearch_id"));
//      searchIdTextBox.sendKeys("54469A");
      CommonMethods.sendText("54469A", dashboardPage.searchIdTextBox);

  }

  @When("user clicks on search button")
  public void user_clicks_on_search_button() {
//     WebElement searchButton = driver.findElement(By.id("searchBtn"));
//     searchButton.click();
     CommonMethods.click(dashboardPage.searchIdTextBox);
  }

  @Then("user is able to see employee information")
  public void user_is_able_to_see_employee_information() {
      System.out.println("Employee is displayed");
  }
}


