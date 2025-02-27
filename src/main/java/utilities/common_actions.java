package utilities;

import common.base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


public class common_actions extends base {


    WebDriverWait wait;


    //generate the current date and time
    public String generateDateTimeString() {
        Date dateNow = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
        return dateFormat.format(dateNow).toString();
    }

    //Load web_config.properties file
    public common_actions() {

        prop = new Properties();

        try {
            FileInputStream propFile = new FileInputStream(System.getProperty("user.dir") +
                    "/src/main/resources/web_config.properties");
            prop.load(propFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties getProp() {
        return prop;
    }


    //takes screenshot and saves the screenshot in the reports folder
    public void takeScreenshot(String screenshotName) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("./reports/" + screenshotName + ".png"));
            log.info("Screenshot taken");
        } catch (IOException e) {
            e.printStackTrace();
            log.info("Could not take the screenshot");
        }
    }
}
