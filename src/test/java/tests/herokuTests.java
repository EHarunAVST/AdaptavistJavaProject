package tests;

import Pages.herokuappLoginFormPage;
import Pages.herokuappSecurePage;
import org.junit.Test;

public class herokuTests extends herokuappBaseTest{

    @Test
    public void validCredentials(){
        herokuappLoginFormPage loginPage = new herokuappLoginFormPage(getDriver());
        loginPage.navigateToWebsite();
        loginPage.insertValidUserCredential();
        loginPage.clickLoginButton();

        herokuappSecurePage securePage = new herokuappSecurePage(getDriver());
        securePage.verifyUserAuthorization();
    }
}
