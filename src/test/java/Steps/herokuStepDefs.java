package Steps;

import Pages.herokuappIFramePage;
import Pages.herokuappJSAlertPage;
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
    private herokuappJSAlertPage alertPage;
    private herokuappIFramePage iframePage;

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

    @Given ("^I navigate to herokuapp '(.*)' website$")
    public void navigateToJSAlertWebsite(String site){
        if(site.equals("alert")){
            alertPage = new herokuappJSAlertPage(driver);
            alertPage.navigateToWebsite();
        }
        else if(site.equals("login")){
            loginpage = new herokuappLoginFormPage(driver);
            loginpage.navigateToWebsite();
        }
        else if(site.equals("iframe")){
            iframePage = new herokuappIFramePage(driver);
            iframePage.navigateToWebsite();
        }

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

    @When("^I click JS '(.*)' button$")
    public void clickJSButton(String jsAlertButton){
        alertPage.clickAlertButton(jsAlertButton);
    }

    @When("^I write '(.*)' in the text iframe$")
    public void writeText(String text){
        iframePage.writeTextInIFrame(text);
    }

    @And("I click login button")
    public void clickLogin(){
        loginpage.clickLoginButton();
    }

    @And("^I click '(.*)' button on '(.*)' warning popout$")
    public void handleBrowserAlert(String buttonType, String alertType){
        alertPage.clickAlertMessage(alertType,buttonType);
    }

    @And("^I insert '(.*)' as input value$")
    public void insertInputOnAlert(String input){
        alertPage.insertInputField(input);
    }

    @And("^I click '(.*)' on toolbar$")
    public void clickToolbar(String toolbarType){
        iframePage.clickToolbar(toolbarType);
    }

    @Then("^Result display '(.*)'$")
    public void checkResult(String message){
        alertPage.checkResultDisplay(message);
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

    @Then("^result will show '(.*)' was selected$")
    public void verifySelectedToolbar(String toolbarType){
        iframePage.checkSelectedToolbar(toolbarType);
    }

    @And("^verify '(.*)' are written in iframe$")
    public void verifyTextInput(String text){
        iframePage.verifyText(text);
    }
}
