package seleniumtests;

import pages.DashboardPage;
import pages.LoginPage;
import pages.AddEmployeePage;

public class PageInitalizer {
	public static LoginPage loginPage;
	public static DashboardPage dashboardPage;
	public static AddEmployeePage addEmpPage;
	
	public static void initializePageObjects() {
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
		addEmpPage = new AddEmployeePage();
	}
}
