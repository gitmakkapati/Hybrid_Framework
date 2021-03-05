package BaseTest;

import ReportManager.ReportManager;
import Sync_Utils.Util_Constants;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

        public  static WebDriver driver;
        public  static Properties prop;
      public  ExtentReports reports =  ReportManager.getInstance();
        public  ExtentTest test;
     //constructor for initializing the property file
        public BaseTest() {

            String path = System.getProperty("user.dir") + "/src/test/resources/config.properties";
            prop = new Properties();
            /** Stream to read the spreadsheet. */
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(path);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                prop.load(fis);

            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        //method to launch the browser from the property file

        public  static void initialization() throws InterruptedException, FileNotFoundException {

            String browserName = prop.getProperty("browser");
            if (browserName.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            driver.manage().window().maximize();
            String url = prop.getProperty("url");
            driver.get(url);
            driver.manage().timeouts().pageLoadTimeout(Util_Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);


        }


    public static boolean scroll_to_WebE(WebElement webe) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webe);
            return true;
        } catch (Exception e) {
             e.printStackTrace();
            return false;
        }
    }





    public void takeFullScreenShot() {

        Date d = new Date();

        String filename = d.toString().replace("", "_").replace(":", "_") + ".png";
        String screenshotPath = SystemUtils.getUserDir() + " /target/screenshot/" + filename;

        //take screenshot image
        Screenshot screenshot =
                new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);

        //write to location
        try {
            ImageIO.write(screenshot.getImage(), "PNG", new File(screenshotPath));
            test.log(LogStatus.INFO, "Snapshot below:" + test.addScreenCapture(screenshotPath));
            test.log(LogStatus.PASS, "Snapshot below:" + test.addScreenCapture(screenshotPath));
            test.log(LogStatus.FAIL, "Snapshot below:" + test.addScreenCapture(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


   // reporting methods

    public void reportInfo(String infoMessage)
    {
        test.log(LogStatus.INFO, infoMessage);
        takeFullScreenShot();
    }

    public void reportPass (String passMessage){
        test.log(LogStatus.PASS, "pass Message");
        takeFullScreenShot();
    }
    public void reportFail(String failMessage)
    {
        test.log(LogStatus.FAIL, "failed Message");
        takeFullScreenShot();

    }





}









