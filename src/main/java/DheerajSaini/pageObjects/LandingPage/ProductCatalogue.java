package DheerajSaini.pageObjects.LandingPage;

import DheerajSaini.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductCatalogue extends AbstractComponent {

    WebDriver driver;
    public ProductCatalogue(WebDriver driver){
        //for parent class webdriver assignations [AbstractComponent]
        super(driver);
        //To initialize the webdriver
        this.driver=driver;
        //To tell the FindBy function about the driver
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=".mb-3")
    List<WebElement> products;

    @FindBy(css=".ng-animating")
    WebElement animation;

    @FindBy(css=".ngx-spinner-overlay")
    WebElement spinnerOverlay;


    By prouctBy= By.cssSelector(".mb-3");
    By addToCart= By.cssSelector(".card-body button:last-of-type");
    By toastMessage= By.cssSelector("#toast-container");
    By routerLink=By.cssSelector("[routerlink*='cart']");

    public List<WebElement> getProductList(){
        waitForElementToAppear(prouctBy);
        return products;
    }

    public WebElement getProductByName(String productName){
        WebElement prod= getProductList().stream().filter(product->
                product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        return prod;
    }

    public void addToCart(String productName){
        WebElement prod=getProductByName(productName);
        prod.findElement(addToCart).click();
        waitForElementToAppear(toastMessage);
        waitForElementToDisappear(animation);
        waitForElementToDisappear(spinnerOverlay);
        waitForElementToBeClickable(routerLink);
    }




}
