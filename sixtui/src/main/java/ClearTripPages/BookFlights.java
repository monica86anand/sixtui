package ClearTripPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookFlights extends CommonMethods{
   private WebDriver driver;

   @FindBy(xpath = "//h2[contains(text(),' flights')]")
   private WebElement txtFlights;
   
   @FindBy(xpath = "//button[text()='Book']")
   private WebElement bookFlights;

 
   
   public BookFlights(WebDriver driver)
   {
	   this.driver=driver;
	   
	   PageFactory.initElements(driver, this);
   }
   
/*
 * This method is used to book tickets and check if book ticket button is displayed
 */
   public boolean bookTickets() throws Exception
   {
	  explicitwait(driver, bookFlights);
	  boolean flag=bookFlights.isDisplayed();
	   bookFlights.click();
	   Thread.sleep(5000);
	   return flag;
	   
	 
   
   }
   
   
   
   
}

