package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Footer extends BasicPage{
    public Footer(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getFooter(){
        return driver.findElement(By.className("footer"));
    }

    public WebElement getTwitter(){
        return driver.findElement(By.cssSelector(".social_twitter>a"));
    }

    public WebElement getFacebook(){
        return driver.findElement(By.cssSelector(".social_facebook>a"));
    }

    public WebElement getLinkedin(){
        return driver.findElement(By.cssSelector(".social_linkedin>a"));
    }

    public void clickOnTwitterIcon(){
        getTwitter().click();
    }

    public void clickOnFacebookIcon(){
        getFacebook().click();
    }

    public void clickOnLinkedinIcon(){
        getLinkedin().click();
    }

    public void scrollToFooter(){
        new Actions(driver).scrollToElement(getFooter()).perform();
    }

    public void waitForTwitterIconToBeVisible(){
        wait
                .withMessage("Twitter button is not visible")
                .until(ExpectedConditions.visibilityOf(getTwitter()));
    }

    public void waitForFacebookIconToBeVisible(){
        wait
                .withMessage("Facebook button is not visible")
                .until(ExpectedConditions.visibilityOf(getFacebook()));
    }

    public void waitForLinkedinIconToBeVisible(){
        wait
                .withMessage("Linkedin button is not visible")
                .until(ExpectedConditions.visibilityOf(getLinkedin()));
    }

    public void redirectToTwitter() {
        driver.navigate().to("https://twitter.com/saucelabs");
        wait.withMessage("Should be redirected to twitter profile")
                .until(ExpectedConditions.urlToBe("https://twitter.com/saucelabs"));
    }
    public void redirectToFacebook() {
        driver.navigate().to("https://facebook.com/saucelabs");
        wait.withMessage("Should be redirected to facebook profile")
                .until(ExpectedConditions.urlToBe("https://facebook.com/saucelabs"));
    }
    public void redirectToLinkedin() {
        driver.navigate().to("https://linkedin.com/saucelabs");
        wait.withMessage("Should be redirected to linkedin profile")
                .until(ExpectedConditions.urlToBe("https://linkedin.com/saucelabs"));
    }
    public WebElement getCopyrightMessage(){
        return driver.findElement(By.className("footer_copy"));
    }

    public String getCopyrightText(){
        return getCopyrightMessage().getText();
    }

}
