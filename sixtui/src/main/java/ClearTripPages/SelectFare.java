package ClearTripPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectFare extends CommonMethods {
	private WebDriver driver;
	private CommonMethods cm = new CommonMethods();

	@FindBy(xpath = "//button[text()='Continue']")
	private WebElement continueBtn;

	@FindBy(xpath = "//h3[contains(text(),'Standard fare')]")
	private WebElement radioBtnStandardFare;

	@FindBy(xpath = "//h2[contains(text(),'Review')]")
	private WebElement reviewYourFareTitle;

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public SelectFare(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to check if select fare page is loaded
	 */

	public boolean checkIfSelectFarePageIsLoaded() {

		try {
			cm.explicitwait(driver, continueBtn);

			cm.switchWindow(driver);
			if (reviewYourFareTitle.isDisplayed())
				return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
/**
 * This method is used to select fare
 */
	public void selectFare() {
		try {
			continueBtn.click();
			Thread.sleep(2000);
			List<WebElement> selectList = driver.findElements(By.xpath("//button[text()='Select'][1]"));
			for (int i = 0; i < selectList.size(); i++) {

				{
					selectList.get(i).click();
					break;

				}
			}
			Thread.sleep(8000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
