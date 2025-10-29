package DheerajSaini.test;

import DheerajSaini.TestComponents.BaseTest;
import DheerajSaini.pageObjects.LandingPage.CartPage;
import DheerajSaini.pageObjects.LandingPage.ProductCatalogue;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class ErrorValidationsTests extends BaseTest {

        @Test(groups = "ErrorHandling")
        public void VerifyError() throws InterruptedException, IOException {
            page.loginApplication("sainidheeraj913@gmail.com", "dfhlksjfjs");
            Assert.assertEquals(page.giveErrorMessage(), "Incorrect email or password.");
        }

        @Test
        public void verifyWrongItem() throws InterruptedException {
            String productName="ZARA COAT 3";
            ProductCatalogue pdct=page.loginApplication("hcldheerajoculs@gmail.com", "@Dksharmais190802");
            Thread.sleep(2000);
            List<WebElement> products=pdct.getProductList();
            pdct.addToCart(productName);
            CartPage cart= pdct.goToCart();
            Boolean match=cart.VerifyProductDisplays("ZARA COAT 32");
            Assert.assertTrue(match);
        }

}
