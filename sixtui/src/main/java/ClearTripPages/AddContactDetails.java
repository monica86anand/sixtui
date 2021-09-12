package ClearTripPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddContactDetails extends CommonMethods {
	private WebDriver driver;
	private CommonMethods cm = new CommonMethods();

	@FindBy(xpath = "//input[@data-testid='mobileNumber']")
	private WebElement txtMobNo;

	@FindBy(xpath = "//input[@data-testid='email']")
	private WebElement txtEmail;

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	private WebElement continueBtn;
	
	@FindBy(xpath = "//button[text()='Continue to payment']")
	private WebElement continueToPayment;
	
	

	public AddContactDetails(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to add mobile no and email addr
	 */

	public void addEmailAndMobileNo() {

		try {

			explicitwait(driver, txtMobNo);
			driver.switchTo().defaultContent();
			Thread.sleep(1000);
			txtMobNo.sendKeys(getTestData("mobileNo"));
			Thread.sleep(1000);
			txtEmail.sendKeys(getTestData("email"));
			Thread.sleep(1000);
			List<WebElement> li = driver.findElements(By.xpath("//button[text()='Continue']"));
			for (int i = 0; i < li.size(); i++) {
				if (li.get(i).isDisplayed()) {
					li.get(i).click();
					break;
				}
			}
			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * This method is used to enter first name of traveller
	 */

	public void addFirstNameOfTraveller() {

		try {

			List<WebElement> firstName = driver.findElements(By.xpath("//input[@data-testid='firstName']"));

			for (int i = 0; i < firstName.size(); i++) {
				if (firstName.get(i).isDisplayed()) {
					firstName.get(i).sendKeys(getTestData("Traveller1firstName"));
					break;
				}
			}
			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method is used to enter last name of traveller
	 * 
	 */
	public void addLastNameOfTraveller() {
		try {

			List<WebElement> lastName = driver.findElements(By.xpath("//input[@data-testid='lastName']"));

			for (int i = 0; i < lastName.size(); i++) {
				if (lastName.get(i).isDisplayed()) {
					lastName.get(i).sendKeys(getTestData("Traveller1lastName"));
					break;
				}
			}

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * This method is used to select gender
	 * 
	 */
	public void selectGender() {
		try {
			List<WebElement> genderBtn = driver
					.findElements(By.xpath("//div[contains(text(),'Gender')]/parent::button"));

			for (int i = 0; i < genderBtn.size(); i++) {
				if (genderBtn.get(i).isDisplayed()) {
					genderBtn.get(i).click();
					break;
				}
			}

			List<WebElement> gender = driver.findElements(
					By.xpath("//div[contains(text(),'Gender')]/parent::button/following-sibling::div/ul/li"));

			for (int i = 0; i < gender.size(); i++) {
				if (gender.get(i).getText().contains(getTestData("Gender"))) {
					gender.get(i).click();
					break;
				}
			}

			Thread.sleep(3000);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * This method is used to select country
	 * 
	 */
	public void selectCountry() {

		try {

			List<WebElement> selectCountry = driver.findElements(By
					.xpath("//label[contains(text(),'Nationality and date of birth')]/following-sibling::div//button"));

			L1: for (int i = 0; i < selectCountry.size(); i++) {
				if (selectCountry.get(i).isDisplayed()) {
					selectCountry.get(i).click();
					List<WebElement> countryTxt = driver
							.findElements(By.xpath("//li[contains(text(),'" + getTestData("Country") + "')]"));
					for (int k = 0; k < countryTxt.size(); k++) {
						if (countryTxt.get(i).isDisplayed()) {
							countryTxt.get(i).click();
							break;
						}
					}

				}
				break L1;
			}

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	/**
	 * 
	 * This method is used to select month
	 */
	
	public void selectDay(String day)
	{
		try
		{
			
		WebElement selectDay=driver.findElement(By.xpath("//label[contains(text(),'Nationality and date of birth')]/following-sibling::div/div[2][1]/select/option[@value='"+day+"']"));
		selectDay.click();
		Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * This method is used to select day
	 */
	
	public void selectMonth(String month)
	{
		try
		{
			
		WebElement selectMonth=driver.findElement(By.xpath("//label[contains(text(),'Nationality and date of birth')]/following-sibling::div/div[3][1]/select/option[@value='"+month+"']"));
		selectMonth.click();
		Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
	/**
	 * 
	 * This method is used to select year
	 */
	
	public void selectYear(String year)
	{
		try
		{
			
		WebElement selectYear=driver.findElement(By.xpath("//label[contains(text(),'Nationality and date of birth')]/following-sibling::div/div[4][1]/select/option[@value='"+year+"']"));
		selectYear.click();
		Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * This method is used to click on continue payment
	 */
	
	public void clickContinuePayment()
	{
		try
		{
			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueToPayment);
			 Thread.sleep(5000);
			 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

	/**
	 * 
	 * This method is used to check if payment header is displayed
	 */
	public boolean checkIfPaymentHeaderIsDisplayed()
	{
		try
		{
			if(driver.findElement(By.xpath("//h1[text()='Pay to complete your booking']")).isDisplayed())
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return false;
		
	}
}
