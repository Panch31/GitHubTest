import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FirstTest {
    public ChromeDriverService driverService = new ChromeDriverService.Builder()
            .usingDriverExecutable(new File("D:\\Yevhenii\\test\\chromedriver.exe"))
            .usingAnyFreePort()
            .build();
    public ChromeOptions chromeOptions = new ChromeOptions();

    @Test
    public void firstTest(){

        WebDriver driver = new ChromeDriver(driverService, chromeOptions);
        String http = "https://github.com/Panch31";
        driver.get(http);
        WebElement name = driver.findElement(By.xpath("//span[contains(@class, 'nick')]"));
        String text = name.getText();
        Assert.assertEquals(text, "Panch31");
        driver.quit();
    }
}
