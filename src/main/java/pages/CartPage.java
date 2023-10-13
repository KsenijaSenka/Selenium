package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasicPage {
    public CartPage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean checkIfAddedItemsExist(){
        return elementExists(By.className("cart_item"));
    }

    public WebElement getItemTitleElement(){
        return driver.findElement(By.className("inventory_item_name"));
    }

    public WebElement getRemoveButton(){
        return driver.findElement(By.xpath("//button[text()='Remove']"));
    }
    public WebElement getContinueShoppingButton(){
        return driver.findElement(By.id("continue-shopping"));
    }

    public WebElement getCheckoutButton(){
        return driver.findElement(By.id("checkout"));
    }


    public void clickOnRemoveButton(){
        getRemoveButton().click();
    }

    public void clickContinueShoppingButton(){
        getContinueShoppingButton().click();
    }

    public void clickCheckoutButton(){
        getCheckoutButton().click();
    }

    public void waitForItemTitleToBeClickable(){
        wait
                .withMessage("Item title should be clickable.")
                .until(ExpectedConditions.elementToBeClickable(getItemTitleElement())).click();
    }

    public void waitForRemoveButtonToBeVisible(){
        wait
                .withMessage("Remove button should be visible.")
                .until(ExpectedConditions.visibilityOf(getRemoveButton()));
    }


    public void waitForContinueShoppingButtonToBeVisible(){
        wait
                .withMessage("Continue shopping button is not visible.")
                .until(ExpectedConditions.visibilityOf(getContinueShoppingButton()));
    }

    public void waitForCheckoutButtonToBeVisible(){
        wait
                .withMessage("Checkout button is not visible.")
                .until(ExpectedConditions.visibilityOf(getCheckoutButton()));
    }
}
