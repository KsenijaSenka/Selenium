package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends BasicPage{
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getLoginButton(){
        return driver.findElement(By.id("login-button"));
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    public boolean doesUsernameInputExist() {
        return elementExists(By.id("user-name"));
    }
    public void clickOnLoginButton() {
        wait
                .withMessage("Button is not clickable")
                .until(ExpectedConditions.elementToBeClickable(getLoginButton())).click();
       }
    public String getErrorMessageText () {
        return driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
    }

    public WebElement getUsernameInput(){
        return driver.findElement(By.id("user-name"));
    }

    public WebElement getPasswordInput(){
        return driver.findElement(By.id("password"));
    }

    public void enterUsername(String username){
        getUsernameInput().sendKeys(username);
    }

    public void enterPassword(String password){
        getPasswordInput().sendKeys(password);
    }

}

