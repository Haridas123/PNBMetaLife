package TestCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
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

public class PNBMetLIfeHomePage_TestCases extends BaseClass 
{

	public List<WebElement> cuntryName;
	public List<WebElement> headerItems;
	public List<WebElement> agentList;
	public List<WebElement> dotList;
	public List<WebElement> headLines;
	public List<WebElement> rightcontainerItems;
	public List<WebElement> primlinks;
	public List<WebElement> seclinks;
	public List<WebElement> footerItem;

	public WebElement headText, showMore;
	// public WebDriver driver;
	public String name, name2, agentName, headLine, headLineText;
	public PNBMetLifeHomePage_Objects pnbObjects;

	@Test(groups= {"SanityTest"})   
	public void header() throws IOException, InterruptedException {

		driver = driverInitialization();
		driver.get("https://www.pnbmetlife.com/");
		driver.manage().window().maximize();

		pnbObjects = new PNBMetLifeHomePage_Objects(driver);
		CallYouBackObject callObj = new CallYouBackObject(driver);
		System.out.println("header  Executed ");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		callObj.toggleBtn().click();

	}

	@Test(groups= {"SanityTest"})
	public void headerItems() {

		headerItems = pnbObjects.headerItems();

		for (int j = 0; j < headerItems.size(); j++) {
			name2 = headerItems.get(j).getText();

			Actions action = new Actions(driver);
			action.moveToElement(headerItems.get(j)).perform();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
			System.out.println("headerItems Executed ----->  "+name2);
		}
		System.out.println("headerItems Executed ");
	}

	// @Test
	public void loginAgents() throws InterruptedException {

		pnbObjects = new PNBMetLifeHomePage_Objects(driver);
		pnbObjects.loginAgent().click();

		agentList = driver.findElements(By.xpath("//ul[@class='dropdown-menu-inner']//li"));
		dotList = driver.findElements(By.xpath("//ul[@class='slick-dots customSlickDots ']//li"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		headLines = driver.findElements(By.xpath("//h1[@class='headline__item-text font-header-4 font-header-2-md']"));

		for (int a = 0; a < agentList.size(); a++) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			agentName = agentList.get(a).getText();
			System.out.println("name of agents   " + agentName);
			agentList.get(a).click();
		}

		pnbObjects.searchBtn().click();
		for (int i = 0; i < dotList.size(); i++) {
			dotList.get(i).click();
			System.out.println("dots are clicked");
		}

		for (int h = 0; h < headLines.size(); h++) {
			headLine = headLines.get(h).getText();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

			System.out.println("headline   " + headLine + " reached ");
		}

	}

	// @Test
	public void leftAndRightContainer() throws IOException, InterruptedException {

		String nameText;

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		headText = driver.findElement(
				By.xpath("//div[@class='sorting-hat__headline-left font-header-2-md font-header-4-sm font-header-4']"));

		// rightcontainerItems=driver.findElements(By.xpath("//div[@class='col-12
		// col-sm-6 sorting-hat-menu-option sorting-hat-cta']"));
		rightcontainerItems = driver.findElements(By.xpath("//div[@class='sorting-hat__itemlink']"));
		showMore = driver.findElement(By.xpath("//div[@class='showmore-link']"));

		headLineText = headText.getText().toString();
		System.out.println("headText  " + headLineText);

		showMore.click();

		// JavascriptExecutor js = (JavascriptExecutor)driver;
		Actions actions = new Actions(driver);
		for (int c = 0; c < rightcontainerItems.size(); c++) {

			nameText = rightcontainerItems.get(c).getText();
			System.out.println("text " + rightcontainerItems.get(c).getText());

			if (nameText.equalsIgnoreCase("Get a Callback")) {

				rightcontainerItems.get(c);
				System.out.println("text " + rightcontainerItems.get(c).getText());
			}

			else {

				actions.moveToElement(rightcontainerItems.get(c)).click().build().perform();
				// js.executeScript("arguments[0].click();", rightcontainerItems.get(c));
				// rightcontainerItems.get(c).click();
				System.out.println("Pay Premium Online clicked successfully " + rightcontainerItems.get(c).getText());
			}

		}
	}

	// @Test
	public void promoBanner() throws IOException, InterruptedException {

		driver = driverInitialization();
		driver.get("https://www.pnbmetlife.com/");
		driver.manage().window().maximize();

		pnbObjects = new PNBMetLifeHomePage_Objects(driver);
		CallYouBackObject callObj = new CallYouBackObject(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		callObj.toggleBtn().click();

		System.out.println("our Belife text-->" + pnbObjects.ourBelife().getText());
		System.out.println("content of promo banner---" + pnbObjects.promoBan().getText());
		// pnbObjects.explorebtn().click();
		// driver.navigate().back();

		System.out.println("left container content-->" + pnbObjects.leftContainerText().getText());
		System.out.println("spurious -->" + pnbObjects.spuriousCall().getText());
		System.out.println(pnbObjects.knowMore().getText());
		// pnbObjects.knowMore().click();

		System.out.println("assure text --> " + pnbObjects.assureView().getText());

		// pnbObjects.rightArrow().click();

		Actions actions = new Actions(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// 2 loop for we assure you
		for (int p = 0; p < 5; p++) {
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pnbObjects.leftArrow());

			js.executeScript("arguments[0].click();", pnbObjects.leftArrow());
			// actions.moveToElement(pnbObjects.leftArrow()).click().build().perform();
			// pnbObjects.leftArrow().click();
			System.out.println("Left arrow location --> " + pnbObjects.leftArrow().getAccessibleName());
		}

		for (int p = 0; p < 5; p++) {
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pnbObjects.rightArrow());

			js.executeScript("arguments[0].click();", pnbObjects.rightArrow());
			// actions.moveToElement(pnbObjects.leftArrow()).click().build().perform();
			// pnbObjects.leftArrow().click();
			System.out.println("Left arrow location --> " + pnbObjects.rightArrow().getAccessibleName());
		}

		// learn more about insurance loop

		for (int a = 0; a < 11; a++) {
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pnbObjects.larrowBtn2());

			// js.executeScript("arguments[0].click();", pnbObjects.larrowBtn2());
			System.out.println(
					" learn more insurance ,LeftArrow location --> " + pnbObjects.rightArrow().getAccessibleName());
		}
		for (int a = 0; a < 11; a++) {
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pnbObjects.rarrowBtn2());

			// js.executeScript("arguments[0].click();", pnbObjects.rarrowBtn2());
			System.out.println(
					" learn more insurance ,LeftArrow location --> " + pnbObjects.rarrowBtn2().getAccessibleName());
		}

