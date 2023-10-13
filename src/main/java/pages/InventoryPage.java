package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage extends BasicPage {
    public InventoryPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement findBackpack() {

        return driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
    }

    public boolean findSauceLabsItem() {
        return elementExists(By.xpath("//div[text()='Sauce Labs Backpack']"));
    }

    public WebElement findAddToCart() {
        return driver
                .findElement(By.id("add-to-cart-sauce-labs-backpack"));
    }

    public void clickAddToCart() {
        findAddToCart().click();
    }

    public boolean checkIfThereIsRemoveButton() {
        return elementExists(By.id("remove-sauce-labs-backpack"));
    }

    public String getCartPageTitle() {
        return driver.getTitle();
    }
}