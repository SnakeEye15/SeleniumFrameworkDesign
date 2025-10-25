package DheerajSaini.pageObjects.LandingPage;

import DheerajSaini.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponent {

    WebDriver driver;
    public CartPage(WebDriver driver){
        //for parent class webdriver assignations [AbstractComponent]
        super(driver);
        //To initialize the webdriver
        this.driver=driver;
        //To tell the FindBy function about the driver
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=".cartSection h3")
    List<WebElement> cartProducts;

    @FindBy(css=".totalRow button")
    WebElement CartButton;

    By CartButtonAlso=By.cssSelector(".totalRow button");

    public Boolean VerifyProductDisplays(String productName){

        return cartProducts.stream().allMatch(cart-> cart.getText().equalsIgnoreCase(productName));
    }


    public CheckOutPage goToCheckOut(){
        waitForElementToAppear(CartButtonAlso);
        CartButton.click();
        CheckOutPage check= new CheckOutPage(driver);
        return check;

    }


}
