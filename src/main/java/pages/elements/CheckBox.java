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
    private By checkBoxBox = By.cssSelector("label[for='tree-node-home']");
    private By classOfAllSelected = By.cssSelector("svg[class='rct-icon rct-icon-check']"); // class of all selected buttons
    private By expandAll = By.cssSelector("button[aria-label='Expand all']");
    private By youHaveSelectedMsg = By.xpath("//*[@id=\"result\"]");


    public void checkBoxClick(){
        getDriver().findElement(checkBoxOption).click();
        getDriver().findElement(checkBoxBox).click();
    }

    public String checkBoxIsItSelected() {
        getDriver().findElement(expandAll).click();
        String valueAttribute = getDriver().findElement(classOfAllSelected).getAttribute("class");
        return  valueAttribute;
    }

    public String confMsg(){
        String message = getDriver().findElement(youHaveSelectedMsg).getText();
        return message;
    }


}
