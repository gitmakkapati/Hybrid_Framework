package PageObjects;

import BaseTest.BaseTest;
import Sync_Utils.Util_Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchListPage extends BaseTest {


    @FindBy(xpath = "//div[@class='css-1e28vvi-PriceContainer e2uk8e8']")
    WebElement price_container_ele;
    @FindBy(css = "div.css-1wn73pq-SearchResultsWrapper.es0c9wm13:nth-child(6) div.css-aoaxu8-InnerWrapper.es0c9wm12 main.css-1ndyouf-Main.eqgqnb30 div.css-8jz4jb-SearchResultsLayoutGroup.es0c9wm6 div.css-kdnpqc-ListingsContainer.earci3d2 div.earci3d1.css-tk5q7b-Wrapper-ListingCard-StyledListingCard.e2uk8e10 div.css-hbmpg0-StyledWrapper.e2uk8e27 div.css-wfndrn-StyledContent.e2uk8e18 div.css-qmlb99-CardHeader.e2uk8e9 > div.css-1e28vvi-PriceContainer.e2uk8e8")
    //@FindBy(xpath = "css-9sl42s-AgentDetailsContainer e11937k12")
    WebElement img_ele;



    public SearchListPage() {

        PageFactory.initElements(driver, this);
    }


      public AgentPage seeAgentDetails() {


        List<WebElement> plist = driver.findElements(By.cssSelector("div.css-1wn73pq-SearchResultsWrapper.es0c9wm13:nth-child(6) div.css-aoaxu8-InnerWrapper.es0c9wm12 main.css-1ndyouf-Main.eqgqnb30 div.css-8jz4jb-SearchResultsLayoutGroup.es0c9wm6 div.css-kdnpqc-ListingsContainer.earci3d2 div.earci3d1.css-tk5q7b-Wrapper-ListingCard-StyledListingCard.e2uk8e10 div.css-hbmpg0-StyledWrapper.e2uk8e27 div.css-wfndrn-StyledContent.e2uk8e18 div.css-qmlb99-CardHeader.e2uk8e9 > div.css-1e28vvi-PriceContainer.e2uk8e8"));
          for (WebElement list : plist) {
              System.out.println(list.getText());

              scroll_to_WebE(img_ele);
              img_ele.click();



          }

          return PageFactory.initElements(driver, AgentPage.class);
      }


    }






