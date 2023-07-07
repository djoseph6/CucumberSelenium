package seleniumtests;

import org.apache.log4j.xml.DOMConfigurator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.CommonMethods;
import util.ConfigReader;

public class LoginScenarios extends CommonMethods{

	
	//---Invalid Admin Data---//
	
	@When("user enters invalid admin username and password")
	public void user_enters_invalid_admin_username_and_password() {
	  DOMConfigurator.configure("log4j2.xml");
		CommonMethods.sendText("admin", loginPage.usernameField);
	   CommonMethods.sendText("admin", loginPage.passwordField);
	}

	@Then("error message is displayed")
	public void error_message_is_displayed() {
	    System.out.println(loginPage.invalidCredentialsSpan.getText());
	}
	
}
