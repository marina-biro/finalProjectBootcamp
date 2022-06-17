package tests;

import lombok.Data;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Data
public class AlertsFrameAndWindowsTests extends BaseTest{
    public AlertsFrameAndWindowsTests() {
    }

    @BeforeMethod
    public void openAlertsFrameAndWindowsOption(){
        getHomePage().clickAlertsFrameAndWindowsOption();
    }

    @Test (priority = 1)
    public void alerts(){
       getAlertsOption().alertsOptionClick();
       getAlertsOption().clickOkAlert();
       getAlertsOption().clickConfirmAlert();
       getAlertsOption().clickPrompt();
       Assert.assertEquals(this.getAlertsOption().confBoxMessage().getText(), "You selected Ok");
       Assert.assertEquals(this.getAlertsOption().confNameMessage().getText(),"You entered Marina");

    }

    @Test (priority = 2)
    public void alertFiveSeconds(){
        getAlertsOption().alertsOptionClick();
        getAlertsOption().clickFiveSeconds();
        //Assert: if it is clicked. No change in the HTML code.
    }




}
