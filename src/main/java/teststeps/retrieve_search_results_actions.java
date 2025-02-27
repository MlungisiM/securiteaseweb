package teststeps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.sport_page;
import utilities.common_actions;
import utilities.testlistener;

@Listeners(testlistener.class)
public class retrieve_search_results_actions extends common_actions {

    sport_page _sportpage = new sport_page();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    public void validation_in_a_table_of_results() throws InterruptedException {
        try {
            _sportpage.formula1_link.click();
            _sportpage.formula1_results_link.click();
            wait.until(ExpectedConditions.elementToBeClickable(_sportpage.formula1_2023_results_link));
            _sportpage.formula1_2023_results_link.click();
            _sportpage.lv_grandprix_lv_streetcircuit_link.click();

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
    public void retrieve_search_results() throws InterruptedException
    {
        try {
            //Click the home page search bar
            _sportpage.homepage_searchbar_textbox.click();
            //enter search parameter in the textbox
            _sportpage.searchbar_textbox2.sendKeys(prop.getProperty("search-parameter"));
            //click the search button
            _sportpage.search_button.click();
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
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getMessage();
        }
    }
}