package seleniumtests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import util.CommonMethods;

public class HooksUtility extends CommonMethods{
	
	@Before
	public static void start() {
		CommonMethods.openBrowserAndNavigateToURL();
	}
	
	@After
	public static void end(Scenario scen) {
		byte[] scrShot;
		if(scen.isFailed()) {
			scrShot = CommonMethods.takeScreenShot("failed/"+ scen.getName());
		}else {
			scrShot = CommonMethods.takeScreenShot("passed/"+scen.getName());
		}
		scen.attach(scrShot, "image/png", scen.getName());
		CommonMethods.closeBrowser();
	}

}
