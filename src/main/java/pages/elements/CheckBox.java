package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class CheckBox extends BasePage {

    public CheckBox(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    private By checkBoxOption = By.id("item-1");
    private By checkBoxBox = By.cssSelector("label[for='tree-node-home'");
    private By checkBoxHolder = By.cssSelector("svg[class='rct-icon rct-icon-check']");
    

    public void checkBoxClick(){

        getDriver().findElement(checkBoxOption).click();
        getDriver().findElement(checkBoxBox).click();

    }

    public boolean checkBoxIsItSelectable(){
        WebElement checkBox = getDriver().findElement(checkBoxBox);
        return checkBox.isEnabled();
    }

    public String checkBoxIsItSelected() {
        String valueAttribute = getDriver().findElement(checkBoxHolder).getAttribute("class");
        return  valueAttribute;
    }


}
