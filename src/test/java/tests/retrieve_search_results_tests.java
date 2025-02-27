package tests;

import common.base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import teststeps.retrieve_search_results_actions;
import utilities.testlistener;
import java.util.concurrent.TimeUnit;

@Listeners(testlistener.class)
public class retrieve_search_results_tests extends base {

    retrieve_search_results_actions _retrieve_search_results_actions;

    @BeforeMethod
    public void launchbrowser() {
        startBrowser();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        _retrieve_search_results_actions = new retrieve_search_results_actions();
    }

    @Test(description = "Test Case 1 - Validation in a table of results", priority = 2)
    public void ValidationInATableOfResultsTest() throws InterruptedException {
        _retrieve_search_results_actions.validation_in_a_table_of_results();
    }

    @Test(description = "Test Case 2 - Retrieve Search results", priority = 2)
    public void RetrieveSearchResultsTest() throws InterruptedException {
        _retrieve_search_results_actions.retrieve_search_results();
    }

    @AfterMethod
    public void close()
    {
        closeBrowser();
    }
}
