package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class herokuappLoginFormPage {

    @FindBy(how = How.CSS, using = "#username")
    private WebElement usernameField ;

    @FindBy(how = How.CSS, using = "#password")
    private WebElement passwordField ;

    @FindBy(how = How.CSS, using = "i.fa-sign-in")
    private WebElement loginButton ;

    @FindBy(how = How.CSS, using = "#flash")
    private WebElement messageHeader ;

    private WebDriver driver;
    private String username = "tomsmith";
    private String password = "SuperSecretPassword!";
    private String invalidPassword = "SuperSecretPassword";
    private String expectedHeader = "Your password is invalid!\n"+"×";

    public herokuappLoginFormPage(WebDriver commondriver) {
        this.driver = commondriver;
        PageFactory.initElements(commondriver,this);
    }

    public void navigateToWebsite(){
        driver.get("http://the-internet.herokuapp.com/login");
    }

    public void insertValidUserCredential(){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    public void insertInvalidUserCredential(){
        usernameField.sendKeys(username);
        passwordField.sendKeys(invalidPassword);
    }

    public herokuappSecurePage clickLoginButton(){
        loginButton.click();
        return new herokuappSecurePage(driver);
    }

    public void verifyUserAuthorization(){
        Assert.assertTrue(messageHeader.isDisplayed());
    }
}