		// loop for solution
		for (int m = 0; m < pnbObjects.meraMediclaim().size(); m++) {

			js.executeScript("arguments[0].click();", pnbObjects.meraMediclaim().get(m));
			// pnbObjects.meraMediclaim().get(m).click();
			System.out.println("virtual card clicked");
		}
		// Disclaimer
		pnbObjects.disclaimerBtn().click();
		// importance notice loop

		for (int a = 0; a < 4; a++) {
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pnbObjects.larrowBtn3());

			js.executeScript("arguments[0].click();", pnbObjects.larrowBtn3());
			Thread.sleep(3000);
			pnbObjects.impknowMore().get(a).click();
			driver.navigate().back();
			Thread.sleep(3000);
			callObj.toggleBtn().click();
			System.out.println(
					" learn more insurance ,LeftArrow location --> " + pnbObjects.larrowBtn3().getAccessibleName());
		}

		for (int a = 0; a < 4; a++) {
			Thread.sleep(3000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pnbObjects.rarrowBtn3());

			js.executeScript("arguments[0].click();", pnbObjects.rarrowBtn3());
			System.out.println(
					" learn more insurance ,LeftArrow location --> " + pnbObjects.rarrowBtn3().getAccessibleName());
		}

		
		  for(int i=0;i<9;i++) {
			  js.executeScript("arguments[0].click();", pnbObjects.rightArrow());
		  //actions.moveToElement(pnbObjects.rightArrow()).click().build().perform();
		  pnbObjects.rightArrow().click();
		  System.out.println("assure text --> "+pnbObjects.rightArrow().getTagName());
		  }
		  // loop for solution 
		  // JavascriptExecutor js2 = (JavascriptExecutor)driver;
		  for(int m=0;m<pnbObjects.meraMediclaim().size();m++) 
		 {
		  
		  js.executeScript("arguments[0].click();", pnbObjects.meraMediclaim().get(m));
		  pnbObjects.meraMediclaim().get(m).click();
		  System.out.println("virtual card clicked");
		  }
		 

	}

	@Test(groups= {"SanityTest"})     
	public void footerLinks() throws IOException, InterruptedException {

		driver = driverInitialization();
		driver.get("https://www.pnbmetlife.com/");
		driver.manage().window().maximize();

		HttpURLConnection huc = null;
		int responseCode = 200;
		String homePage = "https://www.pnbmetlife.com/";
		String url = "";

		pnbObjects = new PNBMetLifeHomePage_Objects(driver);
		CallYouBackObject callObj = new CallYouBackObject(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
		callObj.toggleBtn().click();
		
		  //Disclaimer 
		pnbObjects.disclaimerBtn().click();
		 

		primlinks = pnbObjects.primaryFooterLink();
		seclinks = pnbObjects.secondaryFooterLink();

		System.out.println("primary footer links size -->" + primlinks.size());
		
		  Iterator<WebElement> it=primlinks.iterator();
		  
		  while(it.hasNext()) {
		   url= it.next().getAttribute("href");
		 
		  System.out.println("url is -->"+url);
		  
		  if(url==null||url.isEmpty()) {
		  System.out.println("url is empty or not configured"); continue;
		   }
		  if(url.startsWith(homePage))
		   {
		  System.out.println("url is belongs to another domain"); 
		  continue; 
		  }
		  
		  try {
		   huc= (HttpURLConnection) new URL(url).openConnection();
		  huc.setRequestMethod("HEAD");
		   huc.connect();
		  responseCode=huc.getResponseCode();
		  
		  if(responseCode>=400) { System.out.println("Links is Broken"+url);
		   } else
		    {
		  System.out.println("URl is valid -->"+url);
		   }
		  
		  }catch (MalformedURLException e) 
		  { // TODO Auto-generated catch block
		  e.printStackTrace();
		   }
		    catch (IOException e)
		    { // TODO Auto-generated catch
		   e.printStackTrace();
		   }
		  
		  }
		 

		
		for (int t = 0; t < primlinks.size(); t++) {

			primlinks.get(t).click();
			
			//System.out.println("names of links --->" + primlinks.get(t).getText());
			driver.navigate().back();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
			callObj.toggleBtn().click();
			primlinks = pnbObjects.primaryFooterLink();
		}

		// second footer loop
		for (int s = 0; s < seclinks.size(); s++) {
			System.out.println("names of links --->" + seclinks.get(s).getText());
			seclinks.get(s).click();
			Thread.sleep(3000);
			// System.out.println("names of links --->"+seclinks.get(s).getText());
		}

		
		  //social footer loop
		String names;
		for(int  f=0;f<pnbObjects.socialFooterItems().size()-13;f++)
		{
		  pnbObjects.socialFooterItems().get(f).click();
		  }
		
		//footer call  
		   pnbObjects.footerInfoContact().click();
	
		  
		 // footer Items loop
		  
		  footerItem=pnbObjects.footerInfoItems();
		  for(int e=0;e<footerItem.size()-14;e++)
		  {
			  
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		  WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
		  .until(ExpectedConditions.elementToBeClickable(footerItem.get(e)));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  
		  if(firstResult.getText().equalsIgnoreCase("IRDAI")||firstResult.getText().
		  equalsIgnoreCase("Life Insurance Council")
		  ||firstResult.getText().equalsIgnoreCase("Customer Education")||firstResult.
		  getText().equalsIgnoreCase("Ombudsman"))
		  {
		  System.out.println("footer Items name -->"+firstResult.getText());
		  
		  } else {
		  
		  firstResult.click(); 
		  driver.navigate().back();
		  callObj.toggleBtn().click();
		  footerItem=pnbObjects.footerInfoItems();
		  }
		  
		  }
		 
	}

}
