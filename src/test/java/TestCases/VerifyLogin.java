package TestCases;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import PageObjectModel.LoginPageObjects;
import Resources.BaseClass;

public class VerifyLogin extends BaseClass{
	public List<WebElement> cuntryName;
	String name;
	
	
	@Test
public void verifyLogin() throws IOException, InterruptedException {
	
	driver= driverInitialization();
	driver.get("http://www.metlife.com/");
	
	System.out.println("parent window--> "+driver.getWindowHandle());
	
	LoginPageObjects log=new LoginPageObjects(driver);
	Thread.sleep(5000);
	log.selectCountry().click();
	
	cuntryName =driver.findElements(By.xpath("//div[@class='footer-country-selector__country-name']"));
	
	for(int i=0;i<cuntryName.size();i++)
	{
		
		name=cuntryName.get(i).getText();
		 if(name.equalsIgnoreCase("India"))
		 {
			 cuntryName.get(i).click();
			 
			 /*
			//this line gives open tabs
				Set<String> windowID=driver.getWindowHandles();
				//applied Iteration on set collection
				Iterator<String> it= windowID.iterator();
				
				//next() method point elements in sequence.
				String parent_Tab = it.next();	//parent Tab 
				String child_Tab = it.next();	//child Tab
				
				//control transfered to child_Tab from parent_Tab
				driver.switchTo().window(child_Tab);
				System.out.println("child window--> "+driver.getWindowHandle()); */
		 }
	}
	
	Thread.sleep(7000);
	log.toggleButton().click();
	//log.userName().sendKeys("haidas");
	//log.mobile().sendKeys("9999000000");
	
	//Thread.sleep(10000);
	
	
	
	//log.loginHomePageBTN().click(); 
	
	//log.loginSubHome().click();
}
}
