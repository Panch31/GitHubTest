package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends Page {

    public LoginPage(PageManager pages) {
        super(pages);
    }


    @FindBy(xpath = "//a[@href ='/login']")
    WebElement LoginButton;

    @FindBy(id = "login_field")
    WebElement LoginField;

    @FindBy(xpath = "//input[@name='user[login]']")
    WebElement signUpField;

    @FindBy(xpath = "//input[@name='user[email]']")
    WebElement signUpPassField;

    @FindBy(id = "password")
    WebElement PasswordField;

    @FindBy(xpath = "//input[@type = 'submit']")
    WebElement SubmitButton;

    @FindBy(xpath = "(//dd[contains(@id, 'input-check')])[1]/div/div[1]")
    WebElement loginCheckNotification;

    @FindBy(xpath = "(//dd[contains(@id, 'input-check')])[2]")
    WebElement passwordCheckNotification;

    @FindBy(xpath = "//span[contains(@class, 'nick')]")
    WebElement NameSting;

    public void clickOnLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LoginButton))
                .click();
    }

    public void enterToLoginField(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(LoginField))
                .sendKeys(name);
    }

    public void enterToSignUpField(String login) {
        wait.until(ExpectedConditions.visibilityOf(signUpField))
                .sendKeys(login);
    }

    public void enterToSignUpPassField(String signUpPass) {
        wait.until(ExpectedConditions.visibilityOf(signUpPassField))
                .sendKeys(signUpPass);
    }

    public void enterToPasswordField(String pass) {
        wait.until(ExpectedConditions.elementToBeClickable(PasswordField))
                .sendKeys(pass);
    }

    public void clickOnSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SubmitButton))
                .click();
    }

     public String getName(String userLink){
        driver.get(userLink);
         return wait.until(ExpectedConditions.visibilityOf(NameSting))
                 .getText();
    }

    public String getTextFromLoginCheckNotification(){
        wait.until(ExpectedConditions.visibilityOf(loginCheckNotification));
        return loginCheckNotification.getText();
    }

    public String getTextFromPasswordCheckNotification(){
        wait.until(ExpectedConditions.visibilityOf(passwordCheckNotification));
        return passwordCheckNotification.getText();
    }

}

