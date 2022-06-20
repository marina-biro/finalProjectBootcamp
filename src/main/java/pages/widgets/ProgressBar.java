package pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class ProgressBar extends BasePage {
    public ProgressBar(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    private By progressBarOption = By.xpath("//*[text()='Progress Bar']");
    private By startButton = By.id("startStopButton");
    private By progress = By.cssSelector("div[role='progressbar']");

 //   public WebElement progresss(){
//        return getDriver().findElement(progress);
//    }

    //TC-progress_bars-11
    public void clickProgressBar() throws InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("window.scrollBy(0,500)");
        getDriver().findElement(progressBarOption).click();
        jsExecutor.executeScript("window.scrollBy(0,-500)");
        getDriver().findElement(startButton).click();
        Thread.sleep(10500);
        // the following code sometimes works, most of the time the website doesn't load quickly enough
//       getDriverWait().until(ExpectedConditions.attributeContains(progresss(), "aria-valuenow","40"));
//       getDriverWait().until(ExpectedConditions.textToBePresentInElement(progresss(),"80%"));  // sometimes works, sometimes timeout
//       getDriver().findElement(startButton).click();

    }

    public String value(){
       String valueNow = getDriver().findElement(progress).getAttribute("aria-valuenow");
        return valueNow;
    }

}
