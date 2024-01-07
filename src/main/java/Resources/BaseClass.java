package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
 
 


public class BaseClass 
{
	
	 public WebDriver driver;
	
	public WebDriver driverInitialization() throws IOException {
		
		// this line used to read the data.properties file
		FileInputStream fis= new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\PNBMetLife\\src\\main\\java\\Resources\\data.properties");
		
		// this line access the data.properties file
		Properties prop= new Properties();
		prop.load(fis);
		String browserName =prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver-ver 114\\chromedriver.exe");
			
			//WebDriverManager.chromedriver().setup();	// this line detects browser version latest.we don't need to download driver
			driver =   new ChromeDriver();
			
			
			 
		}
		else if(browserName.equalsIgnoreCase("fireFox"))
		{
			// write here firefox code
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			//write here edge code here
		}
		else {
			System.out.println("please enter valid browser name");
			
		}
		return driver;
	}

}
