package PageObjects;

import BaseTest.BaseTest;
import Sync_Utils.Util_Constants;
import org.apache.poi.xslf.model.ParagraphPropertyFetcher;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class MyAccountPage extends BaseTest {

    @FindBy(xpath = "//input[@id='search-input-location']")
    WebElement search_ele;
    @FindBy(xpath = "//select[@id='forsale_price_max']")
    WebElement maxprice_ele;
    @FindBy(xpath = "//span[contains(text(),'Advanced search options')]")
    WebElement adv_search_link;
    @FindBy(className = "search-checkboxes")
    WebElement checkbox_ele;
    @FindBy(id = "search-submit")
    WebElement search_btn_ele;


    public MyAccountPage() {

        PageFactory.initElements(driver, this);
    }


   public  SearchListPage searchPage() throws InterruptedException {
       search_ele.sendKeys("london");
       Thread.sleep(1000);
       //wait.until(ExpectedConditions.visibilityOf(search_ele)).sendKeys("london");
       search_ele.click();
       Select price = new Select(maxprice_ele);
       price.selectByIndex(9);
       maxprice_ele.click();
       WebDriverWait wait = new WebDriverWait(driver, 30);
       wait.until(ExpectedConditions.visibilityOf(adv_search_link)).click();
       Thread.sleep(3000);
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)");
       WebElement homes_ele = driver.findElement(By.xpath("//label[contains(text(),'Retirement homes')]"));
       homes_ele.click();
       WebElement shared_ele = driver.findElement(By.xpath("//label[contains(text(),'Shared ownership')]"));
       shared_ele.click();
       WebElement auction_ele = driver.findElement(By.xpath("//label[contains(text(),'Auctions')]"));
       auction_ele.click();
       wait.until(ExpectedConditions.visibilityOf(search_btn_ele)).click();
       driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

       return  PageFactory.initElements(driver,  SearchListPage.class);

   }


}
