package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class herokuappLoginFormPage {

    WebDriver driver;

    @FindBy(id = "username")
    private WebElement usernameField ;

    @FindBy(id = "password")
    private WebElement passwordField ;

    @FindBy(css = "i.fa-sign-in")
    private WebElement loginButton ;

    @FindBy(css = "#flash")
    private WebElement messageHeader ;

    private String username = "tomsmith";
    private String password = "SuperSecretPassword!";
    private String invalidPassword = "WrongPassword";
    private String expectedHeader = "Your password is invalid!\n"+"×";

    public herokuappLoginFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void navigateToWebsite(){
        //Opening herokuapp login website
        driver.get("http://the-internet.herokuapp.com/login");
    }

    public void insertValidUserCredential(){
        //Insert valid user credentials into login field
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    public void insertInvalidUserCredential(){
        //Insert invalid user credentials into login field
        usernameField.sendKeys(username);
        passwordField.sendKeys(invalidPassword);
    }

    public void clickLoginButton(){
        //Clicking login button on login page
        loginButton.click();
    }

    public void verifyUserAuthorization(){
        //Verifying user successfully logon on profile page
        Assert.assertTrue(messageHeader.isDisplayed());
    }
}
