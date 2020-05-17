import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FollowPage;
import pages.HomePage;
import pages.LoginPage;
import sun.rmi.runtime.Log;
import util.PropertyLoader;

import java.io.File;

public class FirstTest extends TestBase {

    @Test
    public void loginTest() {
        loginPage.goToHomePage();
        loginPage.clickOnLoginButton();
        loginPage.enterToLoginField();
        loginPage.enterToPasswordField();
        loginPage.clickOnSubmitButton();
        Assert.assertEquals(loginPage.getName(), "Panch31");
    }

    @Test
    public void linkTest() {
        System.out.print(PropertyLoader.loadProperty("browser.name"));
//        homePage.goToHomePage();
//        Assert.assertEquals(homePage.getTitle(), "The world’s leading software development platform · GitHub");
    }

    @Test
    public void followTest() {
        followPage.goToPprettytonyPage();
        followPage.clickOnfollowButton();
        Assert.assertEquals(followPage.getTextFromUnFollowButton(), "Unfollow");
    }

    @Test
    public void unFollowTest() {
        followPage.goToPprettytonyPage();
        followPage.clickOnUnFollowButton();
        Assert.assertEquals(followPage.getTextFromFollowButton(), "Follow");
    }

}
