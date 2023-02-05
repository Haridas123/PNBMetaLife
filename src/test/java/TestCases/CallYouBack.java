package TestCases;

import java.io.IOException;

import PageObjectModel.CallYouBackObject;
import Resources.BaseClass;

public class CallYouBack extends BaseClass{
	
	public void callBack() throws IOException, InterruptedException {
		
		driverInitialization();
		//driver.get("http://www.metlife.com/");
		
		CallYouBackObject call = new CallYouBackObject(driver);
		Thread.sleep(7000);
		call.toggleBtn().click();
	}

}
