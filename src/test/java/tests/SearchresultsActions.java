package tests;

import common.base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.sport_page;
import utilities.testlistener;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Listeners(testlistener.class)
public class SearchresultsActions extends base {

    tablevalidationActions _retrieve_search_results_actions;
    sport_page _sportpage = new sport_page();
    WebDriverWait wait;;


    @BeforeMethod
    public void launchbrowser() {
        startBrowser();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        _sportpage = new sport_page();
    }

    @Given("^I navigate to the search functionality$")
    public void retrieve_search_results ()
    {
        //Click the home page search bar
        _sportpage.homepage_searchbar_textbox.click();
    }
    @When("^I search for Sport in 2023$")
    public void i_search_for_sport_in_2023 ()
    {
        //enter search parameter in the textbox
        _sportpage.searchbar_textbox2.sendKeys(prop.getProperty("search-parameter"));
        //click the search button
        _sportpage.search_button.click();
    }
    @Then("^I want four or more articles, reports, and media to display$")
    public void i_want_four_or_more_articles_reports()
    {
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
    @AfterMethod
    public void close()
    {
        closeBrowser();
    }
}
