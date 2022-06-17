package pages.Elements;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

@Data
public class RadioButton extends BasePage {


    private By radioButtonOption = By.id("item-2");
    private By radioButtonYes = By.cssSelector("label[class='custom-control-label']");
    private By radioButtonConfMessage = By.cssSelector("span[class='text-success']");

    public RadioButton(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


    public void radioButtonClick(){
        getDriver().findElement(radioButtonOption).click();
    }

    public void radioButtonClickYes(){
        getDriver().findElement(radioButtonYes).click();
    }

    public String radioButtonConfirmation(){
        String message = getDriver().findElement(radioButtonConfMessage).getAttribute("class");
        return message;
    }

    public String radioButtonConfirmationNo2(){
        String message = getDriver().findElement(radioButtonConfMessage).getText();
        return message;
    }



}
