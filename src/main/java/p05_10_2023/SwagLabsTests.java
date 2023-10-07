package p05_10_2023;

import d02_10_2023.UrlHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

//Kreirati klasu SwagLabsTests https://www.saucedemo.com/
public class SwagLabsTests {
    private WebDriver driver;
    private WebDriverWait wait;
    private String url = "https://www.saucedemo.com/";

    @BeforeClass
    public void BeforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
//    Before Method:
//    Ucitava home stranicu
//    Brise kolacice

    @BeforeMethod
    public void BeforeMethod() {
        driver.manage().deleteAllCookies();
        driver.get(url);
    }

    //Test #1:  Verify error is displayed when username is missing
    @Test
    public void verifyErrorIsDisplayedWhenUsernameIsMissing() {
        driver.findElement(By.id("login-button")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//*[@id='login_button_container']//form//h3/button")));
        Assert.assertEquals(driver.
                        findElement(By.xpath("//*[@id='login_button_container']//form//h3"))
                        .getText(), "Epic sadface: Username is required",
                "Error message should be present");
    }

    //Test #2:  Verify error is displayed when password is missing
    @Test
    public void verifyErrorIsDisplayedWhenPasswordIsMissing() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.findElement(By.xpath(
                        "//*[@id='login_button_container']//form//h3")).getText(),
                "Epic sadface: Password is required", "Error message for " +
                        "missing password should be present");
    }

    //Test #3:  Verify error is displayed when credentials are wrong
    @Test
    public void verifyErrorIsDisplayedWhenCredentialsAreWrong() {
        String username = "standard_user";
        String password = "invalidpassword";

        driver.findElement(By.name("user-name")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(driver.findElement(By.xpath(
                        "//*[@id='login_button_container']//form//h3")).getText(),
                "Epic sadface: Username and password do not match any user in this service",
                "Error message for invalid username and password should be present");
    }

    //Test #4:  Verify error is displayed when user is locked
    @Test
    public void verifyErrorIsDisplayedWhenUserIsLocked() {
        String username = "locked_out_user";
        String password = "secret_sauce";

        driver.findElement(By.name("user-name")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        Assert.assertEquals(driver.findElement(By.xpath(
                        "//*[@id='login_button_container']//form//h3")).getText(),
                "Epic sadface: Sorry, this user has been locked out.",
                "Error message for locked out user should be present");
    }

    //Test #5:  Verify successful login
    @Test
    public void verifySuccessfulLogin() {
        String username = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.name("user-name")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.urlContains("/inventory.html"));
        wait.withMessage("Url doesn't contain /inventory.html");

        driver.findElement(By.id("react-burger-menu-btn")).click();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[@id='menu_button_container']/div/div[2]")));
        wait.withMessage("Menu is not present");

        boolean logoutExists =
                !driver.findElements(By.id("logout_sidebar_link")).isEmpty();
        Assert.assertTrue(logoutExists, "Logout should exists.");
        driver.findElement(By.id("logout_sidebar_link")).click();


        boolean loginFormExists =
                !driver.findElements(By.className("login_wrapper")).isEmpty();

        Assert.assertTrue(
                loginFormExists,
                "Should be redirected to login page after logout.");
    }

    //Test #6:  Adding Products to Cart
    @Test
    public void addingProductsToCart() {
        String username = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.name("user-name")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.urlContains("/inventory.html"));
        wait.withMessage("Url doesn't contain /inventory.html");

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("remove-sauce-labs-backpack")));
        wait.withMessage("Remove button is not present");

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a/span"))
                        .getText(),
                "1", "Number of products should be 1");
    }

    //Test #7: Viewing Product Details
    @Test
    public void viewingProductDetails() {
        String username = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.name("user-name")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.urlContains("/inventory.html"));
        wait.withMessage("Url doesn't contain /inventory.html");

        driver.findElement(By.id("item_4_title_link")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.inventory_details_price")));
        wait.withMessage("The price is invisible.");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .cssSelector("div.inventory_details_desc.large_size")));
        wait.withMessage("The description is invisible.");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-sauce-labs-backpack")));
        wait.withMessage("Add to cart button is invisible");

    }

    //Test #8: Removing Products from Cart
    @Test
    public void removingProductsFromCart() {
        String username = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.name("user-name")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.urlContains("/inventory.html"));
        wait.withMessage("Url doesn't contain /inventory.html");

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a/span"))
                        .getText(),
                "1", "Number of products should be 1");

        driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("#item_4_title_link > div")).getText(),
                "Sauce Labs Backpack", "Sauce Labs Backpack should be present in cart.");

        driver.findElement(By.id("remove-sauce-labs-backpack")).click();

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath
                ("//div[text()='Sauce Labs Backpack']"), 0));
        wait.withMessage("Cart is not empty");

    }

    //Test #9: Product Checkout
    @Test
    public void productCheckout() {
        String username = "standard_user";
        String password = "secret_sauce";
        String checkoutName = "Pera";
        String checkoutLastName = "Peric";
        String checkoutZip = "18000";

        driver.findElement(By.name("user-name")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.urlContains("/inventory.html"));
        wait.withMessage("Url doesn't contain /inventory.html");

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a/span")).getText(),
                "1", "Number of products should be 1");

        driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a")).click();

        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys(checkoutName);
        driver.findElement(By.id("last-name")).sendKeys(checkoutLastName);
        driver.findElement(By.id("postal-code")).sendKeys(checkoutZip);
        driver.findElement(By.id("continue")).click();


        wait.until(ExpectedConditions.numberOfElementsToBe(By
                .cssSelector("#checkout_summary_container div.cart_quantity"), 1));

        Assert.assertTrue(driver.findElement(By.cssSelector("div.summary_subtotal_label")).getText()
                        .contains(driver.findElement(By.cssSelector("div.item_pricebar > div")).getText()),
                "Prices in item pricebar and subtotal should be equal.");

        driver.findElement(By.id("finish")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='checkout_complete_container']/h2"))
                        .getText(),
                "Thank you for your order!", "Message should be equal to: Thank you for your order!");
    }
//Test #10:  Validate Social Links in Footer
    @Test
    public void validateSocialLinksInFooter() throws IOException {
        String username = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.name("user-name")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.urlContains("/inventory.html"));
        wait.withMessage("Url doesn't contain /inventory.html");

        new Actions(driver).scrollToElement(driver.findElement(By.cssSelector("#page_wrapper > footer"))).perform();


        String twitterLink = driver.findElement(By.cssSelector(".social_twitter>a")).getAttribute("href");
        String facebookLink = driver.findElement(By.cssSelector(".social_facebook>a")).getAttribute("href");
        String linkedinLink = driver.findElement(By.cssSelector(".social_linkedin>a")).getAttribute("href");

        int statusCodeTwitter = UrlHelper.getHTTPResponseStatusCode(twitterLink);
        int statusCodeFacebook = UrlHelper.getHTTPResponseStatusCode(facebookLink);
        int statusCodeLinkedin = UrlHelper.getHTTPResponseStatusCode(linkedinLink);

        Assert.assertEquals(statusCodeTwitter, 200, "Response code for Twitter should be 200");
        Assert.assertEquals(statusCodeFacebook, 200, "Response code for Facebook should be 200");
        Assert.assertEquals(statusCodeLinkedin, 200, "Response code for Linkedin should be 200");
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
   }
}
