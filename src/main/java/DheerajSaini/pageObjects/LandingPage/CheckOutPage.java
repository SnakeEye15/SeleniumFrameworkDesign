package DheerajSaini.pageObjects.LandingPage;

import DheerajSaini.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends AbstractComponent {
    WebDriver driver;
    public CheckOutPage(WebDriver driver){
        //for parent class webdriver assignations [AbstractComponent]
        super(driver);
        //To initialize the webdriver
        this.driver=driver;
        //To tell the FindBy function about the driver
        PageFactory.initElements(driver,this);
    }


    @FindBy(css="[placeholder='Select Country']")
    WebElement inputCountry;

    @FindBy(css=".ta-item:nth-of-type(2)")
    WebElement selectForCountry;

    @FindBy(css=".btnn")
    WebElement submit;

    By selectCountry= By.cssSelector(".ta-item:nth-of-type(2)");

    public void setSelectCountry(String countryName){
        Actions a= new Actions(driver);
        a.sendKeys(inputCountry,"india").build().perform();
        waitForElementToAppear(selectCountry);
        selectForCountry.click();
    }

    public ConfirmPage clickSubmit(){
        submit.click();
        ConfirmPage confirmPage= new ConfirmPage(driver);
        return confirmPage;
    }

}
