package Tests;

import BaseTest.BaseTest;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import PageObjects.SearchListPage;
import Sync_Utils.Util_Constants;
import org.testng.annotations.*;

import java.io.FileNotFoundException;

public class Test_Pages extends BaseTest {
    Util_Constants util;
    HomePage home;
    LoginPage login;
    MyAccountPage accpage;
    SearchListPage search;

    public Test_Pages() {

        super();

    }


    @BeforeTest

    public void setup() throws FileNotFoundException, InterruptedException {
   test = reports.startTest("Testing Zoopla Login Functionality and Price Search");
        initialization();
        util = new Util_Constants();
        home = new HomePage();
        reportInfo("Launching the Zoopla Application ");
        home.clearCookies();
        login = new LoginPage();
        accpage = new MyAccountPage();
        search = new SearchListPage();


    }

    @Test(priority = 1)
    public void testCase1() throws InterruptedException {

          reportInfo(" Logging into Account");
        login.launchMyAccountPage(prop.getProperty("uname"), prop.getProperty("pwd"));
          reportInfo("Searching Properties in London");
        accpage.searchPage();
         reportInfo("Getting the Price list and choosing the property ");
         reportInfo("Able to see the agent contacts related to the chosen Property");
         reportPass("Test check -  Passed and Application Closed");
         search.seeAgentDetails();



    }


        @AfterTest
        public void tearDown () {
            reports.endTest(test);
            reports.flush();
        driver.quit();
        }

    }


