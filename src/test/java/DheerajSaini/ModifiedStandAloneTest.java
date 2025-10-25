package DheerajSaini;

import DheerajSaini.pageObjects.LandingPage.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ModifiedStandAloneTest {
    public static void main(String[] args) throws InterruptedException {

        String productName="ZARA COAT 3";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.manage().window().maximize();
        LandingPage page= new LandingPage(driver);
        page.goTo();
        ProductCatalogue pdct=page.loginApplication("sainidheeraj913@gmail.com", "@Dksharmais1908");
        Thread.sleep(2000);
        List<WebElement> products=pdct.getProductList();
        pdct.addToCart(productName);
        // Now click the cart button
        CartPage cart= pdct.goToCart();
        Boolean match=cart.VerifyProductDisplays(productName);
        Assert.assertTrue(match);
        CheckOutPage check=cart.goToCheckOut();
        check.setSelectCountry("india");
        ConfirmPage confirmPage=check.clickSubmit();
        String confirmMessage=confirmPage.verifyConfirmMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
        driver.quit();


    }
}
