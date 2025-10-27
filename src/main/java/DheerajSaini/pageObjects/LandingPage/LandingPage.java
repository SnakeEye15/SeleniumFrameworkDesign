package DheerajSaini.pageObjects.LandingPage;

import DheerajSaini.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {

    WebDriver driver;
    public LandingPage(WebDriver driver){
        //for parent class webdriver assignations [AbstractComponent]
        super(driver);
        //To initialize the webdriver
        this.driver=driver;
        //To tell the FindBy function about the driver
        PageFactory.initElements(driver,this);
    }

   //WebElement Email= driver.findElement(By.id("userEmail"))
    //PageFactory methods to declare webElements

    @FindBy(id="userEmail")
    WebElement Email;

    @FindBy(id="userPassword")
    WebElement passwordEle;

    @FindBy(id="login")
    WebElement submit;

    @FindBy(css="div[aria-label='Incorrect email or password.']")
    WebElement Errormessge;

    public ProductCatalogue loginApplication(String username, String password){
        Email.clear();
        passwordEle.clear();
        Email.sendKeys(username);
        passwordEle.sendKeys(password);
        submit.click();
        ProductCatalogue pdct=new ProductCatalogue(driver);
        return pdct;
    }

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client/#/auth/login");
    }

    public String giveErrorMessage(){
            waitForWebElementToAppear(Errormessge);
            return Errormessge.getText();
    }


    //div[aria-label='Incorrect email or password.']


}
