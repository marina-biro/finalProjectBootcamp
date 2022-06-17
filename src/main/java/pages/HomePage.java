package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

@Data
public class HomePage extends BasePage{

    private By elementsOption = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]");
    private By alertsFrameAndWindowsOption = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[3]");
    private By widgets = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[4]");

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickElementsOption(){
         WebElement element = getDriver().findElement(elementsOption);
         element.click();
    }

    public void clickAlertsFrameAndWindowsOption(){
        WebElement alertsFrameAndWindows = getDriver().findElement(alertsFrameAndWindowsOption);
        alertsFrameAndWindows.click();
    }

    public void clickWidgetsOption(){
        WebElement widgetss = getDriver().findElement(widgets);
        widgetss.click();
    }



}
