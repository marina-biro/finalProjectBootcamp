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


    @Test (priority = 7) //TC-text_box-01
    public void populatingAndSubmittingAForm(){
        this.getTextBox().textBoxClick();
        this.getTextBox().textBoxPopulateForm("Marina Biro", "marina.nina.biro@gmail.com", "Street 3", "Street 5");
        Assert.assertEquals(this.getTextBox().textBox().getText(),
                "Name:Marina Biro\n" +
                "Email:marina.nina.biro@gmail.com\n" +
                "Current Address :Street 3\n" +
                "Permananet Address :Street 5");
    }


    @Test (priority = 3) //TC-radio_button-03
    public void checkYesRadioButton(){
        this.getRadioButton().radioButtonOptionClick();
        this.getRadioButton().radioButtonClickYes();
        Assert.assertEquals(this.getRadioButton().radioBtnConfMessageClassValue(), "text-success");
        Assert.assertEquals(this.getRadioButton().radioBtnConfMessageVisibleText(), "Yes");
        Assert.assertFalse(this.getRadioButton().impressiveBtnSelected());
    }

    @Test (priority = 4) //TC-radio_button-03a
    public void checkImpressiveRadioButton(){
        this.getRadioButton().radioButtonOptionClick();
        this.getRadioButton().radioButtonClickImpressive();
        Assert.assertEquals(this.getRadioButton().radioBtnConfMessageClassValue(), "text-success");
        Assert.assertEquals(this.getRadioButton().radioBtnConfMessageVisibleText(), "Impressive");
        Assert.assertFalse(this.getRadioButton().yesBtnSelected());
}

    @Test (priority = 5) //TC-radio_button-03b
    public void checkNoRadioButton(){
        this.getRadioButton().radioButtonOptionClick();
        Assert.assertFalse(this.getRadioButton().noBtnSelectable());
    }

    @Test (priority = 6) //TC-web_tables-05
    public void populatingAndSubmittingWebForm (){
        this.getWebTable().webTableClick();
        this.getWebTable().webTableAddEntry();
        this.getWebTable().webTablePopulateForm("John", "Doe", "john.doe@gmail.com", "30", "10000", "IT");
        this.getWebTable().webTablesSearchEntry("john.doe@gmail.com");
        Assert.assertEquals(this.getWebTable().webTableSearchResultName().getText(),"John");
        Assert.assertEquals(this.getWebTable().webTableSearchResultSurname().getText(), "Doe");
        Assert.assertEquals(this.getWebTable().webTableSearchResultAge().getText(), "30");
        Assert.assertEquals(this.getWebTable().webTableSearchResultSalary().getText(), "10000");
        Assert.assertEquals(this.getWebTable().webTableSearchResultDepartment().getText(), "IT");

    }

    @Test (priority = 1) //TC-Web_Tables-05a
    public void editingExistingEntry(){
        this.getWebTable().webTableClick();
        this.getWebTable().webTablesSearchEntry("kierra@example.com");
        this.getWebTable().webTableEditEntry();
        this.getWebTable().webTableClearAndCorrectForm("Johana", "40");
        Assert.assertEquals(this.getWebTable().webTableSearchResultName().getText(),"Johana");
        Assert.assertEquals(this.getWebTable().webTableSearchResultAge().getText(), "40");
    }

    @Test (priority = 8) //TC-Web_Tables-05b
    public void deletingExistingEntry(){
        this.getWebTable().webTableClick();
        this.getWebTable().webTablesSearchEntry("kierra@example.com");
        this.getWebTable().webTableDeleteEntry();
        Assert.assertTrue(this.getWebTable().isEntryDeleted());
    }

    @Test (priority = 9) //TC-left_rightClick-06
    public void checkLeftAndRightClicks(){
        this.getButtons().buttonsClick();
        this.getButtons().clickOnceRight();
        this.getButtons().clickTwoTimesLeft();
        this.getButtons().clickOnceLeft();
        Assert.assertEquals(this.getButtons().rightClickConf().getText(),"You have done a right click");
        Assert.assertEquals(this.getButtons().leftClickConf().getText(), "You have done a dynamic click");
        Assert.assertEquals(this.getButtons().doubleClickConf().getText(), "You have done a double click");
    }


    @Test (priority = 2) //TC-check_box-02
    public void checkingAndUncheckingTheCheckBox(){
        this.getCheckBox().checkBoxClick();
        Assert.assertEquals(this.getCheckBox().checkBoxIsItSelected(), "rct-icon rct-icon-check");
        Assert.assertEquals(this.getCheckBox().confMsg(), "You have selected :\n" +
                "home\n" + "desktop\n" + "notes\n" + "commands\n" + "documents\n" + "workspace\n" + "react\n" +
                "angular\n" + "veu\n" + "office\n" + "public\n" + "private\n" + "classified\n" + "general\n" +
                "downloads\n" + "wordFile\n" + "excelFile");

    }

}
