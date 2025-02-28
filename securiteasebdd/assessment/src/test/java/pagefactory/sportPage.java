package pagefactory;

import common.base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;


public class sportPage extends base {


	@FindBy(xpath = "//span[@class='ssrcss-1u47p8g-LinkTextContainer eis6szr1'][normalize-space()='Formula 1']")
	public WebElement formula1_link;

	@FindBy(css = ".ssrcss-qefkng-SearchText.eki2hvo12")
	public WebElement homepage_searchbar_textbox;

	@FindBy(id = "searchInput")
	public WebElement searchbar_textbox2;

	@FindBy(id = "searchButton")
	public WebElement search_button;

	@FindBy(css = "li.ssrcss-1y9ep4i-StyledMenuItem:nth-child(3) > a:nth-child(1) > span:nth-child(1)")
	public WebElement formula1_results_link;

	@FindBy(css = "li.ssrcss-1d9284p-ContentItem:nth-child(9) > div:nth-child(1) > a:nth-child(1)")
	public WebElement formula1_2023_results_link;

	@FindBy(css = ".ssrcss-14xrj8w-Stack > section:nth-child(2) > h2:nth-child(1) > button:nth-child(1) > div:nth-child(1) > span:nth-child(1)")
	public WebElement lv_grandprix_lv_streetcircuit_link;

	@FindBy(css = "#main-data > div > div > div > section:nth-child(1) > div > div > div.ssrcss-701wbd-Footer.e1ho0zmu2 > div.ssrcss-dp2wjz-LinksWrapper.e1ho0zmu1 > a > span")
	public WebElement full_race_results_link;

	WebDriverWait wait;

	WebDriver driver;
	
	public sportPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigate_to_search() throws InterruptedException {
		try {
			//Click the home page search bar
			homepage_searchbar_textbox.click();
		}
		catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
	}
	public void search_sport() throws InterruptedException {
		try {
			//Click the home page search bar
			homepage_searchbar_textbox.click();
			//enter search parameter in the textbox
			searchbar_textbox2.sendKeys(prop.getProperty("search-parameter"));
			//click the search button
			search_button.click();
		}
		catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}

	}

	public void validation_in_a_table_of_results() throws InterruptedException {
		try {
			formula1_link.click();
			formula1_results_link.click();
			wait.until(ExpectedConditions.elementToBeClickable(formula1_2023_results_link));
			formula1_2023_results_link.click();
			lv_grandprix_lv_streetcircuit_link.click();

			WebElement element = driver.findElement(By.cssSelector("#main-data > div > div > div > section:nth-child(1) > div > div > div:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > div > div > span.ssrcss-1hf3wfc-FullName.e1dzfgvv0"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(500);

			List<WebElement> raceResults = driver.findElements(By.xpath("//*[@id=\"main-data\"]/div/div/div/section[1]/div/div/div[1]/table/tbody"));

			// Print size for debugging
			System.out.println("Number of race results found: " + raceResults.size());

			// Ensure at least 3 results exist before proceeding
			Assert.assertTrue(raceResults.size() < 3, "Not enough race results found");

			// Extract only driver names for comparison
			String firstPlace = raceResults.get(0).getText().trim();
			String secondPlace = raceResults.get(1).getText().trim();
			String thirdPlace = raceResults.get(2).getText().trim();

			// Validate top 3 race results
			Assert.assertEquals(firstPlace, "Max Verstappen", "1st place incorrect");
			Assert.assertEquals(secondPlace, "George Russell", "2nd place incorrect");
			Assert.assertEquals(thirdPlace, "Sergio Perez", "3rd place incorrect");

		}
		catch (Exception e)
		{
			e.printStackTrace();
			e.getMessage();
		}
	}

}
