package pages.Widgets;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

@Data
public class Slider extends BasePage{
    public Slider(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    private By sliderOption = By.xpath("//*[text()='Slider']");
    private By slider = By.xpath("//*[@id=\"sliderContainer\"]/div[1]/span/input");
    private By confirmationNumber = By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/form/div/div[2]/input");

    public WebElement sliderSlide(){
        return getDriver().findElement(slider);
    }


    public void clickSliderOption(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("window.scrollBy(0,500)");
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(sliderOption));
        getDriver().findElement(sliderOption).click();
    }


    public void moveSlider(){
        int x=20;
        int width = sliderSlide().getSize().getWidth();
        Actions act= new Actions(getDriver());
        act.moveToElement(sliderSlide(), ((width*x)/100), 0).click();
        act.build().perform();
    }

    public String confirmation(){
        String currentValue = getDriver().findElement(confirmationNumber).getAttribute("value");
        return currentValue;
    }

}
