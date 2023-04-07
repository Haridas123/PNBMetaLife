package TestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import PageObjectModel.CallYouBackObject;
import PageObjectModel.PNBMetLifeHomePage_Objects;
import Resources.BaseClass;

public class PNBMetLIfeHomePage_TestCases extends BaseClass {
	
	
	public List<WebElement> cuntryName;
	public List<WebElement> headerItems;
	public List<WebElement> agentList;
	public List<WebElement> dotList;
	public List<WebElement>headLines;
	public List<WebElement> rightcontainerItems;
	
	public WebElement headText,showMore;
	//public WebDriver driver;
	public String name,name2,agentName,headLine,headLineText;
	public PNBMetLifeHomePage_Objects pnbObjects;
	 
	
	
	
	 
	 @Test
	public void header() throws IOException, InterruptedException {
		
		driver=driverInitialization();
		driver.get("https://www.pnbmetlife.com/");
		driver.manage().window().maximize();
		
		pnbObjects= new PNBMetLifeHomePage_Objects(driver);
		CallYouBackObject callObj= new CallYouBackObject(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		callObj.toggleBtn().click();

	}
	 
	//@Test
	 public void headerItems() {
		
			headerItems=pnbObjects.headerItems();
			
			for(int j=0;j<headerItems.size();j++)
			{
				name2=headerItems.get(j).getText();
				
					Actions action= new Actions(driver);
					action.moveToElement(headerItems.get(j)).perform();
				
			}
			
	 }
	
	@Test
	public void loginAgents() throws InterruptedException {
		
		
		pnbObjects= new PNBMetLifeHomePage_Objects(driver);
		pnbObjects.loginAgent().click();
		
		agentList=driver.findElements(By.xpath("//ul[@class='dropdown-menu-inner']//li"));
		dotList =driver.findElements(By.xpath("//ul[@class='slick-dots customSlickDots ']//li"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		headLines=driver.findElements(By.xpath("//h1[@class='headline__item-text font-header-4 font-header-2-md']"));
		
		for(int a=0;a<agentList.size();a++)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			agentName = agentList.get(a).getText();
			System.out.println("name of agents   "+agentName);
			agentList.get(a).click();
		}
		
		
		pnbObjects.searchBtn().click();
		for (int i=0;i<dotList.size();i++) {
			dotList.get(i).click();
			System.out.println("dots are clicked");
		}
		
		for(int h=0;h<headLines.size();h++)
		{
			headLine=headLines.get(h).getText();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			
			System.out.println("headline   "+headLine+" reached ");
		}
		
	}
	
	//@Test
	public void leftAndRightContainer() throws IOException, InterruptedException {
		
		String nameText;
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		headText=driver.findElement(By.xpath("//div[@class='sorting-hat__headline-left font-header-2-md font-header-4-sm font-header-4']"));
		
		//rightcontainerItems=driver.findElements(By.xpath("//div[@class='col-12 col-sm-6 sorting-hat-menu-option sorting-hat-cta']"));
		rightcontainerItems=driver.findElements(By.xpath("//div[@class='sorting-hat__itemlink']"));
		showMore=driver.findElement(By.xpath("//div[@class='showmore-link']"));

		headLineText=headText.getText().toString();
		System.out.println("headText  "+headLineText);

		 showMore.click();
		 
		 //JavascriptExecutor js = (JavascriptExecutor)driver;
		 Actions actions = new Actions(driver);
		for(int c=0;c<rightcontainerItems.size();c++) {

			  nameText=rightcontainerItems.get(c).getText();
			  System.out.println("text "+rightcontainerItems.get(c).getText());
			  
			  if(nameText.equalsIgnoreCase("Get a Callback"))
			  {

				  rightcontainerItems.get(c);  
				  System.out.println("text "+rightcontainerItems.get(c).getText());
			  }
		  
			  else  {
				  
				  actions.moveToElement(rightcontainerItems.get(c)).click().build().perform();
				 // js.executeScript("arguments[0].click();", rightcontainerItems.get(c));
				 // rightcontainerItems.get(c).click();
				  System.out.println("Pay Premium Online clicked successfully "+rightcontainerItems.get(c).getText());
			  }
			  

			}
	}
}
