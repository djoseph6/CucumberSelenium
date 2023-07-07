package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.CommonMethods;

public class DashboardPage extends CommonMethods{
	
	@FindBy(id="menu_pim_viewPimModule")
	public WebElement pimDashboardBtn;
	
	@FindBy(id="menu_pim_viewEmployeeList")
	public WebElement pimEmployeeBtn;
// PIM WEBELEMENTS
	
	@FindBy(id="empsearch_id")
	 public WebElement searchIdTextBox;
	
	@FindBy(id="searchBtn")
	public  WebElement searchButton;
	
	@FindBy(name="btnAdd")
	public WebElement addNewEmployeeBtn;
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

}
