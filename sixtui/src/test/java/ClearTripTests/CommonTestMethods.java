package ClearTripTests;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonTestMethods
{
	/**
	 * This method is used to open browser
	 * @param browser
	 * @return
	 * @throws Exception
	 */
public WebDriver openBrowser(String browser) throws Exception

{
	    Properties properties=loadPropertiesFile();
	    ChromeOptions chromeOptions = new ChromeOptions();
		
	   WebDriver driver = null;
	  
	   if("chrome".equals(getTestData(properties,"browser")))
	   {
	   System.setProperty("webdriver.chrome.driver", "C:\\Users\\monanand\\Downloads\\chromedriver_win32\\chromedriver.exe");
	   //driver = new ChromeDriver();
	   WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver(chromeOptions);
	   
	   }
	   else if("firefox".equals(getTestData(properties,"browser")))
	   {
		 //  System.setProperty("webdriver.gecko.driver","C:\\Users\\monanand\\Downloads\\geckodriver.exe" );
		   WebDriverManager.firefoxdriver().setup();
		   driver = new FirefoxDriver();   
	   }
	   
	   return driver;
}

/**
 * This method is used to load properties file
 * @return
 * @throws IOException
 */

public static Properties loadPropertiesFile() throws IOException
{
	   FileReader reader =new FileReader(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\cleartrip.properties"));
	   Properties properties=new Properties();
	   properties.load(reader);
	   return properties;
}

/**
 * This method is used to return value of a key from a properties file
 * @param prop
 * @param param
 * @return
 * @throws IOException
 */
public String getTestData(Properties prop,String param) throws IOException{
	 	   return prop.getProperty(param);
	   
}


}