import managers.AppManager;
import managers.SingletonAppManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.annotations.*;
import pages.FollowPage;
import pages.HomePage;
import pages.LoginPage;
import util.TestListener;
import org.slf4j.LoggerFactory;

import java.io.File;

@Listeners(util.TestListener.class)
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
    }


    @AfterMethod
    public void afterMethod() {

    }

    @AfterClass
    public void afterClass() {
    }

    @AfterSuite
    public void afterSuite() {
        driver.quit();
    }

}
