package Steps;

import Pages.herokuappLoginFormPage;
import Pages.herokuappSecurePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class herokuStepDefs {

    private WebDriver driver;
    private herokuappLoginFormPage loginpage;
    private herokuappSecurePage securePage;

    @Before
    public void startUp(){
        System.setProperty("webdriver.chrome.driver","src/test/java/Resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void closeBrowser(){
        if(driver != null){
            driver.close();
            driver.quit();
        }
    }

    @Given("I navigate to herokuapp website")
    public void navigateToWebsite(){
        loginpage = new herokuappLoginFormPage(driver);
        loginpage.navigateToWebsite();
    }

    @When("^I insert '(.*)' user credentials$")
    public void insertUserCredential(String credentials){
        if(credentials.equals("valid")){
            loginpage.insertValidUserCredential();
        }
        else{
            loginpage.insertInvalidUserCredential();
        }
    }

    @And("I click login button")
    public void clickLogin(){
        loginpage.clickLoginButton();
    }

    @Then ("^I '(.*)' logon into herokuapp account$")
    public void verifyUser(String status){
        securePage = new herokuappSecurePage(driver);
        if(status.equals("fail")){
            loginpage.verifyUserAuthorization();
        }
        else{
            securePage.verifyUserAuthorization();
        }
    }
}
