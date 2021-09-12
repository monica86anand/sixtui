package ClearTripPages;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchFlights extends CommonMethods{
   private WebDriver driver;

   @FindBy(xpath = "//p[contains(text(),'Round trip')]/parent::div/preceding-sibling::div/span")
   private WebElement rdnBtnRoundTrip;

   @FindBy(xpath = "//h4[contains(text(),'From')]/following-sibling::div//input[@placeholder='Any worldwide city or airport']")
   private WebElement sddFrom;
   
   
   @FindBy(xpath = "//h4[contains(text(),'To')]/following-sibling::div//input[@placeholder='Any worldwide city or airport']")
   private WebElement sddTo;
   
   @FindBy(xpath = "//h4[contains(text(),'Depart')]/parent::div/parent::div/following-sibling::div//div[contains(@class,'homeCalender')]/button[1]")
   private WebElement departOnCal;
   
   
   @FindBy(xpath = "//h4[contains(text(),'Depart')]/parent::div/parent::div/following-sibling::div//div[contains(@class,'homeCalender')]/button[2]")
   private WebElement returnOnCal;
   
   @FindBy(xpath = "//p[contains(text(),'Bangalore')]")
   private WebElement autoSuggFrom;
   
   @FindBy(xpath = "//div[contains(text(),'Suggestions')]/following-sibling::li/p")
   private WebElement autoSuggTo;
   
   @FindBy(xpath = "//button[text()='Search flights']")
   private WebElement searchFlights;
   
   
   
   public SearchFlights(WebDriver driver)
   {
	   this.driver=driver;
	   
	   PageFactory.initElements(driver, this);
   }
   
   /**
    * This method is used to Select from airport
    */
   
   public String selectFromAirport() 
   {
	   try
	   {
	   explicitwait(driver, rdnBtnRoundTrip);
	   rdnBtnRoundTrip.click();
	   sddFrom.sendKeys(getTestData("fromAirport"));
	   Thread.sleep(2000);
	   ((JavascriptExecutor) driver).executeScript("arguments[0].click();", autoSuggFrom);
	   Thread.sleep(3000);
	   }
	   catch(Exception e)
	   {
		
	        e.printStackTrace();
	}
	
	   return sddFrom.getAttribute("value");
   }
	   
	/**
	 * This method is used to select destination airport 
	 */
   public String selectToAirport() 
   {
	   try
	   {
		   sddTo.sendKeys(getTestData("toAirport"));
		   scrollBy(driver);
		   Thread.sleep(1000);
		   autoSuggTo.click();
		   departOnCal.click();
	   }
	   catch(Exception e)
	   {
		 
	        e.printStackTrace();
	}
	   return sddTo.getAttribute("value");
   }
	  
   /**
    * This method is used to select departure on date
    */
   public void selectDepartOnDate()
   {
	   
	   try
	   {
		  
		   WebElement fromDate=  driver.findElement(By.xpath("//div[contains(text(),'"+getTestData("fromDate")+"') and contains(@class,'p-1')]/parent::div/parent::div[contains(@aria-label,'"+getTestData("fromMonth")+"')]"));
		   ((JavascriptExecutor) driver).executeScript("arguments[0].click();", fromDate);
		   ((JavascriptExecutor) driver).executeScript("arguments[0].click();", fromDate);
		
		  
		   new CommonMethods().scrollUp(driver);
		
	   }
	   catch(Exception e)
	   {
		 
	        e.printStackTrace();
	}
	   
	}

	/**
	 * This method is used to return on date
	 */
   
   public void selectReturnOnDate()
   {
	   
	   try
	   {
		  
		   returnOnCal.click();
		   ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[contains(text(),'"+getTestData("toDate")+"') and contains(@class,'p-1')]/parent::div/parent::div[contains(@aria-label,'"+getTestData("toMonth")+"')]")));
		  
		
		
	   }
	   catch(Exception e)
	   {
		   
	        e.printStackTrace();
	}
	   
	}
   
   /**
    * This method is used to select no of travellers
    */
   public String selectNoOfTravellers()
   {
	  String noOfAdults=""; 
	   try
	   {
		  
		   
				   driver.findElement(By.xpath("//h4[contains(text(),'Adults')]/following-sibling::select/option[contains(text(),'"+getTestData("adults")+"')]")).click();
				   Select sel=new Select(driver.findElement(By.xpath("//h4[contains(text(),'Adults')]/following-sibling::select")));
				   noOfAdults=sel.getFirstSelectedOption().getText();
				   System.out.print("noOfAdults"+noOfAdults);
				   searchFlights.click();
				  
	   }
	   catch(Exception e)
	   {
		   
	        e.printStackTrace();
	}
	 
	   
	  return noOfAdults; 
	}
    
   
   /**
    * This method is used to return the depart on and return on dates
    */
   
   public List<String> getDates() 
   {
List<String> datesFields=new ArrayList<String>();
	   try
	   {
	   List<WebElement> li=driver.findElements(By.xpath("//div[contains(@class,'homeCalender')]//div[contains(@class,'fs-2')]"));
	   for(int i=0;i<li.size();i++)
	   {
		   System.out.print(li.get(i).getText());
		   datesFields.add(li.get(i).getText());
	   }
	   }
	   catch(Exception e)
	   {
		 e.printStackTrace();  
	   }
	   return datesFields;
	
   }
}





   
   


