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
    @Test(priority = 2, retryAnalyzer = BootsnipRetry.class)
    public void verifyErrorIsDisplayedWhenPasswordIsMissing() {
        String username = "standard_user";

        loginPage.enterUsername(username);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Username is required",
                "Error message should be present if password is missing");
    }

    //Test #3
    @Test
    public void verifyErrorIsDisplayedWhenCredentialsAreWrong() {
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
    @Test(priority = 3, retryAnalyzer = BootsnipRetry.class)
    public void verifyTheUrl() {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        topNavPage.clickOnCartButton();

        Assert.assertEquals(loginPage.getCurrentUrl(), url + "cart.html",
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

    //Cart page sheet #4
    @Test
    public void verifyIfTheHamburgerMenuButtonIsPresented() {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        topNavPage.clickOnCartButton();
        topNavPage.waitForBurgerButton();
    }

    //Cart page sheet #5
    @Test
    public void verifyIfTheCartIconIsPresented() {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        topNavPage.clickOnCartButton();
        topNavPage.waitForBurgerButton();
        topNavPage.waitForCartIcon();
    }

    //Cart page sheet #6
    @Test
    public void verifyIfTheHamburgerMenuButtonIsEnabled() {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        topNavPage.clickOnCartButton();
        topNavPage.clickOnBurger();
        Assert.assertTrue(topNavPage.isBurgerButtonEnabled(), "Hamburger button should be enabled");
    }

    //Cart page sheet #7
    @Test
    public void verifyIfTheCartIconIsEnabled() {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        topNavPage.clickOnCartButton();
        Assert.assertTrue(topNavPage.isCartIconEnabled(),
                "Cart icon should be enabled");
    }
    //Cart page sheet #8
    @Test
    public void verifyIfTheHamburgerButtonIsWorking () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        topNavPage.clickOnCartButton();
        topNavPage.clickOnBurger();
        leftNavPage.waitLeftNavMenu();
    }
    //Cart page sheet #9
    @Test
    public void verifyIfTheCartIconIsWorking () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        topNavPage.clickOnCartButton();

        Assert.assertEquals(loginPage.getCurrentUrl(),
                url + "/cart.html",
                "Should redirect to cart page after clicking the cart icon.");
    }
    //Cart page sheet #10
    @Test
    public void verifyIfTheCartIconHasCorrectNumberOfAddedItems() {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();

        int itemsBefore = topNavPage.getNumberOfItemsFromCart();
        inventoryPage.clickAddToCart();
        topNavPage.clickOnCartButton();
        Assert.assertTrue(inventoryPage.checkIfThereIsRemoveButton(),
                "There should be a remove button");

        int itemsAfter = topNavPage.getNumberOfItemsFromCart();

        Assert.assertEquals(itemsAfter, itemsBefore + 1,
                "Number of items in the cart should be increased");
    }
    //Cart page sheet #11
    @Test
    public void verifyTheSubHeaderTitle () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        topNavPage.clickOnCartButton();

        Assert.assertEquals(topNavPage.getSubheaderTitleText(), "Your Cart",
                "Subheader title should be: 'Your Cart'");
    }
    //Cart page sheet #12
    @Test
    public void verifyTheTotalNumberOfMenuOptions () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        topNavPage.clickOnCartButton();
        topNavPage.clickOnBurger();

        leftNavPage.waitLeftNavMenu();
        Assert.assertEquals(leftNavPage.getNumberOfMenuOptions(), 4,
                "Total number of options in menu should be four.");
    }
    //Cart page sheet #13
    @Test
    public void verifyTheSpellingOfAllOptionsInMenu () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        topNavPage.clickOnCartButton();
        topNavPage.clickOnBurger();

        leftNavPage.waitLeftNavMenu();

        Assert.assertTrue(leftNavPage.spellingOfOptions(),
                "Spelling of options in menu is incorrect.");
    }
    //Cart page sheet #14
    @Test
    public void verifyIfAllItemsOptionIsWorking () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        topNavPage.clickOnCartButton();
        topNavPage.clickOnBurger();

        leftNavPage.waitLeftNavMenu();
        leftNavPage.clickAllItems();

        Assert.assertEquals(loginPage.getCurrentUrl(),
                url + "/inventory.html",
                "Should redirect to the products page.");
    }
    //Cart page sheet #15
    @Test
    public void verifyIfAboutOptionIsWorking () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        topNavPage.clickOnCartButton();
        topNavPage.clickOnBurger();

        leftNavPage.waitLeftNavMenu();

        leftNavPage.clickAbout();

        Assert.assertEquals(loginPage.getCurrentUrl(),
                "https://saucelabs.com/",
                "Should redirect to the sauce labs website");
    }
    //Cart page sheet #16
    @Test
    public void verifyIfLogoutOptionIsWorking () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        topNavPage.clickOnCartButton();
        topNavPage.clickOnBurger();

        leftNavPage.waitLeftNavMenu();
        leftNavPage.clickOnLogoutButton();

        Assert.assertTrue(
                loginPage.doesUsernameInputExist(),
                "Should redirect to login page");

    }
    //Cart page sheet #17
    @Test
    public void verifyIfResetAppStateIsWorking () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        inventoryPage.clickAddToCart();
        boolean doesBadgeExist = topNavPage.checkIfCartBadgeExists();

        topNavPage.clickOnCartButton();
        topNavPage.clickOnBurger();
        leftNavPage.waitLeftNavMenu();
        leftNavPage.clickResetAppState();
        boolean doesBadgeExistAfterReset = topNavPage.checkIfCartBadgeExists();

        Assert.assertEquals(doesBadgeExistAfterReset,
                !doesBadgeExist, "Reset option should reset the app");
    }
    //Cart page sheet #18
    @Test
    public void verifyIfTheEkisButtonIsPresented(){
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        topNavPage.clickOnCartButton();
        topNavPage.clickOnBurger();
        leftNavPage.waitXButton();
    }
    //Cart page sheet #19
    @Test
    public void verifyIfTheEkisButtonsIsWorking () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        topNavPage.clickOnCartButton();
        topNavPage.clickOnBurger();
        leftNavPage.waitXButton();
        leftNavPage.clickXButton();
        leftNavPage.waitLeftNavMenuDissapears();
    }
    //Cart page sheet #20
    @Test
    public void verifyIfTheItemsAddedIsPresented () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        inventoryPage.clickAddToCart();
        topNavPage.clickOnCartButton();

        Assert.assertTrue(cartPage.checkIfAddedItemsExist(),
                "Added items should be on the page.");
    }
}