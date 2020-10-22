package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class herokuappJSAlertPage extends herokuappBasePage{

    @FindBy(how = How.CSS, using = ".example ul li:first-child button")
    private WebElement JSAlertButton ;

    @FindBy(how = How.CSS, using = ".example ul li:nth-child(2) button")
    private WebElement JSConfirmButton ;

    @FindBy(how = How.CSS, using = ".example ul li:last-child button")
    private WebElement JSPromptButton ;

    @FindBy(how = How.CSS, using = "#result")
    private WebElement resultDisplay ;

    public herokuappJSAlertPage(WebDriver commondriver) {
        super(commondriver);
    }

    public void navigateToWebsite(){
        //Opening herokuapp JSAlert website
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
    }

    public void clickAlertButton(String jsAlertType){
        switch (jsAlertType){
            case "alert":
                JSAlertButton.click();
                break;
            case "confirm":
                JSConfirmButton.click();
                break;
            case "prompt":
                JSPromptButton.click();
                break;
            default:
                throw new IllegalArgumentException("No button to be selected");
        }
    }

    public void clickAlertMessage(String alertType, String buttonType){
        if (alertType.equals("JSAlert")){
            if (buttonType.equals("ok")){
                driver.switchTo().alert().accept();
            }
        }
        else if (alertType.equals("JSConfirm")){
            if (buttonType.equals("ok")){
                driver.switchTo().alert().accept();
            }
            else {
                driver.switchTo().alert().dismiss();
            }
        }
        else{
            if (buttonType.equals("ok")){
                driver.switchTo().alert().accept();
            }
            else {
                driver.switchTo().alert().dismiss();
            }
        }
    }

    public void checkResultDisplay(String message){
        driver.switchTo().defaultContent();
        Assert.assertTrue(message.equals(resultDisplay.getText()));
    }

    public void insertInputField(String input){
        driver.switchTo().alert().sendKeys(input);
    }
}
