package PageObjects;

import BaseTest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

public class LoginPage extends BaseTest {


    @FindBy(xpath = "//header/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")
    WebElement login_btn;
    @FindBy(xpath  = "//input[@id='signin_email']")
    WebElement email_txtbox;
    @FindBy(xpath = "//input[@id='signin_password']")
    WebElement pwd_txtbox;
    @FindBy(css = "#signin_submit")
    WebElement sign_btn;
    @FindBy(linkText = "My Zoopla")
    WebElement my_account;


  //Initialising page objects

    public LoginPage(){

        PageFactory.initElements(driver, this);


    }


  public MyAccountPage launchMyAccountPage(String uname, String pwd) throws InterruptedException {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.visibilityOf(login_btn)).click();
      email_txtbox.sendKeys(uname);
      pwd_txtbox.sendKeys(pwd);
        sign_btn.click();
        Thread.sleep(1000);
        return PageFactory.initElements(driver, MyAccountPage.class);

    }



}
