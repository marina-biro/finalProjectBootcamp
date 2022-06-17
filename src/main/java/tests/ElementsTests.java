package tests;

import lombok.Data;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
@Data
public class ElementsTests extends BaseTest {
    public ElementsTests(){

    }

    @BeforeMethod
    public void openElements(){
        getHomePage().clickElementsOption();
    }


    @Test (priority = 1) //TC-text_box-01
    public void populatingAndSubmittingAForm(){
        this.getTextBox().textBoxClick();
        this.getTextBox().textBoxPopulateForm();
        //Assert.assertEquals(this.menuPage.textBoxGetCurrAddress().getText(), "Current Address :Street 3"); // some problem with the assertation
        Assert.assertEquals(this.getTextBox().textBoxGetConfirmationEmail().getText(),"Email:marina.nina.biro@gmail.com");
    }

    @Test (priority = 2) //TC-check_box-02
    public void checkingAndUncheckingTheCheckBox(){
        this.getCheckBox().checkBoxClick();
        Assert.assertTrue(this.getCheckBox().checkBoxIsItSelectable());
        Assert.assertEquals(this.getCheckBox().checkBoxIsItSelected(), "rct-icon rct-icon-check");
    }

    @Test (priority = 3) //TC-radio_button-03
    public void checkYesRadioButton(){
        this.getRadioButton().radioButtonClick();
        this.getRadioButton().radioButtonClickYes();
        Assert.assertEquals(this.getRadioButton().radioButtonConfirmation(), "text-success");
        Assert.assertEquals(this.getRadioButton().radioButtonConfirmationNo2(), "Yes");
    }

    @Test (priority = 4) //TC-web_tables-05
    public void populatingAndSubmittingWebForm (){
        this.getWebTable().webTableClick();
        this.getWebTable().webTableAddEntry();
        this.getWebTable().webTablePopulateForm("John", "Doe", "john.doe@gmail.com", "30", "10000", "IT");
        this.getWebTable().webTablesSearchEntry("john.doe@gmail.com");
        //napisati krace. jedna metoda koja uporedjuje indekse u objektu i getText. vraca tru/false
        Assert.assertEquals(this.getWebTable().webTableSearchResultName().getText(),"John");
        Assert.assertEquals(this.getWebTable().webTableSearchResultSurname().getText(), "Doe");
        Assert.assertEquals(this.getWebTable().webTableSearchResultAge().getText(), "30");
        Assert.assertEquals(this.getWebTable().webTableSearchResultSalary().getText(), "10000");
        Assert.assertEquals(this.getWebTable().webTableSearchResultDepartment().getText(), "IT");

    }

    @Test (priority = 5) //TC-Web_Tables-06
    public void editingExistingEntry(){
        this.getWebTable().webTableClick();
        this.getWebTable().createAndFindEntry();
        this.getWebTable().webTableEditEntry();
        this.getWebTable().webTableClearForm("Johana", "40");
        Assert.assertEquals(this.getWebTable().webTableSearchResultName().getText(),"Johana");
        Assert.assertEquals(this.getWebTable().webTableSearchResultAge().getText(), "40");
    }

    @Test (priority = 6)
    public void checkLeftAndRightClicks(){
        this.getButtons().buttonsClick();
        this.getButtons().clickOnceRight();
        this.getButtons().clickTwoTimesLeft();
        this.getButtons().clickOnceLeft();
        Assert.assertEquals(this.getButtons().rightClickConf().getText(),"You have done a right click");
        Assert.assertEquals(this.getButtons().leftClickConf().getText(), "You have done a dynamic click");
        Assert.assertEquals(this.getButtons().doubleClickConf().getText(), "You have done a double click");
    }






}
