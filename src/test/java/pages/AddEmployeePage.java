package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.CommonMethods;

public class AddEmployeePage extends CommonMethods{
	
	@FindBy(id="firstName")
	public WebElement firstNameInput;
	@FindBy(id="middleName")
	public WebElement middleNameInput;
	@FindBy(id="lastName")
	public WebElement lastNameInput;
	@FindBy(id="employeeId")
	public WebElement employeeIDInput;
	@FindBy(id="photofile")
	public WebElement photographUploadBtn;
	@FindBy(id="chkLogin")
	public WebElement loginDetailsCheckBox;
	@FindBy(id="btnSave")
	public WebElement saveButton;
	@FindBy(id="user_name")
	public WebElement usernameTextFieldBox;
	@FindBy(id="user_password")
	public WebElement passwordTextFieldBox;
	@FindBy(id="re_password")
	public WebElement confirmPasswordBox;
	
	public AddEmployeePage() {
		PageFactory.initElements(driver, this);
	}

}
