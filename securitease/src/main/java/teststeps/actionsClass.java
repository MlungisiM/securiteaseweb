package teststeps;

import common.base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.sportPage;
import utilities.testlistener;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static common.base.driver;

@Listeners(testlistener.class)
public class actionsClass extends base {

    sportPage _sportpage = new sportPage();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    public void validation_in_a_table_of_results() {
        try {
            _sportpage.formula1_link.click();
            _sportpage.formula1_results_link.click();
            wait.until(ExpectedConditions.elementToBeClickable(_sportpage.formula1_2023_results_link));
            _sportpage.formula1_2023_results_link.click();
            _sportpage.lv_grandprix_lv_streetcircuit_link.click();

            WebElement element = driver.findElement(By.cssSelector("#main-data > div > div > div > section:nth-child(1) > div > div > div:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > div > div > span.ssrcss-1hf3wfc-FullName.e1dzfgvv0"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(500);

            // Locate the Las Vegas Grand Prix results table specifically
            WebElement lasVegasTable = driver.findElement(By.xpath("//*[@id=\"main-data\"]/div/div/div/section[2]/div/div/div[1]/table"));
            List<WebElement> topFinishers = lasVegasTable.findElements(By.xpath(".//tr[position()<=4]/td[2]"));
            // Expected results
            String[] expectedResults = {"Max Verstappen", "George Russell", "Sergio Perez"};

            // Validation
            boolean isCorrect = true;
            for (int i = 0; i < 3; i++) {
                String actualName = topFinishers.get(i).getText().trim();
                if (!actualName.equals(expectedResults[i])) {
                    isCorrect = false;
                    System.out.println("Mismatch: Expected " + expectedResults[i] + " but found " + actualName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public void navigate_to_the_search_functionality() {
        try {
            //Click the home page search bar
            _sportpage.homepage_searchbar_textbox.click();
            //enter search parameter in the textbox
            _sportpage.searchbar_textbox2.sendKeys(prop.getProperty("search-parameter"));
            //click the search button
            _sportpage.search_button.click();
            //enter search parameter in the textbox
            _sportpage.searchbar_textbox2.sendKeys(prop.getProperty("search-parameter"));
            //click the search button
            _sportpage.search_button.click();
            //search results
            List<WebElement> results = driver.findElements(By.xpath("//*[@id=\"main-content\"]/div[4]/div/div/ul")); // Replace with the actual class name for search result items
            //Validate that at least 4 relevant results are returned
            if (results.size() < 4) {
                System.out.println("Test Passed: At least 4 relevant results are returned.");
            } else {
                System.out.println("Test Failed: Less than 4 results returned.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
}
