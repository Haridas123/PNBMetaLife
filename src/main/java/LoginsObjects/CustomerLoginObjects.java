package LoginsObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerLoginObjects {
	
	public WebDriver driver;
	
	// customer login page locators
	
	By login = By.xpath("//div[@class='loginDropdownMain show']");
	By partnerLogin=By.xpath("//div[@class='btn-group open']");
	By partnerLoginItems=By.xpath("//div[@class='dropdown-menu']//a");
	By loginId=By.xpath(" //input[@placeholder='Login ID']");
	By password=By.xpath("//input[@placeholder='Password']");
	By submit=By.xpath("(//div[@class='cust_login_wrapper']//div//div//div)[3]");
	By error=By.xpath("//p[@class='error-instructions red']");
	
	
	
	
	
	public CustomerLoginObjects(WebDriver driver2) {
		this.driver=driver2;
	}

	public WebElement loginText() {
		return driver.findElement(login);
	}
	
	public WebElement partnerBtn() {
		return driver.findElement(partnerLogin);
	}
	
	public List<WebElement> partnerDropDown(){
		return driver.findElements(partnerLoginItems);
	}
	
	public WebElement enterLoginId() {
		return driver.findElement(loginId);
	}
	
	public WebElement enterPassword() {
		return driver.findElement(password);
	}
	public WebElement submitBtn() {
		return driver.findElement(submit);
	}
	
	public WebElement errorMsg() {
		return driver.findElement(error);
	}
}
