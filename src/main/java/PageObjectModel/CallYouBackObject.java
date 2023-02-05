package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CallYouBackObject {
	public WebDriver driver;
	
	By toggleButton= By.xpath("(//button[@class='customModal-close customModal-toggle'])[1]");
	By userName=By.xpath("//input[@id='broname']");
	By mobile=By.xpath("//input[@id='bromobileNumber']");
	By getOpt=By.xpath("//a[@class='lead-gen-breaker__cta btn-brand-1st leadFormGenerateOTP']");
	By otp=By.xpath("//input[@id='brojoinNowOTP']");
	By selectCity= By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']");
	By submitBtn= By.xpath("//a[@class='lead-gen-breaker__cta btn-brand-1st leadFormSubmit']");
	
	
	public CallYouBackObject(WebDriver driver2) {
		
		this.driver=driver2;
	}

	public WebElement toggleBtn()
	{
		return driver.findElement(toggleButton);
	}
	
	public WebElement userName()
	{
		return driver.findElement(userName);
	}
	
	public WebElement mobile() {
		
		return driver.findElement(mobile);
	}
	public WebElement getOtp() {
		return driver.findElement(getOpt);
	}
	public WebElement city() {
		return driver.findElement(selectCity);
	}
	public WebElement submit() {
		return driver.findElement(submitBtn);
	}
	

}
