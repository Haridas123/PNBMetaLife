package TestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import PageObjectModel.CallYouBackObject;
import PageObjectModel.PNBMetLifeHomePage_Objects;
import Resources.BaseClass;

public class PNBMetLIfeHomePage_TestCases extends BaseClass {
	public List<WebElement> cuntryName;
	public List<WebElement> headerItems;
	public String name,name2;
	public PNBMetLifeHomePage_Objects pnbObjects;
	
	
	 
	 
	 @Test
	public void headerItem() throws IOException, InterruptedException {
		
		driver=driverInitialization();
		driver.get("https://www.pnbmetlife.com/");
		driver.manage().window().maximize();
		
		pnbObjects= new PNBMetLifeHomePage_Objects(driver);
		CallYouBackObject callObj= new CallYouBackObject(driver);
		//Thread.sleep(7000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		callObj.toggleBtn().click();

	}
	 
	@Test
	 public void headerItems() {

			headerItems=pnbObjects.headerItems();
			
			for(int j=0;j<headerItems.size();j++)
			{
				name2=headerItems.get(j).getText();
				
					Actions action= new Actions(driver);
					action.moveToElement(headerItems.get(j)).perform();
				
			}
	 }
}
