package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdateDialogPage extends BasicPage {


    public UpdateDialogPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitForDialogToBeVisible(){
        wait
                .withMessage("Edit dialog should be visible")
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("edit")));
    }
    public void clearAndTypeFirstName(String firstname){
        getFirstNameInput().clear();
        getFirstNameInput().sendKeys();
    }
    public WebElement getFirstNameInput(){
        return driver.findElement(By.id("fn"));
    }
}
