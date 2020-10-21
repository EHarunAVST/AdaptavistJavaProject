package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class herokuappSecurePage{

    @FindBy(how = How.CSS , using = "h4.subheader")
    private WebElement messageHeader ;

    private WebDriver driver;
    private String expectedHeader = "Welcome to the Secure Area. When you are done click logout below.";

    public herokuappSecurePage(WebDriver commondriver) {
        this.driver = commondriver;
        PageFactory.initElements(commondriver,this);    }

    public void verifyUserAuthorization(){
        Assert.assertTrue(messageHeader.isDisplayed());
        Assert.assertTrue(expectedHeader.equals(messageHeader.getText()));
    }
}
