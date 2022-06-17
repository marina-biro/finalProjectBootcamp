package tests;

import lombok.Data;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Data
public class WidgetsTests extends BaseTest{

    public WidgetsTests() {
    }

    @BeforeMethod
    public void openWidgetsOption(){
        getHomePage().clickWidgetsOption();
    }

    @Test
    public void sliderTest(){
        getSlider().clickSliderOption();
        getSlider().moveSlider();
        Assert.assertEquals(getSlider().confirmation(), "70");
    }

    @Test
    public void progressBarTest() throws InterruptedException {
        getProgressBar().clickProgressBar();
        Assert.assertEquals(getProgressBar().value(), "100");
    }


}
