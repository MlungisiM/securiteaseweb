package StepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import common.base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagefactory.sportPage;

public class actionsClass extends base {

	WebDriver driver = null;
	sportPage sportPage;
	WebDriverWait wait;


	@BeforeMethod
	public void launchbrowser() {
		startBrowser();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		sportPage = new sportPage(driver);
	}

	@Given("I navigate to the search functionality")
	public void i_navigate_to_the_search_functionality() throws Exception {
		sportPage.navigate_to_search();
		sportPage.search_sport();
	}

	@When("I search for Sport in {int}")
	public void i_search_for_Sport_in(Integer int1) throws Exception {

		throw new io.cucumber.java.PendingException();
	}
	@Then("I want four or more articles, reports, and media to display")
	public void i_want_four_or_more_articles_reports_and_media_to_display() {
		//Wait for search results to load
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main-content\"]/div[4]/div/div/ul"))); // Replace with the actual result container class
		//Retrieve search results
		List<WebElement> results = driver.findElements(By.xpath("//*[@id=\"main-content\"]/div[4]/div/div/ul")); // Replace with the actual class name for search result items
		//Validate that at least 4 relevant results are returned
		if (results.size() < 4) {
			System.out.println("Test Passed: At least 4 relevant results are returned.");
		} else {
			System.out.println("Test Failed: Less than 4 results returned.");
		}
		throw new io.cucumber.java.PendingException();
	}

		@AfterMethod
		public void close()
		{
		closeBrowser();
		}
}
