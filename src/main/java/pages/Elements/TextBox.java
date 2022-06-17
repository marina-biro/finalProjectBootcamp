package pages.Elements;

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


    public void textBoxClick(){
        getDriver().findElement(textBoxOption).click();
    }

    public void textBoxPopulateForm(){
        getDriver().findElement(fullName).sendKeys("Marina Biro");
        getDriver().findElement(userEmail).sendKeys("marina.nina.biro@gmail.com");
        getDriver().findElement(currentAddress).sendKeys("Street 3");
        getDriver().findElement(permanentAddress).sendKeys("Street 5");
        getDriver().findElement(submitButton).click();
    }

    public WebElement textBoxGetConfirmationEmail(){
        return getDriver().findElement(confirmationEmail);
    }
    // check later
    public WebElement textBoxGetCurrAddress(){
        return getDriver().findElement(confirmationCurrAddress);
    }


}
