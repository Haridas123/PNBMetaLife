package TestCases;

import java.io.IOException;
import java.util.List;

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
		 }
	}
	
	//log.loginHomePageBTN().click();
	
	//log.loginSubHome().click();
}
}
