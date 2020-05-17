package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FollowPage extends Page {

    public FollowPage(PageManager pages) {
        super(pages);
    }

    @FindBy(xpath = "(//input[@type ='submit'])[3]")
    WebElement followButton;

    @FindBy(xpath = "(//input[@type ='submit'])[4]")
    WebElement unFollowButton;

    public void clickOnFollowButton(){
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
