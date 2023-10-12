package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.io.IOException;
import java.time.Duration;
import p02_10_2023.Helper;

public abstract class BasicTest {
    protected String url = "https://www.saucedemo.com/";
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;
    protected LeftNavPage leftNavPage;
    protected InventoryPage inventoryPage;
    protected TablePage tablePage;
    protected UpdateDialogPage updateDialogPage;
    protected DeleteDialogPage deleteDialogPage;
    protected JavascriptExecutor js;


    @BeforeClass
    public void BeforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        tablePage = new TablePage(driver, wait);
        updateDialogPage = new UpdateDialogPage(driver, wait);
        deleteDialogPage = new DeleteDialogPage(driver,
                wait);
        loginPage = new LoginPage(driver, wait);
        leftNavPage = new LeftNavPage(driver, wait);
        inventoryPage = new InventoryPage(driver, wait);
        js = (JavascriptExecutor) driver;

    }

    @BeforeMethod
    public void setup() {
        driver.manage().deleteAllCookies();
        driver.navigate().to(url);
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) throws IOException {
        js.executeScript("window.localStorage.clear();");
        if (testResult.getStatus() == ITestResult.FAILURE) {
            Helper.takeAScreenshot(driver, "screenshots/" + testResult.getName() + ".jpg");
        }
    }

    @AfterClass
    public void afterClass(){
        driver.close();
    }
}
