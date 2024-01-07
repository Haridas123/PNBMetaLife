package LoginsObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginDropDownObjects {

	public WebDriver driver;
	
	
	By  login=	By.xpath("//label[@class='loginDropdown']");
	By  loginList=	By.xpath(" //div[@class='loginDropMenu']//ul//li");
	
	//search test case
	
	By searchBtn=	By.xpath("//div[@class='header__utilities']//div[@title='SEARCH']");
	By noResult=	By.xpath("//div[@class='font-body-3 ']");
	By searchBtn2=	By.xpath("//a[@id='homepage__global-searchLink']");
	By closeBtn=	By.xpath("//div[@class='search-overlay__close']");
	By searchText=	By.xpath("//input[@id='searchInPage']");
	
	public LoginDropDownObjects(WebDriver driver2) {
		this.driver=driver2;
	}

	public WebElement logins() {
		
		return driver.findElement(login);
	}
	
	public WebElement resultField() {
		
		return driver.findElement(noResult);
	}
	
	public WebElement searchLink() {
		
		return driver.findElement(searchBtn2);
	}
	public WebElement close() {
		
		return driver.findElement(closeBtn);
	}
	
 public WebElement searchBox() {
		
		return driver.findElement(searchText);
	}
	
	public WebElement search() {
		
		return driver.findElement(searchBtn);
	}
	
	public List<WebElement> loginItemList(){
		return driver.findElements(loginList);
	}
}
