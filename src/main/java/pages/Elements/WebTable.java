package pages.Elements;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

@Data
public class WebTable extends BasePage {

        public WebTable(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    private By webTableOption = By.id("item-3");
    private By webTableAddButton = By.id("addNewRecordButton");
    private By webTableFirstName = By.id("firstName");
    private By webTableLastName = By.id("lastName");
    private By webTableEmail = By.id("userEmail");
    private By webTableAge = By.id("age");
    private By webTableSalary = By.id("salary");
    private By webTableDepartment = By.id("department");
    private By webTableSubmit = By.id("submit");

    public WebElement getWebTableFirstName(){
        return getDriver().findElement(webTableFirstName);
    }
    public WebElement getWebTableLastName(){
        return getDriver().findElement(webTableLastName);
    }
    public WebElement getWebTableEmail(){
        return getDriver().findElement(webTableEmail);
    }
    public WebElement getWebTableAge(){
        return getDriver().findElement(webTableAge);
    }
    public WebElement getWebTableSalary(){
        return  getDriver().findElement(webTableSalary);
    }
    public WebElement getWebTableDepartment(){
        return getDriver().findElement(webTableDepartment);
    }

    public void webTablePopulateForm(String name, String lastName, String email, String age, String salary, String department){
        getWebTableFirstName().sendKeys(name);
        getWebTableLastName().sendKeys(lastName);
        getWebTableEmail().sendKeys(email);
        getWebTableAge().sendKeys(age);
        getWebTableSalary().sendKeys(salary);
        getWebTableDepartment().sendKeys(department);
        webTableFormSubmit();
    }

    public void webTableClearForm(String name, String age){
        getWebTableFirstName().clear();
        getWebTableFirstName().sendKeys(name);
        getWebTableAge().clear();
        getWebTableAge().sendKeys(age);
        webTableFormSubmit();
    }

    public void webTableClick(){
        getDriver().findElement(webTableOption).click();
    }

    public void webTableAddEntry(){
        getDriver().findElement(webTableAddButton).click();

    }
    public void webTableFormSubmit(){
        getDriver().findElement(webTableSubmit).click();
    }

    private By webTablesSearch = By.id("searchBox");
    private By firstNameRow = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div/div[1]");
    private By lastNameRow = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div/div[2]");
    private By ageRow = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div/div[3]");
    private By salaryRow = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div/div[5]");
    private By departmentRow = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div/div[6]");

    private By editEntryIcon = By.id("edit-record-4");


    public void webTablesSearchEntry(String email){
        getDriver().findElement(webTablesSearch).sendKeys(email);
    }

    public WebElement webTableSearchResultName(){
        explicitWait(5,firstNameRow);
        return getDriver().findElement(firstNameRow);
    }

    public WebElement webTableSearchResultSurname(){
        return getDriver().findElement(lastNameRow);
    }

    public WebElement webTableSearchResultAge(){
        return getDriver().findElement(ageRow);
    }

    public WebElement webTableSearchResultSalary(){
        return getDriver().findElement(salaryRow);
    }

    public WebElement webTableSearchResultDepartment(){
        return getDriver().findElement(departmentRow);
    }
    public void webTableEditEntry(){
        getDriver().findElement(editEntryIcon).click();
    }


    public void createAndFindEntry(){
       webTableAddEntry();
       webTablePopulateForm("John", "Doe", "john.doe@gmail.com", "30", "10000", "IT");
       webTablesSearchEntry("john.doe@gmail.com");
    }


}
