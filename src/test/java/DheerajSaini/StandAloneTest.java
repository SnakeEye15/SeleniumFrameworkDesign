package DheerajSaini;

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

public class StandAloneTest {
    public static void main(String[] args) throws InterruptedException {

        String productName="ZARA COAT 3";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/client/#/auth/login");

        driver.findElement(By.id("userEmail")).sendKeys("sainidheeraj913@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("@Dksharmais1908");
        driver.findElement(By.id("login")).click();
        Thread.sleep(2000);


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
        List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));

        WebElement prod= products.stream().filter(product->
                product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
                        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

        //waiting for product added message to appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

        //waiting for animation to turn off
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
        // Wait for spinner overlay to disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ngx-spinner-overlay")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[routerlink*='cart']")));
        // Now click the cart button
        driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();


        List<WebElement> cartProcuts=driver.findElements(By.cssSelector(".cartSection h3"));

        Boolean match=cartProcuts.stream().allMatch(cart-> cart.getText().equalsIgnoreCase(productName));

        Assert.assertTrue(match);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".totalRow button")));
        driver.findElement(By.cssSelector(".totalRow button")).click();

        Actions a= new Actions(driver);

        a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-item:nth-of-type(2)")));
        driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();

        driver.findElement(By.cssSelector(".btnn")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));

        String confirmMessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));

        driver.quit();


    }
}
