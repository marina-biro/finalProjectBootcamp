package pages.Elements;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

@Data
public class Buttons extends BasePage {
    public Buttons(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    Actions act = new Actions(getDriver());

    private By buttonsOption = By.id("item-4");

    private By doubleClickButton = By.id("doubleClickBtn");
    private By rightClickButton = By.id("rightClickBtn");
    private By clickOnceButton = By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/button");

    private By doubleClickConfirmation = By.id("doubleClickMessage");
    private By rightClickConfirmation = By.id("rightClickMessage");
    private By oneClickConformation = By.id("dynamicClickMessage");

    public WebElement doubleClickConf(){
        return getDriver().findElement(doubleClickConfirmation);
    }

    public WebElement rightClickConf(){
        return getDriver().findElement(rightClickConfirmation);
    }

    public WebElement leftClickConf(){
        return getDriver().findElement(oneClickConformation);
    }

    public void buttonsClick(){
        getDriver().findElement(buttonsOption).click();
    }


    public void clickTwoTimesLeft(){
        WebElement doubleLeftButton = getDriver().findElement(doubleClickButton);
        act.doubleClick(doubleLeftButton).perform();
    }

    public void  clickOnceLeft(){
        getDriver().findElement(clickOnceButton).click();
    }

    public void clickOnceRight(){
        WebElement rightClick = getDriver().findElement(rightClickButton);
        act.contextClick(rightClick).perform();
    }

}
