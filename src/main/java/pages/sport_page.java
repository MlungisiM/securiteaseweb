package pages;

import common.base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import utilities.testlistener;
import java.time.Duration;

@Listeners(testlistener.class)
public class sport_page extends base {


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

    private WebDriverWait wait;


    public sport_page() {
        //this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
}
