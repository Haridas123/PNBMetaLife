package LoginListTestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import LoginsObjects.CustomerLoginObjects;
import LoginsObjects.LoginDropDownObjects;
import PageObjectModel.CallYouBackObject;
import Resources.BaseClass;
import org.openqa.selenium.Alert;

public class CutomerLoginTestcases extends BaseClass
{
	
	public List<WebElement> loginItems;
	public CustomerLoginObjects custObj;
	public List<WebElement> menuItems;
	public List<WebElement> social;
	public List<WebElement> pagerItems;
	public List<WebElement> saleChannelItems;

	
	

	//@Test(dataProvider = "loginData")
	@Test(groups= {"SmokeTest"})
	public void aloginTry( ) throws IOException, InterruptedException {
		
		String name;
		String actual="Error: Either the login id or password is incorrect";
		String expected="";
		
	
		driverInitialization();
		driver.get("https://www.pnbmetlife.com/");
		driver.manage().window().maximize();
		
		CallYouBackObject call = new CallYouBackObject(driver);
		call.toggleBtn().click();
		custObj=new CustomerLoginObjects(driver);
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
		//driver.switchTo().window(parent_Tab);
	
		}
		//custObj=new CustomerLoginObjects(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		custObj.enterLoginId().sendKeys("haridas");
		custObj.enterPassword().sendKeys("password123");
		custObj.submitBtn().click();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//expected=custObj.errorMsg().getText();
		
		//Assert.assertEquals(actual, expected);
		// this line i have used for avoiding "stale element reference: element is not attached to the page document"
		loginItems=loginObj.loginItemList();
	}
	
		
}
	
	//@DataProvider
	public Object[][] loginData(){
		Object[][] loginInput=new Object[2][2];
		loginInput[0][0]="haridas  ";					//valid id ---> Haridasq , Hari@123
		loginInput[0][1]="hari@123";
		/*	
		loginInput[1][0]="hari";	//invalid userName
		loginInput[1][1]=" Hari@123 "; 		//password start with space ,invalid
		
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
	
	/*
	//@Test
	public void menuItemLIst() {
		
		//CallYouBackObject call = new CallYouBackObject(driver);
		call.toggleBtn().click();
		
		//LoginDropDownObjects loginObj=new LoginDropDownObjects(driver);
		
		loginObj.logins().click();
		loginItems=loginObj.loginItemList();
		custObj=new CustomerLoginObjects(driver);
		menuItems=custObj.topMenuList();
		for(int t=0;t<menuItems.size();t++)
		{
			menuItems.get(t).click();
		}
	}*/
	
	
	//@Test
	public void headSocialLinks() throws InterruptedException {
		
	social=custObj.socialLinklist();
		String title;
		for(int s=0;s<social.size();s++)
		{	//this line works.it stop the execution control for 8 second every iteration	
			Thread.sleep(8000);
			
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  //not working
		//	wait.until(ExpectedConditions.elementToBeClickable(social.get(s)));			//not working
		//	((JavascriptExecutor)driver).executeScript("arguments[0].click();", social.get(s));	//not working
			
			title=social.get(s).getText();
			if(title.contentEquals("1800-425-69-69 (For customers calling from within India only)")) {
				//social.get(s).click();
			// Switching to Alert        
		        Alert alert = driver.switchTo().alert();
				// to cancel the Alert
				driver.switchTo().alert().dismiss();
				System.out.println("first Titel--->"+social.get(s).getText()+"index "+s);	
				
			}
			else {
				social.get(s).click();
				System.out.println(social.get(s).getText());
			}
			
		}
	}
	
	//@Test
	public void newUser() throws InterruptedException
	{
		
		String headline,securityAnsText,policyText,DOB,email,mobile;
	
	//	custObj.forgotPasswordbtn().click();
		custObj.newUserBtn().click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		custObj.inputCustomerId().sendKeys("22123");
		custObj.newUserBtn().click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			headline=custObj.userRegistration().getText();
			policyText=custObj.policyNoText().getText();
			System.out.println("policyText --->"+policyText);
		//Assert.assertEquals(headline, "User Registration", "headline matched");
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  //not working
		//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy("custObj.inputCustomerId()"));			//not working
		
		/*
		//custObj.inputCustomerId().sendKeys("haridas123");
		Thread.sleep(5000);
		
		
		custObj.inputUserName().sendKeys("hari123");
		securityAnsText=custObj.securityAnsText().getText();
	//	Assert.assertEquals(securityAnsText, "Security Answer:", "Security Answer: matched");
		Thread.sleep(5000);
		custObj.inputSecurityAns().sendKeys("tandulwadi");
		policyText=custObj.policyNoText().getText();
	//	Assert.assertEquals(policyText, "Policy No./Solution Id*:", "Policy No./Solution Id*: matched");
		Thread.sleep(5000);
		custObj.inputPolicyNo().sendKeys("1234567890");
		DOB=custObj.dobText().getText();
		Thread.sleep(5000);
	//	Assert.assertEquals(DOB, "DOB*:", "DOB*: matched");
		custObj.dob().click();
		custObj.selectYear().click();
		custObj.selectMonth();
		custObj.selectDay();
		
		email=custObj.emailText().getText();
//		Assert.assertEquals(email, "Email ID*:", "Email ID*: matched");
		Thread.sleep(5000);
		custObj.inputEmailId().sendKeys("tokalwadhari@gmail.com");
		mobile=custObj.mobileText().getText();
	//	Assert.assertEquals(mobile, "Mobile*:", "Mobile*: matched");
		Thread.sleep(5000);
		custObj.inputMobileCode().sendKeys("91");
		custObj.inputMobileNo().sendKeys("9545056174");
		custObj.userResetBtn().click();
		custObj.userResetBtn().click();  */
		
		
	}
	
	//@Test
	public void pagerList() throws InterruptedException {
		  List<WebElement> pList=driver.findElements(By.xpath("//div[@class='bx-wrapper']//li[2]"));
		
		pagerItems=custObj.pagerItemList();
		
		for(int p=0;p<pagerItems.size();p++) {
			Thread.sleep(5000);
			pagerItems.get(p).click();
			//pList.get(p).click();
			System.out.println("tagName"+pagerItems.get(p).getTagName());
		}
	}
	
	//@Test
	
	public void salesChannelList() {
		saleChannelItems=custObj.salesChannelList();
		for(int s=0;s<saleChannelItems.size();s++) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			saleChannelItems.get(s).click();
			System.out.println("title -- > "+ saleChannelItems.get(s).getText());
		}
	}
}
