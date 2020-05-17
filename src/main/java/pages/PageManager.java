package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import sun.rmi.runtime.Log;

import static org.openqa.selenium.support.PageFactory.initElements;

public class PageManager {

    private WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected FollowPage followPage;

    public PageManager(WebDriver driver){
        this.driver = driver;
        homePage = initElements(new HomePage(this));
        loginPage = initElements(new LoginPage(this));
        followPage = initElements(new FollowPage(this));
    }

    private <T extends  Page> T initElements(T page){
        PageFactory.initElements(driver,page);
        return page;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
