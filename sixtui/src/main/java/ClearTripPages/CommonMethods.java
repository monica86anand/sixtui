package ClearTripPages;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods
{
	/**
	 * This method is used to handle explicit wait
	 * @param driver
	 * @param element
	 */
	public void explicitwait(WebDriver driver,WebElement element)
	{
	
		WebDriverWait wbwait=new WebDriverWait(driver, 100);
		ExpectedConditions.visibilityOf(element);
	}
	
	/**
	 * This method is used to scroll  downwards 
	 * @param driver
	 */
	public void scrollBy(WebDriver driver)
	{
	
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,300)");
	}
	
	
	/**
	 * 
	 * This method is used to scroll upwards
	 * @param driver
	 */
	public void scrollUp(WebDriver driver)
	{
	
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(300,0)");
	}
	
	
	/**
	 * This method is used to get test data
	 * @param param
	 * @return
	 * @throws IOException
	 */
	public String getTestData(String param) throws IOException{
		FileReader reader =new FileReader(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\cleartrip.properties"));
		   Properties properties=new Properties();
		   properties.load(reader);
		   return properties.getProperty(param);
		   
	}
	/**
	 * 
	 * 
	 * 
	 */
	public void switchWindow(WebDriver driver) throws Exception
	{
		
		try {
			String parent = driver.getWindowHandle();

			Set<String> s = driver.getWindowHandles();

			Iterator<String> I1 = s.iterator();

			while (I1.hasNext()) {

				String child_window = I1.next();

				if (!parent.equals(child_window)) {
					driver.switchTo().window(child_window);

					break;

				}

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
}