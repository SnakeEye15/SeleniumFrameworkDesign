package DheerajSaini.pageObjects.LandingPage;

import DheerajSaini.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends AbstractComponent {

    WebDriver driver;
    public OrderPage(WebDriver driver){
        //for parent class webdriver assignations [AbstractComponent]
        super(driver);
        //To initialize the webdriver
        this.driver=driver;
        //To tell the FindBy function about the driver
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="tr td:nth-child(3)")
    List<WebElement> Orders;

    public Boolean VerifyOrderDisplays(String productName){

        return Orders.stream().allMatch(cart-> cart.getText().equalsIgnoreCase(productName));
    }



}
