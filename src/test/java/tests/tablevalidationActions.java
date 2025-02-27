package tests;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.sport_page;
import utilities.common_actions;
import utilities.testlistener;

@Listeners(testlistener.class)
public class tablevalidationActions extends common_actions {

    sport_page _sportpage = new sport_page();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    @BeforeMethod
    public void launchbrowser() {
        startBrowser();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //_retrieve_search_results_actions = new tablevalidationActions();
    }


   @Given("^I navigate to the BBC Formula 1 results page$")
   public void i_navigate_to_bbc_f1_results_page() throws InterruptedException {

            _sportpage.formula1_link.click();
            _sportpage.formula1_results_link.click();
            wait.until(ExpectedConditions.elementToBeClickable(_sportpage.formula1_2023_results_link));
            _sportpage.formula1_2023_results_link.click();
            _sportpage.lv_grandprix_lv_streetcircuit_link.click();

            WebElement element = driver.findElement(By.cssSelector("#main-data > div > div > div > section:nth-child(1) > div > div > div:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > div > div > span.ssrcss-1hf3wfc-FullName.e1dzfgvv0"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(500);
        }
        @When("^I extract the top three race winners$")
       public void i_extract_top_three_race_winners() throws InterruptedException {

            // Locate the Las Vegas Grand Prix results table specifically
            WebElement lasVegasTable = driver.findElement(By.xpath("//*[@id=\"main-data\"]/div/div/div/section[2]/div/div/div[1]/table"));
            List<WebElement> topFinishers = lasVegasTable.findElements(By.xpath(".//tr[position()<=4]/td[2]"));
        }


       @Then("the race winners should be Max Verstappen, George Russell, and Sergio Perez")
       public void validate_race_winners() {

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

               if (isCorrect) {
                   System.out.println("Race results are correctly reported!");
               } else {
                   System.out.println("Race results validation failed!");
               }
           }


       }

           @AfterMethod
           public void close()
           {
               closeBrowser();
           }
       }
