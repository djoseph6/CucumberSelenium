package seleniumtests;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.CommonMethods;
import util.Constants;
import util.ExcelReader;

public class addEmployeeScenarios extends CommonMethods{
//---BACKGROUND IMPLEMNATION---//
	@When("user clicks on PIM option")
	public void user_clicks_on_pim_option() {
	    CommonMethods.click(dashboardPage.pimDashboardBtn);
	}

	@When("user clicks on add employee button")
	public void user_clicks_on_add_employee_button() {
	 CommonMethods.click(dashboardPage.addNewEmployeeBtn);
	}
//---ADDING ONE EMPLOYEE---//
	@When("user enters firstname and lastname")
	public void user_enters_firstname_and_lastname() {
	  CommonMethods.sendText("john", addEmpPage.firstNameInput);
	  CommonMethods.sendText("doe34", addEmpPage.lastNameInput);
	}

	@When("user clicks on save button")
	public void user_clicks_on_save_button() {
	  CommonMethods.click(addEmpPage.saveButton);
	}

	@Then("employee added successfully")
	public void employee_add_successfully() {
	   System.out.println("Employee added successfully");
	}
//---adding multiple employees using scenario outline---//
	@When("user enters {string} and {string} and {string}")
	public void user_enters_and_and(String string, String string2, String string3) {
	    CommonMethods.sendText(string, addEmpPage.firstNameInput);
	    CommonMethods.sendText(string2, addEmpPage.middleNameInput);
	    CommonMethods.sendText(string3, addEmpPage.lastNameInput);
	}

	@When("user enters {string} and {string} and {string} in data driven format")
	public void user_enters_and_and_in_data_driven_format(String firstName, String middleName, String lastName) {
		CommonMethods.sendText(firstName, addEmpPage.firstNameInput);
		CommonMethods.sendText(middleName, addEmpPage.middleNameInput);
		CommonMethods.sendText(lastName, addEmpPage.lastNameInput);
	}

	@Then("employee added successfuly")
	public void employee_added_successfuly() {
	    System.out.println("employees added successfully");
	}
	
	 @When("user adds multiple employees using excel from {string} and verify it")
	    public void user_adds_multiple_employees_using_excel_from_and_verify_it(String sheetName) throws InterruptedException {
		//here we are getting the data from excel file using parameters
	       List<Map<String, String>> newEmployees =
	               ExcelReader.read("Sheet1", Constants.ADDEMPLOYEE_DATA_PATH);

	       Iterator<Map<String, String>> itr = newEmployees.iterator();

	       //it will check whether we have new element/value or not
	        while (itr.hasNext()){

	           //in this map, we have data from every single employee one by one it will give us that data
	           Map<String,String> mapNewEmp =  itr.next();
	            //we are filling the employee data now using mapNewEmp variable
	           //BATCH 16, KEYS WHAT WE ARE PASSING HERE SHOULD MATCH WITH THE KEYS IN EXCEL
	           sendText(mapNewEmp.get("firstname"),addEmpPage.firstNameInput);
	           sendText(mapNewEmp.get("lastname"), addEmpPage.lastNameInput);
	           sendText(mapNewEmp.get("middlename"), addEmpPage.middleNameInput);
	           sendText(mapNewEmp.get("photographpath"), addEmpPage.photographUploadBtn);

	           //we can enter username and password only after selecting the checkbox
	            if(!addEmpPage.loginDetailsCheckBox.isSelected()){
	                click(addEmpPage.loginDetailsCheckBox);
	            }
	            sendText(mapNewEmp.get("username"),addEmpPage.usernameTextFieldBox);
	            sendText(mapNewEmp.get("password"), addEmpPage.passwordTextFieldBox);
	            sendText(mapNewEmp.get("confirmpassword"), addEmpPage.confirmPasswordBox);

	            //here we are fetching the employee id from the UI using get attribute method
	            String empIdValue = addEmpPage.employeeIDInput.getAttribute("value");
	            Assert.assertTrue(addEmpPage.saveButton.isDisplayed());
	            click(addEmpPage.saveButton);
	            Thread.sleep(3000);
	            //we have to verify that the employee has been added
	            click(dashboardPage.pimDashboardBtn);
	            //searching the employee using emp id which we just got
	            sendText(empIdValue, dashboardPage.searchIdTextBox);
	            click(dashboardPage.searchButton);
	            Thread.sleep(3000);

	            //print the value from the table row
	            List<WebElement> rowData = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
	            for (int i=0; i<rowData.size(); i++){
	                System.out.println("I am inside the loop");
	                //it will return one by one all the data from the row
	                String rowText = rowData.get(i).getText();
	                //it will print the complete row data
	                //output of this will be empid firstname middlename lastname
	                System.out.println(rowText);
	                //we have to verify this data against the data coming from excel

	                String expectedData = empIdValue + " "+mapNewEmp.get("firstname")+" "+
	                        mapNewEmp.get("middlename")+" "+mapNewEmp.get("lastname");

//	                Assert.assertEquals(expectedData, rowText);
	                //you can use below code too to verify the data
	              //  Assert.assertTrue(expectedData.equals(rowText));
	            }
	            //to add more employees we need to click on add employee button
	            click(dashboardPage.addNewEmployeeBtn);
	        }

	    
	 }
}
