package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class herokuappLoginFormPage extends herokuappBasePage{

    @FindBy(how = How.CSS, using = "#username")
    private WebElement usernameField ;

    @FindBy(how = How.CSS, using = "#password")
    private WebElement passwordField ;

    @FindBy(how = How.CSS, using = "i.fa-sign-in")
    private WebElement loginButton ;

    @FindBy(how = How.CSS, using = "#flash")
    private WebElement messageHeader ;

    private String username = "tomsmith";
    private String password = "SuperSecretPassword!";
    private String invalidPassword = "WrongPassword";
    private String expectedHeader = "Your password is invalid!\n"+"×";

    public herokuappLoginFormPage(WebDriver commondriver) {
        super(commondriver);
    }

    public void navigateToWebsite(){
        //Opening herokuapp website
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

    public herokuappSecurePage clickLoginButton(){
        //Clicking login button on login page
        loginButton.click();
        return new herokuappSecurePage(driver);
    }

    public void verifyUserAuthorization(){
        //Verifying user successfully logon on profile page
        Assert.assertTrue(messageHeader.isDisplayed());
    }
}
