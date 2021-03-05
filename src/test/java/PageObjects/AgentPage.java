package PageObjects;

import BaseTest.BaseTest;
import org.openqa.selenium.support.PageFactory;

public class AgentPage extends BaseTest {

    public AgentPage(){

        PageFactory.initElements(driver,this);
    }
}
