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
	By loginId=By.xpath(" //input[@placeholder='Mobile no/Email id/Client id/User id']");
	By password=By.xpath("//input[@placeholder='Password']");
	By submit=By.xpath("(//div[@class='cust_login_wrapper']//div//div//div)[3]");
	By error=By.xpath("//p[@class='error-instructions red']");
	
	// Top_menu menu-list
	
	By menuList= By.xpath("//ul[@class='top_menu menu-list']//li");
	
	// Head social link
	
	By socialLink=By.xpath("//div[@class='head_social_lnk']//a");
	
	// new user locators
	
	By newUser=By.xpath(" //ul[@class='login_lnk']//li[1]");
	By userRegis=By.xpath("//h1");
	By custId=By.xpath(" //tr//th[1] ");
	//By inputCustId=By.xpath("//input[@id='CustId']"); //  //input[@id='CustId']
	By inputCustId=By.xpath("//input[@id='CustId']");
	By inputUser=By.xpath("//input[@id='UserName']");
	By username=By.xpath("(//th)[2]");
	By selectQuest=By.xpath("(//th)[3]");
	By securityAns=By.xpath("(//th)[4]");
	By inputSecurity=By.xpath("//input[@id='SecAnswer']");
	By policyNo=By.xpath("(//th)[5]");
	By inputPolicy=By.xpath("//input[@id='PolicyNo']");
	By dob=By.xpath("(//th)[6]");
	By email=By.xpath("(//th)[7]");
	By inputEmail=By.xpath("//input[@id='Email']");
	By mobile=By.xpath("(//th)[8]");
	By mobilecode=By.xpath("//input[@id='MobCode']");
	By MobileNo=By.xpath(" //input[@id='MobNo']");
	By regisBtn=By.xpath(" //input[@id='RegisterBut']");
	By resetBtn=By.xpath("//input[@id='ResetBut']");
	By calender=By.xpath("//input[@id='Dob']");
	By pickMonth=By.xpath("//select[@class='ui-datepicker-month']");
	By pickYear=By.xpath("//select[@class='ui-datepicker-year']");
	By pickDate=By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td[@data-handler='selectDay']");
	By previous=By.xpath(" //a[@title='Prev']");
	By next=By.xpath("//a[@title='Next']");
	By forgotPass=By.xpath(" //ul[@class='login_lnk']//li[2]");
	By customerId2=By.xpath("//input[@id='txtCustId']");
	By pagerItems=By.xpath(" //div[@class='bx-pager-item']//a");
	By saleChannel=By.xpath("//ul[@class='sales_channel']//li");
	
	
	public CustomerLoginObjects(WebDriver driver2) 
	{
		this.driver=driver2;
	}
	
	
	
	public List<WebElement> salesChannelList() 
	{
		return driver.findElements(saleChannel);
	}
	public List<WebElement> pagerItemList() {
		return driver.findElements(pagerItems);
	}
	public WebElement inputCustomerId2() {
		return driver.findElement(customerId2);
	}
	
	
	public WebElement clientId() {
		return driver.findElement(loginId);
	}
	public WebElement clientpassword() {
		return driver.findElement(password);
	}
	
	
	
	
	public WebElement forgotPasswordbtn() {
		return driver.findElement(forgotPass);
	}
	public WebElement nextBtn() {
		return driver.findElement(next);
	}
	public WebElement previousBtn() {
		return driver.findElement(previous);
	}
	public WebElement selectDay() {
		return driver.findElement(pickDate);
	}
	public WebElement selectYear() {
		return driver.findElement(pickYear);
	}
	public WebElement selectMonth() {
		return driver.findElement(pickMonth);
	}
	public WebElement dob() {
		return driver.findElement(calender);
	}
	public WebElement userResetBtn() {
		return driver.findElement(resetBtn);
	}
	public WebElement registrationBtn() {
		return driver.findElement(regisBtn);
	}
	public WebElement inputMobileNo() {
		return driver.findElement(MobileNo);
	}
	public WebElement inputMobileCode() {
		return driver.findElement(mobilecode);
	}
	public WebElement mobileText() {
		return driver.findElement(mobile);
	}
	public WebElement inputEmailId() {
		return driver.findElement(inputEmail);
	}
	public WebElement emailText() {
		return driver.findElement(email);
	}
	
	public WebElement dobText() {
		return driver.findElement(dob);
	}
	
	public WebElement inputPolicyNo() {
		return driver.findElement(inputPolicy);
	}
	
	public WebElement policyNoText() {
		return driver.findElement(policyNo);
	}
	public WebElement securityAnsText() {
		return driver.findElement(securityAns);
	}
	
	public WebElement inputSecurityAns() {
		return driver.findElement(inputSecurity);
	}
	
	public WebElement selectQuestionText() {
		return driver.findElement(selectQuest);
	}
	
	public WebElement userNameText() {
		return driver.findElement(username);
	}
	
	public WebElement inputUserName() {
		return driver.findElement(inputUser);
	}
	
	public WebElement inputCustomerId() {
		return driver.findElement(inputCustId);
	}
	
	public WebElement customerId() {
		return driver.findElement(custId);
	}
	
	public WebElement userRegistration() {
		return driver.findElement(userRegis);
	}
	
	public WebElement newUserBtn() {
		return driver.findElement(newUser);
	}
	
	public List<WebElement> socialLinklist(){
		return driver.findElements(socialLink);
	}
	
	
	public List<WebElement> topMenuList(){
		return driver.findElements(menuList);
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
