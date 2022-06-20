package pages.elements;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

@Data
public class RadioButton extends BasePage {


    private By radioButtonOption = By.id("item-2");
    private By radioButtonYes = By.cssSelector("label[for='yesRadio']");
    private By radioButtonImpressive = By.cssSelector("label[for='impressiveRadio']");
    private By radioButtonNo = By.id("noRadio");
    private By radioButtonConfMessage = By.cssSelector("span[class='text-success']");


    public RadioButton(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


    public void radioButtonOptionClick(){
        getDriver().findElement(radioButtonOption).click();
    }

    //TC-radio_button-03
    public void radioButtonClickYes(){
        getDriver().findElement(radioButtonYes).click();
    }

    public boolean yesBtnSelected(){
        return getDriver().findElement(radioButtonYes).isSelected();
    }

    //TC-radio_button-04
    public void radioButtonClickImpressive(){
        getDriver().findElement(radioButtonImpressive).click();
    }

    public boolean impressiveBtnSelected(){
        return getDriver().findElement(radioButtonImpressive).isSelected();
    }

    //TC-radio_button-05
    public boolean noBtnSelectable(){
        return getDriver().findElement(radioButtonNo).isEnabled();
    }


    public String radioBtnConfMessageClassValue(){
        String message = getDriver().findElement(radioButtonConfMessage).getAttribute("class");
        return message;
    }

    public String radioBtnConfMessageVisibleText(){
        String message = getDriver().findElement(radioButtonConfMessage).getText();
        return message;
    }
}
