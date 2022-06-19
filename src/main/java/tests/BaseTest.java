package tests;

import pages.alertsframeandwindows.AlertsOption;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import pages.*;
import pages.elements.*;
import pages.widgets.ProgressBar;
import pages.widgets.Slider;

import java.time.Duration;

@Data
public abstract class BaseTest {

    private WebDriver driver;
    private WebDriverWait driverWait;
    private HomePage homePage;
    private RadioButton radioButton;
    private WebTable webTable;
    private TextBox textBox;
    private CheckBox checkBox;
    private Buttons buttons;
    private AlertsOption alertsOption;
    private Slider slider;
    private ProgressBar progressBar;

    public BaseTest(){}


    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Raven\\Desktop\\QA\\chromedriver.exe");
        driver = new ChromeDriver();
        getDriver().navigate().to("https://demoqa.com/");
        getDriver().manage().window().maximize();
        this.driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.homePage = new HomePage(driver,driverWait);
        this.radioButton = new RadioButton(driver, driverWait);
        this.webTable = new WebTable(driver,driverWait);
        this.textBox = new TextBox(driver,driverWait);
        this.checkBox = new CheckBox(driver,driverWait);
        this.buttons = new Buttons(driver,driverWait);
        this.alertsOption = new AlertsOption(driver,driverWait);
        this.slider = new Slider(driver, driverWait);
        this.progressBar = new ProgressBar(driver,driverWait);



    }


}
