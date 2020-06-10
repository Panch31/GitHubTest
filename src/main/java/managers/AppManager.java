package managers;

import helpers.MarketplaceHelper;
import helpers.NavigationHelper;
import helpers.RepositoryHelper;
import helpers.UserHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import util.PropertyLoader;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class AppManager {

    private UserHelper userHelper;
    private NavigationHelper navigationHelper;
    private RepositoryHelper repositoryHelper;
    private MarketplaceHelper marketplaceHelper;

    private static WebDriver driver;

    AppManager(){
        File chromeDriver = new File(PropertyLoader.loadProperty("chrome.driver.path"));
        ChromeDriverService driverService = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeDriver)
                .usingAnyFreePort()
                .build();
        ChromeOptions chromeOptions = new ChromeOptions()
                .addArguments(PropertyLoader.loadProperty("chrome.option1"))
                .addArguments(PropertyLoader.loadProperty("chrome.option2"));
        driver = new ChromeDriver(driverService, chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        userHelper = new UserHelper();
        navigationHelper = new NavigationHelper();
        repositoryHelper = new RepositoryHelper();
        marketplaceHelper = new MarketplaceHelper();
    }

    public static WebDriver getWebDriver(){return driver;}
    public UserHelper getUserHelper(){return userHelper;}
    public NavigationHelper getNavigationHelper(){return navigationHelper;}
    public RepositoryHelper getRepositoryHelper(){return repositoryHelper;}
    public MarketplaceHelper getMarketplaceHelper(){return marketplaceHelper;}

}
