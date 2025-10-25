package DheerajSaini.pageObjects.LandingPage;

import DheerajSaini.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmPage extends AbstractComponent {
    WebDriver driver;
    public ConfirmPage(WebDriver driver) {
        super(driver);
        //To initialize the webdriver
        this.driver=driver;
        //To tell the FindBy function about the driver
        PageFactory.initElements(driver,this);
    }

    By confirmMessage=By.cssSelector(".hero-primary");

    @FindBy(css=".hero-primary")
    WebElement CompleteMessage;


    /***
     *
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));

     String confirmMessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
     */

    public String verifyConfirmMessage(){
        waitForElementToAppear(confirmMessage);
        return CompleteMessage.getText();
    }


}
