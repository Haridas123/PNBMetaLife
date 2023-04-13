package LoginListTestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import LoginsObjects.LoginDropDownObjects;
import PageObjectModel.CallYouBackObject;
import Resources.BaseClass;

public class LoginDropDownTestcase extends BaseClass{
	
	public List<WebElement> loginItems;
	String actual,expected;
	String expect[]= {"Customer Login","PNB","NON PNB","Agency (Advisor)","Agency (Employees)","Direct Marketing","Pathshala","Carpediem"};
	
	
	
	
	
	//@Test(groups = "searchData")
	//@Test(dataProvider = "searchText")
	public void searchData(String inputString,String password) throws IOException {
		
		//String inputString="term plan";
		
		driverInitialization();
		driver.get("https://www.pnbmetlife.com/");
		driver.manage().window().maximize();
		
		CallYouBackObject call = new CallYouBackObject(driver);
		call.toggleBtn().click();
		
			
		LoginDropDownObjects loginObj=new LoginDropDownObjects(driver);
		loginObj.search().click();
		loginObj.searchBox().sendKeys(password);
		loginObj.searchLink().click();
		loginObj.close().click();
		System.out.println("searching data is passed");
		
	}
	@DataProvider
	public Object[][] searchText(){
		
		Object[][] data=new Object[2][2];
		data[0][0]="term ";
		data[0][1]="term plan info";
		data[1][0]="health";
		data[1][1]="health plan";
		
		return data;
	}
	
	
	//@Test(groups="login" )
	@Test
	public void loginBtn( ) throws IOException {
		
		String actual,expected;
		String name;
		
		driverInitialization();
		driver.get("https://www.pnbmetlife.com/");
		driver.manage().window().maximize();
		
		CallYouBackObject call = new CallYouBackObject(driver);
		call.toggleBtn().click();
		
		LoginDropDownObjects loginObj=new LoginDropDownObjects(driver);
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.elementToBeClickable(loginObj.logins()));
		//((JavascriptExecutor)driver).executeScript("arguments[0].click();", loginObj.logins());
		loginObj.logins().click();
		actual=loginObj.logins().getText();
		
		//Hard assert
		//Assert.assertEquals("Log In", actual);
		
		loginItems=loginObj.loginItemList();
		
		// soft Assert
		SoftAssert softAssert = new SoftAssert();
	
		for(int i=0;i<loginItems.size();i++) {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			name=loginItems.get(i).getText();
			loginItems.get(i).click();
			
			
			Set<String> handles=driver.getWindowHandles();
			Iterator<String> obj1= handles.iterator();
			
			//next() method point elements in sequence.
			String parent_Tab = obj1.next();	//parent Tab 
			String child_Tab = obj1.next();	//child Tab
			if(name.equalsIgnoreCase("Customer Login"))
			{
			//control transfered to child_Tab from parent_Tab
			driver.switchTo().window(child_Tab);
			WebElement partnerLoginBtn=driver.findElement(By.xpath("//div[@class='btn-group']"));
			partnerLoginBtn.click();
			 System.out.println("parentId--->"+parent_Tab+"-----childId----"+child_Tab);
			// control back to parent_Tab from child_Tab
			 driver.switchTo().window(parent_Tab);
			}
			 System.out.println("titals--->"+name+"parentId--->"+parent_Tab+"childId"+child_Tab);
			
			//System.out.println("assert result ");
		//	softAssert.assertEquals(name, expect[i]);
			
			//softAssert.assertAll();
			//System.out.println("assert passed ");
		}
		
		
	}

}
