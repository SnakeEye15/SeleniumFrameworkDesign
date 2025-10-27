package DheerajSaini.test;

import DheerajSaini.TestComponents.BaseTest;
import DheerajSaini.pageObjects.LandingPage.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

public class ModifiedStandAloneTest extends BaseTest {
    String productName="ZARA COAT 3";
        @Test
        public void firstTest() throws InterruptedException, IOException {

        ProductCatalogue pdct=page.loginApplication("sainidheeraj913@gmail.com", "@Dksharmais1908");
        Thread.sleep(2000);
        List<WebElement> products=pdct.getProductList();
        pdct.addToCart(productName);
        CartPage cart= pdct.goToCart();
        Boolean match=cart.VerifyProductDisplays(productName);
        Assert.assertTrue(match);
        CheckOutPage check=cart.goToCheckOut();
        check.setSelectCountry("india");
        ConfirmPage confirmPage=check.clickSubmit();
        String confirmMessage=confirmPage.verifyConfirmMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
    }

    @Test(dependsOnMethods = {"firstTest"})
    public void OrderHistory() throws InterruptedException {
        ProductCatalogue pdct= page.loginApplication("sainidheeraj913@gmail.com", "@Dksharmais1908");
        Thread.sleep(2000);
        OrderPage orderPage=pdct.goToOrder();
        Assert.assertTrue(orderPage.VerifyOrderDisplays(productName));
        }
}
