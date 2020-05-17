package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FollowPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public FollowPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    @FindBy(xpath = "(//input[@type ='submit'])[3]")
    WebElement followButton;

    @FindBy(xpath = "(//input[@type ='submit'])[4]")
    WebElement unFollowButton;

    public void goToPprettytonyPage(){
        driver.get("https://github.com/pprettytony");
    }


    public void clickOnfollowButton(){
        wait.until(ExpectedConditions.elementToBeClickable(followButton))
                .click();
    }

    public void clickOnUnFollowButton(){
        wait.until(ExpectedConditions.elementToBeClickable(unFollowButton))
                .click();
    }

    public String getTextFromFollowButton(){
        return wait.until(ExpectedConditions.visibilityOf(followButton))
                .getAttribute("value");
    }

    public String getTextFromUnFollowButton(){
        return wait.until(ExpectedConditions.visibilityOf(unFollowButton))
                .getAttribute("value");
    }

}
