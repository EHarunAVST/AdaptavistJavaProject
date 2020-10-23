package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class herokuappIFramePage extends herokuappBasePage{

    @FindBy(how = How.CSS, using = "#mce_0_ifr")
    private WebElement textfieldIframe ;

    @FindBy(how = How.CSS, using = "#tinymce")
    private WebElement inputTextfield ;

    @FindBy(how = How.CSS, using = "#mceu_0 button")
    private WebElement undoButton ;

    @FindBy(how = How.CSS, using = "#mceu_28-body div[role=button]:first-child")
    private WebElement selectedParagraphIcon ;

    @FindBy(how = How.CSS, using = "#mceu_28-body div[role=button]:last-child")
    private WebElement selectedBoldIcon ;

    @FindBy(how = How.CSS, using = "#mceu_3 button")
    private WebElement boldButton ;

    @FindBy(how = How.CSS, using = "#mceu_4 button")
    private WebElement italicIcon ;

    public herokuappIFramePage(WebDriver commondriver) {
        super(commondriver);
    }

    public void navigateToWebsite(){
        //Opening herokuapp iframe website
        driver.get("http://the-internet.herokuapp.com/iframe");
    }

    public void writeTextInIFrame(String text){
        //Writing input into textfield
        driver.switchTo().frame(textfieldIframe);
        inputTextfield.clear();
        inputTextfield.sendKeys(text);
        driver.switchTo().defaultContent();
    }

    public void clickToolbar(String toolbarType){
        //Click specific function on the toolbar
        if(toolbarType.equals("bold")){
            boldButton.click();
        }
        else if(toolbarType.equals("italic")){
            italicIcon.click();
        }
    }

    public void checkSelectedToolbar(String toolbarType){
        //Check selected toolbar on the bottom navigation bar
        String displayStatus;
        switch (toolbarType){
            case "paragraph":
                displayStatus = "p";
                selectedParagraphIcon.isDisplayed();
                Assert.assertTrue(displayStatus.equals(selectedParagraphIcon.getText()));
                break;
            case "bold":
                displayStatus = "strong";
                Assert.assertTrue(displayStatus.equals(selectedBoldIcon.getText()));
                break;
            default:
                throw new IllegalArgumentException("No Toolbar option was found.");
        }
    }

    public void verifyText(String text){
        //Verify the text inserted into the iframe
        driver.switchTo().frame(textfieldIframe);
        Assert.assertTrue(text.equals(inputTextfield.getText()));
        driver.switchTo().defaultContent();
    }
}
