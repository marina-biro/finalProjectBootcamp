package pages.alertsframeandwindows;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class AlertsOption extends BasePage {

    public AlertsOption(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    private By alertsOption = By.xpath("//*[text()='Alerts']");
    private By alert = By.id("alertButton");
    private By alertFiveSeconds = By.id("timerAlertButton");
    private By confirmAlert = By.id("confirmButton");
    private By prompt = By.id("promtButton");

    private By confirmBoxMessage = By.id("confirmResult");
    private By confirmNameMessage = By.id("promptResult");


    public WebElement confBoxMessage (){
        return getDriver().findElement(confirmBoxMessage);
    }
    public WebElement confNameMessage(){
        return getDriver().findElement(confirmNameMessage);
    }


    public void alertsOptionClick(){
        WebElement alertsOptionC = getDriver().findElement(alertsOption);
        alertsOptionC.click();
    }

    //TC-alerts-12
    public void clickOkAlert(){
        getDriver().findElement(alert).click();
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }

    public void clickConfirmAlert(){
        getDriver().findElement(confirmAlert).click();
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }

    public void clickPrompt(){
        getDriver().findElement(prompt).click();
        Alert alert = getDriver().switchTo().alert();
        alert.sendKeys("Marina");
        alert.accept();
    }

    //TC-alerts-13
    public void clickFiveSeconds(){
        getDriver().findElement(alertFiveSeconds).click();
        getDriverWait().until(ExpectedConditions.alertIsPresent());
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }

}
