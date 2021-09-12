package ClearTripTests;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ClearTripPages.SelectFare;
import ClearTripPages.AddContactDetails;
import ClearTripPages.BookFlights;
import ClearTripPages.SearchFlights;

public class FlightsTest extends CommonTestMethods{
	   
	
	
	

	
	  static WebDriver driver;
	  static Properties prop;
	  CommonTestMethods cm=new CommonTestMethods();

	   @BeforeTest
	   public void setup() {
		
		   
		 try
		 {
		   driver= openBrowser("chrome");
		   prop=loadPropertiesFile();
		  
		
	       driver.navigate().to(getTestData(prop, "url"));
	      
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 }
		 catch(Exception e)
		 {
			e.printStackTrace();
		 }
	   }

	   @Test
	   public void searchFlights() throws Exception {
	
		SearchFlights sf=SearchFlights.class.getConstructor(WebDriver.class).newInstance(driver);
	    Assert.assertEquals(sf.selectFromAirport().trim(),getTestData(prop, "fromCity"));
	    Assert.assertEquals(sf.selectToAirport().trim(),getTestData(prop, "toCity"));
	    sf.selectDepartOnDate();
	    sf.selectReturnOnDate();
	  
	    Assert.assertTrue(sf.getDates().get(0).contains(getTestData(prop, "fromDate")));
	    Assert.assertTrue(sf.getDates().get(1).contains(getTestData(prop, "toDate")));
	    Assert.assertEquals(sf.selectNoOfTravellers().trim(),getTestData(prop, "adults"));
	
		
	      
	   }
	   
	   
	   @Test(dependsOnMethods = "searchFlights")
	   public void bookFlights() throws Exception {
	 
		BookFlights bookFlights=BookFlights.class.getConstructor(WebDriver.class).newInstance(driver);
		Assert.assertEquals(bookFlights.bookTickets(),true);
	
	      
	   }
	   
	   
	   @Test(dependsOnMethods = "bookFlights")
	   public void selectFare() throws Exception {
	 
		
		
		SelectFare selectfare=SelectFare.class.getConstructor(WebDriver.class).newInstance(driver);
		Assert.assertTrue(selectfare.checkIfSelectFarePageIsLoaded());
		selectfare.selectFare();
	
	      
	   }


	   
	   @Test(dependsOnMethods = "selectFare")
	   public void addContactDetails() throws Exception {
	 
		
		
		   AddContactDetails addContactDetails=AddContactDetails.class.getConstructor(WebDriver.class).newInstance(driver);
		   addContactDetails.addEmailAndMobileNo();
		   addContactDetails.addFirstNameOfTraveller();
		   addContactDetails.addLastNameOfTraveller();
		   addContactDetails.selectGender();
		   addContactDetails.selectCountry();
		   addContactDetails.selectDay(getTestData(prop, "day"));
		   addContactDetails.selectMonth(getTestData(prop, "month"));
		   addContactDetails.selectYear(getTestData(prop, "year"));
		   addContactDetails.clickContinuePayment();
		   Assert.assertTrue(addContactDetails.checkIfPaymentHeaderIsDisplayed());
	      
	   }

	   
	    @AfterTest
	    public void close(){
	          driver.quit();
	       }
	   
}


