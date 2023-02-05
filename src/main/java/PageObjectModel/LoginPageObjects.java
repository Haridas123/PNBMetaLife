package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {
	//this driver dont have scope. driver=NULL;
	public WebDriver driver;
	
	By loginBt= By.xpath("(//div[@title='LOG IN'])[1]");
	By loginBt2= By.xpath("//input[@value='Login']");
	By selectCountry=By.xpath("//div[@class='footer-country-selector font-body-4']");
	
	
	public LoginPageObjects(WebDriver driver2) {
		 this.driver=driver2;	// driver has scope.driver is not now NULL
	}
	
	public WebElement selectCountry()
	{
		return driver.findElement(selectCountry);
	}

	public WebElement loginHomePageBTN()
	{
		return driver.findElement(loginBt);
	}

	public WebElement loginSubHome() {
		return driver.findElement(loginBt2);
	}
	
}
