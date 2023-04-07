package PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PNBMetLifeHomePage_Objects {
	public WebDriver driver;
	
	By header_Navigation=By.xpath("//div[@class='header__navigation-container-menu-item-title font-eyebrow-1']");
	By loginbtn=By.xpath("//label[@class='loginDropdown']");
	By searchBtn= By.xpath("//div[@class='header__utilities']//div[@class='header__search-container']");
	
	public PNBMetLifeHomePage_Objects(WebDriver driver) {
		 this.driver=driver;
	}
	
	public List<WebElement> headerItems(){
		
		return driver.findElements(header_Navigation);
		
	}
	
	public WebElement loginAgent() {
		return driver.findElement(loginbtn);
	}
	
	public WebElement searchBtn() {
		return driver.findElement(searchBtn);
	}

}
