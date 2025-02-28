package tests;

import common.base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import teststeps.actionsClass;
import utilities.testlistener;
import java.util.concurrent.TimeUnit;

@Listeners(testlistener.class)
public class web_tests extends base {

    actionsClass _actions;

    @BeforeMethod
    public void launchbrowser() {
        startBrowser();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        _actions = new actionsClass();
    }

    @Test(description = "TC ID - ****: Table Validation", priority = 1)
    public void tableValidation() throws InterruptedException {
        _actions.validation_in_a_table_of_results();
    }

    @Test(description = "TC ID - ****: Search functionality", priority = 1)
    public void search() throws InterruptedException {
        _actions.navigate_to_the_search_functionality();
    }
    @AfterMethod
    public void close()
    {
        closeBrowser();
    }
}
