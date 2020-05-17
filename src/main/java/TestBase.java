import managers.AppManager;
import managers.SingletonAppManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.FollowPage;
import pages.HomePage;
import pages.LoginPage;

import java.io.File;

public class TestBase {

    AppManager app = SingletonAppManager.getInstance().manager;
    WebDriver driver = AppManager.getWebDriver();

    @BeforeMethod
//    public void beforeMethod() {
//        System.out.println("Before Method");
//    }

    @BeforeClass
//    public void beforeClass() {
//        System.out.println("beforeClass");
//    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("beforeSuite");
    }


    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("afterClass");
    }

    @AfterSuite
    public void afterSuite() {
        driver.quit();
        System.out.println("afterSuite");
    }

}
