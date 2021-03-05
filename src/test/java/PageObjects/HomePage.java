package PageObjects;

import BaseTest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends BaseTest {

    @FindBy(xpath = "//body/div[@id='ui-cookie-consent-overlay-wrap']/div[2]/form[1]/div[1]/div[1]/div[1]/button[2]")
    WebElement cookie_ele;


   public HomePage() {
       PageFactory.initElements(driver, this );
   }

   public LoginPage clearCookies(){

         cookie_ele.click();

   return PageFactory.initElements(driver,LoginPage.class);
    }



}
