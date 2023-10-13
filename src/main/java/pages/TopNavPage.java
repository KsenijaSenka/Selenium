package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopNavPage extends BasicPage{
    public TopNavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getBurgerButton(){
        return driver.findElement(By.id("react-burger-menu-btn"));
    }

    public void waitForBurgerButton(){
        wait.withMessage("Burger menu button is not present")
                .until(ExpectedConditions.visibilityOf(getBurgerButton()));
    }

    public WebElement getCartButton(){
        return driver.findElement(By.className("shopping_cart_link"));
    }

    public void waitForCartIcon(){
        wait.withMessage("Cart icon is not present")
                .until(ExpectedConditions.visibilityOf(getCartButton()));
    }

    public WebElement getHeaderTitle(){return driver.findElement(By.className("app_logo"));}

    public String getHeaderTitleText(){return getHeaderTitle().getText();}

    public void clickOnBurger(){
        getBurgerButton().click();
    }

    public void clickOnCartButton(){
        getCartButton().click();
    }

    public boolean isBurgerButtonEnabled(){
        return getBurgerButton().isEnabled();
    }

    public boolean isCartIconEnabled(){
        return getCartButton().isEnabled();
    }

    public boolean checkIfCartBadgeExists(){
        return elementExists(By.className("shopping_cart_badge"));
    }

    public WebElement getCartBadge(){
        if(checkIfCartBadgeExists()){
            return driver.findElement(By.className("shopping_cart_badge"));
        }
        else return null;
    }
    public int getNumberOfItemsFromCart(){
        if(getCartBadge()!=null){
            return  Integer.parseInt(getCartBadge().getText());
        }
        else return 0;
    }

    public WebElement getSubheaderTitle(){
        return driver.findElement(By.cssSelector(".header_secondary_container>.title"));
    }
    public String getSubheaderTitleText(){
        return getSubheaderTitle().getText();
    }

}
