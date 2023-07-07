package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.CommonMethods;

public class LoginPage extends CommonMethods{
	@FindBy(xpath="//*[@id='txtUsername']")
	public WebElement usernameField;
	
	@FindBy(id="txtPassword")
	public WebElement passwordField;
	
	@FindBy(id="btnLogin")
	public WebElement loginButton;
	
	public String expectedURLTitle = "Human Management System";
	
	@FindBy(id="spanMessage")
	public WebElement invalidCredentialsSpan;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
}
