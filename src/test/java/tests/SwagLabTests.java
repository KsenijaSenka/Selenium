package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import retry.BootsnipRetry;

public class SwagLabTests extends BasicTest {
//Test #1
    @Test(priority = 1, retryAnalyzer = BootsnipRetry.class)
    public void verifyErrorIsDisplayedWhenUsernameIsMissing() {
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageText(),
                "Epic sadface: Username is required",
                "Error message should be present if username is missing");
    }
//Test #2
@Test(priority=2, retryAnalyzer = BootsnipRetry.class)
    public void verifyErrorIsDisplayedWhenPasswordIsMissing(){
    String username= "standard_user";

    loginPage.enterUsername(username);
    loginPage.clickOnLoginButton();
    Assert.assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Username is required",
            "Error message should be present if password is missing");
}
//Test #3
@Test
    public void verifyErrorIsDisplayedWhenCredentialsAreWrong(){
    String username = "standard_user";
    String password = "invalidpassword";

    loginPage.enterUsername(username);
    loginPage.enterPassword(password);
    loginPage.clickOnLoginButton();
    Assert.assertEquals(loginPage.getErrorMessageText(),
            "Epic sadface: Password is required", "Error message for " +
                    "wrong username and password should be present");
}
//Test #4
@Test
public void verifyErrorIsDisplayedWhenUserIsLocked() {
    String username = "locked_out_user";
    String password = "secret_sauce";

    loginPage.enterUsername(username);
    loginPage.enterPassword(password);
    loginPage.clickOnLoginButton();
    Assert.assertEquals(loginPage.getErrorMessageText(),
            "Epic sadface: Sorry, this user has been locked out.",
            "Error message for locked out user should be present");
}
//Test #5
@Test
public void verifySuccessfulLogin() {
    String username = "standard_user";
    String password = "secret_sauce";

    loginPage.enterUsername(username);
    loginPage.enterPassword(password);
    loginPage.clickOnLoginButton();
    wait.until(ExpectedConditions.urlContains("/inventory.html"));
    wait.withMessage("Url doesn't contain /inventory.html");
    topNavPage.clickOnBurger();
    leftNavPage.waitLeftNavMenu();
    Assert.assertTrue(leftNavPage.doesLogoutButtonExist(), "Logout should exist.");
    leftNavPage.clickOnLogoutButton();
}

//Test #6
    @Test
    public void addingProductsToCart() {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        wait
                .withMessage("Url doesn't contain /inventory.html")
                .until(ExpectedConditions.urlContains("/inventory.html"));
        Assert.assertTrue(inventoryPage.findSauceLabsItem(),
                "Sauce Labs Backpack not found in the cart");
        inventoryPage.clickAddToCart();
        Assert.assertTrue(inventoryPage.checkIfThereIsRemoveButton(),
        "Remove button is not present");
        int numberOfItems = topNavPage.getNumberOfItemsFromCart();

        Assert.assertEquals(numberOfItems, 1,
                "Number of items in the cart should be 1");
    }

//Cart Page sheet #1
        @Test(priority=3, retryAnalyzer = BootsnipRetry.class)
        public void verifyTheUrl(){
            String username = "standard_user";
            String password = "secret_sauce";

            loginPage.enterUsername(username);
            loginPage.enterPassword(password);
            loginPage.clickOnLoginButton();
            topNavPage.clickOnCartButton();

            Assert.assertEquals(loginPage.getCurrentUrl(),url+"cart.html",
                    "Url should be https://www.saucedemo.com/cart.html");
        }
    //Cart Page sheet #2
    @Test
    public void verifyTheTitlePage() {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        inventoryPage.clickAddToCart();
        topNavPage.clickOnCartButton();

        Assert.assertEquals(inventoryPage.getCartPageTitle(),
                "Swag Labs", "Title should be Swag Labs.");
    }
    //Cart page sheet #3
    @Test
    public void verifyTheTitleInHeader() {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        topNavPage.clickOnCartButton();
        Assert.assertEquals(topNavPage.getHeaderTitleText(),
                "Swag Labs",
                "Title in header should be Swag Labs");
    }
    }

