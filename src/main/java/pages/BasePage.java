package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Data
public abstract class BasePage {

    private WebDriver driver;
    private WebDriverWait driverWait;

    public BasePage(){}

    public BasePage(WebDriver driver, WebDriverWait driverWait) {
        this.driver = driver;
        this.driverWait = driverWait;
    }

    public void explicitWait(int seconds, By element){
        new WebDriverWait(getDriver(), Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOfElementLocated(element));
    }


}
