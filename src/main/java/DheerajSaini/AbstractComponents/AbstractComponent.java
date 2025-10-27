package DheerajSaini.AbstractComponents;

import DheerajSaini.pageObjects.LandingPage.CartPage;
import DheerajSaini.pageObjects.LandingPage.OrderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {

    WebDriver driver;
    public AbstractComponent(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="button[routerlink*='cart']")
    WebElement CartHeder;
    //tr td:nth-child(3)
    @FindBy(css=".btn.btn-custom[routerlink='/dashboard/myorders']")
    WebElement OrderHeader;

    public void waitForElementToAppear(By findBy) {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForWebElementToAppear(WebElement findBy) {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }



    public void waitForElementToDisappear(WebElement findBy){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(findBy));
    }

    public void waitForElementToBeClickable(By findBy){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(findBy));
    }

    public CartPage goToCart(){
        CartHeder.click();
        return new CartPage(driver);

    }

    public OrderPage goToOrder(){
        OrderHeader.click();
        return new OrderPage(driver);

    }

}
