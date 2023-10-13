package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class LeftNavPage extends BasicPage {
    public LeftNavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickOnMenu() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    public void waitLeftNavMenu() {
        wait
                .withMessage("Menu is not present")
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By
                                .xpath("//*[@id='menu_button_container']/div/div[2]")));
    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.id("logout_sidebar_link"));
    }

    public void clickOnLogoutButton() {
        getLogoutButton().click();
    }

    public void waitLeftNavMenuDissapears() {
        wait
                .withMessage("Left menu didn't dissappear")
                .until(ExpectedConditions.invisibilityOfElementLocated(By.className("bm-item-list")));
    }

    public void waitXButton() {
        wait
                .withMessage("X button is not present")
                .until(ExpectedConditions.visibilityOf(getXButton()));
    }

    public boolean doesLogoutButtonExist() {
        return elementExists(By.linkText("Logout"), 0);
    }

    public WebElement getAllItems() {
        return driver.findElement(By.linkText("All Items"));
    }

    public WebElement getAbout() {
        return driver.findElement(By.linkText("About"));
    }

    public WebElement getResetAppState() {
        return driver.findElement(By.linkText("Reset App State"));
    }

    public void clickAllItems() {
        getAllItems().click();
    }

    public void clickAbout() {
        getAbout().click();
    }

    public void clickResetAppState() {
        getResetAppState().click();
    }

    public void clickXButton() {
        getXButton().click();
    }

    public List<WebElement> getMenuOptions() {
        return driver.findElements(By.cssSelector(".bm-item-list>a"));
    }

    public List<String> getTextFromMenuOptions() {
        List<String> menuOptions = new ArrayList<>();

        for (int i = 0; i < getNumberOfMenuOptions(); i++) {
            menuOptions.add(getMenuOptions().get(i).getText());
        }
        return menuOptions;
    }

    public int getNumberOfMenuOptions() {
        return getMenuOptions().size();
    }

    public boolean spellingOfOptions() {
        boolean isSpellingCorect = false;
        if (getTextFromMenuOptions().get(0).equals("All Items")
                && getTextFromMenuOptions().get(1).equals("About")
                && getTextFromMenuOptions().get(2).equals("Logout")
                && getTextFromMenuOptions().get(3).equals("Reset App State")) {
            isSpellingCorect = true;
        }
        return isSpellingCorect;
    }
    public WebElement getXButton() {
        return driver.findElement(By.id("react-burger-cross-btn"));
    }
}
