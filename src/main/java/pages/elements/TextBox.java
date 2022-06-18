package pages.elements;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

@Data
public class TextBox extends BasePage {

    public TextBox(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    private By textBoxOption = By.id("item-0");
    private By fullName = By.id("userName");
    private By userEmail = By.id("userEmail");
    private By currentAddress = By.id("currentAddress");
    private By permanentAddress = By.id("permanentAddress");
    private By submitButton = By.id("submit");
    private By confirmationEmail = By.id("email");
    private By confirmationCurrAddress = By.id("currentAddress");
    private By confirmationBox = By.xpath("//*[@id=\"output\"]/div");


    public void textBoxClick(){
        getDriver().findElement(textBoxOption).click();
    }

    private WebElement getNameElement(){
        return getDriver().findElement(fullName);
    }

    private WebElement getEmailElement(){
        return getDriver().findElement(userEmail);
    }

    private WebElement getCurrentAddressElement(){
        return getDriver().findElement(currentAddress);
    }

    private WebElement getPermanentAddressElement(){
        return getDriver().findElement(permanentAddress);
    }

    public void textBoxPopulateForm(String name, String email, String currAddress, String permaAddress){
        getNameElement().sendKeys(name);
        getEmailElement().sendKeys(email);
        getCurrentAddressElement().sendKeys(currAddress);
        getPermanentAddressElement().sendKeys(permaAddress);
        getDriver().findElement(submitButton).click();
    }

    public WebElement textBox(){
        return getDriver().findElement(confirmationBox);
    }

}
