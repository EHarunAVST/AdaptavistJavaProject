package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class herokuappBasePage {
    public WebDriver driver;

    public herokuappBasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


}
