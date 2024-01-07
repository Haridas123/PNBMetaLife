package PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PNBMetLifeHomePage_Objects 
{
	public WebDriver driver;

	By header_Navigation =	 By.xpath("//div[@class='header__navigation-container-menu-item-title font-eyebrow-1']");
	By loginbtn = 	By.xpath("//label[@class='loginDropdown']");
	By searchBtn =	 By.xpath("//div[@class='header__utilities']//div[@class='header__search-container']");
	By our = 	By.xpath(" //div[@class='content-promo-banner__eyebrow font-eyebrow-1']");
	By promobanner =	 By.xpath(" //div[@class='content-promo-banner__headline font-header-4 font-header-5-sm font-header-4-md']");
	By exploreNowbtn =	 By.xpath("//div//a[contains(text(),'EXPLORE NOW')]");
	By leftcontainer = By.xpath("//div[@class='report-breaker__left-container']");
	By beaware = By.xpath("//div[@class='report-breaker__headline-right font-desc-3 font-desc-2-md']");
	By kMore = By.xpath("//a[@class='report-breaker__link']");

	By assuretextView = By.xpath("//p[contains(text(),'We assure you')]");
	By larrow = By.xpath("(//div[@class='col-4 col-md-2 value-prop__controls d-block'])[1]//a[1]");
	By rarrow = By.xpath(" (//div[@class='col-4 col-md-2 value-prop__controls d-block'])[1]//a[2]");

	By meraclaim=By.xpath(" //div[@class='virtualcardWrap']//a");
	
	By junior=By.xpath(" //h2[@class='font-header-4 font-header-5-sm font-header-2-md product-promo-breaker-title']");
	By junior2=By.xpath("//div[@class='font-body-1 font-body-3-sm product-promo-breaker-copy']//p");
	By knowMore2 =By.xpath("//div[@class='product-promo-breaker-cta brand-button font-cta-5']//a");
	
	By lArrow=By.xpath("//div[@class='col-12 col-md-1  d-none d-md-flex recirc-image--indicators']//a[1]");
	By rArrow2=By.xpath("//div[@class='col-12 col-md-1  d-none d-md-flex recirc-image--indicators']//a[2]");
	
	// important notices
	
	By left=By.xpath(" (//div[@class='col-4 col-md-2 value-prop__controls d-block'])[2]//a[1]");
	By right=By.xpath(" (//div[@class='col-4 col-md-2 value-prop__controls d-block'])[2]//a[2]");
	By know=By.xpath(" (//div[@class='slick-track'])[3]//a[contains(text(),'Know More')]");
	//Disclaimer
	
	By disc=By.xpath("//div[@class='disclaimer-container--accordionSection']");
	
	//footerLinks
	By pLink=By.xpath(" //div[@class='footer-primary-links']//a");
	By sLink=By.xpath("//div[@class='footer-secondary-links']//a");
	
	// social footer
	By socialFooter=By.xpath("//a[@class='footer-social-media__link']");
	
	//footer info
	By footerInfo=By.xpath("//div[@class='footer-info__legal-links font-cta-4']//a");
	By footerCall=By.xpath("//div[@class='footer-info__contact font-cta-2']//a");
	
	
	public PNBMetLifeHomePage_Objects(WebDriver driver) 
	{
		this.driver = driver;
	}

	public List<WebElement> footerInfoItems() {

		return driver.findElements(footerInfo);
				
	}
	
	public WebElement footerInfoContact() {

		return driver.findElement(footerCall);
				
	}

	public List<WebElement> socialFooterItems() {

		return driver.findElements(socialFooter);
				
	}
	
	public List<WebElement> meraMediclaim() {

		return driver.findElements(meraclaim);
	}
	
	public List<WebElement> primaryFooterLink() {

		return driver.findElements(pLink);
	}
	
	public List<WebElement> secondaryFooterLink() {

		return driver.findElements(sLink);
	}
	
	public List<WebElement> impknowMore() {

		return driver.findElements(know);
	}
	
	public WebElement disclaimerBtn() {

		return driver.findElement(disc);
	}
	
	public WebElement larrowBtn3() {

		return driver.findElement(left);
	}
	
	public WebElement rarrowBtn3() {

		return driver.findElement(right);
	}
	
	public WebElement larrowBtn2() {

		return driver.findElement(lArrow);
	}
	public WebElement rarrowBtn2() {

		return driver.findElement(rArrow2);
	}
	
	
	public WebElement knowMoreBtn2() {

		return driver.findElement(knowMore2);
	}
	
	public WebElement juniorChamp() {

		return driver.findElement(junior2);
	}
	
	public WebElement juniorBad() {

		return driver.findElement(junior);
	}
	
	public WebElement assureView() {

		return driver.findElement(assuretextView);
	}

	public WebElement leftArrow() {

		return driver.findElement(larrow);
	}

	public WebElement rightArrow() {

		return driver.findElement(rarrow);
	}

	public WebElement ourBelife() {

		return driver.findElement(our);
	}

	public WebElement promoBan() {

		return driver.findElement(promobanner);
	}

	public WebElement explorebtn() {
		return driver.findElement(exploreNowbtn);
	}

	public WebElement leftContainerText() {

		return driver.findElement(leftcontainer);
	}

	public WebElement knowMore() {
		return driver.findElement(kMore);
	}

	public WebElement spuriousCall() {

		return driver.findElement(beaware);
	}

	public List<WebElement> headerItems() {

		return driver.findElements(header_Navigation);

	}

	public WebElement loginAgent() {
		return driver.findElement(loginbtn);
	}

	public WebElement searchBtn() {
		return driver.findElement(searchBtn);
	}

}
