package LoginListTestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import LoginsObjects.CustomerLoginObjects;
import LoginsObjects.LoginDropDownObjects;
import PageObjectModel.CallYouBackObject;
import Resources.BaseClass;

public class CutomerLoginTestcases extends BaseClass{
	
	public List<WebElement> loginItems;
	public CustomerLoginObjects custObj;
	

	@Test(dataProvider = "loginData")
	public void loginTry(String userName,String password) throws IOException {
		
		String name;
		String actual="Error: Either the login id or password is incorrect";
		String expected="";
		
	
		driverInitialization();
		driver.get("https://www.pnbmetlife.com/");
		driver.manage().window().maximize();
		
		CallYouBackObject call = new CallYouBackObject(driver);
		call.toggleBtn().click();
		
		LoginDropDownObjects loginObj=new LoginDropDownObjects(driver);
		
		loginObj.logins().click();
		loginItems=loginObj.loginItemList();
		
		//next() method point elements in sequence.
		//String parent_Tab ;	//parent Tab 
	//	String child_Tab ;	//child Tab
	for(int i=0;i<loginItems.size();i++) {
			
		name=loginItems.get(i).getText();
		System.out.println("titles --- "+loginItems.get(i).getText());
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
		
	
		}
		CustomerLoginObjects custObj=new CustomerLoginObjects(driver);
		
		custObj.enterLoginId().sendKeys(userName);
		custObj.enterPassword().sendKeys(password);
		custObj.submitBtn().click();
		expected=custObj.errorMsg().getText();
		Assert.assertEquals(actual, expected);
		// this line i have used for avoiding "stale element reference: element is not attached to the page document"
		loginItems=loginObj.loginItemList();
	}
		
		
}
	
	@DataProvider
	public Object[][] loginData(){
		Object[][] loginInput=new Object[18][2];
		loginInput[0][0]="  ";					//valid id ---> Haridasq , Hari@123
		loginInput[0][1]="hari@123";
		
		loginInput[1][0]="hari";	//invalid userName
		loginInput[1][1]=" Hari@123 "; 		//password start with space ,invalid
	/*	
		loginInput[2][0]="@hari";	//invalid username start with special symbol
		loginInput[2][1]="Hari@123 ";//valid password
		
		loginInput[3][0]="Haridas@";	//valid username
		loginInput[3][1]="";		// blank password
		
		loginInput[4][0]="Haridas1234567890qwertyyuiophjklmnbvcxz";//username limit exceed
		loginInput[4][1]="Hari@123"; 								//valid password
		
		loginInput[5][0]="Haridas@";									//valid username
		loginInput[5][1]="qwertyuioplkjhgfdsazxcvbnm1234567890";	//exceed character limit
		
		loginInput[6][0]="Haridas";			//space is not allowed
		loginInput[6][1]="hari@123";		//valid password
		
		loginInput[7][0]="Haridas@";		//valid username
		loginInput[7][1]="Hari@123"; 		//valid password
		
		loginInput[8][0]="Haridas@";		//valid username
		loginInput[8][1]="Hari@12";			//old and new password should be different
		*/
		
		return loginInput;
	}
	
}
