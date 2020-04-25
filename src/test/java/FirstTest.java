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
        String http = "https://github.com/";
        driver.get(http);
        WebElement log = driver.findElement(By.xpath("//a[@href ='/login']"));
        log.click();
        driver.findElement(By.xpath("//input[@id = 'login_field']"))
                .sendKeys("Panch31");

        driver.findElement(By.xpath("//input[@id = 'password']"))
                .sendKeys("mAEege4jJW");

        WebElement logIn = driver.findElement(By.xpath("//input[@name = 'commit']"));
        logIn.click();

        driver.findElement(By.xpath("(//span[@class = 'dropdown-caret'])[2]")).click();
        WebElement name = driver.findElement(By.xpath("//strong[@class = 'css-truncate-target']"));
        String text = name.getText();
        Assert.assertEquals(text, "Panch31");
        driver.quit();
    }
}
