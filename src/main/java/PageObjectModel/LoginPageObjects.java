package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {
	//this driver dont have scope. driver=NULL;
	public WebDriver driver;
	//First testing commit
	By loginBt= By.xpath("(//div[@title='LOG IN'])[1]");
	By loginBt2= By.xpath("//input[@value='Login']");
	By selectCountry=By.xpath("//div[@class='footer-country-selector font-body-4']");
	
	// call you back form page objects
	
	//By toggleButton= By.xpath("(//button[@class='customModal-close customModal-toggle'])[1]");
	By toggleButton= By.xpath("//div[@class='customModal-wrapper customModal-transition mainbrochurecustom']//button[@class='customModal-close customModal-toggle']");
	By userName=By.xpath("//input[@id='broname']");
	By mobile=By.xpath("//input[@id='bromobileNumber']");
	By getOpt=By.xpath("//a[@class='lead-gen-breaker__cta btn-brand-1st leadFormGenerateOTP']");
	By otp=By.xpath("//input[@id='brojoinNowOTP']");
	By selectCity= By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']");
	By submitBtn= By.xpath("//a[@class='lead-gen-breaker__cta btn-brand-1st leadFormSubmit']");
	By toggleBtn2 =By.xpath("(//button[@class='customModal-close customModal-toggle'])[2]");
	
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
	
	public WebElement userName()
	{
		return driver.findElement(userName);
	}
	
	public WebElement mobile(){
		return driver.findElement(mobile);
	}
	public WebElement toggleButton()
	{
		return driver.findElement(toggleButton);
	}
}
